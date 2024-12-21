package com.service;

import java.util.List;
import java.util.Random;

import com.management.AccountManagement;
import com.management.CheckBookRequestManagement;
import com.management.TransactionManagement;
import com.model.Account;
import com.model.CheckBookRequest;
import com.model.Transactions;
import com.util.ApplicationUtil;

public class CheckBookRequestService 
{
	AccountManagement am=new AccountManagement();
	TransactionManagement tm=new TransactionManagement();
	CheckBookRequestManagement cm=new CheckBookRequestManagement();
	ApplicationUtil au=new ApplicationUtil();
	
	public int buildCheckBookRequestList(long number)
	{
		int res=0;
		Account a=am.retrieveAccountList(number);
		if(a!=null)
		{
			if(a.getBalance()>=200000)
			{
				List<Transactions> list=tm.retrieveTransactionsUsingAccount(number);
				if(list.size()>0)
				{
					if(list.size()>5)
					{
						String id=generateId();
						String date=au.getCurrentDate();
						CheckBookRequest c=new CheckBookRequest(id,date,a);
						boolean flag=addCheckBookRequestList(c);
						if(flag) 
						{
							res=1;
						}
						else
						{
							res=0;
						}
					}
					else
					{
						res=-3;
					}
				}
				else
				{
					res=-2;
				}
			}
			else
			{
				res=-1;
			}
		}
		else
		{
			res=-4;
		}
		return res;
	}
	
	
	public boolean addCheckBookRequestList(CheckBookRequest c)
	{
		return cm.insertCheckBookRequest(c);
	}
	
	
	
	public String generateId()
	{
		String id="";
		Random rand=new Random();
		
		id="REQ"+rand.nextInt(1000,9999)+cm.retrieveCount();
		
		return id;
	}
	
	public boolean deleteCheckBookRequest(String id)
	{
		return cm.deleteCheckBookRequest(id);
	}
	
	
	public String retrieveId(long number)
    {
    	return cm.retrieveId(number);
    }
}
