package cn.codeartist.code.generator.builder;

import cn.codeartist.code.generator.config.Configuration;
import cn.codeartist.code.generator.jdbc.DataTable;
import cn.codeartist.code.generator.parsing.Template;
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
            String path = "generator-config.xml";
            XmlConfigBuilder config = new XmlConfigBuilder(path);
            Configuration configuration = config.parse();
            logger.info("generatorConfig: " + configuration);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void connectDatabase() {
        try {
            String path = "generator-config.xml";
            Configuration config = new XmlConfigBuilder(path).parse();
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
        try {
            FileBuilder builder = new FileBuilder();
            Map<String, Object> map = new HashMap<>();
            map.put("namespace", "aijiangnan111");
            builder.build(Template.MAPPER, "a/b/c/test.xml", map);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}