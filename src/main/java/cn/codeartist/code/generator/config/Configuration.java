package cn.codeartist.code.generator.config;

import java.util.List;

/**
 * 配置文件实体
 *
 * @author 艾江南
 */
public class Configuration {

    private Settings settings;
    private DataSource dataSource;
    private GenTarget modelTarget;
    private GenTarget daoTarget;
    private GenTarget mapperTarget;
    private List<Table> tables;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public GenTarget getModelTarget() {
        return modelTarget;
    }

    public void setModelTarget(GenTarget modelTarget) {
        this.modelTarget = modelTarget;
    }

    public GenTarget getDaoTarget() {
        return daoTarget;
    }

    public void setDaoTarget(GenTarget daoTarget) {
        this.daoTarget = daoTarget;
    }

    public GenTarget getMapperTarget() {
        return mapperTarget;
    }

    public void setMapperTarget(GenTarget mapperTarget) {
        this.mapperTarget = mapperTarget;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "settings=" + settings +
                ", dataSource=" + dataSource +
                ", modelTarget=" + modelTarget +
                ", daoTarget=" + daoTarget +
                ", mapperTarget=" + mapperTarget +
                ", tables=" + tables +
                '}';
    }
}
