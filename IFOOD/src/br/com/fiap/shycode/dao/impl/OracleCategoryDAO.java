package br.com.fiap.shycode.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.shycode.bean.Category;
import br.com.fiap.shycode.connection.ConnectionDB;
import br.com.fiap.shycode.dao.CategoryDAO;

public class OracleCategoryDAO implements CategoryDAO {
private Connection connection;
    
    public void insert(Category category) {
      PreparedStatement stmt = null;
      
          try {
            connection = ConnectionDB.obtainConnection();
            String sql = "INSERT INTO CATEGORIA(CD_CATEGORIA, DS_NOME) VALUES (SQ_CATEGORIA.NEXTVAL, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, category.getName());
      
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
    
    public List<Category> select() {
	      List<Category> list = new ArrayList<Category>();
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      try {
	    	connection = ConnectionDB.obtainConnection();
	        stmt = connection.prepareStatement("SELECT * FROM CATEGORIA");
	        rs = stmt.executeQuery();
	    
	        while (rs.next()) {
	          int idCategory = rs.getInt("CD_TIPO");
	          String name = rs.getString("DS_NOME");
	         	          
	          Category Category = new Category(idCategory, name);
	          
	          list.add(Category);
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
    
    public void update(Category category){
        PreparedStatement stmt = null;
      
        try {
      	connection = ConnectionDB.obtainConnection();
          String sql = "UPDATE CATEGORIA SET DS_NOME = ? WHERE CD_CATEGORIA = ?";
          stmt = connection.prepareStatement(sql);
          stmt.setString(1, category.getName());
      
        //PARAMETER WHERE
          stmt.setInt(2, category.getIdCategory());
          
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
          String sql = "DELETE FROM CATEGORIA WHERE CD_CATEGORIA = ?";
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
    
    public Category selectById(int idSearch){
        Category Category = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
      	connection = ConnectionDB.obtainConnection();
          stmt = connection.prepareStatement("SELECT * FROM CATEGORIA WHERE CD_CATEGORIA = ?");
          stmt.setInt(1, idSearch);
          rs = stmt.executeQuery();
      
          if (rs.next()){
        	  int idCategory = rs.getInt("CD_CATEGORIA");
   	          String name = rs.getString("DS_NOME");
            Category = new Category(idCategory, name);
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
        return Category;
      }  
}
