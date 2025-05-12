package com.hotelbooking.cozyheaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Admin;
import com.hotelbooking.cozyheaven.model.User;
import com.hotelbooking.cozyheaven.service.AdminService;
import com.hotelbooking.cozyheaven.service.AuthService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AuthService authService;

    // To Add Admin
    @PostMapping("/add/{userid}")
    public Admin addAdmin(@RequestBody Admin admin, @PathVariable int userid) throws InvalidIDException {

        User user = authService.getUserById(userid);
        admin.setUser(user);
        return adminService.addAdmin(admin);
    }

    // To Get Admin Details
    @GetMapping("/get/{adminid}")
    public Admin getAdminByID(@PathVariable int adminid) throws InvalidIDException {
        return adminService.getAdminByID(adminid);
    }

    // To Update Admin Info
    @PutMapping("/update/{adminid}")
    public Admin updateInfo(@PathVariable int adminid, @RequestBody Admin request) throws InvalidIDException {
        Admin admin = adminService.getAdminByID(adminid);
        admin.setName(request.getName());
        admin.setEmail(request.getEmail());
        admin.setContact(request.getContact());
        admin.setLast_Log(request.getLast_Log());
        return adminService.addAdmin(admin);
    }
}
