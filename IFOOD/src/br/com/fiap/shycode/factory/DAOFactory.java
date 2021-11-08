package br.com.fiap.shycode.factory;

import br.com.fiap.shycode.dao.AddressDAO;
import br.com.fiap.shycode.dao.CategoryDAO;
import br.com.fiap.shycode.dao.ImageDAO;
import br.com.fiap.shycode.dao.ItemDAO;
import br.com.fiap.shycode.dao.MenuDAO;
import br.com.fiap.shycode.dao.PaymentDAO;
import br.com.fiap.shycode.dao.RestaurantDAO;
import br.com.fiap.shycode.dao.ScheduleDAO;
import br.com.fiap.shycode.dao.impl.OracleAddressDAO;
import br.com.fiap.shycode.dao.impl.OracleCategoryDAO;
import br.com.fiap.shycode.dao.impl.OracleImageDAO;
import br.com.fiap.shycode.dao.impl.OracleItemDAO;
import br.com.fiap.shycode.dao.impl.OracleMenuDAO;
import br.com.fiap.shycode.dao.impl.OraclePaymentDAO;
import br.com.fiap.shycode.dao.impl.OracleRestaurantDAO;
import br.com.fiap.shycode.dao.impl.OracleScheduleDAO;

public class DAOFactory {
		
	public static AddressDAO getAddressDAO() {
		return new OracleAddressDAO();
	}
	
	public static CategoryDAO getCategoryDAO() {
		return new OracleCategoryDAO();
	}
	
	public static ImageDAO getImageDAO() {
		return new OracleImageDAO();
	}
		
	public static ItemDAO getItemDAO() {
		return new OracleItemDAO();
	}
	
	public static MenuDAO getMenuDAO() {
		return new OracleMenuDAO();
	}
	
	public static PaymentDAO getPaymentDAO() {
		return new OraclePaymentDAO();
	}
	
	public static RestaurantDAO getRestaurantDAO() {
		return new OracleRestaurantDAO();
	}
	
	public static ScheduleDAO getScheduleDAO() {
		return new OracleScheduleDAO();
	}
	
}
