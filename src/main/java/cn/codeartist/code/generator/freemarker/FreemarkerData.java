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
    private String interfacePackage;
    private String servicePackage;
    private String controllerPackage;
    private String className;
    private String classHumpName;
    private String classComment;
    private String tableName;
    private String idClassType;

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

    public String getInterfacePackage() {
        return interfacePackage;
    }

    public void setInterfacePackage(String interfacePackage) {
        this.interfacePackage = interfacePackage;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
    }

    public String getClassHumpName() {
        return classHumpName;
    }

    public void setClassHumpName(String classHumpName) {
        this.classHumpName = classHumpName;
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

    public String getIdClassType() {
        return idClassType;
    }

    public void setIdClassType(String idClassType) {
        this.idClassType = idClassType;
    }
}
