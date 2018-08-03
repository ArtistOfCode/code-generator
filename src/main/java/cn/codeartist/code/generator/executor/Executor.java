package cn.codeartist.code.generator.executor;

/**
 * 生成模块执行
 *
 * @author 艾江南
 */
public interface Executor {

    /**
     * 生成实体类
     */
    void generateModel();

    /**
     * 生成Dao接口
     */
    void generateDao();

    /**
     * 生成Mapper文件
     */
    void generateMapper();

    /**
     * 生成接口文件
     */
    void generatorInterface();

    /**
     * 生成接口实现类文件
     */
    void generatorService();

    /**
     * 生成控制层类文件
     */
    void generatorController();

}
