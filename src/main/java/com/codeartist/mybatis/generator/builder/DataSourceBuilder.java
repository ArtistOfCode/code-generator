package com.codeartist.mybatis.generator.builder;

import com.codeartist.mybatis.generator.config.Configuration;
import com.codeartist.mybatis.generator.config.DataSource;
import com.codeartist.mybatis.generator.config.Table;
import com.codeartist.mybatis.generator.jdbc.DataTable;
import com.codeartist.mybatis.generator.jdbc.DataTableColumn;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库连接构造器
 *
 * @author 艾江南
 */
public class DataSourceBuilder {

    private final Logger logger = Logger.getLogger(DataSourceBuilder.class);
    private final DataSource dataSource;
    private final List<Table> tables;

    public DataSourceBuilder(Configuration configuration) {
        this.dataSource = configuration.getDataSource();
        this.tables = configuration.getTables();
    }

    public List<DataTable> build() {
        List<DataTable> dataTables = new ArrayList<>();
        Connection connection = open();
        if (connection != null) {
            for (Table table : tables) {
                DataTable dataTable = build(connection, table.getTableName());
            }
            close(connection, null, null);
        }
        return dataTables;
    }

    private DataTable build(Connection connection, String table) {
        DataTable dataTable = new DataTable(table);
        buildColumnBaseInfo(connection, dataTable, table);
        buildColumnOtherInfo(connection, dataTable, table);
        buildTableInfo(connection, dataTable, table);
        logger.info("Table: " + dataTable.getComment() + ", " + dataTable.getTable());
        for (DataTableColumn column : dataTable.getColumns()) {
            logger.info("column: " + column.getColumn() + ", class: " + column.getClazz() + ", comment: " + column.getComment());
        }
        return dataTable;
    }

    private void buildColumnBaseInfo(Connection connection, DataTable dataTable, String table) {
        List<DataTableColumn> dataTableColumns = new ArrayList<>();
        String sql = String.format("SELECT * FROM %s WHERE 1=0", table);
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = connection.prepareStatement(sql);
            rs = stat.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 1, n = metaData.getColumnCount(); i <= n; i++) {
                DataTableColumn dataTableColumn = new DataTableColumn();
                dataTableColumn.setColumn(metaData.getColumnName(i));
                String columnClassName = metaData.getColumnClassName(i);
                columnClassName = columnClassName.substring(columnClassName.lastIndexOf(".") + 1).replace("Timestamp", "Date");
                dataTableColumn.setClazz(columnClassName);
                dataTableColumns.add(dataTableColumn);
            }
            dataTable.setColumns(dataTableColumns);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, stat, rs);
        }
    }

    private void buildColumnOtherInfo(Connection connection, DataTable dataTable, String table) {
        String sql = String.format("SHOW FULL FIELDS FROM %s", table);
        Map<String, String> result = new HashMap<>();
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = connection.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()) {
                result.put(rs.getString("Field"), rs.getString("Comment"));
            }
            for (DataTableColumn column : dataTable.getColumns()) {
                column.setComment(result.get(column.getColumn()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, stat, rs);
        }
    }

    private void buildTableInfo(Connection connection, DataTable dataTable, String table) {
        String url = dataSource.getUrl();
        String schema = url.substring(url.lastIndexOf("/") + 1);
        String sql = String.format("SELECT TABLE_COMMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA='%s' AND TABLE_NAME='%s'", schema, table);
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = connection.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()) {
                dataTable.setComment(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, stat, rs);
        }
    }

    private Connection open() {
        try {
            Class.forName(dataSource.getDriver());
            return DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
        } catch (ClassNotFoundException e) {
            logger.error("JDBC driver is not found, cause by " + e.getMessage());
        } catch (SQLException e) {
            logger.error("Database connect error, cause by " + e.getMessage());
        }
        return null;
    }

    private void close(Connection conn, Statement stat, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            logger.error("Database disconnect error, cause by " + e.getMessage());
        }
    }
}
