package com.codeartist.mybatis.generator.session.defaults;

import com.codeartist.mybatis.generator.builder.XMLConfigBuilder;
import com.codeartist.mybatis.generator.config.Configuration;
import com.codeartist.mybatis.generator.session.GenSession;
import com.codeartist.mybatis.generator.session.GenSessionFactory;

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

    @Override
    public GenSession openSession() {
        return new BaseGenSession(configuration);
    }

}
