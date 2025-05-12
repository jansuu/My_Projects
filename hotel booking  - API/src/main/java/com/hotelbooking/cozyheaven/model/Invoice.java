package com.hotelbooking.cozyheaven.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDateTime invoice_date;

    @Column(nullable = false, length = 512)
    private String billing_details;


    @Column(nullable = false)
    private double total_amount;

    @Column(length = 100)
    private String PaymentMethod; // like UPI, CREDIT, DEBIT

    @Column(length = 255)
    private String transaction_id;

    @Column(length = 255)
    private String remarks;

    @ManyToOne
    private Booking booking;

    // Getters & Setters
    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(LocalDateTime invoice_date) {
        this.invoice_date = invoice_date;
    }

    public String getBilling_details() {
        return billing_details;
    }

    public void setBilling_details(String billing_details) {
        this.billing_details = billing_details;
    }


    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public String getPayment_method() {
        return PaymentMethod;
    }

    public void setPayment_method(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
