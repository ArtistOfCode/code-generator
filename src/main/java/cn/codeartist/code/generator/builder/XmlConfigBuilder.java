package cn.codeartist.code.generator.builder;

import cn.codeartist.code.generator.config.*;
import cn.codeartist.code.generator.parsing.XNode;
import cn.codeartist.code.generator.parsing.XPathParser;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 配置文件构造器
 *
 * @author 艾江南
 */
public class XmlConfigBuilder {

    private final Logger logger = Logger.getLogger(XmlConfigBuilder.class);
    private final Configuration configuration = new Configuration();
    private final XPathParser parser;

    public XmlConfigBuilder(String path) throws FileNotFoundException {
        this(new File(path));
    }

    public XmlConfigBuilder(File file) throws FileNotFoundException {
        this(new FileInputStream(file));
    }

    public XmlConfigBuilder(InputStream inputStream) {
        this.parser = new XPathParser(inputStream);
    }

    public Configuration parse() {
        parseConfiguration(parser.evalNode("/config"));
        logger.info("Load configuration successful");
        return configuration;
    }

    private void parseConfiguration(XNode root) {
        settingsElement(settingsAsProperties(root));
        dataSourceElement(root);
        targetElement(root);
        tableElements(root);
    }

    private Properties settingsAsProperties(XNode root) {
        XNode node = root.evalNode("settings");
        if (node == null) {
            return new Properties();
        }
        Properties props = node.getChildrenAsProperties();
        // TODO: Check the setting key
        return props;
    }

    private void settingsElement(Properties properties) {
        Settings settings = new Settings();
        settings.setEnableSerializable(Boolean.valueOf(properties.getProperty("enableSerializable")));
        configuration.setSettings(settings);
    }

    private void dataSourceElement(XNode root) {
        XNode node = root.evalNode("dataSource");
        DataSource dataSource = new DataSource();
        dataSource.setDriver(node.getStringAttribute("driver"));
        dataSource.setUrl(node.getStringAttribute("url"));
        dataSource.setUsername(node.getStringAttribute("username"));
        dataSource.setPassword(node.getStringAttribute("password"));
        configuration.setDataSource(dataSource);
    }

    private void targetElement(XNode root) {
        GenTarget modelGenerator = genTargetAttr(root.evalNode("javaModelGenerator"));
        GenTarget daoGenerator = genTargetAttr(root.evalNode("javaDaoGenerator"));
        GenTarget mapperGenerator = genTargetAttr(root.evalNode("mapperGenerator"));
        configuration.setModelTarget(modelGenerator);
        configuration.setDaoTarget(daoGenerator);
        configuration.setMapperTarget(mapperGenerator);
    }

    private void tableElements(XNode root) {
        List<XNode> nodes = root.evalNodes("table");
        List<Table> tables = new ArrayList<>();
        for (XNode node : nodes) {
            Table table = new Table();
            table.setClassName(node.getStringAttribute("className"));
            table.setTableName(node.getStringAttribute("tableName"));
            tables.add(table);
        }
        configuration.setTables(tables);
    }

    private GenTarget genTargetAttr(XNode node) {
        GenTarget genTarget = new GenTarget();
        genTarget.setTargetPackage(node.getStringAttribute("targetPackage"));
        genTarget.setTargetProject(node.getStringAttribute("targetProject"));
        return genTarget;
    }
}