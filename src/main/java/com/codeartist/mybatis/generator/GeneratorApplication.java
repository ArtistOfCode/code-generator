package com.codeartist.mybatis.generator;

import com.codeartist.mybatis.generator.session.GenSession;
import com.codeartist.mybatis.generator.session.GenSessionFactory;
import com.codeartist.mybatis.generator.session.defaults.BaseGenSessionFactory;

/**
 * 主方法
 *
 * @author 艾江南
 */
public class GeneratorApplication {

    public static void main(String[] args) {
        GenSessionFactory factory = new BaseGenSessionFactory().build("generatorConfig.xml");
        GenSession session = factory.openSession();
        session.generate();
    }

}
