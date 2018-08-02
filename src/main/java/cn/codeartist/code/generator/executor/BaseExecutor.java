package cn.codeartist.code.generator.executor;

import cn.codeartist.code.generator.builder.DataSourceBuilder;
import cn.codeartist.code.generator.builder.FileBuilder;
import cn.codeartist.code.generator.config.Configuration;
import cn.codeartist.code.generator.config.Table;
import cn.codeartist.code.generator.freemarker.DaoData;
import cn.codeartist.code.generator.freemarker.MapperData;
import cn.codeartist.code.generator.freemarker.ModelData;
import cn.codeartist.code.generator.handler.ClassHandler;
import cn.codeartist.code.generator.handler.FieldHandler;
import cn.codeartist.code.generator.handler.defaults.BaseClassHandler;
import cn.codeartist.code.generator.handler.defaults.BaseFieldHandler;
import cn.codeartist.code.generator.jdbc.DataTable;
import cn.codeartist.code.generator.parsing.Template;
import cn.codeartist.code.generator.utils.NameUtil;

import java.util.List;

/**
 * 生成模块执行基础实现
 *
 * @author 艾江南
 */
public class BaseExecutor implements Executor {

    private final FileBuilder fileBuilder;
    private final ClassHandler classHandler;
    private final FieldHandler fieldHandler;
    private final Configuration configuration;
    private final List<DataTable> dataTables;

    public BaseExecutor(Configuration configuration) {
        this.fileBuilder = new FileBuilder();
        this.classHandler = new BaseClassHandler();
        this.fieldHandler = new BaseFieldHandler();
        this.configuration = configuration;
        this.dataTables = new DataSourceBuilder(configuration).build();
    }

    @Override
    public void generateModel() {
        ModelData modelData = new ModelData();
        String tPackage = configuration.getModelTarget().getTargetPackage();
        String path = configuration.getModelTarget().getTargetProject() + NameUtil.packageToDir(tPackage);
        classHandler.packageHandler(path);
        modelData.setPackageName(tPackage);
        classHandler.settingsHandler(modelData, configuration.getSettings());
        for (DataTable dataTable : dataTables) {
            Table table = dataTable.getTable();
            modelData.setClassComment(dataTable.getComment());
            fieldHandler.columnToField(modelData, dataTable);
            classHandler.classHandler(table);
            modelData.setClassName(table.getClassName());
            fieldHandler.importPackageHandler(modelData);
            fileBuilder.build(Template.MODEL, path + "/" + modelData.getClassName() + ".java", modelData);
        }
    }

    @Override
    public void generateDao() {
        String tPackage = configuration.getDaoTarget().getTargetPackage();
        String path = configuration.getDaoTarget().getTargetProject() + NameUtil.packageToDir(tPackage);
        DaoData daoData = new DaoData();
        daoData.setPackageName(tPackage);
        classHandler.packageHandler(path);
        fileBuilder.build(Template.BASEDAO, path + "/BaseMapper.java", daoData);
        for (DataTable dataTable : dataTables) {
            Table table = dataTable.getTable();
            classHandler.classHandler(table);
            daoData.setModelName(table.getClassName());
            daoData.setModelPackage(configuration.getModelTarget().getTargetPackage() + "." + daoData.getModelName());
            fileBuilder.build(Template.DAO, path + "/" + daoData.getModelName() + "Mapper.java", daoData);
        }
    }

    @Override
    public void generateMapper() {
        String tPackage = configuration.getMapperTarget().getTargetPackage();
        String path = configuration.getMapperTarget().getTargetProject() + NameUtil.packageToDir(tPackage);
        MapperData mapperData = new MapperData();
        classHandler.packageHandler(path);
        for (DataTable dataTable : dataTables) {
            String className = dataTable.getTable().getClassName();
            fieldHandler.columnToField(mapperData, dataTable);
            mapperData.setTableName(dataTable.getTable().getTableName());
            mapperData.setDaoPackage(configuration.getDaoTarget().getTargetPackage() + "." + className + "Mapper");
            mapperData.setModelPackage(configuration.getModelTarget().getTargetPackage() + "." + className);
            fileBuilder.build(Template.MAPPER, path + "/" + className + "Mapper.xml", mapperData);
        }
    }

}
