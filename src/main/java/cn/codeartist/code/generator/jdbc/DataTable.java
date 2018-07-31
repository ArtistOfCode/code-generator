package cn.codeartist.code.generator.jdbc;

import cn.codeartist.code.generator.config.Table;

import java.util.List;

/**
 * 数据库表
 *
 * @author 艾江南
 */
public class DataTable {

    private Table table;
    private String comment;
    private List<DataTableColumn> columns;

    public DataTable(Table table) {
        this.table = table;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
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
