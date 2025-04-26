package com.hotelbooking.cozyheaven.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.exception.InvalidUsernameException;
import com.hotelbooking.cozyheaven.model.Customer;
import com.hotelbooking.cozyheaven.model.User;
import com.hotelbooking.cozyheaven.repository.AuthRepository;
import com.hotelbooking.cozyheaven.repository.CustomerRepository;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AuthRepository authRepository;

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	

	public Customer addCustomer(Customer customer) throws InvalidUsernameException 
	{
		// TODO Auto-generated method stub
		User user = customer.getUser();
		User user1 = authRepository.findByUsername(user.getUsername());
		if(user1 != null)
		{
			throw new InvalidUsernameException("User Already Exist!!!! Keep going and Try to Login......");
		}
		if(user.getRole() == null)
		{
			user.setRole("Customer");
		}
		String encodedPass = bcrypt.encode(user.getPassword());
		user.setPassword(encodedPass);
		
		authRepository.save(user);
		customer.setUser(user);
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
