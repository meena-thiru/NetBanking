package com.model;

public class Profile 
{
	private String customerId;
	private String customerName;
	private String dob;
	private String emailId;
	private String address;
	private long contactNumber;
	
	
	
	
	public Profile(String customerId, String customerName, String dob, String emailId, String address,
			long contactNumber) 
	{
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.dob = dob;
		this.emailId = emailId;
		this.address = address;
		this.contactNumber = contactNumber;
	}




	public String getCustomerId() 
	{
		return customerId;
	}
	public void setCustomerId(String customerId) 
	{
		this.customerId = customerId;
	}




	public String getCustomerName() 
	{
		return customerName;
	}
	public void setCustomerName(String customerName) 
	{
		this.customerName = customerName;
	}




	public String getDob() 
	{
		return dob;
	}
	public void setDob(String dob) 
	{
		this.dob = dob;
	}




	public String getEmailId() 
	{
		return emailId;
	}
	public void setEmailId(String emailId) 
	{
		this.emailId = emailId;
	}




	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}




	public long getContactNumber() 
	{
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) 
	{
		this.contactNumber = contactNumber;
	}
}
