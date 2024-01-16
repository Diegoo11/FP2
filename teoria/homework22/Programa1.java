package teoria.homework22;

import java.sql.*;

public class Programa1 {
  public static void main(String[] args) {
    Connection conn = null;
    Statement statement = null;
    ResultSet resultSet = null;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");

      String url = "jdbc:mysql://localhost:3306/tictactoe";
      String usuario = "root";
      String contraseña = "11yenaro11";
      conn = DriverManager.getConnection(url, usuario, contraseña);

      if (conn != null) {
        System.out.println("Conexión exitosa a MySQL!");
        statement = conn.createStatement();
        String query = "SELECT * FROM users;";

        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
          int id = resultSet.getInt("id");
          String username = resultSet.getString("username");
          String password = resultSet.getString("password");

          System.out.println("ID: " + id
            + ", username: " + username
            + ", password: " + password
          );
        }
      }
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      try {
        if (conn != null && !conn.isClosed()) {
          conn.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
