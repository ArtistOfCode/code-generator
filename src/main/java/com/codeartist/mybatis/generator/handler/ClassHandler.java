package com.codeartist.mybatis.generator.handler;

import com.codeartist.mybatis.generator.config.Settings;
import com.codeartist.mybatis.generator.freemarker.ModelData;

public interface ClassHandler extends IHandler {

    void settingsHandler(ModelData modelData, Settings settings);

    void packageHandler(String path);

}
