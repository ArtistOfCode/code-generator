package cn.codeartist.code.generator.handler;

import cn.codeartist.code.generator.config.Configuration.Settings;
import cn.codeartist.code.generator.config.Configuration.Table;
import cn.codeartist.code.generator.freemarker.BaseData;

/**
 * 生成类的处理器
 *
 * @author 艾江南
 */
public interface ClassHandler {

    /**
     * 将配置绑定到类中
     *
     * @param baseData 基础数据类
     * @param settings 配置
     */
    void settingsHandler(BaseData baseData, Settings settings);

    /**
     * 生成包的文件夹
     *
     * @param path 包路径
     */
    void packageHandler(String path);

    /**
     * 获取配置文件中的表与内对应关系
     *
     * @param table 配置
     */
    void classHandler(Table table);

}
