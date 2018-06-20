package com.codeartist.mybatis.generator.jdbc;

/**
 * 数据库表元数据
 *
 * @author 艾江南
 */
public class DataTableColumn {

    private String column;
    private String clazz;
    private String comment;

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
