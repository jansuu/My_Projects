package com.java.transport;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Timestamp;

import org.junit.Test;

import com.java.transport.model.Admin;
import com.java.transport.model.Booking;
import com.java.transport.model.Customer;
import com.java.transport.model.Gender;
import com.java.transport.model.Journey;
import com.java.transport.model.Payment;
import com.java.transport.model.Vehicle;

public class MainTest {
	
	
	@Test
	public void testtostring1() throws ParseException
	{
		Admin admin1 = new Admin(1, "jay", Date.valueOf("2004-06-09") , Date.valueOf("2024-10-09"), "9876543210", "jay123", "jay@123", "jay@gmail.com", Gender.MALE);
		String result = "Admin [adminid=1, name=jay, dob=2004-06-09, doj=2024-10-09, mobile=9876543210, username=jay123, password=jay@123, email=jay@gmail.com, gender=MALE]";
		assertEquals(result,admin1.toString());
		 
	}
	@Test
	public void testgettersandsetters1()
	{
		Admin admin = new Admin();
		admin.setAdminid(1);
		admin.setName("jay");
		admin.setMobile("9876543210");
		admin.setUsername("jay123");
		admin.setPassword("jay@123");
		admin.setEmail("jay@gmail.com");
		admin.setGender(Gender.MALE);
		admin.setDob(Date.valueOf("2004-06-09")); 
		admin.setDoj(Date.valueOf("2024-10-09")); 
	    
	    assertEquals(1,admin.getAdminid());
	    assertEquals("jay", admin.getName());
	    assertEquals("9876543210", admin.getMobile()); 
	    assertEquals("jay123", admin.getUsername());
	    assertEquals("jay@123", admin.getPassword()); 
	    assertEquals("jay@gmail.com", admin.getEmail());
	    assertEquals(Gender.MALE, admin.getGender());
	    assertEquals(Date.valueOf("2004-06-09"), admin.getDob());
	    assertEquals(Date.valueOf("2024-10-09"), admin.getDoj());
	    
	}
 
	@Test
	public void testconstructor1(){
		Admin admin = new Admin();
		assertNotNull(admin);
		Date dt = Date.valueOf("2024-10-09");
		Date dt1 = Date.valueOf("2004-06-09");
		Admin admin1 = new Admin(1, "jay", dt1 , dt, "9876543210", "jay123", "jay@123", "jay@gmail.com", Gender.MALE);
		assertEquals(1, admin1.getAdminid());
		assertEquals("jay", admin1.getName());
		assertEquals("9876543210", admin1.getMobile()); 
		assertEquals("jay123", admin1.getUsername());
		assertEquals("jay@123", admin1.getPassword()); 
		assertEquals("jay@gmail.com", admin1.getEmail());
		assertEquals(Gender.MALE, admin1.getGender());
		assertEquals(Date.valueOf("2004-06-09"), admin.getDob());
		assertEquals(Date.valueOf("2024-10-09"), admin.getDoj());
		
	}
	
	@Test
	public void testToString2()
	{
		Vehicle vc1 = new Vehicle(1, 202, "bus", "a1", 25, "available", 15, 1);
		String res ="Vehicle [vehicleId=1, registrationno=202, vehicletype=bus, vehiclename=a1, capacity=25, status=available, quantity=15, adminId=1]";
		assertEquals(res, vc1.toString());
	}
	@Test
	public void testgettersandsetters2()
	{
		 Vehicle vc = new Vehicle();
			vc.setVehicleId(1);
			vc.setRegistrationno(202);
			vc.setVehicletype("bus");
			vc.setVehiclename("a1");
			vc.setCapacity(25);
			vc.setStatus("available");
			vc.setQuantity(15);
			vc.setAdminId(1);
			
			assertEquals(1, vc.getVehicleId());
			assertEquals(202, vc.getRegistrationno());
			assertEquals("bus", vc.getVehicletype());
			assertEquals("a1", vc.getVehiclename());
			assertEquals(25, vc.getCapacity());
			assertEquals("available", vc.getStatus());
			assertEquals(15, vc.getQuantity());
			assertEquals(1, vc.getAdminId());
	}
	@Test
	public void testConstructor1()
	{
		Vehicle vc = new Vehicle();
		assertNotNull(vc);
		Vehicle vc1 = new Vehicle(1, 202, "bus", "a1", 25, "available", 15, 1);
		assertEquals(1, vc1.getVehicleId());
		assertEquals(202, vc1.getRegistrationno());
		assertEquals("bus", vc1.getVehicletype()); 
		assertEquals("a1", vc1.getVehiclename());
		assertEquals(25, vc1.getCapacity());
		assertEquals("available", vc1.getStatus());
		assertEquals(15, vc1.getQuantity());
		assertEquals(1, vc1.getAdminId());
	}
	
