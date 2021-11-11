package br.com.fiap.shycode.bean;

public class Category {
	
	// Atributos
	/**
	 * Id Categoria
	 */
	private int IdCategory;
	/**
	 * Nome Categoria
	 */
	private String Name;
	
	// Construtores
	/**
	 * Construtor Categoria Vazio
	 */
	public Category() {
		super();
	}
	
	/**
	 * Construtor Categoria Completo
	 * @param idCategory
	 * @param name
	 */
	public Category(int idCategory, String name) {
		super();
		IdCategory = idCategory;
		Name = name;
	}
	
	// Getters e Setters
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
	

}
