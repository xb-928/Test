package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {

  //增加
  public boolean insertUser(String name,float balance,float mileage) {
    Connection connection = DBUtils.getConnection();
    PreparedStatement preparedStatement = null;
    String sql = "insert into ofo_users(ofo_users_name,ofo_users_balance,ofo_users_mileage) value(?,?,?)";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,name);
      preparedStatement.setFloat(2,balance);
      preparedStatement.setFloat(3,mileage);
      int num = preparedStatement.executeUpdate();
      if (num > 0) {
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DBUtils.close(null,preparedStatement,connection);
    }
    return false;
  }

  //删除
  public boolean deleteUser(int id,String name,float balance,float mileage) {
    Connection connection = DBUtils.getConnection();
    PreparedStatement preparedStatement = null;
    String sql = "delete from ofo_users where ofo_users_id = ? and ofo_users_name = ? and ofo_users_balance = ? and ofo_users_mileage = ?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1,id);
      preparedStatement.setString(2,name);
      preparedStatement.setFloat(3,balance);
      preparedStatement.setFloat(4,mileage);
      int num = preparedStatement.executeUpdate();
      if (num > 0) {
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DBUtils.close(null,preparedStatement,connection);
    }
    return false;
  }

  //修改
  public boolean updateUser(int id,String name,float balance,float mileage) {
    Connection connection = DBUtils.getConnection();
    PreparedStatement preparedStatement = null;
    String sql = "update ofo_users set ofo_users_name = ?,ofo_users_balance = ?,ofo_users_mileage = ? where ofo_users_id = ?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,name);
      preparedStatement.setFloat(2,balance);
      preparedStatement.setFloat(3,mileage);
      preparedStatement.setInt(4,id);
      int num = preparedStatement.executeUpdate();
      if (num > 0) {
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DBUtils.close(null,preparedStatement,connection);
    }
    return false;
  }

  //查询
  public List<User> selectUser() {
    ArrayList<User> list = new ArrayList<>();
    Connection connection = DBUtils.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = "select * from ofo_users";
    try {
      preparedStatement = connection.prepareStatement(sql);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        int id = resultSet.getInt("ofo_users_id");
        String name = resultSet.getString("ofo_users_name");
        float balance = resultSet.getFloat("ofo_users_balance");
        float mileage = resultSet.getFloat("ofo_users_mileage");
        User user = new User(id,name,balance,mileage);
        list.add(user);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DBUtils.close(resultSet,preparedStatement,connection);
    }
    return list;
  }

}
