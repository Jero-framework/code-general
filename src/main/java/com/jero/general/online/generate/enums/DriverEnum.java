package com.jero.general.online.generate.enums;

/**
 * @Description 数据库连接驱动枚举
 * @Author lixuetao
 * @Date 2020/4/27
 **/
public enum DriverEnum {

    MYSQL("com.mysql.cj.jdbc.Driver","mysql"),
    ORACLE("oracle.jdbc.OracleDriver", "oracle");

    private String value;

    private String label;

    DriverEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
