package br.com.fiap.shycode.bean;

public class Menu {
	
	private int IdMenu;
	private String name;
	
	public Menu () {
		
	}
	
	public Menu(int idMenu, String name) {
		super();
		this.name = name;
		this.IdMenu = idMenu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdMenu() {
		return IdMenu;
	}

	public void setIdMenu(int idMenu) {
		this.IdMenu = idMenu;
	}

}
