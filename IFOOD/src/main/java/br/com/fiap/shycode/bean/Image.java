package br.com.fiap.shycode.bean;

public class Image {
	private int IdImage;
	private String Url;
	private int IdRestaurant;
	
	public int getIdImage() {
		return IdImage;
	}
	
	public void setIdImage(int idImage) {
		IdImage = idImage;
	}
	
	public String getUrl() {
		return Url;
	}
	
	public void setUrl(String url) {
		Url = url;
	}
	
	public int getIdRestaurant() {
		return IdRestaurant;
	}
	
	public void setIdRestaurant(int idRestaurant) {
		IdRestaurant = idRestaurant;
	}
	
	public Image(int idImage, String url, int idRestaurant) {
		super();
		IdImage = idImage;
		Url = url;
		IdRestaurant = idRestaurant;
	}	
}
