package com.codeartist.mybatis.generator.freemarker;

import com.codeartist.mybatis.generator.jdbc.DataTableColumn;

import java.util.ArrayList;
import java.util.List;

/**
 * 实体类模板对应的数据
 *
 * @author 艾江南
 */
public class ModelData extends BaseData {

    private String packageName;
    private String className;
    private String classComment;
    private List<Field> fields;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassComment() {
        return classComment;
    }

    public void setClassComment(String classComment) {
        this.classComment = classComment;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<DataTableColumn> columns) {
        List<Field> fields = new ArrayList<>();
        for (DataTableColumn dataTableColumn : columns) {
            fields.add(new Field(dataTableColumn));
        }
        this.fields = fields;
    }
}
