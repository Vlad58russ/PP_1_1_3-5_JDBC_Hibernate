//package jm.task.core.jdbc.dao;

//import jm.task.core.jdbc.model.User;

//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;

//import static jm.task.core.jdbc.util.Util.getConnection;


//public class UserDaoJDBCImpl implements UserDao {
// Connection connection = getConnection();

// public UserDaoJDBCImpl() {
// }

// public void createUsersTable() {
//    try (Statement statement = connection.createStatement()) {
//      statement.executeUpdate("CREATE TABLE IF NOT EXISTS users " +
//              "(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), last_name VARCHAR(255), age INT)");
//   } catch (SQLException e) {
//      e.printStackTrace();
//   }
//   }

//  public void dropUsersTable() {
//     try (Statement statement = connection.createStatement()) {
//         statement.executeUpdate("DROP TABLE IF EXISTS users");
//     } catch (SQLException e) {
//         e.printStackTrace();
//     }
//  }

// public void saveUser(String name, String lastName, byte age) {
//     try (PreparedStatement pstm = connection.prepareStatement("INSERT INTO users (name, last_name, age) VALUES (?, ?, ?)")) {
//       pstm.setString(1, name);
//       pstm.setString(2, lastName);
//       pstm.setByte(3, age);
//       pstm.executeUpdate();
//   } catch (SQLException e) {
//       e.printStackTrace();
//   }
// }

//  public void removeUserById(long id) {
//    try (PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?")) {
//        prepareStatement.setLong(1, id);
//        prepareStatement.executeUpdate();
//    } catch (SQLException e) {
//       e.printStackTrace();
//    }
//  }

// public List<User> getAllUsers() {
//    List<User> users = new ArrayList<>();

//    try (ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM users")) {
//      while (resultSet.next()) {
//      User user = new User(resultSet.getString("name"),
//             resultSet.getString("last_name"), resultSet.getByte("age"));
//      user.setId(resultSet.getLong("id"));
//       users.add(user);
//    }
//  } catch (SQLException e) {
//       e.printStackTrace();
//     }

//   return users;
//  }

// public void cleanUsersTable() {
//      try (Statement statement = connection.createStatement()) {
//         statement.executeUpdate("TRUNCATE TABLE users");
//     } catch (SQLException e) {
//         e.printStackTrace();
//    }
// }
//}