package com.example.api.model;

import com.example.api.model.exception.APIException;

public interface GetAddress {
	
	GetAddressResponseModel getAddress(String cep) throws APIException;
	
}
