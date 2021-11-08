package br.com.fiap.shycode.dao;

import java.util.List;

import br.com.fiap.shycode.bean.Image;
import br.com.fiap.shycode.exception.DBException;

public interface ImageDAO {
	void insert(Image image) throws DBException;
	void update(Image image) throws DBException;
	void delete(int id) throws DBException;
	public Image selectById(int idSearch);
	List<Image> select();
}
