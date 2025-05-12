package com.java.insurance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import com.java.insurance.model.Claim;
import com.java.insurance.model.Client;
import com.java.insurance.model.Payment;
import com.java.insurance.model.Status;
import com.java.insurance.model.User;
import com.java.insurance.util.ConnectionHelper;



public class InsuranceDaoImpl implements InsuranceDao {
	
	Connection connection;
	PreparedStatement pst;
	
	@Override
	public String adduser(User user) throws ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into user(userid,username,password,role)"
				+ "values(?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, user.getUserid());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getPassword());
		pst.setString(4, user.getRole());
		pst.executeUpdate();
		return "added";
	}

	@Override
	public User loginuser(String username, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		User user = null;
		connection = ConnectionHelper.getConnection();
		String cmd = "select count(*) as cnt from user where username = ? and password = ? group by username;";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, username);
		pst.setString(2, password);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) 
		{
		  user = new User();
		}
		return user;
	}

	@Override
	public String addclient(Client client) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into client(clientid,clientname,contactinfo,policy)"
				+ "values(?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, client.getClientid());
		pst.setString(2, client.getClientname());
		pst.setString(3, client.getContactinfo());
		pst.setString(4, client.getPolicy());
		pst.executeUpdate();
		return "added";
	}

	@Override
	public Client showclient(int clientid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Client client = null;
		connection = ConnectionHelper.getConnection();
		String cmd = "select*from client where clientid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, clientid);
		ResultSet rs = pst.executeQuery();
		if(rs.next())
		{
			client = new Client();
			client.setClientid(rs.getInt("clientid"));
			client.setClientname(rs.getString("clientname"));
			client.setContactinfo(rs.getString("contactinfo"));
			client.setPolicy(rs.getString("policy"));
		}
		return client;
	}

	@Override
	public String addclaim(Claim claim) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into claim(claimid,claimnumber,datefiled,claimamount,status,policy,clientid)"
				+ "values(?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, claim.getClaimid());   
		pst.setInt(2, claim.getClaimnumber());
		pst.setDate(3, claim.getDatefiled());
		pst.setInt(4, claim.getClaimamount());
		pst.setString(5,claim.getStatus().toString());
		pst.setString(6, claim.getPolicy());
		pst.setInt(7, claim.getClientid());
		pst.executeUpdate();
		return "added";
	}

	@Override
	public Claim searchclaim(String policy, int clientid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Claim claim = null;
		connection = ConnectionHelper.getConnection();
		String cmd = "select*from claim where policy=? and clientid=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, policy);
		pst.setInt(2, clientid);
		ResultSet rs = pst.executeQuery();
		if(rs.next())
		{
			claim = new Claim();
			claim.setClaimid(rs.getInt("claimid"));
			claim.setClaimnumber(rs.getInt("claimnumber"));
			claim.setDatefiled(rs.getDate("datefiled"));
			claim.setClaimamount(rs.getInt("claimamount"));
			claim.setStatus(Status.valueOf(rs.getString("status")));
			claim.setPolicy(rs.getString("policy"));
			claim.setClientid(rs.getInt("clientid"));
		}
		return claim;
	}

	@Override
	public Payment showpayment(int clientid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Payment payment = null;
		connection = ConnectionHelper.getConnection();
		String cmd = "select*from payment where clientid =?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, clientid);
		ResultSet rs = pst.executeQuery();
		if(rs.next())
		{
			payment = new Payment();
			payment.setPaymentid(rs.getInt("paymentid"));
			payment.setPaymentdate(rs.getDate("paymentdate"));
			payment.setPaymentamount(rs.getInt("paymentamount"));
			payment.setClientid(rs.getInt("clientid"));
		}
		return payment;
	} 

	@Override
	public List<Payment> showPendingPayments() throws ClassNotFoundException, SQLException {
	    List<Payment> pendingPayments = new ArrayList<>();
            connection = ConnectionHelper.getConnection();

            String cmd = "SELECT p.paymentid, p.paymentdate, p.clientid, p.paymentamount, " +
                         "c.claimamount, (c.claimamount - p.paymentamount) AS pending " +
                         "FROM payment p JOIN claim c ON p.clientid = c.clientid " +
                         "WHERE (c.claimamount - p.paymentamount) > 0";

            pst = connection.prepareStatement(cmd);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) 
            {
                Payment payment = new Payment();
                payment.setPaymentid(rs.getInt("paymentid"));
                payment.setPaymentdate(rs.getDate("paymentdate"));
                payment.setPaymentamount(rs.getInt("paymentamount"));
                payment.setClientid(rs.getInt("clientid"));
                double pending = rs.getDouble("pending");
                System.out.println("Pending amount for Payment ID " + rs.getInt("paymentid") + " : " + pending);
                pendingPayments.add(payment);
            }
       
        return pendingPayments;
    }

}
