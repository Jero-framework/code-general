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
* 代码生成基本字段实体
*
* @author hzwlsoft
* @date 2020-04-26
*/
@ApiModel(value="CodeBaseInfo实体", description="代码生成基本字段")
@TableName("code_base_info")
@Data
public class CodeBaseInfoEO extends BaseEntity<CodeBaseInfoEO>{

    @TableId("id")
    private Long id;

    @ApiModelProperty(value = "表名")
    @TableField("table_name")
    @NotNull(message = "请填写表名")
    @Max(value = 30, message = "表名仅能为0-30位任意字符")
    private String tableName;

    @ApiModelProperty(value = "表描述")
    @TableField("table_description")
    @Max(value = 200, message = "表描述仅能为0-200位任意字符")
    private String tableDescription;

    @ApiModelProperty(value = "数据库地址")
    @TableField("database_url")
    @Max(value = 500, message = "数据库地址仅能为0-500位任意字符")
    private String databaseUrl;

    @ApiModelProperty(value = "数据库用户名")
    @TableField("database_username")
    @Max(value = 50, message = "数据库用户名仅能为0-50位任意字符")
    private String databaseUsername;

    @ApiModelProperty(value = "数据库密码")
    @TableField("database_password")
    @Max(value = 50, message = "数据库密码仅能为0-50位任意字符")
    private String databasePassword;

    @ApiModelProperty(value = "是否高级查询，0为否，1为是")
    @TableField("is_senior_query")
    @NotNull(message = "请选择是否为高级查询")
    private Integer isSeniorQuery;

    @ApiModelProperty(value = "是否复选框，0为否，1为是")
    @TableField("is_checkbox")
    @NotNull(message = "请选择是否含有复选框")
    private Integer isCheckbox;

    @ApiModelProperty(value = "是否分页，0为否，1为是")
    @TableField("is_page")
    @NotNull(message = "请选择是否分页展示")
    private Integer isPage;

    @ApiModelProperty(value = "是否是树，0为否，1为是")
    @TableField("is_tree")
    @NotNull(message = "请选择是否为树形结构")
    private Integer isTree;

}
