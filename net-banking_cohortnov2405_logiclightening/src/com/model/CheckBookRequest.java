package com.model;

public class CheckBookRequest {
	
	
	private String requestId;
//	private long accountNumber;
//	private String accountType;
//	private String bankName;
	private String requestDate;
	private Account a;
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	

//	public long getAccountNumber() {
//		return accountNumber;
//	}
//	public void setAccountNumber(long accountNumber) {
//		this.accountNumber = accountNumber;
//	}
//	public String getAccountType() {
//		return accountType;
//	}
//	public void setAccountType(String accountType) {
//		this.accountType = accountType;
//	}
//	public String getBankName() {
//		return bankName;
//	}
//	public void setBankName(String bankName) {
//		this.bankName = bankName;
//	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public Account getA() {
		return a;
	}
	public void setA(Account a) {
		this.a = a;
	}
//	public CheckBookRequest(String requestId, long accountNumber, String accountType, String bankName,
//			String requestDate, Account a) {
//		super();
//		this.requestId = requestId;
//		this.accountNumber = accountNumber;
//		this.accountType = accountType;
//		this.bankName = bankName;
//		this.requestDate = requestDate;
//		this.a = a;
//	}
	public CheckBookRequest(String requestId, String requestDate, Account a) {
		super();
		this.requestId = requestId;
		this.requestDate = requestDate;
		this.a = a;
	}


	
	
	
	
}