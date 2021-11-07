package br.com.fiap.shycode.dao;

import br.com.fiap.shycode.bean.Item;

public interface ItemDAO {
	void insert(Item item);
	void select();
	void update(Item item);
	void delete(int id);
	void selectById(int idSearch);
}
