package br.com.fiap.shycode.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.shycode.bean.Address;
import br.com.fiap.shycode.bean.Category;
import br.com.fiap.shycode.bean.Restaurant;
import br.com.fiap.shycode.dao.AddressDAO;
import br.com.fiap.shycode.dao.CategoryDAO;
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
	private CategoryDAO daoCategory;
	
	@Override
	public void init() throws ServletException {
		super.init();
		daoRestaurant = DAOFactory.getRestaurantDAO();
		daoAddress = DAOFactory.getAddressDAO();
		daoCategory = DAOFactory.getCategoryDAO();
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
			case "abrir-form-cadastro":
				abrirFormCadastro(request, response);
				break;
			}
		}
		
		private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Restaurant> lista = daoRestaurant.select();
			request.setAttribute("restaurantes", lista);
			request.getRequestDispatcher("restaurants.jsp").forward(request, response);
		}
		
		private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int idRestaurant = Integer.parseInt(request.getParameter("codigo"));
			Restaurant restaurant = daoRestaurant.selectById(idRestaurant);
			request.setAttribute("restaurantes", restaurant);
			carregarOpcoesCategoria(request);
			request.getRequestDispatcher("updateRestaurant.jsp").forward(request, response);
			///Address address = daoAddress.selectById(idAddress);
			
			//request.setAttribute("produto", restaurant);
			//Criar pagina de edicao de restaurantes
		}
		
		private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			carregarOpcoesCategoria(request);
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}
		
		public void carregarOpcoesCategoria(HttpServletRequest request) {
			List<Category> lista = daoCategory.select();
			request.setAttribute("categorias", lista);
		}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request, response);
			break;
		case "excluir":
			excluir(request, response);
			break;
		}
	}
		
	public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		int idRestaurant = Integer.parseInt(request.getParameter("codigo"));
		// Deletar address tb?
		try {
			daoRestaurant.delete(idRestaurant);
			// daoAddress.delete(idAddress);?
			request.setAttribute("msg", "Restaurante removido!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao excluir");
		}
		listar(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idRestaurant = Integer.parseInt(request.getParameter("codigo"));
			String name = request.getParameter("nome");
			float minPrice = Float.parseFloat(request.getParameter("valor"));
			int cNPJ = Integer.parseInt(request.getParameter("cnpj"));
			
			int idAddress = Integer.parseInt(request.getParameter("codigoEndereco"));
			String street = request.getParameter("rua");
			String district = request.getParameter("bairro");
			int number = Integer.parseInt(request.getParameter("numero"));
			int cEP = Integer.parseInt(request.getParameter("cep"));
			String city = request.getParameter("cidade");
			String state = request.getParameter("estado");
			String country = request.getParameter("pais");
			String complement = request.getParameter("complemento");
			
			int idCategory = Integer.parseInt(request.getParameter("categoria"));
			
			Category category = new Category();
			category.setIdCategory(idCategory);
			
			Restaurant restaurant = new Restaurant(idRestaurant, name, minPrice, cNPJ); 
			daoRestaurant.insert(restaurant);
			
			Address address = new Address(idAddress, street, district, number, cEP, city, state, country, complement);
			daoAddress.insert(address);

			request.setAttribute("msg", "Restaurante atualizado!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		listar(request, response);
	}

	protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String name = request.getParameter("nome");
			float minPrice = Float.parseFloat(request.getParameter("valor"));
			int cNPJ = Integer.parseInt(request.getParameter("cnpj"));
			
			String street = request.getParameter("rua");
			String district = request.getParameter("bairro");
			int number = Integer.parseInt(request.getParameter("numero"));
			int cEP = Integer.parseInt(request.getParameter("cep"));
			String city = request.getParameter("cidade");
			String state = request.getParameter("estado");
			String country = request.getParameter("pais");
			String complement = request.getParameter("complemento");
			
			int idCategory = Integer.parseInt(request.getParameter("categoria"));
			
			//Request de Category
			Category category = new Category();
			category.setIdCategory(idCategory);
			
			Address address = new Address(0, street, district, number, cEP, city, state, country, complement);
			daoAddress.insert(address);
			var listAddress = daoAddress.select();
			var selectFirst = listAddress.get(0);
			
			Restaurant restaurant = new Restaurant(0, name, minPrice, cNPJ, selectFirst); 
			restaurant.setCategory(category);
			
			daoRestaurant.insert(restaurant);
			
			request.setAttribute("msg", "Restaurante cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		abrirFormCadastro(request, response);
	}

}
