package com.codeartist.mybatis.generator.freemarker;

/**
 * 接口模板对应的数据
 *
 * @author 艾江南
 */
public class DaoData {

    private String packageName;
    private String modelPackage;
    private String modelName;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getModelPackage() {
        return modelPackage;
    }

    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
