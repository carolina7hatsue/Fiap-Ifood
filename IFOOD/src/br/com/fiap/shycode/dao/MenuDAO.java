package br.com.fiap.shycode.dao;

import br.com.fiap.shycode.bean.Menu;

public interface MenuDAO {

	void insert(Menu menu);
	void select();
	void update(Menu menu);
	void delete(int id);
	void selectById(int idSearch);
	
}
