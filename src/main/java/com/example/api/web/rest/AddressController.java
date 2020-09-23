package com.example.api.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.domain.Address;
import com.example.api.model.GetAddressRequestModel;
import com.example.api.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	private AddressService service;

	@Autowired
	public AddressController(AddressService service) {
		this.service = service;
	}

	@GetMapping
	public List<Address> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Address findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
	}
	@PostMapping("/endereco")
	public List<Address> saveAddress(@RequestBody List<GetAddressRequestModel> address ) {
		return service.save(address);
	}
	
}
