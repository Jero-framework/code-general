package com.jero.general.online.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.jero.mp.entity.BaseEntity;

/**
* 代码生成基本字段实体
*
* @author hzwlsoft
* @date 2020-04-26
*/
@ApiModel(value="CodeBaseInfo实体", description="代码生成基本字段")
@TableName("code_base_info")
public class CodeBaseInfoEO extends BaseEntity<CodeBaseInfoEO>{

    @TableId("id")
    private Long id;

    @ApiModelProperty(value = "表名")
    @TableField("table_name")
    private String tableName;

    @ApiModelProperty(value = "表描述")
    @TableField("table_description")
    private String tableDescription;

    @ApiModelProperty(value = "数据库地址")
    @TableField("database_url")
    private String databaseUrl;

    @ApiModelProperty(value = "数据库用户名")
    @TableField("database_username")
    private String databaseUsername;

    @ApiModelProperty(value = "数据库密码")
    @TableField("database_password")
    private String databasePassword;

    @ApiModelProperty(value = "是否高级查询，0为否，1为是")
    @TableField("is_senior_query")
    private Integer isSeniorQuery;

    @ApiModelProperty(value = "是否复选框，0为否，1为是")
    @TableField("is_checkbox")
    private Integer isCheckbox;

    @ApiModelProperty(value = "是否分页，0为否，1为是")
    @TableField("is_page")
    private Integer isPage;

    @ApiModelProperty(value = "是否是树，0为否，1为是")
    @TableField("is_tree")
    private Integer isTree;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableDescription() {
        return tableDescription;
    }

    public void setTableDescription(String tableDescription) {
        this.tableDescription = tableDescription;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getDatabaseUsername() {
        return databaseUsername;
    }

    public void setDatabaseUsername(String databaseUsername) {
        this.databaseUsername = databaseUsername;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    public Integer getIsSeniorQuery() {
        return isSeniorQuery;
    }

    public void setIsSeniorQuery(Integer isSeniorQuery) {
        this.isSeniorQuery = isSeniorQuery;
    }

    public Integer getIsCheckbox() {
        return isCheckbox;
    }

    public void setIsCheckbox(Integer isCheckbox) {
        this.isCheckbox = isCheckbox;
    }

    public Integer getIsPage() {
        return isPage;
    }

    public void setIsPage(Integer isPage) {
        this.isPage = isPage;
    }

    public Integer getIsTree() {
        return isTree;
    }

    public void setIsTree(Integer isTree) {
        this.isTree = isTree;
    }

    @Override
    public String toString() {
        return "CodeBaseInfo{" +
            "id=" + id +
            ", tableName=" + tableName +
            ", tableDescription=" + tableDescription +
            ", databaseUrl=" + databaseUrl +
            ", databaseUsername=" + databaseUsername +
            ", databasePassword=" + databasePassword +
            ", isSeniorQuery=" + isSeniorQuery +
            ", isCheckbox=" + isCheckbox +
            ", isPage=" + isPage +
            ", isTree=" + isTree +
        "}";
    }

}
