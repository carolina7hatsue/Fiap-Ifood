package br.com.fiap.shycode.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    public static Connection obtainConnection() {
      Connection connection = null;
      try {
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        
        connection = DriverManager.getConnection(
            "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
            "RM88998", "fiap21");
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return connection;
    }
    
 }