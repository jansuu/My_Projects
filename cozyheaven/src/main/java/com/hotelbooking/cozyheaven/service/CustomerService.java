package com.hotelbooking.cozyheaven.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Customer;
import com.hotelbooking.cozyheaven.repository.CustomerRepository;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerRepository customerRepository;

	public Customer addCustomer(Customer customer) 
	{
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	public List<Customer> getAllEmployees() 
	{
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	public Customer getCustomerById(int customerId) throws InvalidIDException 
	{
		// TODO Auto-generated method stub
		Optional<Customer> optional = customerRepository.findById(customerId);
		if(optional.isEmpty())
		{
			throw new InvalidIDException("Customer ID is invalid...");
		}
		return optional.get();
	}

	public Customer getCustomerByEmail(String email) throws InvalidIDException 
	{
		// TODO Auto-generated method stub
		Optional<Customer> optional = customerRepository.findByEmail(email);
		if(optional.isEmpty())
		{
			throw new InvalidIDException("email is invalid...");
		}
		return optional.get();
	}

	public void deleteCustomer(int customerId) 
	{
		// TODO Auto-generated method stub
		customerRepository.deleteById(customerId);
	}

	public Customer getCustomerByContact(String contact) throws InvalidIDException 
	{
		// TODO Auto-generated method stub
		Optional<Customer> optional = customerRepository.findByContact(contact);
		if(optional.isEmpty())
		{
			throw new InvalidIDException("contact is invalid...");
		}
		return optional.get();
	}

}
