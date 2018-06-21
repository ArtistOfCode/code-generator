package com.codeartist.mybatis.generator.freemarker;

import com.codeartist.mybatis.generator.utils.NameUtil;

/**
 * 字段
 *
 * @author 艾江南
 */
public class Field {

    private String column;
    private String dataType;
    private String humpName;
    private String bigHumpName;

    public Field(String column, String dataType) {
        this.column = column;
        this.dataType = dataType;
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
