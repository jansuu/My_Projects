package com.hotelbooking.cozyheaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
