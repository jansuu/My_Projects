package com.hotelbooking.cozyheaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer>  {

}
