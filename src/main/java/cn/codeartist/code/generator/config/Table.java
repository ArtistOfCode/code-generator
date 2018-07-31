package cn.codeartist.code.generator.config;

/**
 * 数据库表
 *
 * @author 艾江南
 */
public class Table {

    private String className;
    private String tableName;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return "Table{" +
                "className='" + className + '\'' +
                ", tableName='" + tableName + '\'' +
                '}';
    }
}
