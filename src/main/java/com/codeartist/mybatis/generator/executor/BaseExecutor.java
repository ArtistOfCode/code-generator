package com.codeartist.mybatis.generator.executor;

import com.codeartist.mybatis.generator.builder.DataSourceBuilder;
import com.codeartist.mybatis.generator.builder.FileBuilder;
import com.codeartist.mybatis.generator.config.Configuration;
import com.codeartist.mybatis.generator.freemarker.ModelData;
import com.codeartist.mybatis.generator.jdbc.DataTable;
import com.codeartist.mybatis.generator.parsing.Template;
import com.codeartist.mybatis.generator.utils.NameUtil;

import java.util.List;

public class BaseExecutor implements Executor {

    private final FileBuilder fileBuilder = new FileBuilder();
    private final Configuration configuration;
    private final List<DataTable> dataTables;

    public BaseExecutor(Configuration configuration) {
        this.configuration = configuration;
        this.dataTables = new DataSourceBuilder(configuration).build();
    }

    @Override
    public void generateModel() {
        String tProject = configuration.getModelTarget().getTargetProject();
        String tPackage = configuration.getMapperTarget().getTargetPackage();
        String path = tProject + NameUtil.packageToDir(tPackage);
        ModelData modelData = new ModelData();
        modelData.setPackageName(tPackage);
        for (DataTable dataTable : dataTables) {
            String table = dataTable.getTable().getClassName();
            modelData.setClassName(table == null || "".equals(table.trim()) ? NameUtil.bigHumpName(dataTable.getTable().getTableName()) : table);
            modelData.setClassComment(dataTable.getComment());
            modelData.setFields(dataTable.getColumns());
            fileBuilder.build(Template.MODEL, path + "/" + modelData.getClassName() + ".java", modelData);
        }
    }

    @Override
    public void generateDao() {
        // TODO: 2018/6/21 generateDao
    }

    @Override
    public void generateMapper() {
        // TODO: 2018/6/21 generateMapper
    }
}
