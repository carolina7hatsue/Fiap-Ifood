package br.com.fiap.shycode.bean;

public class Address {
	/**
	 * Id Endereço
	 */
	private int IdAddress;
	/**
	 * Rua
	 */
	private String Street;
	/**
	 * Bairro
	 */
	private String District;
	/**
	 * Numero
	 */
	private int Number;
	/**
	 * CEP
	 */
	private String CEP;
	/**
	 * Cidade
	 */
	private String City;
	/**
	 * Estado
	 */
	private String State;
	/**
	 * País
	 */
	private String Country;
	/**
	 * Complemento
	 */
	private String Complement;
	
	/**
	 * Construtor vazio
	 */
	public Address() {
		super();
	}
	
	/**
	 * Construtor Endereço completo
	 * @param idAddress
	 * @param street
	 * @param district
	 * @param number
	 * @param cEP
	 * @param city
	 * @param state
	 * @param country
	 * @param complement
	 */
	public Address(int idAddress, String street, String district, int number, String cEP, String city, String state,
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
	
 // Getters e Setters
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

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
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

}
