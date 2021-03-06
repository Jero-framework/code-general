package com.jero.general.online.generate.service.impl;

import com.jero.common.utils.StringUtils;
import com.jero.enums.YesOrNoEnum;
import com.jero.general.online.generate.meta.DataFieldMeta;
import com.jero.general.online.generate.meta.TableMeta;
import com.jero.general.online.generate.service.DBTableHandler;

import java.util.List;

/**
 * mysql数据库针对字段操作sql的具体实现
 *
 * 示例：
 * CREATE TABLE `NewTable` (
 * `id`  bigint NOT NULL ,
 * `age`  int NULL ,
 * `price`  decimal(10,2) NOT NULL ,
 * `name`  varchar(50) NOT NULL ,
 * `desc`  text NULL COMMENT '描述' ,
 * `sales`  double(10,2) NULL COMMENT '销售量' ,
 * `status`  tinyint NULL DEFAULT 1 COMMENT '状态' ,
 * PRIMARY KEY (`id`)
 * )
 * ;
 *
 * @Author lixuetao
 * @Date 2020/4/28
 **/
public class MysqlTableHandlerImpl implements DBTableHandler {

    public String buildCreateSql(TableMeta tableMeta, List<String> fieldSql){
        return "";
    }

    @Override
    public String getAddFieldSql(DataFieldMeta fieldMeta) {
        StringBuilder sql = new StringBuilder("ADD COLUMN ")
                .append(handlerFieldMetaToSql(fieldMeta))
                .append(";");
        return sql.toString();
    }

    @Override
    public String getRenameFieldNameSql(DataFieldMeta fieldMeta) {
        StringBuilder sql = new StringBuilder("CHANGE COLUMN ")
                .append(fieldMeta.getOldFieldName())
                .append(" ")
                .append(handlerFieldMetaToSql(fieldMeta))
                .append(";");
        return sql.toString();
    }

    @Override
    public String getUpdateFieldSql(DataFieldMeta fieldMeta) {
        StringBuilder sql = new StringBuilder("MODIFY COLUMN")
                .append(handlerFieldMetaToSql(fieldMeta));
        return sql.toString();
    }

    @Override
    public String getMatchClassTypeByDataType(String fieldType, int digits) {
        return null;
    }

    @Override
    public String getDropTableSql(String tableName) {
        StringBuilder sql = new StringBuilder("DROP TABLE IF EXISTS ")
                .append(tableName)
                .append(";");
        return sql.toString();
    }

    @Override
    public String getDropColumnSql(String fieldName) {
        StringBuilder sql = new StringBuilder("DROP COLUMN ")
                .append(fieldName)
                .append(";");
        return sql.toString();
    }

    @Override
    public String getCommentSql(DataFieldMeta fieldMeta) {
        return null;
    }

    @Override
    public String getDropIndexsSql(String indexName, String tableName) {
        StringBuilder sql = new StringBuilder("DROP INDEX ")
                .append(indexName)
                .append(" ON ")
                .append(tableName);
        return sql.toString();
    }

    @Override
    public String countIndex(String indexName, String tableName) {
        StringBuilder sql = new StringBuilder("select COUNT(*) from information_schema.statistics where table_name = '")
                .append(tableName)
                .append("' AND index_name = '")
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
                    .append(" varchar(")
                    .append(dataFieldMeta.getFieldSize())
                    .append(") ");
        } else if ("date".equalsIgnoreCase(dataFieldMeta.getFieldType())){
            sql.append(dataFieldMeta.getFieldName())
                    .append(" datetime ");
        } else if ("Integer".equalsIgnoreCase(dataFieldMeta.getFieldType())){
            sql.append(dataFieldMeta.getFieldName())
                    .append(" int");
            if (dataFieldMeta.getFieldSize() != null) {
                sql.append("(")
                        .append(dataFieldMeta.getFieldSize())
                        .append(") ");
            }
        } else if ("Long".equalsIgnoreCase(dataFieldMeta.getFieldType())){
            sql.append(dataFieldMeta.getFieldName())
                    .append(" bigint");
            if (dataFieldMeta.getFieldSize() != null) {
                sql.append("(")
                        .append(dataFieldMeta.getFieldSize())
                        .append(") ");
            }
        } else if ("double".equalsIgnoreCase(dataFieldMeta.getFieldType())){
            sql.append(dataFieldMeta.getFieldName())
                    .append(" double(")
                    .append(dataFieldMeta.getFieldSize())
                    .append(",")
                    .append(dataFieldMeta.getDecimalDigits())
                    .append(") ");
        } else if ("bigDecimal".equalsIgnoreCase(dataFieldMeta.getFieldType())){
            sql.append(dataFieldMeta.getFieldName())
                    .append(" decimal(")
                    .append(dataFieldMeta.getFieldSize())
                    .append(",")
                    .append(dataFieldMeta.getDecimalDigits())
                    .append(") ");
        } else if ("text".equalsIgnoreCase(dataFieldMeta.getFieldType())){
            sql.append(dataFieldMeta.getFieldName())
                    .append(" text ");
        } else if ("blob".equalsIgnoreCase(dataFieldMeta.getFieldType())){
            sql.append(dataFieldMeta.getFieldName())
                    .append(" blob ");

        }

        // 判断是否可以为null添加语句
        sql.append(getFieldNullInfo(dataFieldMeta.getIsNullable()));

        // 添加默认值语句
        if (StringUtils.isNotEmpty(dataFieldMeta.getFieldDefault())){
            sql.append(" DEFAULT ")
                    .append(dataFieldMeta.getFieldDefault());
        }

        return sql.toString();
    }

    private String getFieldNullInfo(Integer isNullable){
       return isNullable == YesOrNoEnum.YES.getValue() ? "NULL" : "NOT NULL";
    }
}
