package Slect;

import DAO.Utils;
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

  public static ArrayList<Entity> selectUser(String name) {
    ArrayList<Entity> list = new ArrayList<>();
    Connection connection = Slect.Utils.getConnection();
    String sql = "select * from ofo_users where ofo_users_name like '%'?'%' ";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,name);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        String username = resultSet.getString("ofo_users_name");
        if (name.equals(username)) {
          int id = resultSet.getInt("ofo_users_id");
          Float balance = resultSet.getFloat("ofo_users_balance");
          Float mileage = resultSet.getFloat("ofo_users_mileage");
          Entity entity = new Entity(id,username,balance,mileage);
          list.add(entity);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

}
