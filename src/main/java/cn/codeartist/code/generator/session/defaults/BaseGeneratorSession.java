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
        executor.generateModel();
        executor.generateDao();
        executor.generateMapper();
        executor.generatorInterface();
        executor.generatorService();
        executor.generatorController();
    }

}
