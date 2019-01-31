package cn.codeartist.code.generator.session.defaults;

import cn.codeartist.code.generator.builder.XmlConfigBuilder;
import cn.codeartist.code.generator.config.Configuration;
import cn.codeartist.code.generator.exceptions.ConfigurationException;
import cn.codeartist.code.generator.session.GeneratorSession;
import cn.codeartist.code.generator.session.GeneratorSessionFactory;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author 艾江南
 */
public class BaseGeneratorSessionFactory implements GeneratorSessionFactory {

    private Configuration configuration;
    private boolean isPoolThread = false;

    public BaseGeneratorSessionFactory build(String path) {
        try {
            this.configuration = new XmlConfigBuilder(path).parse();
            return this;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public BaseGeneratorSessionFactory build(File file) {
        try {
            this.configuration = new XmlConfigBuilder(file).parse();
            return this;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public BaseGeneratorSessionFactory poolThread() {
        isPoolThread = true;
        return this;
    }

    @Override
    public GeneratorSession openSession() {
        if (configuration == null) {
            throw new ConfigurationException("Read configuration failure");
        }
        if (isPoolThread) {
            return new PoolGeneratorSession(configuration);
        }
        return new BaseGeneratorSession(configuration);
    }

}
