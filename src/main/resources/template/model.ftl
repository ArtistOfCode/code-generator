package ${packageName};

import java.io.Serializable;

/**
 * ${classComment}
 *
 * @author 艾江南
 */
public class ${className} implements Serializable {

<#list fields as field>
    /**
     * ${field.comment}
     */
    private ${field.dataType} ${field.humpName};
</#list>
<#list fields as field>

    public ${field.dataType} get${field.bigHumpName}() {
        return ${field.humpName};
    }

    public void set${field.bigHumpName}(${field.dataType} ${field.humpName}) {
        this.${field.humpName} = ${field.humpName};
    }
</#list>
}