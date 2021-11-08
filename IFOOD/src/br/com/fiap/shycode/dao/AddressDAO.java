package br.com.fiap.shycode.dao;

import java.util.List;

import br.com.fiap.shycode.bean.Address;
import br.com.fiap.shycode.exception.DBException;

public interface AddressDAO {

	void insert(Address address) throws DBException;
	List<Address> select();
	void update(Address address) throws DBException;
	void delete(int id) throws DBException;
	public Address selectById(int idSearch);
}
