package com.codeartist.mybatis.generator.handler.defaults;

import com.codeartist.mybatis.generator.config.Settings;
import com.codeartist.mybatis.generator.freemarker.ModelData;
import com.codeartist.mybatis.generator.handler.ClassHandler;

public class BaseClassHandler implements ClassHandler {

    @Override
    public void settingsHandler(ModelData modelData, Settings settings) {
        modelData.setHaveSerializable(settings.isEnableSerializable());
    }

}
