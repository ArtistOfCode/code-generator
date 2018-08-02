package cn.codeartist.code.generator.handler.defaults;

import cn.codeartist.code.generator.freemarker.BaseData;
import cn.codeartist.code.generator.freemarker.Field;
import cn.codeartist.code.generator.handler.FieldHandler;
import cn.codeartist.code.generator.jdbc.DataTable;
import cn.codeartist.code.generator.jdbc.DataTableColumn;

import java.util.ArrayList;
import java.util.List;

/**
 * 对字段的处理器
 *
 * @author 艾江南
 */
public class BaseFieldHandler implements FieldHandler {

    @Override
    public void importPackageHandler(BaseData baseData) {
        baseData.setHaveDateField(false);
        baseData.setHaveBigDecimalField(false);
        for (Field field : baseData.getFields()) {
            if ("Date".equals(field.getDataType())) {
                baseData.setHaveDateField(true);
            }
            if ("BigDecimal".equals(field.getDataType())) {
                baseData.setHaveBigDecimalField(true);
            }
        }
    }

    @Override
    public void columnToField(BaseData baseData, DataTable dataTable) {
        List<Field> fields = new ArrayList<>();
        for (DataTableColumn dataTableColumn : dataTable.getColumns()) {
            fields.add(new Field(dataTableColumn));
        }
        baseData.setFields(fields);
    }
}
