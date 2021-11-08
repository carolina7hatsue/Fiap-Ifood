package br.com.fiap.shycode.factory;

import br.com.fiap.shycode.dao.AddressDAO;
import br.com.fiap.shycode.dao.CategoryDAO;
import br.com.fiap.shycode.dao.RestaurantDAO;
import br.com.fiap.shycode.dao.impl.OracleAddressDAO;
import br.com.fiap.shycode.dao.impl.OracleCategoryDAO;
import br.com.fiap.shycode.dao.impl.OracleRestaurantDAO;

public class DAOFactory {
	
	public static RestaurantDAO getRestaurantDAO() {
		return new OracleRestaurantDAO();
	}
	
	public static AddressDAO getAddressDAO() {
		return new OracleAddressDAO();
	}
	
	public static CategoryDAO getCategoryDAO() {
		return new OracleCategoryDAO();
	}
	

}
