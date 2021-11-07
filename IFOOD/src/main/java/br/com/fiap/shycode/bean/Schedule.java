package br.com.fiap.shycode.bean;

import java.sql.Date;

public class Schedule {
	private int IdSchedule;
	private int IdRestaurant;
	private Date DayOfTheWeek;
	private Date Start;
	private Date End;
	
	public int getIdSchedule() {
		return IdSchedule;
	}
	
	public void setIdSchedule(int idSchedule) {
		IdSchedule = idSchedule;
	}
	
	public int getIdRestaurant() {
		return IdRestaurant;
	}
	
	public void setIdRestaurant(int idRestaurant) {
		IdRestaurant = idRestaurant;
	}
	
	public Date getDayOfTheWeek() {
		return DayOfTheWeek;
	}
	
	public void setDayOfTheWeek(Date dayOfTheWeek) {
		DayOfTheWeek = dayOfTheWeek;
	}
	
	public Date getStart() {
		return Start;
	}
	
	public void setStart(Date start) {
		Start = start;
	}
	
	public Date getEnd() {
		return End;
	}
	public void setEnd(Date end) {
		End = end;
	}
	
	public Schedule(int idSchedule, int idRestaurant, Date dayOfTheWeek, Date start, Date end) {
		super();
		IdSchedule = idSchedule;
		IdRestaurant = idRestaurant;
		DayOfTheWeek = dayOfTheWeek;
		Start = start;
		End = end;
	}

}
