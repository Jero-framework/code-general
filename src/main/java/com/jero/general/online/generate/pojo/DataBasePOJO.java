package com.jero.general.online.generate.pojo;

/**
 * 数据库的相关属性
 *
 * @Author lixuetao
 * @Date 2020/4/28
 **/
public class DataBasePOJO {

    private String tableName; //表名

    private String fieldName; //字段名

    private int fieldSize; //字段长度

    private String fieldType; //字段类型

    private String fieldComment; //字段注释

    private int decimalDigits; //小数点位数

    private int isNullable; //是否可以为null，0为否，1为是

    private String oldFieldName; //旧字段名，用于重命名字段的时候

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldComment() {
        return fieldComment;
    }

    public void setFieldComment(String fieldComment) {
        this.fieldComment = fieldComment;
    }

    public int getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(int decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

    public int getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(int isNullable) {
        this.isNullable = isNullable;
    }

    public String getOldFieldName() {
        return oldFieldName;
    }

    public void setOldFieldName(String oldFieldName) {
        this.oldFieldName = oldFieldName;
    }
}
