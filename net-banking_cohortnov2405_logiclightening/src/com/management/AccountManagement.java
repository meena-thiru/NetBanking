////package com.management;
////import com.model.*;
//////import com.util.ApplicationUtil;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
////import java.util.*;
////import com.model.*;
////import com.management.*;
//public class AccountManagement {
//    
//	  public static int insertAccountList(List<Account> accounts) {
//	        int recordsAdded = 0;
//	        String query = "INSERT INTO accounts (account_number, bank_name, account_type, balance, branch, ifsc_code) VALUES (?, ?, ?, ?, ?, ?)";
//	        
//	        try (Connection conn = DBConnectionManager.getConnection();
//	             PreparedStatement stmt = conn.prepareStatement(query)) {
//	             
//	            for (Account account : accounts) {
//	                stmt.setLong(1, account.getAccount_number());
//	                stmt.setString(2, account.getBank_name());
//	                stmt.setString(3, account.getAccount_type());
//	                stmt.setDouble(4, account.getBalance());
//	                stmt.setString(5, account.getBranch());
//	                stmt.setString(6, account.getIFSC_code());
//	                recordsAdded += stmt.executeUpdate();
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	        return recordsAdded;
//	    }
//	
//	
//	
//	private static Connection getConnection() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//	public static boolean checkIdExists(String accountId) {
//	    String query = "SELECT COUNT(*) FROM accounts WHERE account_number = ?";
//	    try (Connection conn = DBConnectionManager.getConnection();
//	         PreparedStatement stmt = conn.prepareStatement(query)) {
//	             
//	        stmt.setString(1, accountId);
//	        try (ResultSet rs = stmt.executeQuery()) {
//	            if (rs.next()) {
//	                return rs.getInt(1) > 0;
//	            }
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    return false;
//	}
////	
////	
//	public static List<Account> retrieveAccountListForTransaction(String customer_id) {
//	    List<Account> accountList = new ArrayList<>();
//	    String query = "SELECT account_number, bank_name, account_type, balance, branch, ifsc_code FROM accounts WHERE customer_id = ? AND balance > 0";
//
//	    try (Connection conn = getConnection();
//	         PreparedStatement stmt = conn.prepareStatement(query)) {
//	             
//	        stmt.setString(1, customer_id);
//	        try (ResultSet rs = stmt.executeQuery()) {
//	            while (rs.next()) {
//	                Account account = new Account(rs.getString("account_number"),rs.getString("bank_name"),rs.getString("account_type"),rs.getDouble("balance"),rs.getString("branch"), rs.getString("ifsc_code"));
//	                accountList.add(account);
//	            }
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    return accountList;
//	}
////	
////
//	public static List<String> retrieveAccountNumberBasedOnAccountType(String account_type) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//		public static boolean deleteAccount(String customerId) {
//		    String query = "DELETE FROM accounts WHERE customer_id = ?";
//		    try (Connection conn = getConnection();
//		         PreparedStatement stmt = conn.prepareStatement(query)) {
//		             
//		        stmt.setString(1, customerId);
//		        
//		        int rowsAffected = stmt.executeUpdate();
//		        return rowsAffected > 0;
//		    } catch (SQLException e) {
//		        e.printStackTrace();
//		    }
//		    return false;
//		}
//		
//		
//
//
//
//
//	public static List<Account> retrieveAccountList(String customer_id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public static void addAccount(Account account) {
//		// TODO Auto-generated method stub
//		
//	}
//}


