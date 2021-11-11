package br.com.fiap.shycode.bean;

public class Restaurant {

	// Atributos
	/**
	 * Id Restaurante
	 */
	private int IdRestaurant;
	/**
	 * Nome Restaurante
	 */
	private String Name;
	/**
	 * Preço mínimo do restaurante
	 */
	private float MinPrice;
	/**
	 * CNPJ do restaurante
	 */
	private String CNPJ;
	/**
	 * Endereço do restaurante
	 */
	private Address address;
	/**
	 * Categoria do restaurante
	 */
	private Category category;

	// Construtores
	/**
	 * Construtor Vazio
	 */
	public Restaurant() {
		super();
	}

	/**
	 * Construtor Restaurante 
	 * @param idRestaurant
	 * @param name
	 * @param minPrice
	 * @param cNPJ
	 */
	public Restaurant(int idRestaurant, String name, float minPrice, String cNPJ) {
		super();
		IdRestaurant = idRestaurant;
		Name = name;
		MinPrice = minPrice;
		CNPJ = cNPJ;
	}
	
	/**
	 * Contrutor Restaurante com endereço
	 * @param idRestaurant
	 * @param name
	 * @param minPrice
	 * @param cNPJ
	 * @param address
	 */
	 public Restaurant(int idRestaurant, String name, float minPrice, String cNPJ, Address address) {
	 super(); 
	 IdRestaurant = idRestaurant; Name = name; MinPrice = minPrice; 
	 CNPJ = cNPJ; 
	 this.address = address; }
	 
	 //Getters e Setters
	public int getIdRestaurant() {
		return IdRestaurant;
	}
	public void setIdRestaurant(int idRestaurant) {
		IdRestaurant = idRestaurant;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public float getMinPrice() {
		return MinPrice;
	}
	public void setMinPrice(float minPrice) {
		MinPrice = minPrice;
	}
	
	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
