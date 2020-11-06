package com.cheng.ofo.dao;

import java.sql.*;

public class DBUtils {
    //?characterEncoding=utf8 characterEncoding=utf8
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/db_ofo_users?characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin123";

    /**
     * 加载驱动
     */
    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
    }

    /**
     * 关闭连接
     *
     * @param con
     * @param statement
     * @param set
     */
    public static void closeConnection(Connection con, Statement statement, ResultSet set) {
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
