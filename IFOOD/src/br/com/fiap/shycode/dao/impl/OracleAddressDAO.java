package br.com.fiap.shycode.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.shycode.bean.Address;
import br.com.fiap.shycode.connection.ConnectionDB;
import br.com.fiap.shycode.dao.AddressDAO;

public class OracleAddressDAO implements AddressDAO {
	
	private Connection connection;
    
    public void insert(Address address) {
      PreparedStatement stmt = null;
      
          try {
            connection = ConnectionDB.obtainConnection();
            String sql = "INSERT INTO ("
            		+ "CD_ENDERECO,"
            		+ "DS_LOGRADOURO,"
            		+ "DS_BAIRRO"
            		+ "VL_NUMERO,"
            		+ "DS_CEP,"
            		+ "DS_CIDADE,"
            		+ "DS_ESTADO,"
            		+ "DS_PAIS,"
            		+ "DS_COMPLEMENTO) "
            		+ "VALUES "
            		+ "(SQ_ENDERECO.NEXTVAL, "
            		+ "?,"
            		+ "?,"
            		+ "?,"
            		+ "?,"
            		+ "?,"
            		+ "?,"
            		+ "?,"
            		+ "?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, address.getStreet());
            stmt.setString(2, address.getDistrict());
            stmt.setInt(3, address.getNumber());
            stmt.setInt(4, address.getCEP());
            stmt.setString(5, address.getCity());
            stmt.setString(6, address.getState());
            stmt.setString(7, address.getCountry());
            stmt.setString(8, address.getComplement());
            
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
    
    public List<Address> select() {
	      List<Address> list = new ArrayList<Address>();
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      try {
	    	connection = ConnectionDB.obtainConnection();
	        stmt = connection.prepareStatement("SELECT * FROM ENDERECO");
	        rs = stmt.executeQuery();
	    
	        while (rs.next()) {
	          int idAddress = rs.getInt("CD_ENDERECO");
	          String street = rs.getString("DS_LOGRADOURO");
	          String district = rs.getString("DS_BAIRRO");
	          int number = rs.getInt("VL_NUMERO");
	          int cep = rs.getInt("DS_CEP");
	          String city = rs.getString("DS_CIDADE");
	          String state = rs.getString("DS_ESTADO");
	          String country = rs.getString("DS_PAIS");
	          String complement = rs.getString("DS_COMPLEMENTO");
	         	          
	          Address Address = new Address(idAddress, street, district, number, cep, city, state, country, complement);
	          
	          list.add(Address);
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
    
    public void update(Address address){
        PreparedStatement stmt = null;
      
        try {
      	connection = ConnectionDB.obtainConnection();
          String sql = "UPDATE ENDERECO SET "
          		+ "DS_LOGRADOURO = ?,"
          		+ "DS_BAIRRO = ?,"
          		+ "VL_NUMERO = ?,"
          		+ "DS_CEP = ?,"
          		+ "DS_CIDADE = ?,"
          		+ "DS_ESTADO = ?,"
          		+ "DS_PAIS = ?,"
          		+ "DS_COMPLEMENTO = ?"
          		+ "WHERE CD_ENDERECO = ?";
          stmt = connection.prepareStatement(sql);
          stmt.setString(1, address.getStreet());
          stmt.setString(2, address.getDistrict());
          stmt.setInt(3, address.getNumber());
          stmt.setInt(4, address.getCEP());
          stmt.setString(5, address.getCity());
          stmt.setString(6, address.getState());
          stmt.setString(7, address.getCountry());
          stmt.setString(8, address.getComplement());
          
          //PARAMETER WHERE
          stmt.setInt(9, address.getIdAddress());
          
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
          String sql = "DELETE FROM  WHERE CD_ENDERECO = ?";
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
    
    public Address selectById(int idSearch){
        Address Address = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
      	connection = ConnectionDB.obtainConnection();
          stmt = connection.prepareStatement("SELECT * FROM ENDERECO WHERE CD_ENDERECO = ?");
          stmt.setInt(1, idSearch);
          rs = stmt.executeQuery();
      
          if (rs.next()){
        	  int idAddress = rs.getInt("CD_ENDERECO");
	          String street = rs.getString("DS_LOGRADOURO");
	          String district = rs.getString("DS_BAIRRO");
	          int number = rs.getInt("VL_NUMERO");
	          int cep = rs.getInt("DS_CEP");
	          String city = rs.getString("DS_CIDADE");
	          String state = rs.getString("DS_ESTADO");
	          String country = rs.getString("DS_PAIS");
	          String complement = rs.getString("DS_COMPLEMENTO");
	         	          
              Address = new Address(idAddress,street,district, number, cep, city, state, country, complement);
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
        return Address;
      }  
}
