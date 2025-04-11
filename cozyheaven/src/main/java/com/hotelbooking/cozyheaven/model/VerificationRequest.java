package com.hotelbooking.cozyheaven.model;

import com.hotelbooking.cozyheaven.enums.ApprovalStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "verification_request")
public class VerificationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false, length = 255)
    private String licensen_number;

    @Column(nullable = false)
    private String property_ownership_proof;

    @Column
    private String message;

    @Column
    private String document;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApprovalStatus status;

    @ManyToOne
    private HotelOwner hotelOwner;

    @ManyToOne
    private Hotel hotel;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicensen_number() {
        return licensen_number;
    }

    public void setLicensen_number(String licensen_number) {
        this.licensen_number = licensen_number;
    }

    public String getProperty_ownership_proof() {
        return property_ownership_proof;
    }

    public void setProperty_ownership_proof(String property_ownership_proof) {
        this.property_ownership_proof = property_ownership_proof;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public ApprovalStatus getStatus() {
        return status;
    }

    public void setStatus(ApprovalStatus status) {
        this.status = status;
    }

    public HotelOwner getHotelOwner() {
        return hotelOwner;
    }

    public void setHotelOwner(HotelOwner hotelOwner) {
        this.hotelOwner = hotelOwner;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
