package br.com.fiap.shycode.dao;

import java.util.List;

import br.com.fiap.shycode.bean.Item;
import br.com.fiap.shycode.exception.DBException;

public interface ItemDAO {
	void insert(Item item) throws DBException;
	List<Item> select();
	void update(Item item) throws DBException;
	void delete(int id) throws DBException;
	void selectById(int idSearch);
}
