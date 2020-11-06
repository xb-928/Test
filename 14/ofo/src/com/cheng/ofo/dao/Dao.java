package com.cheng.ofo.dao;

import com.cheng.ofo.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {
    /**
     * 查询所有用户
     *
     * @return 用户 List
     */
    public static ArrayList<User> selectUser() {
        ArrayList<User> userList = new ArrayList<>();
        //获取连接
        try {
            Connection connection = DBUtils.getConnection();
            String sql = "select * from ofo_users";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ofo_user_id");
                String name = resultSet.getString("ofo_user_name");
                float balance = resultSet.getFloat("ofo_user_balance");
                float mileage = resultSet.getFloat("ofo_user_mileage");
                User user = new User(id, name, balance, mileage);
                userList.add(user);
            }
            //关闭连接
            DBUtils.closeConnection(connection, statement, resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    /**
     * 修改用户数据
     *
     * @param id      用户ID
     * @param name    用户名
     * @param balance 余额
     * @param mileage 里程
     * @return
     */
    public static boolean updateUser(int id, String name, float balance, float mileage) {
        try {
            Connection connection = DBUtils.getConnection();
            String sql = "update  ofo_users set ofo_user_name= ?, ofo_user_balance =?,ofo_user_mileage=? where ofo_user_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setFloat(2, balance);
            statement.setFloat(3, mileage);
            statement.setInt(4, id);

            int n = statement.executeUpdate();
            if (n > 0) {
                return true;
            }

            DBUtils.closeConnection(connection, statement, null);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public static boolean deleteUser(int id) {
        try {
            Connection connection = DBUtils.getConnection();
            String sql = "delete from ofo_users where ofo_user_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int n = statement.executeUpdate();
            if (n > 0) {
                return true;
            }
            DBUtils.closeConnection(connection, statement, null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 新增用户
     *
     * @param name    姓名
     * @param balance 余额
     * @param mileage 里程数
     * @return boolean 新增成功与否
     */
    public static boolean insertUser(String name, float balance, float mileage) {
        try {
            Connection connection = DBUtils.getConnection();
            String sql = "insert into ofo_users (ofo_user_name, ofo_user_balance, ofo_user_mileage) value (?,?,?) ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setFloat(2, balance);
            statement.setFloat(3, mileage);
            int n = statement.executeUpdate();
            if (n > 0) {
                return true;
            }

            //关闭连接
            DBUtils.closeConnection(connection, statement, null);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
