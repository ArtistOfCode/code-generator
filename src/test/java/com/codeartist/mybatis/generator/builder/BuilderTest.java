package com.codeartist.mybatis.generator.builder;

import com.codeartist.mybatis.generator.config.Configuration;
import com.codeartist.mybatis.generator.jdbc.DataTable;
import com.codeartist.mybatis.generator.parsing.Template;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            for (DataTable dataTable : dataTables) {
                logger.info("dataTable: " + dataTable.getComment());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void generateFile() {
        FileBuilder builder = new FileBuilder();
        Map<String, Object> map = new HashMap<>();
        map.put("namespace", "aijiangnan111");
        builder.build(Template.MAPPER, "a/b/c/test.xml", map);
    }
}