package cn.codeartist.code.generator.session.defaults;

import cn.codeartist.code.generator.config.Configuration;
import cn.codeartist.code.generator.executor.BaseExecutor;
import cn.codeartist.code.generator.executor.Executor;
import cn.codeartist.code.generator.session.GenSession;

public class BaseGenSession implements GenSession {

    private final Executor executor;

    public BaseGenSession(Configuration configuration) {
        this.executor = new BaseExecutor(configuration);
    }

    @Override
    public void generate() {
        this.generateModel();
        this.generateDao();
        this.generateMapper();
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
