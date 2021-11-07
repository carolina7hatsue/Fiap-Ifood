package br.com.fiap.shycode.dao;

import br.com.fiap.shycode.bean.Category;

public interface CategoryDAO {

	void insert(Category category);
	void select();
	void update(Category category);
	void delete(int id);
	void selectById(int idSearch);
}
