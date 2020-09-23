package com.example.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.domain.Address;
import com.example.api.domain.Customer;
import com.example.api.model.GetAddress;
import com.example.api.model.GetAddressRequest;
import com.example.api.model.GetAddressRequestModel;
import com.example.api.model.GetAddressResponseModel;
import com.example.api.repository.AddressRepository;
import com.example.api.repository.CustomerRepository;

@Service
public class AddressService {

	private static final Logger log = LoggerFactory.getLogger(AddressService.class);

	private GetAddress getAddress;

	private GetAddressResponseModel responseSpec;

	private AddressRepository repository_andress;

	private CustomerRepository repository_customer;

	public AddressService() {

	}

	@Autowired
	public AddressService(AddressRepository repository_andress, CustomerRepository repository_customer) {
		this.repository_andress = repository_andress;
		this.repository_customer = repository_customer;
		getAddress = new GetAddressRequest();
	}

	public List<Address> findAll() {
		return repository_andress.findAllByOrderByLogradouroAsc();
	}

	public Optional<Address> findById(Long id) {
		return repository_andress.findById(id);
	}

	public List<Address> save(List<GetAddressRequestModel> addressType) {
		List<Address> list = new ArrayList<Address>();

		for (GetAddressRequestModel getAddressRequestModel : addressType) {
			try {
				log.info(String.format("CEP: %s", getAddressRequestModel.getCep()));
				responseSpec = getAddress.getAddress(getAddressRequestModel.getCep());
			}
			catch (Exception exception) {
				log.error(String.format("Erro ao Consultar o CEP: %s", exception.getLocalizedMessage()));
			}
			
			try {
				Address address = new Address();

				Customer customer = repository_customer.findAllById(getAddressRequestModel.getCustomer_id());

				address.setCustomer_id(customer);
				address.setNumero(getAddressRequestModel.getNumero());
				address.setComplemento_end(getAddressRequestModel.getComplemento_end());
				address.setCep(responseSpec.getCep());
				address.setLogradouro(responseSpec.getLogradouro());
				address.setComplemento(responseSpec.getComplemento());
				address.setBairro(responseSpec.getBairro());
				address.setLocalidade(responseSpec.getLocalidade());
				address.setUf(responseSpec.getUf());
				address.setIbge(responseSpec.getIbge());
				address.setGia(responseSpec.getGia());
				address.setDdd(responseSpec.getDdd());

				repository_andress.save(address);
				list.add(address);
			} catch (Exception e) {
				 log.error(String.format("Erro ao inserir o endereco: %s do Customer: %s erro:  %s", responseSpec.getCep(), getAddressRequestModel.getCustomer_id(), e.getLocalizedMessage()));
			}
		}

		return list;
	}

}
