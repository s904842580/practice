package com.hhx.util;

import java.sql.Connection;
import java.util.Date;
import java.util.Properties;

public class DBUtil {
    //定义一个Properties
    private static Properties prop = null;
    static {
        prop = new Properties();
        //给prop集合设置数据
        prop.setProperty("driverClassName","com.mysql,jdbc.Driver");
        prop.setProperty("url","jdbc:mysql://localhost:3306/hhx?characterEncoding=utf8&useSSL=false");
        prop.setProperty("username","root");
    }
    //定义连接获取连接的方法
    public static Connection getConnection(){
        //通过druid获取数据源

    }
}
