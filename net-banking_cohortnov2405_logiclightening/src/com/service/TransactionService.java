package com.service;

import java.util.ArrayList;
import java.util.List;

import com.management.AccountManagement;
import com.management.TransactionManagement;
import com.model.Account;
import com.model.Transactions;
import com.util.ApplicationUtil;

public class TransactionService {
	 ApplicationUtil au=new ApplicationUtil();
	 TransactionManagement tm=new TransactionManagement();
	 AccountService accser=new AccountService();
	 AccountManagement am=new AccountManagement();
	 
	public int depositAmount(Account sender,Account receiver,String tType,double amou){
//		System.out.println("sender   "+sender+"    receiver  "+receiver);
		String transactionId=au.generateTransactionId();
		String custId=receiver.getCustomerId();
		String custName=receiver.getCustomerName();
		long contNo=receiver.getContactNumber();
		long accNo=receiver.getAccountNumber();
		String accType=receiver.getAccountType();
		String bankName=receiver.getBankName();
		String senderName=sender.getCustomerName();
		long senderAccno=sender.getAccountNumber();
		String senderBankName=sender.getBankName();
		long senderContact=sender.getContactNumber();
		String transactionType=tType;
		double amount=amou;
		String date=au.getCurrentDate();
		
		if(sender.getBalance()<amount) {
			String status="Failed";
			double balance=sender.getBalance();
//			String transactionId, String transactionType, double amount, double currentBalance,
//			String transactionDate, String status,Account sender,Account receiver
			Transactions obj=new Transactions(transactionId,transactionType,amount,balance,date,status,sender,receiver);
			int temp=tm.insertTransactionsList(obj);
			
			if(temp>0) {
				return 0;
			}
			
		}
		else {
			String status="Success";
			tm.debitAmount(sender,amount);
			tm.creditAmount(receiver, amount);
			
			Account aobj=accser.retrieveAccountListForTransaction(sender.getAccountNumber());
			double balance=aobj.getBalance();
			Transactions obj=new Transactions(transactionId,transactionType,amount,balance,date,status,sender,receiver);
			int temp=tm.insertTransactionsList(obj);
			if(temp>0) {
				return 1;
			}
		}
		return 0;
	}
	
	
	
	public List<String> retrieveTransactionsList(String id)
	{
		List<String> list=new ArrayList<String>();
		
		Transactions t=tm.retrieveTransactionsList(id);
		if(t!=null)
		{
			list.add(t.getTransactionId());
			list.add(t.getCustomerId());
			list.add(t.getCustomerName());
			String number=""+ t.getContactNumber();
			list.add(number);
			String accNumber=""+t.getAccountNumber();
			list.add(accNumber);
			list.add(t.getAccountType());
			list.add(t.getBankName());
			list.add(t.getSenderName());
			String senderaccNumber=""+t.getSenderAccountNumber();
			list.add(senderaccNumber);
			list.add(t.getSenderBankName());
			String senderContact=""+t.getSenderContactNumber();
			list.add(senderContact);
			list.add(t.getTransactionType());
			String amount=""+t.getAmount();
			list.add(amount);
			String currentBalance=""+t.getCurrentBalance();
			list.add(currentBalance);
			list.add(t.getTransactionDate());
			list.add(t.getStatus());
		}
		else
		{
			list=null;
		}
		
		return list;
	}
	  
	public boolean checkAccountNumberExists(long number)
	{
		return am.checkIdExists(number);
	}
	
	
	public List<String> retrieveTransactionsListForReceipt(long accnumber)
	{
		List<String> list=new ArrayList<String>();
		
		Transactions t=tm.retrieveTransactionsListForReceipt(accnumber);
		if(t!=null)
		{
			list.add(t.getTransactionId());
			list.add(t.getCustomerId());
			list.add(t.getCustomerName());
			String number=""+ t.getContactNumber();
			list.add(number);
			String accNumber=""+t.getAccountNumber();
			list.add(accNumber);
			list.add(t.getAccountType());
			list.add(t.getBankName());
			list.add(t.getSenderName());
			String senderaccNumber=""+t.getSenderAccountNumber();
			list.add(senderaccNumber);
			list.add(t.getSenderBankName());
			String senderContact=""+t.getSenderContactNumber();
			list.add(senderContact);
			list.add(t.getTransactionType());
			String amount=""+t.getAmount();
			list.add(amount);
			String currentBalance=""+t.getCurrentBalance();
			list.add(currentBalance);
			list.add(t.getTransactionDate());
			list.add(t.getStatus());
		}
		else
		{
			list=null;
		}
		
		return list;
	}
	
	
	public List<Transactions> retrieveTransactionsUsingAccount(long number)
	{
		List<Transactions> list=tm.retrieveTransactionsUsingAccount(number);
		if(list.size()>0)
		{
			return list;
		}
		
		return null;
	}
}
