package com.hotelbooking.cozyheaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Admin;
import com.hotelbooking.cozyheaven.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Add a new Admin
    public Admin addAdmin(Admin admin) throws InvalidIDException {
        return adminRepository.save(admin);
    }

    // Get Admin by ID
    public Admin getAdminByID(int adminid) throws InvalidIDException {
        return adminRepository.findById(adminid)
                .orElseThrow(() -> new InvalidIDException("Admin not found for ID: " + adminid));
    }

    // Update Admin details
    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
}
