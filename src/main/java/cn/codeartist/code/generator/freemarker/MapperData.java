package cn.codeartist.code.generator.freemarker;

/**
 * Mapper模板对应的数据
 *
 * @author 艾江南
 */
public class MapperData extends BaseData {

    private String daoPackage;
    private String modelPackage;
    private String tableName;

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
}
