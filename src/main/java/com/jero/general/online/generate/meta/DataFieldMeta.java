package com.jero.general.online.generate.meta;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description 数据库的相关字段属性
 * @Author lixuetao
 * @Date 2020/4/28
 **/
@Data
public class DataFieldMeta {

    private String tableName; //表名

    private String fieldName; //字段名

    private Integer fieldSize; //字段长度

    private String fieldType; //字段类型

    private String fieldComment; //字段注释

    private String fieldDefault; //字段默认值

    private Integer decimalDigits; //小数点位数

    private Integer isNullable; //是否可以为null，0为否，1为是

    private String oldFieldName; //旧字段名，用于重命名字段的时候

}
