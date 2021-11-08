package br.com.fiap.shycode.dao;

import br.com.fiap.shycode.bean.Schedule;

public interface ScheduleDAO {

	void insert(Schedule schedule);
	void select();
	void update(Schedule schedule);
	void delete(int id);
	void selectById(int idSearch);
}
