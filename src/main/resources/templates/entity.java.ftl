package ${package.Entity};

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
<#if swagger2>
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
</#if>
import com.jero.mp.entity.BaseEntity;

/**
* ${table.comment!}实体
*
* @author ${author}
* @date ${date}
*/
<#if swagger2>
    @ApiModel(value="${entity}实体", description="${table.comment!}")
</#if>
@TableName("${table.name}")
public class ${entity}EO extends BaseEntity<${entity}EO>{

    <#list table.fields as field>
        <#if field.keyFlag>
            <#assign keyPropertyName="${field.propertyName}"/>
        </#if>

        <#if field.comment!?length gt 0>
            <#if swagger2>
                @ApiModelProperty(value = "${field.comment}")
            <#else>
                /**
                * ${field.comment}
                */
            </#if>
        </#if>
        <#if field.keyFlag>
        <#-- 主键 -->
            <#if field.keyIdentityFlag>
                @TableId(value = "${field.name}", type = IdType.AUTO)
            <#elseif idType??>
                @TableId(value = "${field.name}", type = IdType.${idType})
            <#elseif field.convert>
                @TableId("${field.name}")
            </#if>
        <#-- 普通字段 -->
        <#elseif field.fill??>
        <#-- -----   存在字段填充设置   ----->
            <#if field.convert>
                @TableField(value = "${field.name}", fill = FieldFill.${field.fill})
            <#else>
                @TableField(fill = FieldFill.${field.fill})
            </#if>
        <#elseif field.convert>
            @TableField("${field.name}")
        </#if>
    <#-- 乐观锁注解 -->
        <#if (versionFieldName!"") == field.name>
            @Version
        </#if>
    <#-- 逻辑删除注解 -->
        <#if (logicDeleteFieldName!"") == field.name>
            @TableLogic
        </#if>
        private ${field.propertyType} ${field.propertyName};
    </#list>

    <#------------  END 字段循环遍历  ---------->

    <#if !entityLombokModel>
        <#list table.fields as field>
            <#if field.propertyType == "boolean">
                <#assign getprefix="is"/>
            <#else>
                <#assign getprefix="get"/>
            </#if>
            public ${field.propertyType} ${getprefix}${field.capitalName}() {
            return ${field.propertyName};
            }

            <#if entityBuilderModel>
                public ${entity} set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
            <#else>
                public void set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
            </#if>
            this.${field.propertyName} = ${field.propertyName};
            <#if entityBuilderModel>
                return this;
            </#if>
            }
        </#list>
    </#if>

    <#if entityColumnConstant>
        <#list table.fields as field>
            public static final String ${table.name?upper_case}_${field.name?upper_case} = "${field.name}";

        </#list>
    </#if>

    <#if !entityLombokModel>
        @Override
        public String toString() {
        return "${entity}{" +
        <#list table.fields as field>
            <#if field_index==0>
                "${field.propertyName}=" + ${field.propertyName} +
            <#else>
                ", ${field.propertyName}=" + ${field.propertyName} +
            </#if>
        </#list>
        "}";
        }
    </#if>
}