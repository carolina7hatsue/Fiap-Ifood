package br.com.fiap.shycode.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.shycode.bean.Address;
import br.com.fiap.shycode.bean.Category;
import br.com.fiap.shycode.bean.Restaurant;
import br.com.fiap.shycode.connection.ConnectionDB;
import br.com.fiap.shycode.dao.RestaurantDAO;

public class OracleRestaurantDAO implements RestaurantDAO {
	
	private Connection connection;
    
    public void insert(Restaurant restaurant) {
      PreparedStatement stmt = null;
      
          try {
            connection = ConnectionDB.obtainConnection();
            String sql = "INSERT INTO RESTAURANTE(CD_RESTAURANTE, NM_RESTAURANTE, VL_PEDIDO_MIN, VL_CNPJ, CD_ENDERECO, CD_TIPO) VALUES (SQ_RESTAURANTE.NEXTVAL, ?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, restaurant.getName());
            stmt.setFloat(2, restaurant.getMinPrice());
            stmt.setInt(3, restaurant.getCNPJ());
            stmt.setInt(4, restaurant.getAddress().getIdAddress());
            stmt.setInt(5, restaurant.getCategory().getIdCategory());
            
      
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
	        stmt = connection.prepareStatement("SELECT * FROM RESTAURANTE"
	        		+ " INNER JOIN ENDERECO ON RESTAURANTE.CD_ENDERECO = ENDERECO.CD_ENDERECO"
	        		+ " INNER JOIN CATEGORIA ON RESTAURANTE.CD_TIPO = CATEGORIA.CD_TIPO");
	        rs = stmt.executeQuery();
	    
	        while (rs.next()) {
	          int idRestaurant = rs.getInt("CD_RESTAURANTE");
	          String nameRestaurant = rs.getString("NM_RESTAURANTE");
	          float valorMin = rs.getFloat("VL_PEDIDO_MIN");
	          int cNPJ = rs.getInt("VL_CNPJ");
          
	          int idAddress = rs.getInt("CD_ENDERECO");
	          String street = rs.getString("DS_LOGRADOURO");
	          String district = rs.getString("DS_BAIRRO");
	          int number = rs.getInt("VL_NUMERO");
	          int cep = rs.getInt("DS_CEP");
	          String city = rs.getString("DS_CIDADE");
	          String state = rs.getString("DS_ESTADO");
	          String country = rs.getString("DS_PAIS");
	          String complement = rs.getString("DS_COMPLEMENTO");
	          
	          int idCategory = rs.getInt("CD_TIPO");
	          String nameCategory = rs.getString("DS_NOME");
	         	       
	         	          
	          Restaurant restaurant = new Restaurant(idRestaurant, nameRestaurant, valorMin, cNPJ);
	          
	          Address address = new Address(idAddress, street, district, number, cep, city, state, country, complement);	  
	        		  
	          Category category = new Category(idCategory, nameCategory);
	          restaurant.setAddress(address);
	          restaurant.setCategory(category);
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
          String sql = "UPDATE RESTAURANTE SET NM_RESTAURANTE = ?, VL_PEDIDO_MIN = ?, VL_CNPJ = ?, CD_ENDERECO = ?, CD_TIPO = ?  WHERE CD_RESTAURANTE = ?";
          stmt = connection.prepareStatement(sql);
          stmt.setString(1, restaurant.getName());
          stmt.setFloat(2, restaurant.getMinPrice());
          stmt.setInt(3, restaurant.getCNPJ());
          stmt.setInt(4, restaurant.getAddress().getIdAddress());
          stmt.setInt(5, restaurant.getCategory().getIdCategory());
          
          //PARAMETER WHERE
          stmt.setInt(6, restaurant.getIdRestaurant());
      
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
          stmt = connection.prepareStatement("SELECT * FROM RESTAURANTE INNER JOIN ENDERECO ON RESTAURANTE.CD_ENDERECO = ENDERECO.CD_ENDERECO "
          		+ "INNER JOIN CATEGORIA ON RESTAURANTE.CD_TIPO = CATEGORIA.CD_TIPO WHERE RESTAURANTE.CD_RESTAURANTE = ?");
          stmt.setInt(1, idSearch);
          rs = stmt.executeQuery();
      
          if (rs.next()){
   	       	  int idRestaurant = rs.getInt("CD_RESTAURANTE");
	          String nameRestaurant = rs.getString("NM_RESTAURANTE");
	          float valorMin = rs.getFloat("VL_PEDIDO_MIN");
	          int cNPJ = rs.getInt("VL_CNPJ");
	          
	          int idAddress = rs.getInt("CD_ENDERECO");
	          String street = rs.getString("DS_LOGRADOURO");
	          String district = rs.getString("DS_BAIRRO");
	          int number = rs.getInt("VL_NUMERO");
	          int cep = rs.getInt("DS_CEP");
	          String city = rs.getString("DS_CIDADE");
	          String state = rs.getString("DS_ESTADO");
	          String country = rs.getString("DS_PAIS");
	          String complement = rs.getString("DS_COMPLEMENTO");
	          
	          int idCategory = rs.getInt("CD_TIPO");
	          String nameCategory = rs.getString("DS_NOME");
	          
	          restaurant = new Restaurant(idRestaurant, nameRestaurant, valorMin, cNPJ);
	          Address address = new Address(idAddress, street, district, number, cep, city, state, country, complement);	  
	          Category category = new Category(idCategory, nameCategory);
	          restaurant.setAddress(address);
	          restaurant.setCategory(category);
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
