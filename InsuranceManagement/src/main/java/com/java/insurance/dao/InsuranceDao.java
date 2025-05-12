package com.java.insurance.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.insurance.model.Claim;
import com.java.insurance.model.Client;
import com.java.insurance.model.Payment;
import com.java.insurance.model.User;

public interface InsuranceDao {
	
	String adduser(User user) throws ClassNotFoundException, SQLException;
	User loginuser(String username,String password) throws ClassNotFoundException, SQLException;
	String addclient(Client client) throws ClassNotFoundException, SQLException;
	Client showclient(int clientid) throws ClassNotFoundException, SQLException;
	String addclaim(Claim claim) throws ClassNotFoundException, SQLException;
	Claim searchclaim(String policy,int clientid) throws ClassNotFoundException, SQLException;
	Payment showpayment(int clientid) throws ClassNotFoundException, SQLException;
	public List<Payment> showPendingPayments() throws ClassNotFoundException, SQLException;

}
