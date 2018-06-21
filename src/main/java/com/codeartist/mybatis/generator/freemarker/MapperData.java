package com.codeartist.mybatis.generator.freemarker;

import com.codeartist.mybatis.generator.jdbc.DataTableColumn;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper模板对应的数据
 *
 * @author 艾江南
 */
public class MapperData {

    private String daoPackage;
    private String modelPackage;
    private String tableName;
    private List<Field> fields;

    public String getDaoPackage() {
        return daoPackage;
    }

    public void setDaoPackage(String daoPackage) {
        this.daoPackage = daoPackage;
    }

    public String getModelPackage() {
        return modelPackage;
    }

    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
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
