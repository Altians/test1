package com.example.appdo.utils;

import java.sql.*;

/**
 * @Author: crh
 * @CreateDate: 2024/6/19
 * @Description:
 */
public class MySQLConnectionCount {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 注册MySQL驱动 com.mysql.cj.jdbc.Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 打开连接
            conn = DriverManager.getConnection("jdbc:mysql://192.168.145.15:3306/tailg-arch-alarm", "ro", "qv3CWkN%khw!HkEz");
            // 创建Statement对象
            stmt = conn.createStatement();
            // 执行SQL语句，查询连接数
            rs = stmt.executeQuery("SHOW STATUS LIKE 'Threads_connected'");
            // 处理结果集
            while(rs.next()) {
                System.out.println("MySQL连接数: " + rs.getString("Value"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
