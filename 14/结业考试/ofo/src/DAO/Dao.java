package DAO;

import Moule.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {

  public static List<Entity> getSelect(){
    List<Entity> list = new ArrayList<>();
    Connection connection = Utils.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = "select * from ofo_users";
    try {
      preparedStatement = connection.prepareStatement(sql);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        int id = resultSet.getInt("ofo_users_id");
        String name = resultSet.getString("ofo_users_name");
        Float balance = resultSet.getFloat("ofo_users_balance");
        Float mileage = resultSet.getFloat("ofo_users_mileage");
        Entity entity = new Entity(id,name,balance,mileage);
        list.add(entity);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      Utils.close(resultSet,preparedStatement,connection);
    }
    return list;
  }

  public static boolean updateUser(int id, String name, float balance, float mileage){
    Connection connection = Utils.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = "update ofo_users set ofo_users_name = ?,ofo_users_balance = ?,ofo_users_mileage = ? where ofo_users_id = ?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,name);
      preparedStatement.setFloat(2,balance);
      preparedStatement.setFloat(3,mileage);
      preparedStatement.setInt(4,id);
      int num = preparedStatement.executeUpdate();
      if (num>0) {
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      Utils.close(resultSet,preparedStatement,connection);
    }
    return false;
  }

  //增加方法
  public static boolean insertUser(String name, String balance , String mileage) {
    Connection connection = Utils.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = "insert into ofo_users(ofo_users_name,ofo_users_balance,ofo_users_mileage) value (?,?,?)";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,name);
      preparedStatement.setFloat(2, Float.parseFloat(balance));
      preparedStatement.setFloat(3, Float.parseFloat(mileage));
      int num = preparedStatement.executeUpdate();
      if (num>0) {
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      Utils.close(resultSet,preparedStatement,connection);
    }
    return false;
  }

  //删除方法
  public static boolean deleteUser(int id,String name,float balance,float mileage) {
    Connection connection = Utils.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = "delete from ofo_users where ofo_users_id = ? or ofo_users_name = ? or ofo_users_balance = ? or ofo_users_mileage = ?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, id);
      preparedStatement.setString(2,name);
      preparedStatement.setFloat(3, balance);
      preparedStatement.setFloat(4, mileage);
      int num = preparedStatement.executeUpdate();
      if (num>0) {
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

}
