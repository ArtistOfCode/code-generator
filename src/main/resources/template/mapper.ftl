<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${daoPackage}.${className}Mapper">

    <sql id="column_list">
        <#list fields as field>`${field.column}`<#if field_has_next>,</#if></#list>
    </sql>

    <sql id="column_map">
        <#list fields as field>`${field.column}`<#if field.column != field.humpName> AS ${field.humpName}</#if><#if field_has_next>,</#if></#list>
    </sql>

    <sql id="column_set">
        <set>
            <#list fields as field>
            <if test="${field.humpName} != null<#if field.dataType == "String"> and ${field.humpName} != ''</#if>">
                `${field.column}`=${"#{"}${field.humpName}${"}"}
            </if>
            </#list>
        </set>
    </sql>

    <insert id="insert" parameterType="${modelPackage}.${className}">
        INSERT INTO `${tableName}` (<include refid="column_list"/>) VALUES (<#list fields as field>${"#{"}${field.humpName}${"}"}<#if field_has_next>,</#if></#list>);
    </insert>

    <select id="select" resultType="${modelPackage}.${className}">
        SELECT <include refid="column_map"/> FROM `${tableName}`
    </select>

    <select id="selectById" resultType="${modelPackage}.${className}">
        SELECT <include refid="column_map"/> FROM `${tableName}` WHERE `id`=${"#{"}id${"}"}
    </select>

    <update id="updateById">
        UPDATE `${tableName}`
        <include refid="column_set"/>
        WHERE `id`=${"#{"}id${"}"}
    </update>

    <delete id="deleteById">
        DELETE FROM `${tableName}` WHERE `id`=${"#{"}id${"}"}
    </delete>

</mapper>