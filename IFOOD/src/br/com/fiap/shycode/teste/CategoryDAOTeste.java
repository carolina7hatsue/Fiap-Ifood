package br.com.fiap.shycode.teste;

import java.util.List;

import br.com.fiap.shycode.bean.Category;
import br.com.fiap.shycode.dao.CategoryDAO;
import br.com.fiap.shycode.factory.DAOFactory;

public class CategoryDAOTeste {

    public static void main(String[] args) {
        CategoryDAO dao = DAOFactory.getCategoryDAO();
        List<Category> lista = dao.select();
        for (Category categoria : lista) {
            System.out.println(categoria.getIdCategory() + " " + categoria.getName());
        }
    }

}