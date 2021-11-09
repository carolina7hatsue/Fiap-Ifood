package br.com.fiap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.shycode.bean.Address;
import br.com.fiap.shycode.bean.Restaurant;
import br.com.fiap.shycode.dao.AddressDAO;
import br.com.fiap.shycode.dao.RestaurantDAO;
import br.com.fiap.shycode.exception.DBException;
import br.com.fiap.shycode.factory.DAOFactory;

/**
 * Servlet implementation class CadastrarRestauranteServlet
 */
@WebServlet("/cadastro")
public class CadastrarRestauranteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RestaurantDAO daoRestaurant;
	private AddressDAO daoAddress;
	
	@Override
	public void init() throws ServletException {
		super.init();
		daoRestaurant = DAOFactory.getRestaurantDAO();
		daoAddress = DAOFactory.getAddressDAO();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String acao = request.getParameter("acao");
			
			switch (acao) {
			case "listar":
				listar(request, response);
				break;
			case "abrir-form-edicao":
				abrirFormEdicao(request, response);
				break;
			}
		}
		
		private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("codigo"));
			Restaurant restaurant = daoRestaurant.selectById(id);
			Address address = daoAddress.selectById(id);
			
			request.setAttribute("produto", restaurant);
			//Criar pagina de edicao de restaurantes
			//request.getRequestDispatcher("edicao-produto.jsp").forward(request, response);
		}

		private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Restaurant> lista = daoRestaurant.select();
			request.setAttribute("restaurantes", lista);
			request.getRequestDispatcher("restaurantes.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		
	protected void doPost(HttpServletRequest request, HttpServeletResponse response)
		throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request, response);
			break;
		}
	}
		
		
	protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String name = request.getParameter("nome");
			float minPrice = Float.parseFloat(request.getParameter("valor"));
			
			String street = request.getParameter("rua");
			String district = request.getParameter("bairro");
			int number = Integer.parseInt(request.getParameter("numero"));
			int cEP = Integer.parseInt(request.getParameter("cep"));
			String city = request.getParameter("cidade");
			String state = request.getParameter("estado");
			String country = request.getParameter("pais");
			String complement = request.getParameter("complemento");
			
			//Request de Category
			
			Restaurant restaurant = new Restaurant(1, name, minPrice); 
			daoRestaurant.insert(restaurant);
			
			Address address = new Address(1, street, district, number, cEP, city, state, country, complement);
			daoAddress.insert(address);
			
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
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idRestaurant = Integer.parseInt(request.getParameter(""));
			String name = request.getParameter("nome");
			float minPrice = Float.parseFloat(request.getParameter("valor"));
			
			int idAddress = Integer.parseInt(request.getParameter(""));
			String street = request.getParameter("rua");
			String district = request.getParameter("bairro");
			int number = Integer.parseInt(request.getParameter("numero"));
			int cEP = Integer.parseInt(request.getParameter("cep"));
			String city = request.getParameter("cidade");
			String state = request.getParameter("estado");
			String country = request.getParameter("pais");
			String complement = request.getParameter("complemento");
			
			//Request de Category
			Restaurant restaurant = new Restaurant(idRestaurant, name, minPrice); 
			daoRestaurant.insert(restaurant);
			
			Address address = new Address(idAddress, street, district, number, cEP, city, state, country, complement);
			daoAddress.insert(address);

			request.setAttribute("msg", "Produto atualizado!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		listar(request,response);
	}
	
	

}
