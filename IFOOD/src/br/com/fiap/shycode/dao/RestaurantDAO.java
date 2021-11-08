package br.com.fiap.shycode.dao;

import java.util.List;

import br.com.fiap.shycode.bean.Restaurant;
import br.com.fiap.shycode.exception.DBException;

public interface RestaurantDAO {

	void insert(Restaurant restaurant) throws DBException;
	List<Restaurant> select();
	void update(Restaurant restaurant) throws DBException;
	void delete(int id) throws DBException;
	public Restaurant selectById(int idSearch);
	
}
