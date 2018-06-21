package com.codeartist.mybatis.generator.session.defaults;

import com.codeartist.mybatis.generator.config.Configuration;
import com.codeartist.mybatis.generator.executor.BaseExecutor;
import com.codeartist.mybatis.generator.executor.Executor;
import com.codeartist.mybatis.generator.session.GenSession;

public class BaseGenSession implements GenSession {

    private final Executor executor;

    public BaseGenSession(Configuration configuration) {
        this.executor = new BaseExecutor(configuration);
    }

    @Override
    public void generate() {
        generateModel();
        generateDao();
        generateMapper();
    }

    @Override
    public void generateModel() {
        executor.generateModel();
    }

    @Override
    public void generateDao() {

    }

    @Override
    public void generateMapper() {

    }
}
