package br.com.fiap.shycode.dao;

import java.util.List;

import br.com.fiap.shycode.bean.Schedule;
import br.com.fiap.shycode.exception.DBException;

public interface ScheduleDAO {

	void insert(Schedule schedule) throws DBException;
	List<Schedule> select();
	void update(Schedule schedule) throws DBException;
	void delete(int id) throws DBException;
	void selectById(int idSearch);
}
