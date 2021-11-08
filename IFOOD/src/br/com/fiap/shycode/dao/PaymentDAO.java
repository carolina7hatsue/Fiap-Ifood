package br.com.fiap.shycode.dao;

import java.util.List;

import br.com.fiap.shycode.bean.Payment;
import br.com.fiap.shycode.exception.DBException;

public interface PaymentDAO {
	void insert(Payment payment) throws DBException;
	List<Payment> select();
	void update(Payment payment) throws DBException;
	void delete(int id) throws DBException;
	public Payment selectById(int idSearch);
}
