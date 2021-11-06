package br.com.fiap.shycode.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.shycode.bean.Menu;
import br.com.fiap.shycode.connection.ConnectionDB;

public class OracleMenuDAO {
	
	private Connection connection;
    
    public void insert(Menu menu) {
      PreparedStatement stmt = null;
      
          try {
            connection = ConnectionDB.obtainConnection();
            String sql = "INSERT INTO CARDAPIO(CD_CARDAPIO, NM_NOME) VALUES (SQ_RESTAURANTE.NEXTVAL, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, menu.getName());
      
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
    
    public List<Menu> select() {
	      List<Menu> list = new ArrayList<Menu>();
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      try {
	    	connection = ConnectionDB.obtainConnection();
	        stmt = connection.prepareStatement("SELECT * FROM RESTAURANTE");
	        rs = stmt.executeQuery();
	    
	        while (rs.next()) {
	          int idMenu = rs.getInt("CD_CARDAPIO");
	          String name = rs.getString("NM_NOME");
	         	          
	          Menu menu = new Menu(idMenu, name);
	          
	          list.add(menu);
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
    
    public void update(Menu menu){
        PreparedStatement stmt = null;
      
        try {
      	connection = ConnectionDB.obtainConnection();
          String sql = "UPDATE CARDAPIO SET NM_NOME = ? WHERE CD_CARDAPIO = ?";
          stmt = connection.prepareStatement(sql);
          stmt.setString(1, menu.getName());
      
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
          String sql = "DELETE FROM CARDAPIO WHERE CD_CARDAPIO = ?";
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
    
    public Menu selectById(int idSearch){
        Menu menu = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
      	connection = ConnectionDB.obtainConnection();
          stmt = connection.prepareStatement("SELECT * FROM RESTAURANTE WHERE CD_RESTAURANTE = ?");
          stmt.setInt(1, idSearch);
          rs = stmt.executeQuery();
      
          if (rs.next()){
        	  int idMenu = rs.getInt("CD_CARDAPIO");
   	          String name = rs.getString("NM_NOME");
            menu = new Menu(idMenu, name);
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
        return menu;
      }  
}
