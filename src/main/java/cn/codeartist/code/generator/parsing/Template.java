package cn.codeartist.code.generator.parsing;

/**
 * 源代码模板
 *
 * @author 艾江南
 */
public enum Template {

    /**
     * 数据库接口
     */
    DAO("dao"),
    /**
     * 基础数据库接口
     */
    BASEDAO("basedao"),
    /**
     * Mapper文件
     */
    MAPPER("mapper"),
    /**
     * 实体类
     */
    MODEL("model");

    public String name;

    Template(String tplName) {
        this.name = tplName;
    }
}
