package br.com.fiap.shycode.factory;

import br.com.fiap.shycode.dao.impl.OracleRestaurantDAO;

public class DAOFactory {
	
	public static OracleRestaurantDAO select() {
		return new OracleRestaurantDAO();
	}

}
