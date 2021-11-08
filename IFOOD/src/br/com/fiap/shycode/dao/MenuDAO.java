package br.com.fiap.shycode.dao;

import java.util.List;

import br.com.fiap.shycode.bean.Menu;
import br.com.fiap.shycode.exception.DBException;

public interface MenuDAO {

	void insert(Menu menu) throws DBException;
	List<Menu> select();
	void update(Menu menu) throws DBException;
	void delete(int id) throws DBException;
	public Menu selectById(int idSearch);
	
}
