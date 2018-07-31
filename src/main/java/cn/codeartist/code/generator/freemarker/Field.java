package cn.codeartist.code.generator.freemarker;

import cn.codeartist.code.generator.jdbc.DataTableColumn;
import cn.codeartist.code.generator.utils.NameUtil;

/**
 * 字段
 *
 * @author 艾江南
 */
public class Field {

    private String column;
    private String dataType;
    private String comment;
    private String humpName;
    private String bigHumpName;

    public Field(DataTableColumn dataTableColumn) {
        this.column = dataTableColumn.getColumn();
        this.dataType = dataTableColumn.getClazz();
        this.comment = dataTableColumn.getComment();
        this.humpName = NameUtil.humpName(column);
        this.bigHumpName = NameUtil.bigHumpName(column);
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getHumpName() {
        return humpName;
    }

    public void setHumpName(String humpName) {
        this.humpName = humpName;
    }

    public String getBigHumpName() {
        return bigHumpName;
    }

    public void setBigHumpName(String bigHumpName) {
        this.bigHumpName = bigHumpName;
    }
}
