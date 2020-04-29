package com.jero.general.online.generate.utils;

import com.jero.general.online.controller.CodeAllInfoController;
import com.jero.general.online.generate.enums.DriverEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description 数据库连接类，支持mysql、oracle数据库的连接
 * @Author lixuetao
 * @Date 2020/4/27
 **/
public class DBUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBUtils.class);

    private static Connection conn;

    /**
     * 获取数据库连接，自动判断数据库类型
     * @param url
     * @param username
     * @param password
     * @return
     */
    public static Connection getConnection(String url, String username, String password){
        try {
            String driveName = getDataDriverByUrl(url);
            Class.forName(driveName);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception  e) {
            LOGGER.info("数据库连接失败", e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    LOGGER.info("数据库连接关闭失败", throwables);
                }
            }
        }
        return conn;
    }

    /**
     * 关闭数据库连接、编译语句、结果集等
     * @param conn
     * @param stat
     * @param rs
     */
    public static void close(Connection conn, Statement stat, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                LOGGER.info("结果集关闭失败", throwables);
            }
        }

        if (stat != null){
            try {
                stat.close();
            } catch (SQLException throwables) {
                LOGGER.info("数据库语句关闭失败", throwables);
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                LOGGER.info("数据库连接关闭失败", throwables);
            }
        }
    }

    /**
     * 根据数据库url得到数据库驱动
     * @param url
     * @return
     */
    private static String getDataDriverByUrl(String url){
        if (url == null || !url.startsWith("jdbc:")){
            throw new IllegalArgumentException("url不是有效的数据库连接地址");
        }

        if (url.contains("mysql")) {
            return DriverEnum.MYSQL.getValue();
        } else if (url.contains("oracle")) {
            return DriverEnum.ORACLE.getValue();
        } else {
            throw new IllegalArgumentException("url不是有效的数据库连接地址");
        }
    }

}
