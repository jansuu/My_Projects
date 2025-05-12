package com.java.insurance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.Test;

import com.java.insurance.model.Claim;
import com.java.insurance.model.Client;
import com.java.insurance.model.Payment;
import com.java.insurance.model.Status;
import com.java.insurance.model.User;

public class Testing {
		
		@Test
		public void testToString1() {
		
			Claim claim1 =  new Claim(1, 202,Date.valueOf("2003-10-12") , 500000, Status.approved, "health", 1);
			
			String result = "Claim [claimid=1, claimnumber=202, datefiled=2003-10-12, claimamount=500000, status=approved, policy=health, clientid=1]";
			assertEquals(result,claim1.toString());
		} 
		
		@Test  
		public void testgettersandsetters1() {
			Claim claim = new Claim();
			claim.setClaimamount(1);
			claim.setClaimid(202);
			claim.setDatefiled(Date.valueOf("2003-10-12"));
			claim.setClaimnumber(500000);
			claim.setStatus(Status.approved);
			claim.setPolicy("health");
			claim.setClientid(1);
			
			
			assertEquals(1, claim.getClaimamount());
			assertEquals(202, claim.getClaimid());
			assertEquals(Date.valueOf("2003-10-12"),claim.getDatefiled());
			assertEquals(500000,claim.getClaimnumber());
			assertEquals(Status.approved,claim.getStatus());
			assertEquals("health",claim.getPolicy());
			assertEquals(1,claim.getClientid());
			
		}
		
		


		@Test
		public void testConstructor1() {
			Claim claim= new Claim();
			assertNotNull(claim);
			String s1= "2003-10-12";
			Date dt=Date.valueOf(s1);
			Claim claim1 =  new Claim(1, 202, dt, 500000, Status.approved, "health", 1);
			assertEquals(1,claim1.getClaimamount());
			assertEquals(202,claim1.getClaimid());
			assertEquals(Date.valueOf("2003-10-12"),claim1.getDatefiled());
			assertEquals(500000,claim1.getClaimnumber());
			assertEquals(Status.approved, claim.getStatus());
			assertEquals("health", claim1.getPolicy());
			assertEquals(1, claim1.getClientid());
		}
	
	 @Test
	    public void testEnumValues() {
	       
	        Status[] statuses = Status.values();
	        assertEquals(4, statuses.length);
	        assertEquals(Status.approved, statuses[0]);
	        assertEquals(Status.processing, statuses[1]);
	        assertEquals(Status.declined, statuses[2]);
	    }
	 
	 @Test
	    public void testEnumValueOf() {
	        
	        assertEquals(Status.approved, Status.valueOf("approved"));
	        assertEquals(Status.processing, Status.valueOf("processing"));
	        assertEquals(Status.declined, Status.valueOf("declined"));
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testInvalidEnumValue() {
	        
	        Status.valueOf("invalidStatus");
	    }

	    @Test
	    public void testEnumToString() {
	       
	        assertEquals("approved", Status.approved.toString());
	        assertEquals("processing", Status.processing.toString());
	        assertEquals("declined", Status.declined.toString());
	    }
	    
	    @Test
	    public void testToString2() {
	        Client client1 = new Client(1, "John", "9234567890", "Health");

	        String result = "Client [clientid=1, clientname=John, contactinfo=9234567890, policy=Health]";
	        assertEquals(result, client1.toString());
	    }

	    @Test
	    public void testGettersAndSetters2() {
	        Client client = new Client();
	        client.setClientid(1);
	        client.setClientname("John");
	        client.setContactinfo("9234567890");
	        client.setPolicy("Health Policy");

	        assertEquals(1, client.getClientid());
	        assertEquals("John", client.getClientname());
	        assertEquals("9234567890", client.getContactinfo());
	        assertEquals("Health", client.getPolicy());
	    }

	    @Test
	    public void testConstructor2() {
	        Client client = new Client();
	        assertNotNull(client);

	        Client client1 = new Client(1, "John", "9234567890", "Health");

	        assertEquals(1, client1.getClientid());
	        assertEquals("John", client1.getClientname());
	        assertEquals("9234567890", client1.getContactinfo());
	        assertEquals("Health", client1.getPolicy());
	    }
	    
	    @Test
	    public void testToString3() {
	        Payment payment1 = new Payment(1, Date.valueOf("2023-11-22"), 10000, 1);

	        String result = "Payment [paymentid=1, paymentdate=2023-11-22, paymentamount=10000, clientidl=1]";
	        assertEquals(result, payment1.toString());
	    }

	    @Test
	    public void testGettersAndSetters3() {
	        Payment payment = new Payment();
	        payment.setPaymentid(1);
	        payment.setPaymentdate(Date.valueOf("2023-11-22"));
	        payment.setPaymentamount(10000);
	        payment.setClientid(1);

	        assertEquals(1, payment.getPaymentid());
	        assertEquals(Date.valueOf("2023-11-22"), payment.getPaymentdate());
	        assertEquals(10000, payment.getPaymentamount());
	        assertEquals(101, payment.getClientid());
	    }

	    @Test
	    public void testConstructor3() {
	        Payment payment = new Payment();
	        assertNotNull(payment);

	        Date paymentDate = Date.valueOf("2023-11-22");
	        Payment payment1 = new Payment(1, paymentDate, 10000, 1);

	        assertEquals(1, payment1.getPaymentid());
	        assertEquals(Date.valueOf("2023-11-22"), payment1.getPaymentdate());
	        assertEquals(10000, payment1.getPaymentamount());
	        assertEquals(1, payment1.getClientid());
	    }
	    
	    @Test
	    public void testToString4() {
	        User user1 = new User(1, "john_doe", "password123", "manager");

	        String result = "User [userid=1, username=john_doe, password=password123, role=manager]";
	        assertEquals(result, user1.toString());
	    }

	    @Test
	    public void testGettersAndSetters4() {
	        User user = new User();
	        user.setUserid(1);
	        user.setUsername("john_doe");
	        user.setPassword("password123");
	        user.setRole("manager");

	        assertEquals(1, user.getUserid()); 
	        assertEquals("john_doe", user.getUsername());
	        assertEquals("password123", user.getPassword());
	        assertEquals("manager", user.getRole());
	    }
 
	    @Test
	    public void testConstructor4() {
	        User user = new User();
	        assertNotNull(user);

	        User user1 = new User(1, "john_doe", "password123", "manager");

	        assertEquals(1, user1.getUserid());
	        assertEquals("john_doe", user1.getUsername());
	        assertEquals("password123", user1.getPassword());
	        assertEquals("manager", user1.getRole());
	    }

}
