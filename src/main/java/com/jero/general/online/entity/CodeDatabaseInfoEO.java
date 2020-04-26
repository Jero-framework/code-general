package com.jero.general.online.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.jero.mp.entity.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
* 表对应的数据库属性实体
*
* @author hzwlsoft
* @date 2020-04-26
*/
@ApiModel(value="CodeDatabaseInfo实体", description="表对应的数据库属性")
@TableName("code_database_info")
public class CodeDatabaseInfoEO extends BaseEntity<CodeDatabaseInfoEO>{

    @TableId("id")
    private Long id;

    @ApiModelProperty(value = "字段名")
    @TableField("field_name")
    @NotNull(message = "请填写字段名")
    @Max(value = 30, message = "字段名仅能为0-30位任意字符")
    private String fieldName;

    @ApiModelProperty(value = "字段描述")
    @TableField("field_description")
    @Max(value = 200, message = "字段备注仅能为0-200位任意字符")
    private String fieldDescription;

    @ApiModelProperty(value = "字段长度")
    @TableField("field_length")
    @NotNull(message = "请填写字段长度")
    private Integer fieldLength;

    @ApiModelProperty(value = "字段长度的小数点")
    @TableField("field_point")
    private Integer fieldPoint;

    @ApiModelProperty(value = "字段类型，String/int/double/Date/Text/Blob")
    @TableField("field_type")
    @NotNull(message = "请选择字段类型")
    private String fieldType;

    @ApiModelProperty(value = "是否是主键，0为否，1为是")
    @TableField("is_primary_key")
    private Integer isPrimaryKey;

    @ApiModelProperty(value = "是否可以为null，0位否，1为是")
    @TableField("is_null")
    private Integer isNull;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public void setFieldDescription(String fieldDescription) {
        this.fieldDescription = fieldDescription;
    }

    public Integer getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(Integer fieldLength) {
        this.fieldLength = fieldLength;
    }

    public Integer getFieldPoint() {
        return fieldPoint;
    }

    public void setFieldPoint(Integer fieldPoint) {
        this.fieldPoint = fieldPoint;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public Integer getIsPrimaryKey() {
        return isPrimaryKey;
    }

    public void setIsPrimaryKey(Integer isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }

    public Integer getIsNull() {
        return isNull;
    }

    public void setIsNull(Integer isNull) {
        this.isNull = isNull;
    }

    @Override
    public String toString() {
        return "CodeDatabaseInfo{" +
            "id=" + id +
            ", fieldName=" + fieldName +
            ", fieldDescription=" + fieldDescription +
            ", fieldLength=" + fieldLength +
            ", fieldPoint=" + fieldPoint +
            ", fieldType=" + fieldType +
            ", isPrimaryKey=" + isPrimaryKey +
            ", isNull=" + isNull +
        "}";
    }

}
