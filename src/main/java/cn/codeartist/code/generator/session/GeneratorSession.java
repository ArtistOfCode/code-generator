package cn.codeartist.code.generator.session;

/**
 * @author 艾江南
 */
public interface GeneratorSession {

    /**
     * 生成全部
     */
    void generate();

    /**
     * 生成实体类
     */
    void generateModel();

    /**
     * 生成数据访问层
     */
    void generateDao();

    /**
     * 生成Mapper文件
     */
    void generateMapper();

}
