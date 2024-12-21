package com.model;

public class Account 
{

	private String customerId;
	private String customerName;
	private long contactNumber;
	private String email;
	private long accountNumber;
	private String bankName="CITY UNION BANK";
	private String accountType;
	private double balance;
	private String branch;
	private String ifscCode;
	private String idProofType;
	private String idProofNumber;
	
	private Profile p;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getIdProofType() {
		return idProofType;
	}
	public void setIdProofType(String idProofType) {
		this.idProofType = idProofType;
	}

	public String getIdProofNumber() {
		return idProofNumber;
	}
	public void setIdProofNumer(String idProofNumber) {
		this.idProofNumber = idProofNumber;
	}
	
	public Profile getP() {
		return p;
	}
	public void setP(Profile p) {
		this.p = p;
	}

	public Account(long accountNumber, String accountType,
			double balance, String branch, String ifscCode, String idProofType, String idProofNumber, Profile p) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.branch = branch;
		this.ifscCode = ifscCode;
		this.idProofType = idProofType;
		this.idProofNumber = idProofNumber;
		this.p = p;
	}
	public Account(String customerId, String customerName, long contactNumber, String email, long accountNumber,
			String bankName, String accountType, double balance, String branch) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.accountType = accountType;
		this.balance = balance;
		this.branch = branch;
	}
	public Account(String customerId, String customerName, long contactNumber, String email, long accountNumber,
			String bankName, String accountType, double balance, String branch,String ifscCode, String idProofType, String idProofNumber) {
		this(customerId,customerName,contactNumber, email, accountNumber,
				bankName, accountType,balance, branch);
		this.ifscCode = ifscCode;
		this.idProofType = idProofType;
		this.idProofNumber = idProofNumber;
	}
	
	
}

		

