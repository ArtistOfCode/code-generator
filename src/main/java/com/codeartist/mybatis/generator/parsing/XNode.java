package com.codeartist.mybatis.generator.parsing;

import org.w3c.dom.CharacterData;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 配置文件节点
 *
 * @author 艾江南
 */
public class XNode {

    private final Node node;
    private final String name;
    private final String body;
    private final Properties attrs;
    private final XPathParser xpathParser;

    public XNode(XPathParser xpathParser, Node node) {
        this.node = node;
        this.name = node.getNodeName();
        this.body = parseBody(node);
        this.attrs = parseAttrs(node);
        this.xpathParser = xpathParser;
    }

    private String parseBody(Node node) {
        if (node.getNodeType() == Node.CDATA_SECTION_NODE || node.getNodeType() == Node.TEXT_NODE) {
            return ((CharacterData) node).getData();
        }
        return null;
    }

    private Properties parseAttrs(Node node) {
        Properties properties = new Properties();
        NamedNodeMap attributes = node.getAttributes();
        if (attributes != null) {
            for (int i = 0, n = attributes.getLength(); i < n; i++) {
                Node item = attributes.item(i);
                properties.put(item.getNodeName(), item.getNodeValue());
            }
        }
        return properties;
    }

    public String evalString(String expression) {
        return xpathParser.evalString(expression);
    }

    public XNode evalNode(String expression) {
        return xpathParser.evalNode(node, expression);
    }

    public List<XNode> evalNodes(String expression) {
        return xpathParser.evalNodes(node, expression);
    }

    public Properties getChildrenAsProperties() {
        Properties properties = new Properties();
        for (XNode child : getChildren()) {
            String name = child.getStringAttribute("name");
            String value = child.getStringAttribute("value");
            if (name != null && value != null) {
                properties.setProperty(name, value);
            }
        }
        return properties;
    }

    public List<XNode> getChildren() {
        List<XNode> children = new ArrayList<>();
        NodeList nodeList = node.getChildNodes();
        if (nodeList != null) {
            for (int i = 0, n = nodeList.getLength(); i < n; i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    children.add(new XNode(xpathParser, node));
                }
            }
        }
        return children;
    }

    public String getStringAttribute(String name) {
        return getStringAttribute(name, null);
    }

    public String getStringAttribute(String name, String def) {
        String value = attrs.getProperty(name);
        return value == null ? def : value;
    }

}
