package com.jero.general.online.generate.service;

import com.jero.general.online.generate.meta.DataFieldMeta;

/**
 * 数据表操作接口，提供
 * 添加字段、重命名字段、更新字段、转换java类型到数据库字段类型、丢弃表、丢弃列、
 * 注释字段、丢弃索引、统计索引等sql语句获取接口
 */
public interface DBTableHandler {

    /**
     * 获取添加列的sql
     * @param fieldMeta
     * @return
     */
    String getAddFieldSql(DataFieldMeta fieldMeta);

    /**
     * 获取重命名字段sql
     * @param fieldMeta
     * @return
     */
    String getRenameFieldNameSql(DataFieldMeta fieldMeta);

    /**
     * 获取更新字段的sql
     * @param fieldMeta
     * @return
     */
    String getUpdateFieldSql(DataFieldMeta fieldMeta);

    /**
     * 根据数据库字段类型获取对应的Java数据类型
     * @param fieldType 字段类型
     * @param digits 小数的位数
     * @return
     */
    String getMatchClassTypeByDataType(String fieldType, int digits);

    /**
     * 获取根据表名删除表的sql
     * @param tableName
     * @return
     */
    String getDropTableSql(String tableName);

    /**
     * 获取根据字段名删除字段的sql
     * @param fieldName
     * @return
     */
    String getDropColumnSql(String fieldName);

    /**
     * 获取添加注释的sql
     * @param fieldMeta
     * @return
     */
    String getCommentSql(DataFieldMeta fieldMeta);

    /**
     * 获取删除索引的sql
     * @param indexName
     * @param tableName
     * @return
     */
    String getDropIndexsSql(String indexName, String tableName);

    /**
     * 获取统计索引的sql
     * @param indexName
     * @param tableName
     * @return
     */
    String countIndex(String indexName, String tableName);

}
