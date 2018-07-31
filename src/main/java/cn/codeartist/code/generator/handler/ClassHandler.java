package cn.codeartist.code.generator.handler;

import cn.codeartist.code.generator.config.Settings;
import cn.codeartist.code.generator.config.Table;
import cn.codeartist.code.generator.freemarker.ModelData;

public interface ClassHandler extends IHandler {

    void settingsHandler(ModelData modelData, Settings settings);

    void packageHandler(String path);

    void classHandler(Table table);

}
