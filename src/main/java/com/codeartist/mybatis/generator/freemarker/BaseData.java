package com.codeartist.mybatis.generator.freemarker;

/**
 * 基础数据
 *
 * @author 艾江南
 */
public class BaseData {

    private boolean haveSerializable = true;
    private boolean haveDataField;
    private boolean haveBigDecimalField;

    public boolean isHaveSerializable() {
        return haveSerializable;
    }

    public void setHaveSerializable(boolean haveSerializable) {
        this.haveSerializable = haveSerializable;
    }

    public boolean isHaveDataField() {
        return haveDataField;
    }

    public void setHaveDataField(boolean haveDataField) {
        this.haveDataField = haveDataField;
    }

    public boolean isHaveBigDecimalField() {
        return haveBigDecimalField;
    }

    public void setHaveBigDecimalField(boolean haveBigDecimalField) {
        this.haveBigDecimalField = haveBigDecimalField;
    }
}
