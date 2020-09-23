package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository repository;

	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public List<Customer> findAll() {
		return repository.findAllByOrderByNameAsc();
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

	public List<Customer> save(List<Customer> cliente) {
		for (Customer customer : cliente) {
			repository.save(customer);
		}
		return cliente;
	}
	
	public void delete(List<Customer> cliente) {
		for (Customer customer : cliente) {
			repository.delete(customer);
		}
	}
}
