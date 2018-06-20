package com.codeartist.mybatis.generator.builder;

import com.codeartist.mybatis.generator.config.Configuration;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 读取XML配置文件单元测试
 *
 * @author 艾江南
 */
public class XMLConfigBuilderTest {

    private final Logger logger = Logger.getLogger(XMLConfigBuilderTest.class);

    @Test
    public void loadGeneratorConfigXMLFile() {
        String resources = "generatorConfig.xml";
        try {
            XMLConfigBuilder config = new XMLConfigBuilder(new FileInputStream(new File(resources)));
            Configuration configuration = config.parse();
            logger.info("generatorConfig: " + configuration);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}