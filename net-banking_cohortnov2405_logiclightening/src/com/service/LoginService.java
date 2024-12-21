package com.service;

import com.management.LoginManagement;
import com.model.Login;
import com.util.ApplicationUtil;

public class LoginService 
{
	LoginManagement lm=new LoginManagement();
	ApplicationUtil au=new ApplicationUtil();
	public String buildNewLoginId(String name)
	{
		return generateId(name,retriveCount());
	}
	
	public boolean checkBothPassword(String password1,String password2)
	{
		return password1.equals(password2);
	}
	
	public boolean checkPassword(String password)
	{
		return au.checkPasword(password);
	}

// ADD TO DATABASE 
	public boolean addNewLoginDetails(String id,String password,String customerId)
	{
		Login l=new Login(id,password,customerId);
		
		return lm.addLoginDetails(l);
	}
	
	public String generateId(String name,int num)
	{
		String id="";
		
		id="USER"+name.substring(0,3)+  ++num;
		
		if(checkIdExists(id))
		{
			return generateId(id,num);
		}
		
		return id;
	}
	
	public boolean checkIdAndPasswordExists(String id,String password)
	{
		
		return lm.checkIdAndPasswordExists(id, password);
	}
	
	public boolean checkIdExists(String id)
	 {		 
		 return lm.checkIdExists(id);		  
	 }
	
	public int retriveCount()
	{
		return lm.retrieveCount();
	}
	
	
	public boolean deleteLogin(String id)
	{
		return lm.deleteLogin(id);
	}
}
