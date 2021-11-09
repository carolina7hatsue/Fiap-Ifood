package br.com.fiap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.shycode.bean.Restaurant;
import br.com.fiap.shycode.dao.RestaurantDAO;
import br.com.fiap.shycode.exception.DBException;
import br.com.fiap.shycode.factory.DAOFactory;

/**
 * Servlet implementation class CadastrarRestauranteServlet
 */
@WebServlet("/cadastro")
public class CadastrarRestauranteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RestaurantDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getRestaurantDAO();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String acao = request.getParameter("cadastro");
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String nome = request.getParameter("nome");
			float preco = Float.parseFloat(request.getParameter("valor"));
			
			Restaurant restaurant = new Restaurant(1, nome, preco); 
			dao.insert(restaurant);
			
			request.setAttribute("msg", "Produto cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);
	}
	
	

}
