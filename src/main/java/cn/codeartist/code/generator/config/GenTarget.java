package cn.codeartist.code.generator.config;

/**
 * 生成源代码目标文件夹
 *
 * @author 艾江南
 */
public class GenTarget {

    private String targetPackage;
    private String targetProject;

    public String getTargetPackage() {
        return targetPackage;
    }

    public void setTargetPackage(String targetPackage) {
        this.targetPackage = targetPackage;
    }

    public String getTargetProject() {
        return targetProject;
    }

    public void setTargetProject(String targetProject) {
        this.targetProject = targetProject;
    }

    @Override
    public String toString() {
        return "GenTarget{" +
                "targetPackage='" + targetPackage + '\'' +
                ", targetProject='" + targetProject + '\'' +
                '}';
    }
}
