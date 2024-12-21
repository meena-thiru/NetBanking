package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Profile;

public class ProfileManagement 
{
	public boolean addProfile(Profile p)
	{
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=DBConnectionManager.getConnection();
			
			ps=con.prepareStatement("insert into profile values(?,?,?,?,?,?)");
			
			ps.setString(1,p.getCustomerId());
			ps.setString(2,p.getCustomerName());
			ps.setString(3,p.getDob());
			ps.setString(4,p.getEmailId());
			ps.setString(5,p.getAddress());
			ps.setLong(6,p.getContactNumber());
			
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
	
	public boolean checkIdExists(String id)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select * from profile where customer_Id=?");
			
			ps.setString(1, id);
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
	
	public boolean updateEmailInProfile(String id,String detail)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("update profile set email_id=? where customer_Id=?");
			
			
			ps.setString(1,detail);
			ps.setString(2, id);
			
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
	
	
	
	public boolean updateAddressInProfile(String id,String detail)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("update profile set address=? where customer_Id=?");
			
			
			ps.setString(1,detail);
			ps.setString(2, id);
			
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
	
	public boolean updateContactInProfile(String id,long detail)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("update profile set contact_number=? where customer_Id=?");			
			
			ps.setLong(1,detail);
			ps.setString(2, id);
			
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
	
	public Profile retrieveProfileDetails(String id)
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Profile p=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select * from profile WHERE customer_id=?");
			ps.setString(1, id);
		
			rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				p=new Profile(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getLong(6));
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
		
		return p;
	}
	
	
	
	public String retrieveCustomerId(String email)
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String str="";
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select * from profile WHERE email_id=?");
			ps.setString(1, email);
		
			rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				str=rs.getString(1);
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
	
	
	public boolean deleteProfileDetails(String id)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("DELETE FROM profile WHERE customer_Id=?");
			
			ps.setString(1, id);
			
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
	
	
	public String retrieveCount()
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String str=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select customer_id  from profile order by customer_id desc limit 1;");
		
			rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				str=rs.getString("customer_id");
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
}
