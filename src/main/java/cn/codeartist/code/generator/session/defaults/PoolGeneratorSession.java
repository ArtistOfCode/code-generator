package cn.codeartist.code.generator.session.defaults;

import cn.codeartist.code.generator.config.Configuration;
import cn.codeartist.code.generator.executor.BaseExecutor;
import cn.codeartist.code.generator.executor.Executor;
import cn.codeartist.code.generator.session.GeneratorSession;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 艾江南
 */
public class PoolGeneratorSession implements GeneratorSession {

    private final Executor executor;

    public PoolGeneratorSession(Configuration configuration) {
        this.executor = new BaseExecutor(configuration);
    }

    @Override
    public void generate() {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        executorService.execute(executor::generateModel);
        executorService.execute(executor::generateDao);
        executorService.execute(executor::generateMapper);
        executorService.execute(executor::generatorInterface);
        executorService.execute(executor::generatorService);
        executorService.execute(executor::generatorController);
        executorService.shutdown();
    }

}
