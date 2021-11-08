package br.com.fiap.shycode.bean;

public class Category {

	private int IdCategory;
	private String Name;
	
	public int getIdCategory() {
		return IdCategory;
	}
	
	public void setIdCategory(int idCategory) {
		IdCategory = idCategory;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public Category(int idCategory, String name) {
		super();
		IdCategory = idCategory;
		Name = name;
	}
}
