package br.com.fiap.shycode.dao;

import br.com.fiap.shycode.bean.Image;

public interface ImageDAO {
	void insert(Image image);
	void select();
	void update(Image image);
	void delete(int id);
	void selectById(int idSearch);
}
