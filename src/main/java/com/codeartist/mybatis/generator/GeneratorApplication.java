package com.codeartist.mybatis.generator;

import com.codeartist.mybatis.generator.utils.TemplateUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 主方法
 *
 * @author 艾江南
 */
public class GeneratorApplication {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("namespace", "com.ajn.codeartist");
        TemplateUtil.templateToFile("mapper", "test.xml", map);
    }

}