	@Test
	public void testToString3()
	{
		Booking bk = new Booking(1, 2, 2, Date.valueOf("2024-11-24"), null, null, 3, 100);
		String res ="Booking [bookingId=1, customerId=2, journeyId=2, bookingdate=2024-11-24, startdate=null, enddate=null, noofdays=3, advanceamount=100]";
		assertEquals(res, bk.toString());
	}
	@Test
	public void testgettersandsetters3()
	{
		Booking bk = new Booking();
		bk.setBookingId(1);
		bk.setCustomerId(2);
		bk.setJourneyId(2);
		bk.setBookingdate(Date.valueOf("2024-11-24"));
		bk.setStartdate(null);
		bk.setEnddate(null);
		bk.setNoofdays(3);
		bk.setAdvanceamount(100);
		
		assertEquals(1, bk.getBookingId());
		assertEquals(2, bk.getCustomerId());
		assertEquals(2, bk.getJourneyId());
		assertEquals(Date.valueOf("2024-11-24"), bk.getBookingdate());
		assertEquals(null, bk.getStartdate());
		assertEquals(null, bk.getEnddate());
		assertEquals(3, bk.getNoofdays());
		assertEquals(100, bk.getAdvanceamount());
	}
	@Test
	public void testConstructor3() 
	{
		Booking bk1 = new Booking();
		assertNotNull(bk1);
		Date paymentDate = Date.valueOf("2024-11-24");
		
		Booking bk = new Booking(1, 2, 2, paymentDate, null, null, 3, 100);
		assertEquals(1, bk.getBookingId());
		assertEquals(2, bk.getCustomerId());
		assertEquals(2, bk.getJourneyId());
		assertEquals(Date.valueOf("2024-11-24"), bk.getBookingdate());
		assertEquals(null, bk.getStartdate());
		assertEquals(null, bk.getEnddate());
		assertEquals(3, bk.getNoofdays());
		assertEquals(100, bk.getAdvanceamount());
	}
	
	@Test
	public void testToString4()
	{
		Customer cs = new Customer(1, "John Doe", 30, "1234567890", "johndoe@example.com");
		String result = "Customer [customerId=1, customername=John Doe, age=30, mobile=1234567890, email=johndoe@example.com]";
	    assertEquals(result, cs.toString());
	}
	@Test
	public void testGettersAndSetters4()
	{
		Customer cs = new Customer();
		cs.setCustomerId(1);
		cs.setCustomername("John Doe");
		cs.setAge(30);
		cs.setMobile("1234567890");
		cs.setEmail("johndoe@example.com");
		
		assertEquals(1, cs.getCustomerId());
		assertEquals("John Doe", cs.getCustomername()); 
		assertEquals(30, cs.getAge());
		assertEquals("1234567890", cs.getMobile());
		assertEquals("johndoe@example.com", cs.getEmail()); 
	}
	@Test
	public void testConstructor4()
	{
		Customer cs1 = new Customer();
		assertNotNull(cs1);
		Customer cs = new Customer(1, "John Doe", 30, "1234567890", "johndoe@example.com");
		assertEquals(1, cs.getCustomerId());
		assertEquals("John Doe", cs.getCustomername());
		assertEquals(30, cs.getAge());
		assertEquals("1234567890", cs.getMobile());
		assertEquals("johndoe@example.com", cs.getEmail());
	}
	
