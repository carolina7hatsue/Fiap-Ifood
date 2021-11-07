package br.com.fiap.shycode.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.shycode.bean.Restaurant;
import br.com.fiap.shycode.connection.ConnectionDB;

public class OracleRestaurantDAO {
	
	private Connection connection;
    
    public void insert(Restaurant restaurant) {
      PreparedStatement stmt = null;
      
          try {
            connection = ConnectionDB.obtainConnection();
            String sql = "INSERT INTO RESTAURANTE(CD_RESTAURANTE, NM_RESTAURANTE, VL_PEDIDO_MIN) VALUES (SQ_RESTAURANTE.NEXTVAL, ?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, restaurant.getName());
            stmt.setFloat(2, restaurant.getMinPrice());
      
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
    
    public List<Restaurant> select() {
	      List<Restaurant> list = new ArrayList<Restaurant>();
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      try {
	    	connection = ConnectionDB.obtainConnection();
	        stmt = connection.prepareStatement("SELECT * FROM RESTAURANTE");
	        rs = stmt.executeQuery();
	    
	        while (rs.next()) {
	          int idRestaurant = rs.getInt("CD_RESTAURANTE");
	          String name = rs.getString("NM_RESTAURANTE");
	          float valorMin = rs.getFloat("VL_PEDIDO_MIN");
	         	          
	          Restaurant restaurant = new Restaurant(idRestaurant, name, valorMin);
	          
	          list.add(restaurant);
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
    
    public void update(Restaurant restaurant){
        PreparedStatement stmt = null;
      
        try {
      	connection = ConnectionDB.obtainConnection();
          String sql = "UPDATE RESTAURANTE SET NM_RESTAURANTE = ?, VL_PEDIDO_MIN = ? WHERE CD_RESTAURANTE = ?";
          stmt = connection.prepareStatement(sql);
          stmt.setString(1, restaurant.getName());
          stmt.setFloat(2, restaurant.getMinPrice());
          
          //PARAMETER WHERE
          stmt.setInt(4, restaurant.getIdRestaurant());
      
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
          String sql = "DELETE FROM RESTAURANTE WHERE CD_RESTAURANTE = ?";
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
    
    public Restaurant selectById(int idSearch){
        Restaurant restaurant = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
      	connection = ConnectionDB.obtainConnection();
          stmt = connection.prepareStatement("SELECT * FROM RESTAURANTE WHERE CD_RESTAURANTE = ?");
          stmt.setInt(1, idSearch);
          rs = stmt.executeQuery();
      
          if (rs.next()){
        	  int idRestaurant = rs.getInt("CD_RESTAURANTE");
   	          String name = rs.getString("NM_RESTAURANTE");
   	          float valorMin = rs.getFloat("VL_PEDIDO_MIN");
            restaurant = new Restaurant(idRestaurant, name, valorMin);
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
        return restaurant;
      }  
}
