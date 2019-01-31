package cn.codeartist.code.generator.freemarker;

import lombok.Data;

import java.util.List;

/**
 * 基础数据
 *
 * @author 艾江南
 */
@Data
public class BaseData {

    private boolean haveSerializable = true;
    private boolean haveDateField;
    private boolean haveBigDecimalField;
    private List<Field> fields;

}
