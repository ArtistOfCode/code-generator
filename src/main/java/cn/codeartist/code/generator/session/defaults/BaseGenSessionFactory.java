package cn.codeartist.code.generator.session.defaults;

import cn.codeartist.code.generator.builder.XMLConfigBuilder;
import cn.codeartist.code.generator.config.Configuration;
import cn.codeartist.code.generator.session.GenSession;
import cn.codeartist.code.generator.session.GenSessionFactory;

import java.io.File;
import java.io.FileNotFoundException;

public class BaseGenSessionFactory implements GenSessionFactory {

    private Configuration configuration;

    public GenSessionFactory build(String path) {
        try {
            this.configuration = new XMLConfigBuilder(path).parse();
            return this;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GenSessionFactory build(File file) {
        try {
            this.configuration = new XMLConfigBuilder(file).parse();
            return this;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenSession openSession() {
        return new BaseGenSession(configuration);
    }

}
