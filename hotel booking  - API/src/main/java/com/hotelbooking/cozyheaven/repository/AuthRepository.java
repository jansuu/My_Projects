package com.hotelbooking.cozyheaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.User;

public interface AuthRepository extends JpaRepository<User, Integer> 
{

	User findByUsername(String username);

}