	@Test
	public void testToString5()
	{
		Journey jk = new Journey(1, 1, 204, "Chennai", "Coimbatore", Timestamp.valueOf("2024-11-20 08:00:00"), Timestamp.valueOf("2024-11-20 18:00:00"), "DAILY", 1, 150);
		String result = "Journey [journeyId=1, vehicleId=1, registrationno=204, startstation=Chennai, endstation=Coimbatore, starttime=2024-11-20 08:00:00.0, depaturetime=2024-11-20 18:00:00.0, type=DAILY, adminId=1, price=150]";
		assertEquals(result, jk.toString());
	}
	@Test
	public void testGettersAndSetters5()
	{
		Journey jk = new Journey();
		jk.setJourneyId(1);
		jk.setVehicleId(1);
		jk.setRegistrationno(204);
		jk.setStartstation("Chennai");
		jk.setEndstation("Coimbatore");
		jk.setStarttime(Timestamp.valueOf("2024-11-20 08:00:00"));
		jk.setDepaturetime(Timestamp.valueOf("2024-11-20 18:00:00"));
		jk.setType("DAILY");
		jk.setAdminId(1);
		jk.setPrice(150);
		
		assertEquals(1, jk.getJourneyId());
		assertEquals(1, jk.getVehicleId());
		assertEquals(204, jk.getRegistrationno());
		assertEquals("Chennai", jk.getStartstation());
		assertEquals("Coimbatore", jk.getEndstation());
		assertEquals(Timestamp.valueOf("2024-11-20 08:00:00"), jk.getStarttime());
		assertEquals(Timestamp.valueOf("2024-11-20 18:00:00"), jk.getDepaturetime());
		assertEquals("DAILY", jk.getType());
		assertEquals(1, jk.getAdminId());
		assertEquals(150, jk.getPrice());
	}
	@Test
	public void testConstructor5()
	{
		Journey jk1 = new Journey(); 
		assertNotNull(jk1);
		Journey jk = new Journey(1, 1, 204, "Chennai", "Coimbatore", Timestamp.valueOf("2024-11-20 08:00:00"), Timestamp.valueOf("2024-11-20 18:00:00"), "DAILY", 1, 150);
		assertEquals(1, jk.getJourneyId());
		assertEquals(1, jk.getVehicleId());
		assertEquals(204, jk.getRegistrationno());
		assertEquals("Chennai", jk.getStartstation());
		assertEquals("Coimbatore", jk.getEndstation());
		assertEquals(Timestamp.valueOf("2024-11-20 08:00:00"), jk.getStarttime());
		assertEquals(Timestamp.valueOf("2024-11-20 18:00:00"), jk.getDepaturetime());
		assertEquals("DAILY", jk.getType());
		assertEquals(1, jk.getAdminId());
		assertEquals(150, jk.getPrice());
	}
	
	@Test 
	public void testToString6()
	{
		Payment pk = new Payment(1, 1, 20);
		String result = "Payment [paymentid=1, bookingid=1, finalamount=20]";
		assertEquals(result, pk.toString());
	} 
	@Test
	public void testGettersAndSetters6()
	{
		Payment pk = new Payment();
		pk.setPaymentid(1);
		pk.setBookingid(1);
		pk.setFinalamount(20); 
		
		assertEquals(1, pk.getPaymentid());
		assertEquals(1, pk.getBookingid());
		assertEquals(20, pk.getFinalamount());
	}
	@Test
	public void testConstructor6()
	{
		Payment pk1 = new Payment();
		assertNotNull(pk1);
		Payment pk = new Payment(1, 1, 20);
		assertEquals(1, pk.getPaymentid());
		assertEquals(1, pk.getBookingid());
		assertEquals(20, pk.getFinalamount());
	}

}
