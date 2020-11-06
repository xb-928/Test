package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {

  //增加
  public static boolean insertUser(String name,String balance,String mileage) {
    Connection connection = DBUtils.getConnection();
    String sql = "insert into ofo_users(ofo_users_name,ofo_users_balance,ofo_users_mileage) value(?,?,?)";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,name);
      preparedStatement.setFloat(2, Float.parseFloat(balance));
      preparedStatement.setFloat(3, Float.parseFloat(mileage));
      int num = preparedStatement.executeUpdate();
      if (num > 0) {
        return true;
      }
      DBUtils.close(null,preparedStatement,connection);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  //删除
  public static boolean deleteUser(int id) {
    Connection connection = DBUtils.getConnection();
    String sql = "delete from ofo_users where ofo_users_id = ? ";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1,id);
      int num = preparedStatement.executeUpdate();
      if (num > 0) {
        return true;
      }
      DBUtils.close(null,preparedStatement,connection);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  //修改
  public static boolean updateUser(int id,String name,float balance,float mileage){
    Connection connection = DBUtils.getConnection();
    String sql = "update ofo_users set ofo_users_name = ?,ofo_users_balance = ?,ofo_users_mileage = ? where ofo_users_id = ?";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,name);
      preparedStatement.setFloat(2,balance);
      preparedStatement.setFloat(3,mileage);
      preparedStatement.setInt(4,id);
      int num = preparedStatement.executeUpdate();
      if (num > 0) {
        return true;
      }
      DBUtils.close(null,preparedStatement,connection);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  //查询
  public static ArrayList<User> selectUser() {
    ArrayList<User> list = new ArrayList<>();
    Connection connection = DBUtils.getConnection();
    String sql = "select * from ofo_users";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        int id = resultSet.getInt("ofo_users_id");
        String name = resultSet.getString("ofo_users_name");
        float balance = resultSet.getFloat("ofo_users_balance");
        float mileage = resultSet.getFloat("ofo_users_mileage");
        User user = new User(id,name,balance,mileage);
        list.add(user);
      }
      DBUtils.close(resultSet,preparedStatement,connection);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }
}
