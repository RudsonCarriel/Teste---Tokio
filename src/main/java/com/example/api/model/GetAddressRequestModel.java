package com.example.api.model;

public class GetAddressRequestModel {

	private String cep;
	
	private Long customer_id;
	
	private String complemento_end;
	
	private Long numero;



	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}


	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getComplemento_end() {
		return complemento_end;
	}

	public void setComplemento_end(String complemento_end) {
		this.complemento_end = complemento_end;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	
	
}
