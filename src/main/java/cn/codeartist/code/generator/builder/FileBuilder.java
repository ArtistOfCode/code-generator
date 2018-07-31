package cn.codeartist.code.generator.builder;

import cn.codeartist.code.generator.exceptions.BuilderException;
import cn.codeartist.code.generator.parsing.Template;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.MruCacheStorage;
import freemarker.template.Configuration;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

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
        this.configuration.setCacheStorage(new MruCacheStorage(10, 100));
        this.configuration.setDefaultEncoding("UTF-8");
    }

    public void build(Template template, String path, Object object) {
        try {
            freemarker.template.Template tpl = configuration.getTemplate(template.name + ".ftl");
            FileOutputStream fos = new FileOutputStream(path);
            Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
            logger.info(template.name + " --> " + path + " successful");
            tpl.process(object, out);
        } catch (Exception e) {
            throw new BuilderException("File generate error, causer by " + e, e);
        }
    }

}
