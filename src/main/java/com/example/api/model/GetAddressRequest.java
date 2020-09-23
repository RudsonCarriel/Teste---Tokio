package com.example.api.model;

import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.api.model.exception.APIException;

import static com.example.api.constant.Constants.*;

public class GetAddressRequest implements GetAddress {

	public GetAddressResponseModel getAddress(String cep) throws APIException {
		try {
			final WebClient webClient = WebClient.builder().baseUrl(HOST).build();

			final GetAddressResponseModel responseSpec = webClient.method(HttpMethod.GET)
					.uri(cep + "/json/")
					.retrieve()
					.bodyToFlux(GetAddressResponseModel.class)
					.blockLast();
			return responseSpec;
		} catch (Exception e) {
			
			throw new APIException(
					String.format("Falha ao obter endereco completo com CEP: %s Exception: %s",
							cep, e.getMessage()));
		}
	}
}
