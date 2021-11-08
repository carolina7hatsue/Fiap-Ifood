package br.com.fiap.shycode.dao;

import br.com.fiap.shycode.bean.Restaurant;

public interface RestaurantDAO {

	void insert(Restaurant restaurant);
	void select();
	void update(Restaurant restaurant);
	void delete(int id);
	void selectById(int idSearch);
	
}
