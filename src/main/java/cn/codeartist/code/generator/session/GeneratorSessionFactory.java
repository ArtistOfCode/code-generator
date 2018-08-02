package cn.codeartist.code.generator.session;

/**
 * 工厂
 *
 * @author 艾江南
 */
public interface GeneratorSessionFactory {

    /**
     * 创建生成会话
     *
     * @return GeneratorSession
     */
    GeneratorSession openSession();

}
