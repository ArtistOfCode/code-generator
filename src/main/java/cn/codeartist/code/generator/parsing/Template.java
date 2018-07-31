package cn.codeartist.code.generator.parsing;

/**
 * 源代码模板
 *
 * @author 艾江南
 */
public enum Template {

    DAO("dao"),
    BASEDAO("basedao"),
    MAPPER("mapper"),
    MODEL("model");

    public String name;

    Template(String tplName) {
        this.name = tplName;
    }
}
