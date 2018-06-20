package com.codeartist.mybatis.generator.jdbc;

import java.util.List;

/**
 * 数据库表
 *
 * @author 艾江南
 */
public class DataTable {

    private String table;
    private String comment;
    private List<DataTableColumn> columns;

    public DataTable(String table) {
        this.table = table;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<DataTableColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<DataTableColumn> columns) {
        this.columns = columns;
    }
}
