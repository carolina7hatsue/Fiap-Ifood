package br.com.fiap.shycode.dao;

import br.com.fiap.shycode.bean.Address;

public interface AddressDAO {

	void insert(Address menu);
	void select();
	void update(Address menu);
	void delete(int id);
	void selectById(int idSearch);
}
