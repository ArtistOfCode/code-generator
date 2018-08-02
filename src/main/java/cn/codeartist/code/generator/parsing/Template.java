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
    DAO("dao", "Mapper.java"),
    /**
     * 基础数据库接口
     */
    BASEDAO("basedao", "BaseMapper.java"),
    /**
     * Mapper文件
     */
    MAPPER("mapper", "Mapper.xml"),
    /**
     * 实体类
     */
    MODEL("model", ".java");

    public String name;
    public String suffix;

    Template(String tplName, String suffix) {
        this.name = tplName;
        this.suffix = suffix;
    }
}
