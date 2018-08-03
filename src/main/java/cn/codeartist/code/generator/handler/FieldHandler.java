package cn.codeartist.code.generator.handler;

import cn.codeartist.code.generator.freemarker.BaseData;
import cn.codeartist.code.generator.jdbc.DataTable;

/**
 * 对字段的处理器
 *
 * @author 艾江南
 */
public interface FieldHandler {

    /**
     * 根据数据类型判断是否要导入包
     *
     * @param baseData 基础数据
     */
    void importPackageHandler(BaseData baseData);

    /**
     * 数据库表字段名转类成员变量
     *
     * @param baseData  基础数据
     * @param dataTable 数据库表信息
     */
    void columnToField(BaseData baseData, DataTable dataTable);

    /**
     * 获取ID的数据类型
     *
     * @param dataTable 数据库表
     * @return ID数据类型
     */
    String getIdClassType(DataTable dataTable);

}
