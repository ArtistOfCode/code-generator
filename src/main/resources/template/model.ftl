package ${packageName};

<#if haveSerializable>import java.io.Serializable;
</#if><#if haveBigDecimalField>import java.math.BigDecimal;
</#if><#if haveDateField>import java.util.Date;
</#if>

/**
 * ${classComment}
 *
 * @author 艾江南
 */
public class ${className} <#if haveSerializable>implements Serializable </#if>{

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