package com.management;
import com.model.*;
//import com.util.ApplicationUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import com.model.*;
import com.management.*;
public class AccountManagement 
{
	public boolean addAccountList(Account a)
	{
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=DBConnectionManager.getConnection();
			
			ps=con.prepareStatement("insert into account values(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			Profile p=a.getP();
			ps.setString(1,p.getCustomerId());
			ps.setString(2,p.getCustomerName());
			ps.setLong(3,p.getContactNumber());
			ps.setString(4,p.getEmailId());
			ps.setLong(5,a.getAccountNumber());
			ps.setString(6,a.getBankName());
			ps.setString(7,a.getAccountType());
			ps.setDouble(8,a.getBalance());
			ps.setString(9,a.getBranch());
			ps.setString(10,a.getIfscCode());
			ps.setString(11,a.getIdProofType());
			ps.setString(12,a.getIdProofNumber());
			
			int row=ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
		}
		catch(SQLException | NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try 
			{
				if(con!=null)
				{
					con.close();
				}
				if(ps!=null)
				{
					ps.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		return false;
	}
	
	
	public boolean checkIdExists(long number)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select * from account where account_number=?");
			
			ps.setLong(1, number);
			rs=ps.executeQuery();
			flag=rs.next();
			
		}
		catch(SQLException | NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try 
			{
				if(con!=null)
				{
					con.close();
				}
				if(ps!=null)
				{
					ps.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		return flag;
	}
	
	
	
	public Account retrieveAccountListForTransaction(long number)
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Account a=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select * from Account WHERE account_number=?");
			ps.setLong(1, number);
		
			rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				a=new Account(rs.getString(1),rs.getString(2),rs.getLong(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7),rs.getDouble(8),rs.getString(9));
			}
			
//			public Account(String customerId, String customerName, long contactNumber, String email, long accountNumber,
//					String bankName, String accountType, double balance, String branch)
			 
		}
		catch(SQLException | NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try 
			{
				if(con!=null)
				{
					con.close();
				}
				if(ps!=null)
				{
					ps.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		return a;
	}
	
	
	
	public Account retrieveAccountList(String id)
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Account a=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select * from Account WHERE customer_id=?");
			ps.setString(1, id);
		
			rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				a=new Account(rs.getString(1),rs.getString(2),rs.getLong(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7),rs.getDouble(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
			}
			
//			public Account(String customerId, String customerName, long contactNumber, String email, long accountNumber,
//					String bankName, String accountType, double balance, String branch)
			 
		}
		catch(SQLException | NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try 
			{
				if(con!=null)
				{
					con.close();
				}
				if(ps!=null)
				{
					ps.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		return a;
	}
	
	
	public Account retrieveAccountList(long number)
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Account a=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select * from Account WHERE account_number=?");
			ps.setLong(1, number);
		
			rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				a=new Account(rs.getString(1),rs.getString(2),rs.getLong(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7),rs.getDouble(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
			}
			
//			public Account(String customerId, String customerName, long contactNumber, String email, long accountNumber,
//					String bankName, String accountType, double balance, String branch)
			 
		}
		catch(SQLException | NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try 
			{
				if(con!=null)
				{
					con.close();
				}
				if(ps!=null)
				{
					ps.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		return a;
	}
	
	
	public boolean updateTheBalance(Long number,double balance)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("update account set balance=? where account_number=?");
			
			ps.setDouble(1,balance);
			ps.setLong(2, number);
			
			int row=ps.executeUpdate();
			
			if(row>0)
			{
				flag=true;
			}
		}
		catch(SQLException | NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try 
			{
				if(con!=null)
				{
					con.close();
				}
				if(ps!=null)
				{
					ps.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return flag;
	}
	
	
	
	
	
	public static boolean deleteAccount(String customerId) {
	    String query = "DELETE FROM account WHERE customer_id = ?";
	    try (Connection conn = DBConnectionManager.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	         stmt.setString(1, customerId);
	        
	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	    	System.out.println(e.getMessage());
	    }
	    return false;
	}

	public static List<String> retrieveAccountNumberBasedOnAccountType(String account_type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public String retrieveCount()
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String str=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select account_number  from Account order by account_number desc limit 1;");
		
			rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				str=rs.getString("account_number");
			}

			 
		}
		catch(SQLException | NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try 
			{
				if(con!=null)
				{
					con.close();
				}
				if(ps!=null)
				{
					ps.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		return str;
	}
	
	
	
	
	
	// branch table check
	
	public String checkBranchExists(String branch)
	{
		String ifsc=null;
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select ifsc_code from branch where branch_name=?");
			ps.setString(1, branch);
			rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				ifsc=rs.getString(1);
			}

			 
		}
		catch(SQLException | NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try 
			{
				if(con!=null)
				{
					con.close();
				}
				if(ps!=null)
				{
					ps.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		return ifsc;
	}
	
	
	public double retrieveBalance(long number)
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		double balance=-1;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select balance from Account WHERE account_number=?");
			ps.setLong(1, number);
		
			rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				balance=rs.getDouble(1);
			}
			 
		}
		catch(SQLException | NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try 
			{
				if(con!=null)
				{
					con.close();
				}
				if(ps!=null)
				{
					ps.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		return balance;
	}
	
	
	
	public List<String> retrieveBasedOnType(String type)
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		 String accNumber="";
		List<String> list=new ArrayList<String>();
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select account_number from Account WHERE account_type=?");
			ps.setString(1, type);
		
			rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				accNumber=""+rs.getLong(1);
				list.add(accNumber);
			}
			 
		}
		catch(SQLException | NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try 
			{
				if(con!=null)
				{
					con.close();
				}
				if(ps!=null)
				{
					ps.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		return list;
	}
}
