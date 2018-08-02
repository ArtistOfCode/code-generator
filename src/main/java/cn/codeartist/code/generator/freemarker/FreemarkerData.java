package cn.codeartist.code.generator.freemarker;

/**
 * 模板使用数据
 *
 * @author 艾江南
 */
public class FreemarkerData extends BaseData {

    private String modelPackage;
    private String daoPackage;
    private String mapperPackage;
    private String className;
    private String classComment;
    private String tableName;

    public String getModelPackage() {
        return modelPackage;
    }

    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }

    public String getDaoPackage() {
        return daoPackage;
    }

    public void setDaoPackage(String daoPackage) {
        this.daoPackage = daoPackage;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
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

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
