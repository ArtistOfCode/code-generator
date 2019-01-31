package cn.codeartist.code.generator.freemarker;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 模板使用数据
 *
 * @author 艾江南
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FreemarkerData extends BaseData {

    private String modelPackage;
    private String daoPackage;
    private String mapperPackage;
    private String interfacePackage;
    private String servicePackage;
    private String controllerPackage;
    private String className;
    private String classHumpName;
    private String classComment;
    private String tableName;
    private String idClassType;

}
