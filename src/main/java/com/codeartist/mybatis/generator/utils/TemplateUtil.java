package com.codeartist.mybatis.generator.utils;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * 模板工具类
 *
 * @author 艾江南
 */
public class TemplateUtil {

    private static final Logger logger = Logger.getLogger(TemplateUtil.class);
    private static final Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);

    static {
        configuration.setTemplateLoader(new ClassTemplateLoader(TemplateUtil.class, "/template"));
        configuration.setDefaultEncoding("UTF-8");
    }

    /**
     * 根据模板生成源文件
     *
     * @param template 模板
     * @param file     生成目标文件
     * @param object   数据模型
     */
    public static void templateToFile(String template, String file, Object object) {
        try {
            Template tpl = configuration.getTemplate(template + ".ftl");
            if (file.split("/").length > 1) {
                File dir = new File(file.substring(0, file.lastIndexOf("/")));
                if (dir.exists()) {
                    logger.info("directory " + file + " is exists");
                } else {
                    if (dir.mkdirs()) {
                        logger.info("mkdirs " + dir);
                    } else {
                        logger.error("mkdirs " + dir + "error");
                    }
                }
            }
            FileOutputStream fos = new FileOutputStream(file);
            Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
            logger.info(template + " --> " + file + " successful");
            tpl.process(object, out);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

}
