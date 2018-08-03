package cn.codeartist.code.generator.session.defaults;

import cn.codeartist.code.generator.config.Configuration;
import cn.codeartist.code.generator.executor.BaseExecutor;
import cn.codeartist.code.generator.executor.Executor;
import cn.codeartist.code.generator.session.GeneratorSession;

/**
 * @author 艾江南
 */
public class BaseGeneratorSession implements GeneratorSession {

    private final Executor executor;

    public BaseGeneratorSession(Configuration configuration) {
        this.executor = new BaseExecutor(configuration);
    }

    @Override
    public void generate() {
        this.generateModel();
        this.generateDao();
        this.generateMapper();
        this.generateInterface();
        this.generateService();
        this.generateController();
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

    @Override
    public void generateInterface() {
        executor.generatorInterface();
    }

    @Override
    public void generateService() {
        executor.generatorService();
    }

    @Override
    public void generateController() {
        executor.generatorController();
    }
}
