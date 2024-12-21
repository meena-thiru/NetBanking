package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Login;
import com.model.Profile;

public class LoginManagement 
{
	public boolean addLoginDetails(Login l)
	{
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=DBConnectionManager.getConnection();
			
			ps=con.prepareStatement("insert into login values(?,?,?)");
			
			ps.setString(1,l.getUserId());
			ps.setString(2,l.getPassword());
			ps.setString(3, l.getCustomerId());
			
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
			
			ps=con.prepareStatement("select * from login where user_Id=?");
			
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
	
	
	public boolean checkIdAndPasswordExists(String id,String password)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select * from login where user_Id=? and password=?");
			
			ps.setString(1, id);
			ps.setString(2, password);
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
	
	
	public int retrieveCount()
	{
		int count=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select count(user_id) as noofcount from login");
			
			rs=ps.executeQuery();
			rs.next();
			count=rs.getInt("noofcount");
			
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
	
	public boolean updatePasswordInLogin(String id,String password)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("update login set password=? where user_Id=?");
			
			ps.setString(1,password);
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
	
	
	public String retrieveCustomerId(String name)
	{
		String id=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			con=DBConnectionManager.getConnection();		
			
			ps=con.prepareStatement("select customer_id from login where user_id=?");
			ps.setString(1, name);
			
			rs=ps.executeQuery();
			rs.next();
			id=rs.getString(1);
			
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
		
		return id;
	}
	
	
	
	public boolean deleteLogin(String id)
	{
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=DBConnectionManager.getConnection();
			
			ps=con.prepareStatement("DELETE FROM LOGIN WHERE CUSTOMER_ID=?");
			
			ps.setString(1,id);
			
			
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
	
}
