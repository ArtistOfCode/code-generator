package com.codeartist.mybatis.generator.session.defaults;

import com.codeartist.mybatis.generator.config.Configuration;
import com.codeartist.mybatis.generator.executor.BaseExecutor;
import com.codeartist.mybatis.generator.executor.Executor;
import com.codeartist.mybatis.generator.session.GenSession;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BaseGenSession implements GenSession {

    private final Executor executor;

    public BaseGenSession(Configuration configuration) {
        this.executor = new BaseExecutor(configuration);
    }

    @Override
    public void generate() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(this::generateModel);
        executor.execute(this::generateDao);
        executor.execute(this::generateMapper);
        executor.shutdown();
    }

    @Override
    public void generateModel() {
        executor.generateModel();
    }

    @Override
    public void generateDao() {
        executor.generateDao();
    }

    @Override
    public void generateMapper() {
        executor.generateMapper();
    }
}
