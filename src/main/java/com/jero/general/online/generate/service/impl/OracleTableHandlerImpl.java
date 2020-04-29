package com.jero.general.online.generate.service.impl;

import com.jero.common.utils.StringUtils;
import com.jero.enums.YesOrNoEnum;
import com.jero.general.online.generate.meta.DataFieldMeta;
import com.jero.general.online.generate.service.DBTableHandler;

/**
 * @Description oracle数据库针对字段操作sql的具体实现
 * @Author lixuetao
 * @Date 2020/4/29
 **/
public class OracleTableHandlerImpl implements DBTableHandler{

    @Override
    public String getAddFieldSql(DataFieldMeta fieldMeta) {
        StringBuilder sql = new StringBuilder("ADD ")
                .append(handlerFieldMetaToSql(fieldMeta))
                .append(";");
        return sql.toString();
    }

    @Override
    public String getRenameFieldNameSql(DataFieldMeta fieldMeta) {
        StringBuilder sql = new StringBuilder("RENAME COLUMN ")
                .append(fieldMeta.getOldFieldName())
                .append(" TO ")
                .append(fieldMeta.getFieldName())
                .append(";");
        return sql.toString();
    }

    @Override
    public String getUpdateFieldSql(DataFieldMeta fieldMeta) {
        StringBuilder sql = new StringBuilder("MODIFY ")
                .append(handlerFieldMetaToSql(fieldMeta))
                .append(";");
        return sql.toString();
    }

    @Override
    public String getMatchClassTypeByDataType(String fieldType, int digits) {
        return null;
    }

    @Override
    public String getDropTableSql(String tableName) {
        StringBuilder sql = new StringBuilder("DROP TABLE ")
                .append(tableName.toLowerCase())
                .append(";");
        return sql.toString();
    }

    @Override
    public String getDropColumnSql(String fieldName) {
        StringBuilder sql = new StringBuilder("DROP COLUMN ")
                .append(fieldName.toUpperCase())
                .append(";");
        return sql.toString();
    }

    @Override
    public String getCommentSql(DataFieldMeta fieldMeta) {
        StringBuilder sql = new StringBuilder("COMMENT ON COLUMN ")
                .append(fieldMeta.getTableName())
                .append(fieldMeta.getFieldName())
                .append(" IS ")
                .append(fieldMeta.getFieldComment())
                .append(";");
        return sql.toString();
    }

    @Override
    public String getDropIndexsSql(String indexName, String tableName) {
        StringBuilder sql = new StringBuilder("DROP INDEX ")
                .append(indexName)
                .append(";");
        return sql.toString();
    }

    @Override
    public String countIndex(String indexName, String tableName) {
        StringBuilder sql = new StringBuilder("select COUNT(*) from user_indexes where TABLE_NAME = '")
                .append(tableName)
                .append("' AND INDEX_NAME = '")
                .append(indexName)
                .append("'");
        return sql.toString();
    }

    /**
     * 将数据库原属性转换成
     * @param dataFieldMeta
     * @return
     */
    private String handlerFieldMetaToSql(DataFieldMeta dataFieldMeta){
        StringBuilder sql = new StringBuilder();
        if ("string".equalsIgnoreCase(dataFieldMeta.getFieldType())){
            sql.append(dataFieldMeta.getFieldName())
                    .append(" varchar2(")
                    .append(dataFieldMeta.getFieldSize())
                    .append(") ");
        } else if ("date".equalsIgnoreCase(dataFieldMeta.getFieldType())){
            sql.append(dataFieldMeta.getFieldName())
                    .append(" date ");
        } else if ("Integer".equalsIgnoreCase(dataFieldMeta.getFieldType()) || "Long".equalsIgnoreCase(dataFieldMeta.getFieldType())){
            sql.append(dataFieldMeta.getFieldName())
                    .append(" NUMBER(")
                    .append("(")
                    .append(dataFieldMeta.getFieldSize())
                    .append(") ");
        } else if ("double".equalsIgnoreCase(dataFieldMeta.getFieldType()) || "bigDecimal".equalsIgnoreCase(dataFieldMeta.getFieldType())){
            sql.append(dataFieldMeta.getFieldName())
                    .append(" NUMBER(")
                    .append(dataFieldMeta.getFieldSize())
                    .append(",")
                    .append(dataFieldMeta.getDecimalDigits())
                    .append(") ");
        } else if ("text".equalsIgnoreCase(dataFieldMeta.getFieldType())){
            sql.append(dataFieldMeta.getFieldName())
                    .append(" CLOB ");
        } else if ("blob".equalsIgnoreCase(dataFieldMeta.getFieldType())){
            sql.append(dataFieldMeta.getFieldName())
                    .append(" BLOB ");
        }

        // 添加默认值语句
        if (StringUtils.isNotEmpty(dataFieldMeta.getFieldDefault())){
            sql.append(" DEFAULT ")
                    .append(dataFieldMeta.getFieldDefault())
                    .append(" ");
        }

        sql.append(getFieldNullInfo(dataFieldMeta.getIsNullable()));

        return sql.toString();
    }

    private String getFieldNullInfo(Integer isNullable){
        return isNullable == YesOrNoEnum.YES.getValue() ? "NULL" : "NOT NULL";
    }

}
