package br.com.fiap.shycode.bean;

public class Item {

	private int IdItem;
	private String Description;
	private float Price;
	private String Name;
	
	public int getIdItem() {
		return IdItem;
	}
	
	public void setIdItem(int idItem) {
		IdItem = idItem;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String description) {
		Description = description;
	}
	
	public float getPrice() {
		return Price;
	}
	
	public void setPrice(float price) {
		Price = price;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public Item(int idItem, String description, float price, String name) {
		super();
		IdItem = idItem;
		Description = description;
		Price = price;
		Name = name;
	}

}
