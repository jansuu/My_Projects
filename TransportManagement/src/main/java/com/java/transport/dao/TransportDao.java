package com.java.transport.dao;

import java.sql.SQLException;
import java.util.List;


import com.java.transport.model.Admin;
import com.java.transport.model.Booking;
import com.java.transport.model.Customer;
import com.java.transport.model.Journey;
import com.java.transport.model.Payment;
import com.java.transport.model.Vehicle;

public interface TransportDao {
	
	List<Admin> showadmin() throws ClassNotFoundException, SQLException;
	Admin searchadmin(String name) throws ClassNotFoundException, SQLException;
	String addadmin(Admin admin) throws SQLException, ClassNotFoundException;
	boolean addvehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException; 
    List<Vehicle> showvehicles() throws SQLException, ClassNotFoundException;
    Vehicle searchvehiclebytype(String vehicleType) throws SQLException, ClassNotFoundException;
    Journey search(int journeyId) throws ClassNotFoundException, SQLException;
    boolean addJourney(Journey journey) throws SQLException, ClassNotFoundException;
    boolean updateJourney(Journey journey) throws SQLException, ClassNotFoundException;
    String cancleJourney(int journeyId) throws SQLException, ClassNotFoundException;
    String addCustomer(Customer customer) throws ClassNotFoundException, SQLException;
    String addBooking(Booking booking) throws ClassNotFoundException, SQLException;
    Booking showbookingbyid(int bookingId) throws ClassNotFoundException, SQLException;
    String cancelbooking(int bookingId) throws ClassNotFoundException, SQLException;
    Payment searchpaymnet(int paymentId) throws ClassNotFoundException, SQLException;
    String addpayment(Payment payment) throws ClassNotFoundException, SQLException;
    List<Payment> clearpayment() throws ClassNotFoundException, SQLException;
	

}
