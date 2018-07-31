package cn.codeartist.code.generator;

import cn.codeartist.code.generator.session.GenSession;
import cn.codeartist.code.generator.session.GenSessionFactory;
import cn.codeartist.code.generator.session.defaults.BaseGenSessionFactory;

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
