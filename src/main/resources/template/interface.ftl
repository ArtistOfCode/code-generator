package ${interfacePackage};

import ${modelPackage}.${className};

import java.util.List;

public interface ${className}Provider {

    int insert${className}(${className} ${classHumpName});

    List<${className}> select${className}List(${className} ${classHumpName});

${className} select${className}ById(${idClassType} id);

    int update${className}ById(${className} ${classHumpName});

    int delete${className}ById(${idClassType} id);
}