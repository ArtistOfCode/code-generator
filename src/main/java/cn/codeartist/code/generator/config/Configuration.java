package cn.codeartist.code.generator.config;

import lombok.Data;

import java.util.List;

/**
 * 配置文件实体
 *
 * @author 艾江南
 */
@Data
public class Configuration {

    private Settings settings;
    private DataSource dataSource;
    private GenTarget modelTarget;
    private GenTarget daoTarget;
    private GenTarget mapperTarget;
    private GenTarget interfaceTarget;
    private GenTarget serviceTarget;
    private GenTarget controllerTarget;
    private List<Table> tables;

    /**
     * 配置里面的设置实体
     */
    @Data
    public class Settings {
        private boolean enableSerializable = true;
        private boolean enableLombok = true;
        private String templatePath = "/template";
    }

    /**
     * 生成源代码目标文件夹
     */
    @Data
    public class GenTarget {
        private String targetPackage;
        private String targetProject;
    }

    /**
     * 数据库表
     *
     * @author 艾江南
     */
    @Data
    public class Table {
        private String className;
        private String tableName;
    }

}
