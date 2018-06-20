package com.codeartist.mybatis.generator.builder;

import com.codeartist.mybatis.generator.config.Configuration;
import com.codeartist.mybatis.generator.jdbc.DataTable;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * 配置单元测试
 *
 * @author 艾江南
 */
public class BuilderTest {

    private final Logger logger = Logger.getLogger(BuilderTest.class);

    @Test
    public void loadGeneratorConfigXMLFile() {
        try {
            String path = "generatorConfig.xml";
            XMLConfigBuilder config = new XMLConfigBuilder(path);
            Configuration configuration = config.parse();
            logger.info("generatorConfig: " + configuration);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void connectDatabase() {
        try {
            String path = "generatorConfig.xml";
            Configuration config = new XMLConfigBuilder(path).parse();
            List<DataTable> dataTables = new DataSourceBuilder(config).build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}