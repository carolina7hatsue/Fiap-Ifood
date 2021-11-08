package br.com.fiap.shycode.teste;

import java.util.List;

import br.com.fiap.shycode.bean.Restaurant;
import br.com.fiap.shycode.dao.RestaurantDAO;
import br.com.fiap.shycode.exception.DBException;
import br.com.fiap.shycode.factory.DAOFactory;


public class RestaurantDAOTeste {

	public static void main(String[] args) {
		RestaurantDAO dao = DAOFactory.getRestaurantDAO();
		
		//Cadastrar um produto
		Restaurant restaurant = new Restaurant(0,"Caverna da Pamonha",(float)20.00);
		try {
			dao.insert(restaurant);
			System.out.println("Produto cadastrado.");
		} catch (DBException e) {
			e.printStackTrace();
		}

		//Buscar um produto pelo código e atualizar
		restaurant = dao.selectById(0);
		restaurant.setName("Caderno capa dura");
		restaurant.setMinPrice((float)20.00);
		try {
			dao.update(restaurant);
			System.out.println("Produto atualizado.");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		//Listar os produtos
		List<Restaurant> lista = dao.select();
		for (Restaurant item : lista) {
			System.out.println("Nome restaurante: " + item.getName() + "\nPreço min: " +  item.getMinPrice());
		}
		
		//Remover um produto
		try {
			dao.delete(0);
			System.out.println("Produto removido.");
		} catch (DBException e) {
			e.printStackTrace();
		}	
	}	
}
