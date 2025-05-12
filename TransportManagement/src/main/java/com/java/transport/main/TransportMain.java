package com.java.transport.main;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.java.transport.dao.TransportDao;
import com.java.transport.dao.TransportDaoImpl;
import com.java.transport.model.Admin;
import com.java.transport.model.Booking;
import com.java.transport.model.Customer;
import com.java.transport.model.Gender;
import com.java.transport.model.Journey;
import com.java.transport.model.Payment;
import com.java.transport.model.Vehicle;

public class TransportMain {
	static Scanner sc = new Scanner(System.in);
	
	static TransportDao transportdao = new TransportDaoImpl();
	
	public static void adminshow() throws ClassNotFoundException, SQLException
	{
		List<Admin> adlist = transportdao.showadmin();
		for (Admin admin : adlist)
		{
			System.out.println(admin);
		}
	}   
	  
	public static void adminsearch() throws ClassNotFoundException, SQLException
	{
		String adminname;
		System.out.println("enter admin name");
		adminname = sc.next();
		Admin admin = transportdao.searchadmin(adminname);
		if (admin!= null) {
			System.out.println(admin);
		} else {
			System.out.println("***Record Not Found ***");
		}
	}
	
	public static void addadmin() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Admin admin = new Admin();
		System.out.println("Enter admin id  ");
		admin.setAdminid(sc.nextInt());
		System.out.println("Enter admin name  ");
		admin.setName(sc.next());
		System.out.println("Enter gender  ");
		admin.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter dob  ");
		Date dt1 = sdf.parse(sc.next());
		java.sql.Date sqlDate1 = new java.sql.Date(dt1.getTime());
		admin.setDob(sqlDate1);
		System.out.println("Enter doj  ");
		Date dt2 = sdf.parse(sc.next());
		java.sql.Date sqlDate2 = new java.sql.Date(dt2.getTime());
		admin.setDoj(sqlDate2);
		System.out.println("Enter mobile  ");
		admin.setMobile(sc.next());
		System.out.println("Enter email  ");
		admin.setEmail(sc.next());
		System.out.println("Enter username  ");
		admin.setUsername(sc.next());
		System.out.println("Enter password  ");
		admin.setPassword(sc.next());
		try {
			System.out.println(transportdao.addadmin(admin));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void showvehicles() throws ClassNotFoundException, SQLException {
	  List<Vehicle> vehicleList = transportdao.showvehicles();
	        for (Vehicle vehicle : vehicleList)
	        {
	            System.out.println(vehicle);
	        }
	}
	
	
	 public static void searchVehicleByType() throws ClassNotFoundException, SQLException {
	       String type;
	       System.out.println("enter the type");
	       type = sc.next();
	       Vehicle vehicle = transportdao.searchvehiclebytype(type);
	       if(vehicle!=null)
	       {
	    	   System.out.println(vehicle);
	       }
	       else
	       {
	    	   System.out.println("not found");
	       }
	    }
	 
	 
	 public static void addVehicle() throws ClassNotFoundException, SQLException {
		 
	        Vehicle vehicle = new Vehicle();
	        System.out.println("Enter Vehicle ID: ");
	        vehicle.setVehicleId(sc.nextInt());
	        System.out.println("enter regno");
	        vehicle.setRegistrationno(sc.nextInt());
	        System.out.println("Enter Vehicle Type: ");
	        vehicle.setVehicletype(sc.next());
	        System.out.println("enter vehicle name");
	        vehicle.setVehiclename(sc.next());
	        System.out.println("Enter Capacity: ");
	        vehicle.setCapacity(sc.nextInt());
	        System.out.println("enter status");
	        vehicle.setStatus(sc.next());
	        System.out.println("enter quantity");
	        vehicle.setQuantity(sc.nextInt());
	        System.out.println("enter adminid");
	        vehicle.setAdminId(sc.nextInt());
	        System.out.println(transportdao.addvehicle(vehicle));
	    }
	 
	 
	 public static void addJourney() throws ClassNotFoundException, SQLException {
		 
	        Journey journey = new Journey();
	        System.out.println("Enter Journey ID: ");
	        journey.setJourneyId(sc.nextInt());
	        System.out.println("Enter Vehicle ID: ");
	        journey.setVehicleId(sc.nextInt());
	        System.out.println("enter regno");
	        journey.setRegistrationno(sc.nextInt());
	        System.out.println("Enter Origin: ");
	        journey.setStartstation(sc.next());
	        System.out.println("Enter Destination: ");
	        journey.setEndstation(sc.next());
	        System.out.println("Enter Start Date-Time (yyyy-MM-dd HH:mm:ss): ");
	        String startDateTime = sc.next() + " " + sc.next(); 
	        journey.setStarttime(Timestamp.valueOf(startDateTime));
	        System.out.println("Enter Departure Date-Time (yyyy-MM-dd HH:mm:ss): ");
	        String departureDateTime = sc.next() + " " + sc.next();
	        journey.setDepaturetime(Timestamp.valueOf(departureDateTime));
	        System.out.println("enter type");
	        journey.setType(sc.next());
	        System.out.println("enter price");
	        journey.setPrice(sc.nextInt());
	        System.out.println("enter adminid");
	        journey.setAdminId(sc.nextInt());
	        System.out.println(transportdao.addJourney(journey));
	    }
	 
	 public static void updatejourney() throws ClassNotFoundException, SQLException
	 {
		    Journey journey = new Journey();
	        System.out.println("Enter Journey ID: ");
	        journey.setJourneyId(sc.nextInt());
	        System.out.println("Enter Vehicle ID: ");
	        journey.setVehicleId(sc.nextInt());
	        System.out.println("enter regno");
	        journey.setRegistrationno(sc.nextInt());
	        System.out.println("Enter Origin: ");
	        journey.setStartstation(sc.next());
	        System.out.println("Enter Destination: ");
	        journey.setEndstation(sc.next());
	        System.out.println("Enter Start Date-Time (yyyy-MM-dd HH:mm:ss): ");
	        String startDateTime = sc.next() + " " + sc.next(); 
	        journey.setStarttime(Timestamp.valueOf(startDateTime));
	        System.out.println("Enter Departure Date-Time (yyyy-MM-dd HH:mm:ss): ");
	        String departureDateTime = sc.next() + " " + sc.next();
	        journey.setDepaturetime(Timestamp.valueOf(departureDateTime));
	        System.out.println("enter type");
	        journey.setType(sc.next());
	        System.out.println("enter price");
	        journey.setPrice(sc.nextInt());
	        System.out.println("enter adminid");
	        journey.setAdminId(sc.nextInt());
	        System.out.println(transportdao.updateJourney(journey));
	 }
	 
	 public static void deletejourney() throws ClassNotFoundException, SQLException
	 {
		 int id;
		 System.out.println("enter journey id");
		 id=sc.nextInt();
		 System.out.println(transportdao.cancleJourney(id));
		 
	 }
	 
	 public static void addcustomer() throws ClassNotFoundException, SQLException
	 {
		 Customer c = new Customer();
		 System.out.println("enter customer id");
		 c.setCustomerId(sc.nextInt());
		 System.out.println("enter name");
		 c.setCustomername(sc.next());
		 System.out.println("enter age");
		 c.setAge(sc.nextInt());
		 System.out.println("enter mobile no");
		 c.setMobile(sc.next());
		 System.out.println("enter email");
		 c.setEmail(sc.next());
		 System.out.println(transportdao.addCustomer(c));
	 }
	 
	 public static void addbooking() throws ParseException, ClassNotFoundException, SQLException
	 {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 Booking b = new Booking();
		 System.out.println("enter booking id");
		 b.setBookingId(sc.nextInt());
		 System.out.println("enter customer id");
		 b.setCustomerId(sc.nextInt());
		 System.out.println("enter booking date");
		 Date dt1 = sdf.parse(sc.next());
		 java.sql.Date sqlDate1 = new java.sql.Date(dt1.getTime());
	     b.setBookingdate(sqlDate1);
	     System.out.println("enter journey id");
	     b.setJourneyId(sc.nextInt());
	     System.out.println("enter start date");
	     Date dt2 = sdf.parse(sc.next());
		 java.sql.Date sqlDate2 = new java.sql.Date(dt1.getTime());
	     b.setStartdate(sqlDate2);
	     System.out.println("enter end date");
	     Date dt3 = sdf.parse(sc.next());
		 java.sql.Date sqlDate3 = new java.sql.Date(dt1.getTime());
	     b.setEnddate(sqlDate3);
	     System.out.println("enter noofdays");
	     b.setNoofdays(sc.nextInt());
	     System.out.println("enter advance amount");
	     b.setAdvanceamount(sc.nextInt());
	     System.out.println(transportdao.addBooking(b));
		 
	 }
	 
	 public static void showbookingbyid() throws ClassNotFoundException, SQLException
	 {
		 int id;
		 System.out.println("enter the id");
		 id = sc.nextInt();
		 Booking b = transportdao.showbookingbyid(id);
		 if(b!=null)
		 {
			 System.out.println(b);
		 }
		 else
		 {
			 System.out.println("no recored");
		 }
	 }
	
	 
	 public static void canclebooking() throws ClassNotFoundException, SQLException
	 {
		 int id;
		 System.out.println("enter booking id");
		 id = sc.nextInt();
		 System.out.println(transportdao.cancelbooking(id));
	 }
	 
	 public static void addpayment() throws ClassNotFoundException, SQLException
	 {
		 Payment p = new Payment();
		 System.out.println("enter paymnet id");
		 p.setPaymentid(sc.nextInt());
		 System.out.println("enter booking id");
		 p.setBookingid(sc.nextInt());
		 System.out.println("enter final amount");
		 p.setFinalamount(sc.nextInt());
		 System.out.println(transportdao.addpayment(p));
	 }  
	 
	 public static void clearpayment() throws ClassNotFoundException, SQLException
	 {
		 List<Payment> list = transportdao.clearpayment();
	 }
	public static void main(String[] args) {
		int ch;
		do {
			System.out.println("1. Show admin");
			System.out.println("2. Search admin ");
			System.out.println("3. add admin");
			System.out.println("4. add vehicle");
			System.out.println("5. show vehicles");
			System.out.println("6. search vehicle by type");
			System.out.println("7. add Journey");
			System.out.println("8. update Journey");
			System.out.println("9. cancel Journey");
			System.out.println("10. add customer");
			System.out.println("11. add booking");
			System.out.println("12. searh booking by id");
			System.out.println("13. add payment");
			System.out.println("14. clear payment");
			System.out.println("15. cancle booking");
			System.out.println("Enter Your Choice  ");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				try 
				{
				adminshow();
				}
				catch (ClassNotFoundException | SQLException e) 
				{
					e.printStackTrace();
				}
				break;
			case 2:
				try 
				{
				adminsearch();
				}
				catch (ClassNotFoundException | SQLException e) 
				{
					e.printStackTrace();
				}
				break;
			case 3:
				try
				{
					addadmin();
				} catch (ParseException e) 
				{
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					addVehicle();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					showvehicles();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 6:
				try {
					searchVehicleByType();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 7:
				try {
					addJourney();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 8:
				try {
					updatejourney();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 9:
				try {
					deletejourney();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 10:
				try {
					addcustomer();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 11:
				try {
					addbooking();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 12:
				try {
					showbookingbyid();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 13:
				try {
					addpayment();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 14:
				try { 
					clearpayment();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break; 
			case 15:
				try {
					canclebooking();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
		while(ch!= 16);
	}

}

