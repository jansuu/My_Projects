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
