package com.codeartist.mybatis.generator.parsing;

/**
 * 源代码模板
 *
 * @author 艾江南
 */
public enum Template {

    DAO("dao"),
    MAPPER("mapper"),
    MODEL("model");

    public String name;

    Template(String tplName) {
        this.name = tplName;
    }
}
