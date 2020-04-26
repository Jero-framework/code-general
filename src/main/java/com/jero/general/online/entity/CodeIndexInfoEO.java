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
* 表对应的索引信息实体
*
* @author hzwlsoft
* @date 2020-04-26
*/
@ApiModel(value="CodeIndexInfo实体", description="表对应的索引信息")
@TableName("code_index_info")
public class CodeIndexInfoEO extends BaseEntity<CodeIndexInfoEO>{

    @TableId("id")
    private Long id;

    @TableField("index_name")
    @NotNull(message = "索引名称不能为空")
    @Max(value = 30, message = "索引名称仅能为0-30位字符")
    private String indexName;

    @ApiModelProperty(value = "索引字段，选择本表中的字段名")
    @TableField("index_filed")
    @NotNull(message = "索引字段不能为空")
    private Long indexFiled;

    @ApiModelProperty(value = "normal、unique")
    @TableField("index_type")
    @NotNull(message = "索引类型不能为空")
    private String indexType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public Long getIndexFiled() {
        return indexFiled;
    }

    public void setIndexFiled(Long indexFiled) {
        this.indexFiled = indexFiled;
    }

    public String getIndexType() {
        return indexType;
    }

    public void setIndexType(String indexType) {
        this.indexType = indexType;
    }

    @Override
    public String toString() {
        return "CodeIndexInfo{" +
            "id=" + id +
            ", indexName=" + indexName +
            ", indexFiled=" + indexFiled +
            ", indexType=" + indexType +
        "}";
    }

}
