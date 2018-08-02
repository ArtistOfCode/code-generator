package cn.codeartist.code.generator.handler.defaults;

import cn.codeartist.code.generator.freemarker.Field;
import cn.codeartist.code.generator.freemarker.ModelData;
import cn.codeartist.code.generator.handler.FieldHandler;

/**
 * 对字段的处理器
 *
 * @author 艾江南
 */
public class BaseFieldHandler implements FieldHandler {

    @Override
    public void importPackageHandler(ModelData modelData) {
        modelData.setHaveDateField(false);
        modelData.setHaveBigDecimalField(false);
        for (Field field : modelData.getFields()) {
            if ("Date".equals(field.getDataType())) {
                modelData.setHaveDateField(true);
            }
            if ("BigDecimal".equals(field.getDataType())) {
                modelData.setHaveBigDecimalField(true);
            }
        }
    }

}
