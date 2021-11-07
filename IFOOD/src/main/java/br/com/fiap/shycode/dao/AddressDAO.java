package br.com.fiap.shycode.dao;

import br.com.fiap.shycode.bean.Address;

public interface AddressDAO {

	void insert(Address address);
	void select();
	void update(Address address);
	void delete(int id);
	void selectById(int idSearch);
}
