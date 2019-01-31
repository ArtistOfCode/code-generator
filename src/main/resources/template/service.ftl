package ${servicePackage};

import ${daoPackage}.${className}Mapper;
import ${modelPackage}.${className};
import ${interfacePackage}.${className}Service;

import javax.annotation.Resource;
import java.util.List;

public class ${className}ServiceImpl implements ${className}Service {

    @Resource
    private ${className}Mapper ${classHumpName}Mapper;

    @Override
    public int insert${className}(${className} ${classHumpName}) {
        return ${classHumpName}Mapper.insert(${classHumpName});
    }

    @Override
    public List<${className}> select${className}List(${className} ${classHumpName}) {
        return ${classHumpName}Mapper.select(${classHumpName});
    }

    @Override
    public ${className} select${className}ById(${idClassType} id) {
        return ${classHumpName}Mapper.selectById(id);
    }

    @Override
    public int update${className}ById(${className} ${classHumpName}) {
        return ${classHumpName}Mapper.updateById(${classHumpName});
    }

    @Override
    public int delete${className}ById(${idClassType} id) {
        return ${classHumpName}Mapper.deleteById(id);
    }
}
