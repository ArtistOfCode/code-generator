package cn.codeartist.code.generator.freemarker;

import java.util.List;

/**
 * 基础数据
 *
 * @author 艾江南
 */
public class BaseData {

    private boolean haveSerializable = true;
    private boolean haveDateField;
    private boolean haveBigDecimalField;
    private List<Field> fields;

    public boolean isHaveSerializable() {
        return haveSerializable;
    }

    public void setHaveSerializable(boolean haveSerializable) {
        this.haveSerializable = haveSerializable;
    }

    public boolean isHaveDateField() {
        return haveDateField;
    }

    public void setHaveDateField(boolean haveDateField) {
        this.haveDateField = haveDateField;
    }

    public boolean isHaveBigDecimalField() {
        return haveBigDecimalField;
    }

    public void setHaveBigDecimalField(boolean haveBigDecimalField) {
        this.haveBigDecimalField = haveBigDecimalField;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
