package br.com.fiap.shycode.dao;

import br.com.fiap.shycode.bean.Category;

public interface CategoryDAO {

	void insert(Category menu);
	void select();
	void update(Category menu);
	void delete(int id);
	void selectById(int idSearch);
}
