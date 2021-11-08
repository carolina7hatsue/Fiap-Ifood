package br.com.fiap.shycode.factory;

import br.com.fiap.shycode.dao.RestaurantDAO;
import br.com.fiap.shycode.dao.impl.OracleRestaurantDAO;

public class DAOFactory {
	
	public static RestaurantDAO select() {
		return new OracleRestaurantDAO();
	}

}
