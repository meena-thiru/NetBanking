package com.management;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Account;

import com.model.Transactions;
import java.util.List;
import java.util.ArrayList;

 

public class TransactionManagement {
	public  int insertTransactionsList(Transactions tobj ) {
		int count=0;
		try {
			Connection con=DBConnectionManager.getConnection();
			String data="Insert into transaction values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(data);
			
			Account receiver=tobj.getReceiver();
			Account sender=tobj.getSender();
			 ps.setString(1, tobj.getTransactionId());
		     ps.setString(2, receiver.getCustomerId());
		     ps.setString(3,receiver.getCustomerName());
	  		 ps.setLong(4,receiver.getContactNumber());
	  		 ps.setLong(5, receiver.getAccountNumber());
	  		 ps.setString(6,receiver.getAccountType());
	  	     ps.setString(7, receiver.getBankName());
	  		 ps.setString(8, sender.getCustomerName());
	  		 ps.setLong(9, sender.getAccountNumber());
	  		 ps.setString(10, sender.getBankName());
	  		 ps.setLong(11, sender.getContactNumber());
	  		 ps.setString(12, tobj.getTransactionType());
	  		 ps.setDouble(13, tobj.getAmount());
	  		 ps.setDouble(14, tobj.getCurrentBalance());
	  		 
//	  		 ApplicationUtil au=new ApplicationUtil();
	  		 ps.setString(15, tobj.getTransactionDate());
	  		 ps.setString(16, tobj.getStatus());
	  		 count=ps.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
  	  }
	  
		return count;

	}

	public Transactions retrieveTransactionsList(String transactionId){
		Transactions t=null;
		try {
			Connection conn=DBConnectionManager.getConnection();
			String query = "Select * from transaction WHERE Transaction_id = ?";
            PreparedStatement pmst = conn.prepareStatement(query);
            pmst.setString(1, transactionId);
            ResultSet rs = pmst.executeQuery();
			while(rs.next()){
				String id=rs.getString(1);
				String cust_id=rs.getString(2);
				String cust_name=rs.getString(3);
				long cust_num=rs.getLong(4);
				long account_no=rs.getLong(5);
				String ac_type=rs.getString(6);
				String bankName=rs.getString(7);
				String sender_name=rs.getString(8);
				long sender_accNo=rs.getLong(9);
				String sender_bankName=rs.getString(10);
				long sender_contact=rs.getLong(11);
				String trans_type=rs.getString(12);
				double amount=rs.getDouble(13);
				double current_balance=rs.getDouble(14); 
				
	//			ApplicationUtil au=new ApplicationUtil();
	//			String d1=au.convertStringDate(rs.getDate(15));
	//			java.util.Date date=au.convertUtilDate(d1);
				String date=rs.getString(15);
				String status=rs.getString(16);
				
	
				
				t=new Transactions(id,cust_id,cust_name,cust_num,account_no,ac_type,bankName,sender_name,sender_accNo,sender_bankName,sender_contact,trans_type,amount,current_balance,date,status); 
				
			}
		}
		catch (SQLException e) {
	            System.out.println(e.getMessage());
	     }
	        return t;

	}
	
	
	public List<Transactions> retrieveTransactionsUsingAccount(long number){
		Transactions t=null;
		List<Transactions> list=new ArrayList<Transactions>();
		try {
			Connection conn=DBConnectionManager.getConnection();
			String query = "Select * from transaction WHERE sender_account_number = ?";
            PreparedStatement pmst = conn.prepareStatement(query);
            pmst.setLong(1, number);
            ResultSet rs = pmst.executeQuery();
			while(rs.next()){
				String id=rs.getString(1);
				String cust_id=rs.getString(2);
				String cust_name=rs.getString(3);
				long cust_num=rs.getLong(4);
				long account_no=rs.getLong(5);
				String ac_type=rs.getString(6);
				String bankName=rs.getString(7);
				String sender_name=rs.getString(8);
				long sender_accNo=rs.getLong(9);
				String sender_bankName=rs.getString(10);
				long sender_contact=rs.getLong(11);
				String trans_type=rs.getString(12);
				double amount=rs.getDouble(13);
				double current_balance=rs.getDouble(14); 
				
	//			ApplicationUtil au=new ApplicationUtil();
	//			String d1=au.convertStringDate(rs.getDate(15));
	//			java.util.Date date=au.convertUtilDate(d1);
				String date=rs.getString(15);
				String status=rs.getString(16);
				
	
				
				t=new Transactions(id,cust_id,cust_name,cust_num,account_no,ac_type,bankName,sender_name,sender_accNo,sender_bankName,sender_contact,trans_type,amount,current_balance,date,status); 
				list.add(t);
			}
		}
		catch (SQLException e) {
	            System.out.println(e.getMessage());
	     }
	        return list;

	}
	
	
	public Transactions retrieveTransactionsListForReceipt(long number){
		Transactions t=null;
		try {
			Connection conn=DBConnectionManager.getConnection();
			String query = "Select * from transaction WHERE sender_account_number= ?";
            PreparedStatement pmst = conn.prepareStatement(query);
            pmst.setLong(1, number);
            ResultSet rs = pmst.executeQuery();
			while(rs.next()){
				String id=rs.getString(1);
				String cust_id=rs.getString(2);
				String cust_name=rs.getString(3);
				long cust_num=rs.getLong(4);
				long account_no=rs.getLong(5);
				String ac_type=rs.getString(6);
				String bankName=rs.getString(7);
				String sender_name=rs.getString(8);
				long sender_accNo=rs.getLong(9);
				String sender_bankName=rs.getString(10);
				long sender_contact=rs.getLong(11);
				String trans_type=rs.getString(12);
				double amount=rs.getDouble(13);
				double current_balance=rs.getDouble(14); 
				
	//			ApplicationUtil au=new ApplicationUtil();
	//			String d1=au.convertStringDate(rs.getDate(15));
	//			java.util.Date date=au.convertUtilDate(d1);
				String date=rs.getString(15);
				String status=rs.getString(16);
				
	
				
				t=new Transactions(id,cust_id,cust_name,cust_num,account_no,ac_type,bankName,sender_name,sender_accNo,sender_bankName,sender_contact,trans_type,amount,current_balance,date,status); 
				
			}
		}
		catch (SQLException e) {
	            System.out.println(e.getMessage());
	     }
	        return t;

	}
	
	
	public boolean checkIdExists(String transactionId) {
        boolean b = false;
        try {
            Connection con = DBConnectionManager.getConnection();
            String query = "Select * from transaction WHERE ID = ?";
            PreparedStatement pmst = con.prepareStatement(query);
            pmst.setString(1, transactionId);
            ResultSet rs = pmst.executeQuery();
            b = rs.next(); 
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return b;
    }
	public void debitAmount(Account sender,double amount) {
		  long accNo=sender.getAccountNumber();
		   try {
			Connection conn=DBConnectionManager.getConnection();
			String query="update account set BALANCE = BALANCE - ? where ACCOUNT_NUMBER=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setDouble(1,amount);
			ps.setLong(2, accNo);
			int status=ps.executeUpdate();
			status=status+0;
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
   }
	public void creditAmount(Account receiver,double amount) {
		
		  long accNo=receiver.getAccountNumber();
		  try {
			Connection conn=DBConnectionManager.getConnection();
			String query="update account set BALANCE = BALANCE + ? where ACCOUNT_NUMBER=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setDouble(1,amount);
			ps.setLong(2, accNo);
			int status=ps.executeUpdate();
			status=status+0;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
			
	}
}