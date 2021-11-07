package br.com.fiap.shycode.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.shycode.bean.Item;
import br.com.fiap.shycode.connection.ConnectionDB;

public class OracleItemDAO {
private Connection connection;
    
    public void insert(Item item) {
      PreparedStatement stmt = null;
      
          try {
            connection = ConnectionDB.obtainConnection();
            String sql = "INSERT INTO ITEM("
            		+ "CD_ITEM,"
            		+ "DS_DESCRICAO,"
            		+ "VL_PRECO,"
            		+ "NM_NOME) "
            		+ "VALUES "
            		+ "(SQ_ITEM.NEXTVAL,"
            		+ " ?,"
            		+ " ?,"
            		+ " ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, item.getDescription());
            stmt.setFloat(2, item.getPrice());
            stmt.setString(3, item.getName());
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
    
    public List<Item> select() {
	      List<Item> list = new ArrayList<Item>();
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      try {
	    	connection = ConnectionDB.obtainConnection();
	        stmt = connection.prepareStatement("SELECT * FROM ITEM");
	        rs = stmt.executeQuery();
	    
	        while (rs.next()) {
	          int idItem = rs.getInt("CD_ITEM");
	          String description = rs.getString("DS_DESCRICAO");
	          float price = rs.getFloat("VL_PRECO");
	          String name = rs.getString("NM_NOME");
	          
	          Item Item = new Item(idItem, description,price,name);
	          
	          list.add(Item);
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
    
    public void update(Item item){
        PreparedStatement stmt = null;
      
        try {
      	connection = ConnectionDB.obtainConnection();
          String sql = "UPDATE ITEM SET DS_DESCRICAO = ?,"
          		+ "VL_PRECO = ?,"
          		+ "NM_NOME = ? WHERE CD_ITEM = ?";
          stmt = connection.prepareStatement(sql);
          stmt.setString(1, item.getDescription());
          stmt.setFloat(1, item.getPrice());
          stmt.setString(3, item.getName());
          
          //PARAMETER WHERE
          stmt.setInt(4, item.getIdItem());
      
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
          String sql = "DELETE FROM ITEM WHERE CD_ITEM = ?";
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
    
    public Item selectById(int idSearch){
        Item Item = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
      	connection = ConnectionDB.obtainConnection();
          stmt = connection.prepareStatement("SELECT * FROM ITEM WHERE CD_ITEM = ?");
          stmt.setInt(1, idSearch);
          rs = stmt.executeQuery();
      
          if (rs.next()){
        	  int idItem = rs.getInt("CD_ITEM");
	          String description = rs.getString("DS_DESCRICAO");
	          float price = rs.getFloat("VL_PRECO");
	          String name = rs.getString("NM_NOME");
	          
	          Item = new Item(idItem, description,price,name);
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
        return Item;
      }  
}
