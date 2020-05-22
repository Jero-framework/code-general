package com.jero.general.online.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.jero.mp.entity.BaseEntity;
import lombok.Data;

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
@Data
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

    @ApiModelProperty(value = "是否可以为null，0为否，1为是")
    @TableField("is_null")
    private Integer isNull;

    @TableField("base_info_id")
    private Long baseInfoId;

}
