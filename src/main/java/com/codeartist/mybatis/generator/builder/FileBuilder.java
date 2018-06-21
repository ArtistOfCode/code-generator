package com.codeartist.mybatis.generator.builder;

import com.codeartist.mybatis.generator.exceptions.BuilderException;
import com.codeartist.mybatis.generator.parsing.Template;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * 源代码生成构建器
 *
 * @author 艾江南
 */
public class FileBuilder {

    private final Logger logger = Logger.getLogger(FileBuilder.class);
    private final Configuration configuration;

    public FileBuilder() {
        this.configuration = new Configuration(Configuration.VERSION_2_3_23);
        this.configuration.setTemplateLoader(new ClassTemplateLoader(FileBuilder.class, "/template"));
        this.configuration.setDefaultEncoding("UTF-8");
    }

    public void build(Template template, String path, Object object) {
        try {
            freemarker.template.Template tpl = configuration.getTemplate(template.name + ".ftl");
            if (path.split("/").length > 1) {
                File dir = new File(path.substring(0, path.lastIndexOf("/")));
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
            FileOutputStream fos = new FileOutputStream(path);
            Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
            logger.info(template.name + " --> " + path + " successful");
            tpl.process(object, out);
        } catch (Exception e) {
            throw new BuilderException("File generate error, causer by " + e, e);
        }
    }

}
