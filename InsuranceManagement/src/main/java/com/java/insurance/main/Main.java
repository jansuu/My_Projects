package com.java.insurance.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.java.insurance.dao.InsuranceDao;
import com.java.insurance.dao.InsuranceDaoImpl;
import com.java.insurance.model.Claim;
import com.java.insurance.model.Client;
import com.java.insurance.model.Payment;
import com.java.insurance.model.Status;
import com.java.insurance.model.User;

public class Main {
	
	static Scanner s = new Scanner(System.in);
	
	static InsuranceDao insurancedao = new InsuranceDaoImpl();
	
	public static void adduser() throws ClassNotFoundException, SQLException
	{
		User user = new User();
		System.out.println("enter userid");
		user.setUserid(s.nextInt());
		System.out.println("enter username");
		user.setUsername(s.next());
		System.out.println("enter password");
		user.setPassword(s.next());
		System.out.println("enter role");
		user.setRole(s.next());
		System.out.println(insurancedao.adduser(user));
	} 
	
	public static void addclient() throws ClassNotFoundException, SQLException
	{
		Client client = new Client();
		System.out.println("enter clientid");
		client.setClientid(s.nextInt());
		System.out.println("enter clientname");
		client.setClientname(s.next());
		System.out.println("enter contactinfo");
		client.setContactinfo(s.next());
		System.out.println("enter policy");
		client.setPolicy(s.next());
		System.out.println(insurancedao.addclient(client));
	} 
	
	public static void loginuser() throws ClassNotFoundException, SQLException
	{
		String username,password;
		System.out.println("enter username");
		username = s.next();
		System.out.println("enter password");
		password = s.next();
		User user = insurancedao.loginuser(username, password);
		if(user!= null)
		{
			System.out.println("it is correct record");
		}
		else
		{
			System.out.println("wrong record");
		}
	}
	
	public static void showclient() throws ClassNotFoundException, SQLException {
		int id;
		System.out.println("enter id");
		id=s.nextInt();
		Client client = insurancedao.showclient(id);
		if(client!=null)
		{
			System.out.println(client);
		}
		else
		{
			System.out.println("no record with id"+id);
		}
	}
	
	public static void addclaim() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Claim claim = new Claim();
		System.out.println("enter claimid");
		claim.setClaimid(s.nextInt());
		System.out.println("enter claimnumber");
		claim.setClaimnumber(s.nextInt());
		System.out.println("enter datefiled");
		Date dt1 = sdf.parse(s.next());
		java.sql.Date sqlDate1 = new java.sql.Date(dt1.getTime());
		claim.setDatefiled(sqlDate1);
		System.out.println("enter claimamount");
		claim.setClaimamount(s.nextInt());
		System.out.println("enter status");
		claim.setStatus(Status.valueOf(s.next()));
		System.out.println("enter policy");
		claim.setPolicy(s.next());
		System.out.println("enter clientid");
		claim.setClientid(s.nextInt());
		
		try {
			System.out.println(insurancedao.addclaim(claim));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void searchclaim() throws ClassNotFoundException, SQLException
	{
	String policy;
	int clientid;
	System.out.println("enter policy");
	policy = s.next();
	System.out.println("enter clientid");
	clientid = s.nextInt();
	Claim claim = insurancedao.searchclaim(policy, clientid);
	if(claim!=null)
	{
		System.out.println(claim);
	}
	else
	{
		System.out.println("not found");
	}
	}
	
	public static void showpayment() throws ClassNotFoundException, SQLException
	{
		int id;
		System.out.println("enter client id");
		id=s.nextInt();
		Payment payment = insurancedao.showpayment(id);
		if(payment!=null)
		{
			System.out.println(payment);
		}
		else
		{
			System.out.println("not found");
		}
	}
	
	public static void showPendingPayments() throws ClassNotFoundException, SQLException
	{
		    List<Payment> pendingPayments = insurancedao.showPendingPayments();
		    System.out.println("Payments with Pending Amounts:");
	        for (Payment payment : pendingPayments) {
	            System.out.println("Payment ID: " + payment.getPaymentid());
	            System.out.println("Payment Date: " + payment.getPaymentdate());
	            System.out.println("Payment Amount: " + payment.getPaymentamount());
	            System.out.println("Client ID: " + payment.getClientid());
	            System.out.println("-----------------------------------");
	        }
		
	}
	
	
	public static void main(String[] args) throws ParseException, ClassNotFoundException 
	{
		int ch;
		do
		{
			System.out.println("1.add user");
			System.out.println("2.login user");
			System.out.println("3.add client");
			System.out.println("4.show client");
			System.out.println("5.add claim");
			System.out.println("6.search claim");
			System.out.println("7.show payment details");
			System.out.println("8.show pending payments");
			ch = s.nextInt();
			switch(ch)
			{
			case 1:
				try {
					adduser();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					loginuser();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					addclient();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					showclient();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					addclaim();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 6:
				try {
					searchclaim();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 7:
				try {
					showpayment();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 8:
				try {
					showPendingPayments();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			default:
				System.out.println("enter valid input");
				break;
			}
		}
		while(ch!=9);
	}

}
