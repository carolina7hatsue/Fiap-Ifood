package br.com.fiap.shycode.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.shycode.bean.Schedule;
import br.com.fiap.shycode.connection.ConnectionDB;

public class OracleScheduleDAO {
private Connection connection;
    
    public void insert(Schedule Schedule) {
      PreparedStatement stmt = null;
      
          try {
            connection = ConnectionDB.obtainConnection();
            String sql = "INSERT INTO HORARIO("
            		+ "CD_HORARIO,"
            		+ "CD_RESTAURANTE,"
            		+ "DT_DIA_SEMANA,"
            		+ "DT_HORARIO_INICIO,"
            		+ "DT_HORARIO_FIM) "
            		+ "VALUES "
            		+ "(SQ_HORARIO.NEXTVAL,"
            		+ " ?,"
            		+ " ?,"
            		+ " ?,"
            		+ " ?)";
            
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, Schedule.getIdRestaurant());
            stmt.setDate(1, Schedule.getDayOfTheWeek());
            stmt.setDate(1, Schedule.getStart());
            stmt.setDate(1, Schedule.getEnd());
            
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
    
    public List<Schedule> select() {
	      List<Schedule> list = new ArrayList<Schedule>();
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      try {
	    	connection = ConnectionDB.obtainConnection();
	        stmt = connection.prepareStatement("SELECT * FROM HORARIO");
	        rs = stmt.executeQuery();
	    
	        while (rs.next()) {
	          int idSchedule = rs.getInt("CD_HORARIO");
	          int idRestaurant = rs.getInt("DT_DIA_SEMANA");
	          Date dayOfTheWeek = rs.getDate("DT_DIA_SEMANA");
	          Date start = rs.getDate("DT_HORARIO_INICIO");
	          Date end = rs.getDate("DT_HORARIO_FIM");
	        	  	          
	          Schedule Schedule = new Schedule(idSchedule, idRestaurant, dayOfTheWeek, start, end);
	          
	          list.add(Schedule);
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
    
    public void update(Schedule Schedule){
        PreparedStatement stmt = null;
      
        try {
      	connection = ConnectionDB.obtainConnection();
          String sql = "UPDATE HORARIO SET "
          		+ "CD_RESTAURANTE = ?,"
          		+ "DT_DIA_SEMANA = ?,"
          		+ "DT_HORARIO_INICIO = ?,"
          		+ "DT_HORARIO_FIM = ? WHERE CD_HORARIO = ?";
          stmt = connection.prepareStatement(sql);
          stmt.setInt(1, Schedule.getIdRestaurant());
          stmt.setDate(2, Schedule.getDayOfTheWeek());
          stmt.setDate(3, Schedule.getStart());
          stmt.setDate(4, Schedule.getEnd());
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
          String sql = "DELETE FROM HORARIO WHERE CD_HORARIO = ?";
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
    
    public Schedule selectById(int idSearch){
        Schedule Schedule = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
      	connection = ConnectionDB.obtainConnection();
          stmt = connection.prepareStatement("SELECT * FROM HORARIO WHERE CD_HORARIO = ?");
          stmt.setInt(1, idSearch);
          rs = stmt.executeQuery();
      
          if (rs.next()){
              int idSchedule = rs.getInt("CD_HORARIO");
	          int idRestaurant = rs.getInt("DT_DIA_SEMANA");
	          Date dayOfTheWeek = rs.getDate("DT_DIA_SEMANA");
	          Date start = rs.getDate("DT_HORARIO_INICIO");
	          Date end = rs.getDate("DT_HORARIO_FIM");
            Schedule = new Schedule(idSchedule, idRestaurant, dayOfTheWeek, start, end);
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
        return Schedule;
      }  
}
