package com.hhx.conn;

import java.sql.*;

public class FJDBC {
    public static void main(String[] args) {
        //1:注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //注册驱动
        /*...*/

        Connection conn = null;
        //2：获取连接
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.1.32:3306/hhx?characterEncoding=UTF8&useSSL=false",
                    "zs",
                    "654321"
            );
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //3.定义sql语句
        String sql = "updata tb_user set age = 100 where id = 1";

        //4:获取sql的执行对象
        Statement stat = null;
        try {
            stat = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //5.执行sql语句
        ResultSet rs = null;
        try {
            rs = stat.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //6:处理结果集
        System.out.println(rs);
    }
}
