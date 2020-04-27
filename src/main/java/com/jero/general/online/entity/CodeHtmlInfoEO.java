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
* 表对应的html页面属性实体
*
* @author hzwlsoft
* @date 2020-04-26
*/
@ApiModel(value="CodeHtmlInfo实体", description="表对应的html页面属性")
@TableName("code_html_info")
public class CodeHtmlInfoEO extends BaseEntity<CodeHtmlInfoEO>{

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

    @ApiModelProperty(value = "是否只读，0为否，1为是")
    @TableField("is_readonly")
    @NotNull(message = "请选择是否只读")
    private Integer isReadonly;

    @ApiModelProperty(value = "字段控件，1为文本框，2为密码框，3为单选框，4为多选框，5为日期，6为时间，7为文件，8为图片，9为多行文本，" +
            "10为下拉框、11为下拉多选框、12为树控件、13为部门选择器、14为用户选择器、15位省市区组件")
    @TableField("field_widget")
    @NotNull(message = "请选择字段对应的控件")
    private Integer fieldWidget;

    @ApiModelProperty(value = "字段对应字典值，或字典表。以dic:开头，即寻找字典表")
    @TableField("filed_dic")
    @Max(value = 2000, message = "字段字典值仅能为0-2000位任意字符")
    private String filedDic;

    @ApiModelProperty(value = "默认控件显示在页面的长度")
    @TableField("filed_length")
    @NotNull(message = "请填写字段控件长度")
    private Integer filedLength;

    @ApiModelProperty(value = "是否查询，0为否，1为是")
    @TableField("is_query")
    @NotNull(message = "请选择字段是否需要查询")
    private Integer isQuery;

    @ApiModelProperty(value = "是否必填，0为否，1为是")
    @TableField("is_required")
    @NotNull(message = "请选择字段是否必填")
    private Integer isRequired;

    @ApiModelProperty(value = "字段校验规则，0为正则表达式，1为唯一校验、2为网址、3为电子邮件、4为手机号码、5为邮政编码、6为字母、7为数字、8为整数、9为非标点字符")
    @TableField("valid_rule")
    private Integer validRule;

    @ApiModelProperty(value = "正则表达式，valid_rule为0时，此处必填")
    @TableField("regex")
    @Max(value = 2000, message = "正则表达式仅能为0-2000位任意字符")
    private String regex;

    @TableField("base_info_id")
    private Long baseInfoId;

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

    public Integer getIsReadonly() {
        return isReadonly;
    }

    public void setIsReadonly(Integer isReadonly) {
        this.isReadonly = isReadonly;
    }

    public Integer getFieldWidget() {
        return fieldWidget;
    }

    public void setFieldWidget(Integer fieldWidget) {
        this.fieldWidget = fieldWidget;
    }

    public String getFiledDic() {
        return filedDic;
    }

    public void setFiledDic(String filedDic) {
        this.filedDic = filedDic;
    }

    public Integer getFiledLength() {
        return filedLength;
    }

    public void setFiledLength(Integer filedLength) {
        this.filedLength = filedLength;
    }

    public Integer getIsQuery() {
        return isQuery;
    }

    public void setIsQuery(Integer isQuery) {
        this.isQuery = isQuery;
    }

    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    public Integer getValidRule() {
        return validRule;
    }

    public void setValidRule(Integer validRule) {
        this.validRule = validRule;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public Long getBaseInfoId() {
        return baseInfoId;
    }

    public void setBaseInfoId(Long baseInfoId) {
        this.baseInfoId = baseInfoId;
    }

    @Override
    public String toString() {
        return "CodeHtmlInfo{" +
            "id=" + id +
            ", fieldName=" + fieldName +
            ", fieldDescription=" + fieldDescription +
            ", isReadonly=" + isReadonly +
            ", fieldWidget=" + fieldWidget +
            ", filedDic=" + filedDic +
            ", filedLength=" + filedLength +
            ", isQuery=" + isQuery +
            ", isRequired=" + isRequired +
            ", validRule=" + validRule +
            ", regex=" + regex +
        "}";
    }

}
