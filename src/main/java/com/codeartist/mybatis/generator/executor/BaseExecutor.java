package com.codeartist.mybatis.generator.executor;

import com.codeartist.mybatis.generator.builder.DataSourceBuilder;
import com.codeartist.mybatis.generator.builder.FileBuilder;
import com.codeartist.mybatis.generator.config.Configuration;
import com.codeartist.mybatis.generator.config.Table;
import com.codeartist.mybatis.generator.freemarker.DaoData;
import com.codeartist.mybatis.generator.freemarker.ModelData;
import com.codeartist.mybatis.generator.handler.ClassHandler;
import com.codeartist.mybatis.generator.handler.FieldHandler;
import com.codeartist.mybatis.generator.handler.defaults.BaseClassHandler;
import com.codeartist.mybatis.generator.handler.defaults.BaseFieldHandler;
import com.codeartist.mybatis.generator.jdbc.DataTable;
import com.codeartist.mybatis.generator.parsing.Template;
import com.codeartist.mybatis.generator.utils.NameUtil;

import java.util.List;

public class BaseExecutor implements Executor {

    private final FileBuilder fileBuilder;
    private final ClassHandler classHandler;
    private final Configuration configuration;
    private final List<DataTable> dataTables;

    public BaseExecutor(Configuration configuration) {
        this.fileBuilder = new FileBuilder();
        this.classHandler = new BaseClassHandler();
        this.configuration = configuration;
        this.dataTables = new DataSourceBuilder(configuration).build();
    }

    @Override
    public void generateModel() {
        FieldHandler fieldHandler = new BaseFieldHandler();
        ModelData modelData = new ModelData();
        String tPackage = configuration.getModelTarget().getTargetPackage();
        String path = configuration.getModelTarget().getTargetProject() + NameUtil.packageToDir(tPackage);
        classHandler.packageHandler(path);
        modelData.setPackageName(tPackage);
        classHandler.settingsHandler(modelData, configuration.getSettings());
        for (DataTable dataTable : dataTables) {
            Table table = dataTable.getTable();
            modelData.setClassComment(dataTable.getComment());
            modelData.setFields(dataTable.getColumns());
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
        // TODO: 2018/6/21 generateMapper
    }

}
