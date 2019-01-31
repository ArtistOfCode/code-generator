package cn.codeartist.code.generator.builder;

import cn.codeartist.code.generator.config.Configuration;
import cn.codeartist.code.generator.exceptions.BuilderException;
import cn.codeartist.code.generator.parsing.Template;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.MruCacheStorage;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 源代码生成构建器
 *
 * @author 艾江南
 */
public class FileBuilder {

    private final Logger logger = Logger.getLogger(FileBuilder.class);
    private final freemarker.template.Configuration config;

    public FileBuilder(Configuration configuration) {
        this.config = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23);
        this.config.setTemplateLoader(new ClassTemplateLoader(FileBuilder.class, configuration.getSettings().getTemplatePath()));
        this.config.setCacheStorage(new MruCacheStorage(10, 100));
        this.config.setDefaultEncoding("UTF-8");
    }

    public void build(Template template, String path, String className, Object object) {
        this.build(template, path + "/" + className + template.suffix, object);
    }

    public void build(Template template, String path, Object object) {
        try {
            freemarker.template.Template tpl = config.getTemplate(template.name + ".ftl");
            // 只生成一次，不重复生成下面代码
            boolean oneGenerate = template == Template.BASEDAO || template == Template.INTERFACE || template == Template.SERVICE || template == Template.CONTROLLER;
            if (oneGenerate && new File(path).exists()) {
                return;
            }
            FileOutputStream fos = new FileOutputStream(path);
            Writer out = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8), 10240);
            logger.info(template.name + " --> " + path + " successful");
            tpl.process(object, out);
        } catch (Exception e) {
            throw new BuilderException("File generate error, causer by " + e, e);
        }
    }

}
