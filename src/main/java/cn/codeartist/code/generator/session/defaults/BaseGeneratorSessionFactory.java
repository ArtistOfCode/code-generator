package cn.codeartist.code.generator.session.defaults;

import cn.codeartist.code.generator.builder.XmlConfigBuilder;
import cn.codeartist.code.generator.config.Configuration;
import cn.codeartist.code.generator.session.GeneratorSession;
import cn.codeartist.code.generator.session.GeneratorSessionFactory;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author 艾江南
 */
public class BaseGeneratorSessionFactory implements GeneratorSessionFactory {

    private Configuration configuration;

    public GeneratorSessionFactory build(String path) {
        try {
            this.configuration = new XmlConfigBuilder(path).parse();
            return this;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GeneratorSessionFactory build(File file) {
        try {
            this.configuration = new XmlConfigBuilder(file).parse();
            return this;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GeneratorSession openSession() {
        return new BaseGeneratorSession(configuration);
    }

}
