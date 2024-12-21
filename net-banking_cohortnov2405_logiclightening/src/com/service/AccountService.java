
 package com.service;
 

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.management.AccountManagement;


import java.util.Random;

import com.management.ProfileManagement;
import com.model.Account;
import com.model.Profile;

public class AccountService 
{
	AccountManagement am=new AccountManagement();
	
//  BUILD ACCOUNT LIST
	
	public long buildAccountList()
	{		
		return generateAccountId();
	}
	
	// ADD ACCOUNT LIST METHOD
	
	public boolean addAccountList(String id,String accountType,double balance,String branch,String ifscCode,String idProofType,String idProofNumber)
	{		
		Profile p=retrieveProfileDetails(id);
		long number=buildAccountList();
		Account acc=new Account(number,accountType,balance,branch,ifscCode,idProofType,idProofNumber,p);
		return am.addAccountList(acc);
	}
	
	
	public String checkBranchExists(String branch)
	{
		return am.checkBranchExists(branch);
	}
	
	
	public Profile retrieveProfileDetails(String id)
	{
		ProfileManagement pm=new ProfileManagement();
		return pm.retrieveProfileDetails(id);
	}
	

	//  GENERATE ACCOUNT ID
	
	public long generateAccountId()
	{
//		Random rand=new Random();
		long number=0;
		String last=am.retrieveCount();
//		number=rand.nextInt(100000,999999) ;
		if(last!=null)
		{
			long num=Long.parseLong(last.substring(6));
			last=""+100000+ ""+(++num);
			number=Long.parseLong(last);
		}
		else
		{
			last=""+100000+ ""+(1);
			number=Long.parseLong(last);
		}
		
		return number;
	}
	
	
	// DELETE ACCOUNT LIST
	
	public boolean deleteAccount(String Id) {
      return am.deleteAccount(Id);
  }
	
	
	
	
	
	// RETRIEVE ACCOUNT LIST FOR TRANSACTION METHOD
	
    public Account retrieveAccountListForTransaction(Long number) {
	  return am.retrieveAccountListForTransaction(number);
  }
    
    
    // RETRIEVE ACCOUNT LIST METHOD
    
    public List<String> retrieveAccountList(String id)
    {
    	
    	Account a=am.retrieveAccountList(id);
    	List<String> list =new ArrayList<String>();
    	if(a!=null)
    	{
	    	
	    	list.add(a.getCustomerId());
	    	list.add(a.getCustomerName());
	    	String contact=""+a.getContactNumber();
	    	list.add(contact);
	    	list.add(a.getEmail());
	    	String number=""+a.getAccountNumber();
	    	list.add(number);
	    	list.add(a.getBankName());
	    	list.add(a.getAccountType());
	    	String balance=""+a.getBalance();
	    	list.add(balance);
	    	list.add(a.getBranch());
	    	list.add(a.getIfscCode());
	    	list.add(a.getIdProofType());
	    	list.add(a.getIdProofNumber());
    	}
    	return list;
    	
    }
    
    
    
    public double retrieveBalance(long number)
    {
    	return am.retrieveBalance(number);
    }
    
    
    public boolean checkIdExists(String id)
    {
    	boolean flag=false;
    	Account a=am.retrieveAccountList(id);
    	if(a==null)
    	{
    		flag=true;
    	}
    	return flag;
    }
    
    
    public boolean checkIdExists(long number)
    {
    	return am.checkIdExists(number);
    }
    
    
    public List<String> retrieveBasedOnType(String Type)
    {
    	return am.retrieveBasedOnType(Type);
    }
}


