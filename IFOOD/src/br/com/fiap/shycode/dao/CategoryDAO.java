package br.com.fiap.shycode.dao;

import java.util.List;

import br.com.fiap.shycode.bean.Category;
import br.com.fiap.shycode.exception.DBException;

public interface CategoryDAO {

	void insert(Category category) throws DBException;
	List<Category> select();
	void update(Category category) throws DBException;
	void delete(int id) throws DBException;
	void selectById(int idSearch);
}
