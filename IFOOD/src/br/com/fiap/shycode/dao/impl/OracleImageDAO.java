package br.com.fiap.shycode.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.shycode.bean.Image;
import br.com.fiap.shycode.connection.ConnectionDB;
import br.com.fiap.shycode.dao.ImageDAO;

public class OracleImageDAO implements ImageDAO {
private Connection connection;
    
    public void insert(Image image) {
      PreparedStatement stmt = null;
      
          try {
            connection = ConnectionDB.obtainConnection();
            String sql = "INSERT INTO IMAGEM(CD_IMAGEM, DS_URL, CD_RESTAURANTE) VALUES (SQ_IMAGEM.NEXTVAL, ?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, image.getUrl());
            stmt.setInt(2, image.getIdRestaurant());
            
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
    
    public List<Image> select() {
	      List<Image> list = new ArrayList<Image>();
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      try {
	    	connection = ConnectionDB.obtainConnection();
	        stmt = connection.prepareStatement("SELECT * FROM IMAGEM");
	        rs = stmt.executeQuery();
	    
	        while (rs.next()) {
	          int idImage = rs.getInt("CD_IMAGEM");
	          String url = rs.getString("DS_URL");
	          int idRestaurant = rs.getInt("CD_RESTAURANTE");
                
	          Image Image = new Image(idImage, url, idRestaurant);
	          
	          list.add(Image);
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
    
    public void update(Image image){
        PreparedStatement stmt = null;
      
        try {
      	connection = ConnectionDB.obtainConnection();
          String sql = "UPDATE IMAGEM SET DS_URL = ?, CD_RESTAURANTE = ? WHERE CD_IMAGEM = ?";
          stmt = connection.prepareStatement(sql);
          stmt.setString(1, image.getUrl());
          stmt.setInt(2, image.getIdRestaurant());
          
          //PARAMETER WHERE
          stmt.setInt(2, image.getIdImage());
      
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
          String sql = "DELETE FROM IMAGEM WHERE CD_IMAGEM = ?";
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
    
    public Image selectById(int idSearch){
        Image Image = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
      	connection = ConnectionDB.obtainConnection();
          stmt = connection.prepareStatement("SELECT * FROM IMAGEM WHERE CD_IMAGEM = ?");
          stmt.setInt(1, idSearch);
          rs = stmt.executeQuery();
      
          if (rs.next()){
            int idImage = rs.getInt("CD_IMAGEM");
            String url = rs.getString("DS_URL");
            int idRestaurant = rs.getInt("CD_RESTAURANTE");
            
            Image = new Image(idImage, url,idRestaurant);
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
        return Image;
      }  
}
