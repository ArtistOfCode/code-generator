package cn.codeartist.code.generator.handler.defaults;

import cn.codeartist.code.generator.config.Settings;
import cn.codeartist.code.generator.config.Table;
import cn.codeartist.code.generator.freemarker.ModelData;
import cn.codeartist.code.generator.handler.ClassHandler;
import cn.codeartist.code.generator.utils.NameUtil;
import org.apache.log4j.Logger;

import java.io.File;

public class BaseClassHandler implements ClassHandler {

    private final Logger logger = Logger.getLogger(BaseClassHandler.class);

    @Override
    public void settingsHandler(ModelData modelData, Settings settings) {
        modelData.setHaveSerializable(settings.isEnableSerializable());
    }

    @Override
    public void packageHandler(String path) {
        File dir = new File(path);
        if (dir.exists()) {
            logger.info("directory " + dir + " is exists");
        } else {
            if (dir.mkdirs()) {
                logger.info("mkdirs " + dir);
            } else {
                logger.error("mkdirs " + dir + "error");
            }
        }
    }

    @Override
    public void classHandler(Table table) {
        String className = table.getClassName();
        table.setClassName(className == null || "".equals(className.trim()) ? NameUtil.bigHumpName(table.getTableName()) : className);
    }
}
