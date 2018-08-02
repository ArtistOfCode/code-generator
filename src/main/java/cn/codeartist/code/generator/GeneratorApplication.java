package cn.codeartist.code.generator;

import cn.codeartist.code.generator.session.GeneratorSession;
import cn.codeartist.code.generator.session.GeneratorSessionFactory;
import cn.codeartist.code.generator.session.defaults.BaseGeneratorSessionFactory;

/**
 * 主方法
 *
 * @author 艾江南
 */
public class GeneratorApplication {

    public static void main(String[] args) {
        GeneratorSessionFactory factory = new BaseGeneratorSessionFactory().build("generatorConfig.xml");
        GeneratorSession session = factory.openSession();
        session.generate();
    }

}
