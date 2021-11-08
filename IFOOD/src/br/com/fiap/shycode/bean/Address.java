package br.com.fiap.shycode.bean;

public class Address {
	
	private int IdAddress;
	private String Street;
	private String District;
	private int Number;
	private int CEP;
	private String City;
	private String State;
	private String Country;
	private String Complement;
	
	public Address() {
		
	}

	public int getIdAddress() {
		return IdAddress;
	}

	public void setIdAddress(int idAddress) {
		IdAddress = idAddress;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public int getCEP() {
		return CEP;
	}

	public void setCEP(int cEP) {
		CEP = cEP;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getComplement() {
		return Complement;
	}

	public void setComplement(String complement) {
		Complement = complement;
	}

	public Address(int idAddress, String street, String district, int number, int cEP, String city, String state,
			String country, String complement) {
		super();
		IdAddress = idAddress;
		Street = street;
		District = district;
		Number = number;
		CEP = cEP;
		City = city;
		State = state;
		Country = country;
		Complement = complement;
	}
	
	

}
