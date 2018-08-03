package cn.codeartist.code.generator.executor;

import cn.codeartist.code.generator.builder.DataSourceBuilder;
import cn.codeartist.code.generator.builder.FileBuilder;
import cn.codeartist.code.generator.config.Configuration;
import cn.codeartist.code.generator.config.Table;
import cn.codeartist.code.generator.freemarker.FreemarkerData;
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
    private final FreemarkerData freemarkerData;

    public BaseExecutor(Configuration configuration) {
        this.fileBuilder = new FileBuilder();
        this.classHandler = new BaseClassHandler();
        this.fieldHandler = new BaseFieldHandler();
        this.configuration = configuration;
        this.dataTables = new DataSourceBuilder(configuration).build();
        this.freemarkerData = this.initFreemarkerData(configuration);
    }

    private FreemarkerData initFreemarkerData(Configuration configuration) {
        FreemarkerData freemarkerData = new FreemarkerData();
        freemarkerData.setModelPackage(configuration.getModelTarget().getTargetPackage());
        freemarkerData.setDaoPackage(configuration.getDaoTarget().getTargetPackage());
        freemarkerData.setMapperPackage(configuration.getMapperTarget().getTargetPackage());
        freemarkerData.setInterfacePackage(configuration.getInterfaceTarget().getTargetPackage());
        freemarkerData.setServicePackage(configuration.getServiceTarget().getTargetPackage());
        freemarkerData.setControllerPackage(configuration.getControllerTarget().getTargetPackage());
        return freemarkerData;
    }

    @Override
    public void generateModel() {
        String modelPackage = freemarkerData.getModelPackage();
        String path = configuration.getModelTarget().getTargetProject() + NameUtil.packageToDir(modelPackage);
        classHandler.packageHandler(path);
        classHandler.settingsHandler(freemarkerData, configuration.getSettings());
        for (DataTable dataTable : dataTables) {
            Table table = dataTable.getTable();
            freemarkerData.setClassComment(dataTable.getComment());
            classHandler.classHandler(table);
            fieldHandler.columnToField(freemarkerData, dataTable);
            freemarkerData.setClassName(table.getClassName());
            fieldHandler.importPackageHandler(freemarkerData);
            fileBuilder.build(Template.MODEL, path, freemarkerData.getClassName(), freemarkerData);
        }
    }

    @Override
    public void generateDao() {
        String daoPackage = freemarkerData.getDaoPackage();
        String path = configuration.getDaoTarget().getTargetProject() + NameUtil.packageToDir(daoPackage);
        classHandler.packageHandler(path);
        fileBuilder.build(Template.BASEDAO, path, "", freemarkerData);
        for (DataTable dataTable : dataTables) {
            Table table = dataTable.getTable();
            classHandler.classHandler(table);
            freemarkerData.setClassName(table.getClassName());
            fileBuilder.build(Template.DAO, path, freemarkerData.getClassName(), freemarkerData);
        }
    }

    @Override
    public void generateMapper() {
        String tPackage = freemarkerData.getMapperPackage();
        String path = configuration.getMapperTarget().getTargetProject() + NameUtil.packageToDir(tPackage);
        classHandler.packageHandler(path);
        for (DataTable dataTable : dataTables) {
            Table table = dataTable.getTable();
            fieldHandler.columnToField(freemarkerData, dataTable);
            classHandler.classHandler(table);
            freemarkerData.setClassName(table.getClassName());
            freemarkerData.setTableName(table.getTableName());
            fileBuilder.build(Template.MAPPER, path, freemarkerData.getClassName(), freemarkerData);
        }
    }

    @Override
    public void generatorInterface() {
        String tPackage = freemarkerData.getInterfacePackage();
        String path = configuration.getInterfaceTarget().getTargetProject() + NameUtil.packageToDir(tPackage);
        classHandler.packageHandler(path);
        for (DataTable dataTable : dataTables) {
            Table table = dataTable.getTable();
            freemarkerData.setClassName(table.getClassName());
            freemarkerData.setClassHumpName(NameUtil.humpName(table.getClassName()));
            freemarkerData.setIdClassType(fieldHandler.getIdClassType(dataTable));
            fileBuilder.build(Template.INTERFACE, path, freemarkerData.getClassName(), freemarkerData);
        }
    }

    @Override
    public void generatorService() {
        String tPackage = freemarkerData.getServicePackage();
        String path = configuration.getServiceTarget().getTargetProject() + NameUtil.packageToDir(tPackage);
        classHandler.packageHandler(path);
        for (DataTable dataTable : dataTables) {
            Table table = dataTable.getTable();
            freemarkerData.setClassName(table.getClassName());
            freemarkerData.setClassHumpName(NameUtil.humpName(table.getClassName()));
            freemarkerData.setIdClassType(fieldHandler.getIdClassType(dataTable));
            fileBuilder.build(Template.SERVICE, path, freemarkerData.getClassName(), freemarkerData);
        }
    }

    @Override
    public void generatorController() {

    }
}
