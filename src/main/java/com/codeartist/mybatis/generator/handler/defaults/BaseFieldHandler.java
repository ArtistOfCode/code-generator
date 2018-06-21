package com.codeartist.mybatis.generator.handler.defaults;

import com.codeartist.mybatis.generator.freemarker.Field;
import com.codeartist.mybatis.generator.freemarker.ModelData;
import com.codeartist.mybatis.generator.handler.FieldHandler;

public class BaseFieldHandler implements FieldHandler {

    @Override
    public void importPackageHandler(ModelData modelData) {
        for (Field field : modelData.getFields()) {
            if (field.getDataType().equals("Date")) {
                modelData.setHaveDataField(true);
            }
            if (field.getDataType().equals("BigDecimal")) {
                modelData.setHaveBigDecimalField(true);
            }
        }
    }

}
