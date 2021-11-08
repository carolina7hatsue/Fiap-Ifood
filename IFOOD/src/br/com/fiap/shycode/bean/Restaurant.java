package br.com.fiap.shycode.bean;

public class Restaurant {

	private int IdRestaurant;
	private String Name;
	private float MinPrice;
	
	public Restaurant(int idRestaurant, String name, float minPrice) {
		super();
		IdRestaurant = idRestaurant;
		Name = name;
		MinPrice = minPrice;
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
}