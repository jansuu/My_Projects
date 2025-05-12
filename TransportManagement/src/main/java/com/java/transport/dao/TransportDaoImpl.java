package com.java.transport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.Timestamp;
import java.sql.Time;
import com.java.transport.model.Admin;
import com.java.transport.model.Booking;
import com.java.transport.model.Customer;
import com.java.transport.model.Gender;
import com.java.transport.model.Journey;
import com.java.transport.model.Payment;
import com.java.transport.model.Vehicle;
import com.java.transport.util.ConnectionHelper;

public class TransportDaoImpl implements TransportDao{
	
	Connection connection;
	PreparedStatement pst;
	
	
	@Override
	public List<Admin> showadmin() throws ClassNotFoundException, SQLException {
		
		Admin ad = null; 
		List<Admin> adminlist = new ArrayList<Admin>();
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from admin";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			ad = new Admin(); 
			ad.setAdminid(rs.getInt("adminId"));
			ad.setName(rs.getString("adminname"));
			ad.setDob(rs.getDate("dob"));
			ad.setDoj(rs.getDate("doj"));
			ad.setMobile(rs.getString("mobile"));
			ad.setEmail(rs.getString("email"));		
			ad.setUsername(rs.getString("username"));
			ad.setPassword(rs.getString("password"));
			ad.setGender(Gender.valueOf(rs.getString("gender")));
			adminlist.add(ad);
		}
		return adminlist;
	}

	@Override
	public Admin searchadmin(String name) throws ClassNotFoundException, SQLException {
		
		Admin ad = null;
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from admin where adminname=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, name);
		ResultSet rs = pst.executeQuery();
		if(rs.next())
		{
			ad = new Admin();
			ad.setAdminid(rs.getInt("adminId"));
			ad.setName(rs.getString("adminname"));
			ad.setDob(rs.getDate("dob"));
			ad.setDoj(rs.getDate("doj"));
			ad.setMobile(rs.getString("mobile"));
			ad.setEmail(rs.getString("email"));		
			ad.setUsername(rs.getString("username"));
			ad.setPassword(rs.getString("password"));
			ad.setGender(Gender.valueOf(rs.getString("gender")));
		}
		return ad;
	}

	@Override
	public String addadmin(Admin admin) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into admin(adminId,adminname,gender,dob,doj,mobile,email,username,password)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, admin.getAdminid()); 
		pst.setString(2, admin.getName());
		pst.setString(3,admin.getGender().toString());
		pst.setDate(4,admin.getDob() );
		pst.setDate(5, admin.getDoj());
		pst.setString(6, admin.getMobile());
		pst.setString(7, admin.getEmail());
		pst.setString(8, admin.getUsername());
		pst.setString(9, admin.getPassword());
		pst.executeUpdate();
		return "inserted ";
	}

	@Override
	public boolean addvehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		 String sql = "INSERT INTO Vehicle (vehicleId, registrationno, vehicletype, vehiclename, capacity, status, quantity, adminId) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        pst = connection.prepareStatement(sql);
        pst.setInt(1, vehicle.getVehicleId());
        pst.setInt(2, vehicle.getRegistrationno());
        pst.setString(3, vehicle.getVehicletype());
        pst.setString(4, vehicle.getVehiclename());
        pst.setInt(5, vehicle.getCapacity());
        pst.setString(6, vehicle.getStatus());
        pst.setInt(7, vehicle.getQuantity());
        pst.setInt(8, vehicle.getAdminId());
        pst.executeUpdate();
        return true;
	}

	@Override
	public List<Vehicle> showvehicles() throws SQLException, ClassNotFoundException {
		Vehicle vc = null;
		List<Vehicle> vehicle = new ArrayList<Vehicle>();
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Vehicle";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			 vc = new Vehicle();
	    	 vc.setVehicleId(rs.getInt("vehicleId"));
	    	 vc.setRegistrationno(rs.getInt("registrationno"));
	    	 vc.setVehicletype(rs.getString("vehicletype"));
	    	 vc.setVehiclename(rs.getString("vehiclename"));
	    	 vc.setCapacity(rs.getInt("capacity"));
	    	 vc.setStatus(rs.getString("status"));
	    	 vc.setQuantity(rs.getInt("quantity"));
	    	 vc.setAdminId(rs.getInt("adminId"));
	    	 vehicle.add(vc);

		}
		return vehicle;
	}

	@Override
	public Vehicle searchvehiclebytype(String vehicleType) throws SQLException, ClassNotFoundException {
		 Vehicle vc = null;
		 connection = ConnectionHelper.getConnection();
	     String sql = "SELECT * FROM Vehicle WHERE vehicletype = ?";
	     PreparedStatement pst = connection.prepareStatement(sql);
	     pst.setString(1, vehicleType);
	     ResultSet rs = pst.executeQuery();
	     while(rs.next())
	     {
	    	 vc = new Vehicle();
	    	 vc.setVehicleId(rs.getInt("vehicleId"));
	    	 vc.setRegistrationno(rs.getInt("registrationno"));
	    	 vc.setVehicletype(rs.getString("vehicletype"));
	    	 vc.setVehiclename(rs.getString("vehiclename"));
	    	 vc.setCapacity(rs.getInt("capacity"));
	    	 vc.setStatus(rs.getString("status"));
	    	 vc.setQuantity(rs.getInt("quantity"));
	    	 vc.setAdminId(rs.getInt("adminId"));
	     }
		return vc;
	    
	}
	
	@Override
	public Journey search(int journeyId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 Journey j = null;
		 connection = ConnectionHelper.getConnection();
	     String sql = "SELECT * FROM journey WHERE journeyId = ?";
	     PreparedStatement pst = connection.prepareStatement(sql);
	     pst.setInt(1, journeyId);
	     ResultSet rs = pst.executeQuery();
	     while(rs.next())
	     {
	    	 j = new Journey();
	    	 j.setJourneyId(rs.getInt("journeyId"));
	    	 j.setVehicleId(rs.getInt("vehicleId"));
	    	 j.setRegistrationno(rs.getInt("registrationno"));
	    	 j.setStartstation(rs.getString("startstation"));
	    	 j.setEndstation(rs.getString("endstation"));
	    	 j.setStarttime(rs.getTimestamp("starttime"));
	    	 j.setDepaturetime(rs.getTimestamp("departuretime"));
	    	 j.setType(rs.getString("type"));
	    	 j.setAdminId(rs.getInt("adminId"));
	    	 j.setPrice(rs.getInt("price"));
	     }
		
		return j;
	}

	@Override
	public boolean addJourney(Journey journey) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		 String sql = "INSERT INTO journey (journeyId,vehicleId, registrationno, startstation, endstation, starttime, departuretime, type, adminId, price) "
                 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
          pst = connection.prepareStatement(sql);
          pst.setInt(1, journey.getJourneyId());
          pst.setInt(2, journey.getVehicleId());
          pst.setInt(3, journey.getRegistrationno());
          pst.setString(4, journey.getStartstation());
          pst.setString(5, journey.getEndstation());
          pst.setTimestamp(6, journey.getStarttime());
          pst.setTimestamp(7, journey.getDepaturetime());
          pst.setString(8, journey.getType());
          pst.setInt(9, journey.getAdminId());
          pst.setDouble(10, journey.getPrice());
          
          int rowsAffected = pst.executeUpdate();
          return rowsAffected > 0;
	}

	@Override
	public boolean updateJourney(Journey journey) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String sql = "UPDATE journey SET vehicleId = ?, registrationNo = ?, startStation = ?, endStation = ?, startTime = ?, "
                + "departureTime = ?, type = ?, adminId = ?, price = ? WHERE journeyId = ?";
     try (PreparedStatement stmt = connection.prepareStatement(sql)) {
         stmt.setInt(1, journey.getVehicleId());
         stmt.setInt(2, journey.getRegistrationno());
         stmt.setString(3, journey.getStartstation());
         stmt.setString(4, journey.getEndstation());
         stmt.setTimestamp(5, journey.getStarttime());
         stmt.setTimestamp(6, journey.getDepaturetime());
         stmt.setString(7, journey.getType());
         stmt.setInt(8, journey.getAdminId());
         stmt.setDouble(9, journey.getPrice());
         stmt.setInt(10, journey.getJourneyId());

         int rowsAffected = stmt.executeUpdate();
         return rowsAffected > 0;
     }
	}

	@Override
	public String cancleJourney(int journeyId) throws SQLException, ClassNotFoundException {
		Journey bk = search(journeyId);
		if(bk!=null) {
			connection = ConnectionHelper.getConnection();
	        String cmd = "delete from journey where journeyId=?";
	        pst = connection.prepareStatement(cmd);
	        pst.setInt(1, journeyId);
	        pst.executeUpdate();
			return "journey Record Deleted...";
			}
			return "record is not there";
	}

	@Override
	public String addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 connection = ConnectionHelper.getConnection();
	        String cmd = "INSERT INTO customer (customerId, customername, age, mobile, email) VALUES (?,?,?,?,?)";
	        pst = connection.prepareStatement(cmd);
	        pst.setInt(1, customer.getCustomerId());
	        pst.setString(2, customer.getCustomername());
	        pst.setInt(3, customer.getAge());
	        pst.setString(4, customer.getMobile());
	        pst.setString(5, customer.getEmail());
	        pst.executeUpdate();
	        return "Customer added successfully";
	}

	@Override
	public String addBooking(Booking booking) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		    connection = ConnectionHelper.getConnection();
	        String cmd = "INSERT INTO booking(bookingId, customerId, bookingdate, journeyId, startdate,enddate,noofdays,advanceamount) VALUES (?,?,?,?,?,?,?,?)";
	        pst = connection.prepareStatement(cmd);
	        pst.setInt(1, booking.getBookingId());
	        pst.setInt(2, booking.getCustomerId());
	        pst.setDate(3, booking.getBookingdate());
	        pst.setInt(4, booking.getJourneyId());
	        pst.setDate(5, booking.getStartdate());
	        pst.setDate(6, booking.getEnddate());
	        pst.setInt(7, booking.getNoofdays());
	        pst.setInt(8, booking.getAdvanceamount());
	        pst.executeUpdate();
		    return "booking is done";
	}


	@Override
	public Booking showbookingbyid(int bookingId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Booking b = null;
		connection = ConnectionHelper.getConnection();
        String cmd = "select*from booking where bookingId=?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, bookingId);
        ResultSet rs = pst.executeQuery();
		if(rs.next())
		{
			b = new Booking();
			b.setBookingId(rs.getInt("bookingId"));
			b.setCustomerId(rs.getInt("customerId"));
			b.setBookingdate(rs.getDate("bookingdate"));
			b.setJourneyId(rs.getInt("journeyId"));
			b.setStartdate(rs.getDate("startdate"));
			b.setEnddate(rs.getDate("enddate"));
			b.setNoofdays(rs.getInt("noofdays"));
			b.setAdvanceamount(rs.getInt("advanceamount"));
		}
		return b;
	}

	@Override
	public String cancelbooking(int bookingId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Booking bk = showbookingbyid(bookingId);
		if(bk!=null) {
		connection = ConnectionHelper.getConnection();
        String cmd = "delete from booking where bookingId=?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, bookingId);
        pst.executeUpdate();
		return "booking Record Deleted...";
		}
		return "record is not there";
	}
	

	@Override
	public String addpayment(Payment payment) throws ClassNotFoundException, SQLException
		{
			// TODO Auto-generated method stub
		        connection = ConnectionHelper.getConnection();  
                String query = "INSERT INTO payment (paymentid, bookingId,finalamount) VALUES (?, ?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, payment.getPaymentid());
                statement.setInt(2, payment.getBookingid());
                statement.setInt(3, payment.getFinalamount());
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    return "Payment added successfully!";
             }
                return "Failed to add payment.";
            
   } 

	@Override
	public Payment searchpaymnet(int paymentId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 Payment payment = null;
	     connection = ConnectionHelper.getConnection();
	     String query = "SELECT * FROM payment WHERE paymentId = ?";
	     PreparedStatement statement = connection.prepareStatement(query);
	     statement.setInt(1, paymentId);
	     ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) 
	            {
	                payment = new Payment();
	                payment.setPaymentid(resultSet.getInt("paymentId"));
	                payment.setBookingid(resultSet.getInt("bookingId"));  
	                payment.setFinalamount(resultSet.getInt("finalamount"));
	            }
	     return payment;
	}

	@Override
	public List<Payment> clearpayment() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Payment payment = null; 
		List<Payment> plist = new ArrayList<Payment>();
		connection = ConnectionHelper.getConnection();
		String cmd = "select p.paymentId,p.bookingId,p.finalamount, (b.advanceamount+p.finalamount) as payments, "
				+ "(j.price-b.advanceamount+p.finalamount) as remaining from payment p \r\n"
				+ "join booking b on p.bookingId = b.bookingId join journey j\r\n"
				+ "on j.journeyId = b.journeyId\r\n"
				+ "where (b.advanceamount+p.finalamount) < j.price;";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		 while (rs.next()) 
         {
             payment = new Payment();
             payment.setPaymentid(rs.getInt("paymentid"));
             payment.setBookingid(rs.getInt("bookingId"));
             payment.setFinalamount(rs.getInt("finalamount"));
             double remaining = rs.getDouble("remaining");
             double payments = rs.getDouble("payments");
             System.out.println("Pending amount for Payment ID " + rs.getInt("paymentid") + " : " + remaining);
             System.out.println("payment done by Payment ID " + rs.getInt("paymentid") + " : " + payments);
             System.out.println("---------------------------------");
             plist.add(payment);
             if(remaining!=0) 
             {
            	 continue;
             }
             else
             {
            	 Payment pk1 = searchpaymnet(rs.getInt("paymentid"));
            	 if(pk1!=null)
            	 { 
            		 connection = ConnectionHelper.getConnection();
            		 String cmd1 = "delete from payment where paymentid = ?";
             		 pst = connection.prepareStatement(cmd1);
             		 pst.setInt(1,rs.getInt("paymentid"));
             		 pst.executeUpdate();
            	 }
            	 else
            	 {
            		 System.out.println("the payment is already cleared");
            	 }

             }
         }
		return plist;
	}

	
 }
