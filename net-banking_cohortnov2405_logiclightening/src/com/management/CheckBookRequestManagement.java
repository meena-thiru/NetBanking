package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Account;
import com.model.CheckBookRequest;
import com.model.Profile;

public class CheckBookRequestManagement {
	public boolean insertCheckBookRequest(CheckBookRequest c) {
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=DBConnectionManager.getConnection();
			
			ps=con.prepareStatement("insert into checkbookrequest values(?,?,?,?,?,?,?)");
			
			Account a=c.getA();
			
			ps.setString(1,c.getRequestId());
			ps.setString(2,a.getCustomerId());
			ps.setString(3,a.getCustomerName());
			ps.setLong(4,a.getAccountNumber());
			ps.setString(5,a.getAccountType());
			ps.setString(6,a.getBankName());
			ps.setString(7,c.getRequestDate());
			
			int row=ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
		}
		catch(SQLException | NullPointerException e)
		{
			e.printStackTrace();
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
				e.printStackTrace();
			}
		}
		
		return false;
	}
	public boolean checkIdExists(String id)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select * from checkbookrequest where request_Id=?");
			
			ps.setString(1, id);
			rs=ps.executeQuery();
			flag=rs.next();
			
		}
		catch(SQLException | NullPointerException e)
		{
			e.printStackTrace();
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
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	public boolean deleteCheckBookRequest(String id)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("DELETE FROM checkbookrequest WHERE request_Id=?");
			
			ps.setString(1, id);
			
			int row=ps.executeUpdate();
			
			if(row>0)
			{
				flag=true;
			}
		}
		catch(SQLException | NullPointerException e)
		{
			e.printStackTrace();
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
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	
	public int retrieveCount()
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select count(request_id) as noofcount from checkbookrequest");
		
			rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				count=rs.getInt("noofcount");
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
		
		return count;
	}
	
	
	
	public String retrieveId(long number)
	{
		 String str=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select request_id from checkbookrequest where account_number=?");
			
			ps.setLong(1, number);
			rs=ps.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}
			
		}
		catch(SQLException | NullPointerException e)
		{
			e.printStackTrace();
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
				e.printStackTrace();
			}
		}
		
		return str;
	}
}

