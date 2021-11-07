package br.com.fiap.shycode.bean;

public class Payment {
	private int IdPayment;
	private String Name;
	
	public int getIdPayment() {
		return IdPayment;
	}
	
	public void setIdPayment(int idPayment) {
		IdPayment = idPayment;
	}
	
	public String getName() {
		return Name;
	}
	
	public Payment(int idPayment, String name) {
		super();
		IdPayment = idPayment;
		Name = name;
	}
	
	public void setName(String name) {
		Name = name;
	}
}
