package com.codeartist.mybatis.generator.builder;

import com.codeartist.mybatis.generator.config.*;
import com.codeartist.mybatis.generator.parsing.XNode;
import com.codeartist.mybatis.generator.parsing.XPathParser;

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
public class XMLConfigBuilder {

    private Configuration configuration;
    private final XPathParser parser;

    public XMLConfigBuilder(String path) throws FileNotFoundException {
        this(new File(path));
    }

    public XMLConfigBuilder(File file) throws FileNotFoundException {
        this(new FileInputStream(file));
    }

    public XMLConfigBuilder(InputStream inputStream) {
        this.parser = new XPathParser(inputStream);
    }

    public Configuration parse() {
        this.configuration = new Configuration();
        parseConfiguration(parser.evalNode("/config"));
        return configuration;
    }

    private void parseConfiguration(XNode root) {
        Properties properties = settingsAsProperties(root.evalNode("settings"));
        settingsElement(properties);
        dataSourceElement(root.evalNode("dataSource"));
        modelTargetElement(root.evalNode("javaModelGenerator"));
        daoTargetElement(root.evalNode("mapperGenerator"));
        mapperTargetElement(root.evalNode("javaDaoGenerator"));
        tableElements(root.evalNodes("table"));
    }

    private Properties settingsAsProperties(XNode node) {
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

    private void dataSourceElement(XNode node) {
        DataSource dataSource = new DataSource();
        dataSource.setDriver(node.getStringAttribute("driver"));
        dataSource.setUrl(node.getStringAttribute("url"));
        dataSource.setUsername(node.getStringAttribute("username"));
        dataSource.setPassword(node.getStringAttribute("password"));
        configuration.setDataSource(dataSource);
    }

    private void modelTargetElement(XNode node) {
        configuration.setModelTarget(genTargetAttr(node));
    }

    private void daoTargetElement(XNode node) {
        configuration.setDaoTarget(genTargetAttr(node));
    }

    private void mapperTargetElement(XNode node) {
        configuration.setMapperTarget(genTargetAttr(node));
    }

    private void tableElements(List<XNode> nodes) {
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