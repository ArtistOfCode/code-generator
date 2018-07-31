package cn.codeartist.code.generator.handler.defaults;

import cn.codeartist.code.generator.freemarker.Field;
import cn.codeartist.code.generator.freemarker.ModelData;
import cn.codeartist.code.generator.handler.FieldHandler;

public class BaseFieldHandler implements FieldHandler {

    @Override
    public void importPackageHandler(ModelData modelData) {
        modelData.setHaveDateField(false);
        modelData.setHaveBigDecimalField(false);
        for (Field field : modelData.getFields()) {
            if (field.getDataType().equals("Date")) {
                modelData.setHaveDateField(true);
            }
            if (field.getDataType().equals("BigDecimal")) {
                modelData.setHaveBigDecimalField(true);
            }
        }
    }

}