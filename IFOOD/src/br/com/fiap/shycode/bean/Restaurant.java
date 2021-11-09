package br.com.fiap.shycode.bean;

public class Restaurant {

	private int IdRestaurant;
	private String Name;
	private float MinPrice;
	private int CNPJ;
	private Address address;
	private Category category;

	public Restaurant() {
		super();
	}

	public Restaurant(int idRestaurant, String name, float minPrice, int cNPJ) {
		super();
		IdRestaurant = idRestaurant;
		Name = name;
		MinPrice = minPrice;
		CNPJ = cNPJ;
	}
	
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
	
	public int getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(int cNPJ) {
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
