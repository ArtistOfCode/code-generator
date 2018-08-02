package cn.codeartist.code.generator.freemarker;

/**
 * 实体类模板对应的数据
 *
 * @author 艾江南
 */
public class ModelData extends BaseData {

    private String packageName;
    private String className;
    private String classComment;

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
}
