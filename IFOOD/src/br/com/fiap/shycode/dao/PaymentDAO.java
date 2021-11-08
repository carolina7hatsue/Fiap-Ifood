package br.com.fiap.shycode.dao;

import br.com.fiap.shycode.bean.Payment;

public interface PaymentDAO {
	void insert(Payment payment);
	void select();
	void update(Payment payment);
	void delete(int id);
	void selectById(int idSearch);
}
