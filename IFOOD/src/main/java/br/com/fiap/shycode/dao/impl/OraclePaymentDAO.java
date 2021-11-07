package br.com.fiap.shycode.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.shycode.bean.Payment;
import br.com.fiap.shycode.connection.ConnectionDB;

public class OraclePaymentDAO {
private Connection connection;
    
    public void insert(Payment Payment) {
      PreparedStatement stmt = null;
      
          try {
            connection = ConnectionDB.obtainConnection();
            String sql = "INSERT INTO PAGAMENTO(CD_PAGAMENTO, NM_NOME) VALUES (SQ_PAGAMENTO.NEXTVAL, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, Payment.getName());
      
            stmt.executeUpdate();
          } catch (SQLException e) {
            e.printStackTrace();
          } finally {
            try {
              stmt.close();
              connection.close();
            } catch (SQLException e) {
              e.printStackTrace();
            }
          }
        }
    
    public List<Payment> select() {
	      List<Payment> list = new ArrayList<Payment>();
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      try {
	    	connection = ConnectionDB.obtainConnection();
	        stmt = connection.prepareStatement("SELECT * FROM RESTAURANTE");
	        rs = stmt.executeQuery();
	    
	        while (rs.next()) {
	          int idPayment = rs.getInt("CD_PAGAMENTO");
	          String name = rs.getString("NM_NOME");
	         	          
	          Payment Payment = new Payment(idPayment, name);
	          
	          list.add(Payment);
	        }
	      } catch (SQLException e) {
	        e.printStackTrace();
	        
	      }finally {
	        try {
	          stmt.close();
	          rs.close();
	          connection.close();
	        } catch (SQLException e) {
	          e.printStackTrace();
	        }
	      }
	      return list;
	    }
    
    public void update(Payment Payment){
        PreparedStatement stmt = null;
      
        try {
      	connection = ConnectionDB.obtainConnection();
          String sql = "UPDATE PAGAMENTO SET NM_NOME = ? WHERE CD_PAGAMENTO = ?";
          stmt = connection.prepareStatement(sql);
          stmt.setString(1, Payment.getName());
      
          stmt.executeUpdate();
        } catch (SQLException e) {
          e.printStackTrace();
        } finally {
          try {
            stmt.close();
            connection.close();
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }
      }
      
    public void delete(int id){
        PreparedStatement stmt = null;
      
        try {
      	connection = ConnectionDB.obtainConnection();
          String sql = "DELETE FROM PAGAMENTO WHERE CD_PAGAMENTO = ?";
          stmt = connection.prepareStatement(sql);
          stmt.setInt(1, id);
          stmt.executeUpdate();
        } catch (SQLException e) {
          e.printStackTrace();
        } finally {
          try {
            stmt.close();
            connection.close();
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }
      }
    
    public Payment selectById(int idSearch){
        Payment Payment = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
      	connection = ConnectionDB.obtainConnection();
          stmt = connection.prepareStatement("SELECT * FROM PAGAMENTO WHERE CD_PAGAMENTO = ?");
          stmt.setInt(1, idSearch);
          rs = stmt.executeQuery();
      
          if (rs.next()){
        	  int idPayment = rs.getInt("CD_PAGAMENTO");
   	          String name = rs.getString("NM_NOME");
            Payment = new Payment(idPayment, name);
          }
          
        } catch (SQLException e) {
          e.printStackTrace();
        }finally {
          try {
            stmt.close();
            rs.close();
            connection.close();
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }
        return Payment;
      }  
}
