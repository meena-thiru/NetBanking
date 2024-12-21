
package com.client;
import java.util.List;
import java.util.Scanner;

import com.management.ProfileManagement;
import com.model.Account;
import com.model.Profile;
import com.model.Transactions;
import com.service.AccountService;
import com.service.CheckBookRequestService;
import com.service.LoginService;

import com.service.ProfileService;
import com.service.TransactionService;
import com.util.ApplicationUtil;
public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ProfileService ps=new ProfileService();
		AccountService as=new AccountService();
		LoginService ls=new LoginService();
		
		String green = "\033[32m";
		String red = "\033[31m";
		String yellow = "\033[33m";
        String reset = "\033[0m";
        String bold = "\033[1m"; 
        String underline = "\033[4m";
		//System.out.println("meenatchi");
		try
		{
			
			
			System.out.println("                                "+"\u2764\uFE0F".repeat(18));
			System.out.println("                                "+"\033[31m❤️\033[0m"+"      WELCOME TO NET BANKING     "+ "\033[31m❤️\033[0m");
			System.out.println("                                "+"\u2764\uFE0F".repeat(18));
	
			 do {	 
				 
				 System.out.println("\n\n\n\n"+"\u2554"+ "\u2550".repeat(42) +"\u2557");
				  System.out.printf("\u2551 %-40s \u2551\n","            MAIN MENU");
				  System.out.println("\u2551" + "\u2550".repeat(42) +"\u2551" );
				  System.out.printf("\u2551 %-40s \u2551\n","     1.🚪 LOGIN  "  );
				  System.out.printf("\u2551 %-40s \u2551\n","     2.📃 REGISTER");
				  System.out.printf("\u2551 %-40s \u2551\n","     3.🚪 EXIT");
				  System.out.println("\u255A" + "\u2550".repeat(42) +"\u255D");
	//			  System.out.println("1.Login\n2.Register\n3.Exit\nEnter the choice");
				  System.out.println("\nEnter your choice");
			   	  int choice=sc.nextInt();
				  sc.nextLine();
					 if(choice==1)
					 {
						 System.out.println("Enter the user name");
						 String userName=sc.next();
						 System.out.println("Enter the password");
						 String pwd=sc.next();
						 sc.nextLine();
						 if(ls.checkIdAndPasswordExists(userName, pwd)) 
						 {
							 
							 System.out.println(green+bold+"                        "+"*".repeat(54) );
							  System.out.printf("                        "+"* %-50s *\n","         LOGIN SUCCESSFULLY  ");
							  System.out.println("                        "+"*".repeat(54) +reset);
							 
							 do {
								  System.out.println("\n\n\u2554"+ "\u2550".repeat(42) +"\u2557");
								  System.out.printf("\u2551 %-40s \u2551\n","          🏠 HOME PAGE");
								  System.out.println("\u2551" + "\u2550".repeat(42) +"\u2551" );
								  System.out.printf("\u2551 %-40s \u2551\n","      1.👤 PROFILE");
								  System.out.printf("\u2551 %-40s \u2551\n","      2.💳 ACCOUNT");
								  System.out.printf("\u2551 %-40s \u2551\n","      3.📑 TRANSACTION");
								  System.out.printf("\u2551 %-40s \u2551\n","      4.📓 CHECKBOOK REQUEST");
								  System.out.printf("\u2551 %-40s \u2551\n","      5.🚪 LOGOUT");
								  System.out.println("\u255A" + "\u2550".repeat(42) +"\u255D");
								  System.out.println("\nEnter your choice");
	//								 System.out.println("1. Profile\n2. Account\n3. Transaction\n4. CheckBook Request\n5. Logout\nEnter the choice");
									 choice=sc.nextInt();
									 sc.nextLine();
									 
									 	if(choice==1)
										 {								 					 
											 do {
	//												 System.out.println("1. View Profile");
	//												 System.out.println("2. Update Profile");
	//												 System.out.println("3. Delete Profile");
	//												 System.out.println("4. Exit");
												 
												 	System.out.println("\n\n\n\u2554"+ "\u2550".repeat(42) +"\u2557");
													  System.out.printf("\u2551 %-40s \u2551\n","        👤   PROFILE PAGE");
													  System.out.println("\u2551" + "\u2550".repeat(42) +"\u2551" );
													  System.out.printf("\u2551 %-40s \u2551\n","      1.👀 VIEW PROFILE");
													  System.out.printf("\u2551 %-40s \u2551\n","      2.✏️ UPDATE PROFILE");
													  System.out.printf("\u2551 %-39s \u2551\n","      3.❌ DELETE PROFILE");
													  System.out.printf("\u2551 %-40s \u2551\n","      4.🚪 EXIT");
													  System.out.println("\u255A" + "\u2550".repeat(42) +"\u255D");
													 System.out.println("\nEnter the choice");
													 choice=sc.nextInt();
													 sc.nextLine();
													 		if(choice==1)
															 {
																   
																  Profile p=ps.retrieveProfileDetails(userName);
																  if(p!=null)
																  {
																	  System.out.println("\u2554"+ "\u2550".repeat(52) +"\u2557");
																	  System.out.printf("\u2551 %-50s \u2551\n","            PROFILE DETAILS");
																	  System.out.println("\u2551" + "\u2550".repeat(52) +"\u2551" );
																	  System.out.printf("\u2551 %-50s \u2551\n","1.CUSTOMER_ID        :"+p.getCustomerId());
																	  System.out.printf("\u2551 %-50s \u2551\n","2.CUTOMER_NAME       :"+p.getCustomerName());
																	  System.out.printf("\u2551 %-50s \u2551\n","3.DOB                :"+p.getDob());
																	  System.out.printf("\u2551 %-50s \u2551\n","4.EMAIL_ID           :"+p.getEmailId());
																	  System.out.printf("\u2551 %-50s \u2551\n","5.ADDRESS            :"+p.getAddress());
																	  System.out.printf("\u2551 %-50s \u2551\n","6.CONTACT_NUMBER     :"+p.getContactNumber());
																	  System.out.println("\u255A" + "\u2550".repeat(52) +"\u255D");
																  }
																  else
																  {
																	  System.out.println("There is no profile for you or your Profile has been deleted");
																  }
																
																  
															 }
													 		else if(choice==2)
													 		{
													 			String id=ps.retrieveCustomerIdFromLogin(userName);
																  boolean flag=false;
													 			do 
																  {
														 			  System.out.println("\n\n\n\u2554"+ "\u2550".repeat(42) +"\u2557");
																	  System.out.printf("\u2551 %-40s \u2551\n","         📝  UPDATE PAGE");
																	  System.out.println("\u2551" + "\u2550".repeat(42) +"\u2551" );
																	  System.out.printf("\u2551 %-40s \u2551\n","      1.✏️ UPDATE EMAIL");
																	  System.out.printf("\u2551 %-40s \u2551\n","      2.✏️ UPDATE CONTACT NUMBER");
																	  System.out.printf("\u2551 %-40s \u2551\n","      3.✏️ UPDATE ADDRESS");
																	  System.out.printf("\u2551 %-40s \u2551\n","      4.🚪 EXIT");
																	  System.out.println("\u255A" + "\u2550".repeat(42) +"\u255D");
																	  System.out.println("\n\nEnter the choice");
																	  choice=sc.nextInt();
																	  sc.nextLine();
																	  
																	  
																		  if(choice==1)
																		  {
																			  System.out.println("Enter the new Email ID");
																			  String email=sc.nextLine();
																			  System.out.println(yellow+"\nDo you really want to update email in Profile (YES/NO)"+reset);
																				 String check=sc.next();
																				 sc.nextLine();
																				 if("yes".equalsIgnoreCase(check))
																				 {
																					   flag=ps.updateEmailInProfile( id, email);
																					  
																					  if(flag)
																					  {
																						  System.out.println(green+"\n\nEmail ID has been Successfully Updated"+reset);
																					  }
																					  else
																					  {
																						  System.out.println(red+"Email ID has been Failed to Update"+reset);
																					  }
																				 }
																				 else
																				 {
																					 System.out.println("\nYour profile updation has been canceled");
																				 }
																		  }
																		  else if(choice==2)
																		  {
																			  System.out.println("Enter the new Contact Number");
																			  long contact=sc.nextLong();
																			  System.out.println(yellow+"\nDo you really want to update contact number in Profile (YES/NO)"+reset);
																				 String check=sc.next();
																				 sc.nextLine();
																				 if("yes".equalsIgnoreCase(check))
																				 {
																					   flag=ps.updateContactInProfile(id, contact);
																					   
																					     if(flag)
																						  {
																							  System.out.println(green+"\n\nContact Number has been Successfully Updated"+reset);
																						  }
																						  else
																						  {
																							  System.out.println(red+"Contact Number has been Failed to Update"+reset);
																						  }
																				 }
																				 else
																				 {
																					 System.out.println("\nYour profile updation has been canceled");
																				 }
																		  }
																		  else if(choice==3)
																		  {
																			  System.out.println("Enter the new Address");
																			  String address=sc.nextLine();
																			  System.out.println(yellow+"\nDo you really want to update address in Profile (YES/NO)"+reset);
																				 String check=sc.next();
																				 sc.nextLine();
																				 if("yes".equalsIgnoreCase(check))
																				 {
																					  flag=ps.updateAddressInProfile(id, address);
																					  
																					  if(flag)
																					  {
																						  System.out.println(green+"\n\nAddress has been Successfully Updated\n\n"+reset);
																					  }
																					  else
																					  {
																						  System.out.println(red+"Address has been Failed to Update"+reset);
																					  }
																				 }
																				 else
																				 {
																					 System.out.println("\nYour profile updation has been canceled");
																				 }
																		  }
																		  else if(choice==4)
																		  {
																			  System.out.println("\n\n--------------------RETURNING TO PROFILE PAGE---------------------\n\n");
																			  break;
																		  }
																  }while(true);
																  
													 		}
													 		else if(choice==3)
															 {
																 String id=ps.retrieveCustomerIdFromLogin(userName);
						
																 if(ps.checkIdExists(id))
																 {
																	 List<String> list=as.retrieveAccountList(id);															
																	 if(list.size()<=0)
																	 {
																		 System.out.println(yellow+"\nDo you really want to delete a profile (YES/NO)"+reset);
																		 String check=sc.next();
																		 if("yes".equalsIgnoreCase(check))
																		 {
																			 System.out.println(ps.deleteProfileDetails(id));
																		 }
																		 else
																		 {
																			 System.out.println("\nYour profile deletion has been canceled");
																		 }
																	 }
																	 else
																	 {
																		 System.out.println(yellow+"\nDo you really want to delete a Profile (YES/NO)"+reset);
																		 String check=sc.next();
																		 sc.nextLine();
																		 if("yes".equalsIgnoreCase(check))
																		 {
																			 if(ls.deleteLogin(id))
																			 {
																				 System.out.println(red+"\n\nYour Profile and Login credentials has been deleted.\n\n"+reset);
																			 }
																			 else
																			 {
																				 System.out.println("Refresh your page");
																			 }
																		 }
																		 else
																		 {
																			 System.out.println("\nYour profile deletion has been canceled");
																		 }
																	 }
																 }
																 else
																 {
																	 System.out.println(red+"Customer Id not Exists. Please create a profile"+reset);
																 }
																 
															 }
													 		else if(choice==4)
															 {
													 			System.out.println("--------------RETURNING TO HOME PAGE-------------");
																 break;
															 }
													 
										       }while(true);
										 }
									 	else if(choice==2)
										 {
											 
											 do {
	//												 System.out.println("1. Account Creation");
	//												 System.out.println("2. View Account Details");
	//												 System.out.println("3. View Transaction Details");
	//												 System.out.println("4. Delete Account");
	//												 System.out.println("5. Exit");
												 	
												 	 System.out.println("\n\n\n\u2554"+ "\u2550".repeat(62) +"\u2557");
													  System.out.printf("\u2551 %-60s \u2551\n","         💳  ACCOUNT PAGE");
													  System.out.println("\u2551" + "\u2550".repeat(62) +"\u2551" );
													  System.out.printf("\u2551 %-60s \u2551\n","      1.🆕 ACCOUNT CREATION");
													  System.out.printf("\u2551 %-60s \u2551\n","      2.📄 VIEW ACCOUNT DETAILS");
													  System.out.printf("\u2551 %-60s \u2551\n","      3.📄 VIEW ACCOUNT DETAILS Based on Type");
													  System.out.printf("\u2551 %-59s \u2551\n","      4.❌ DELETE ACCOUNT");
													  System.out.printf("\u2551 %-60s \u2551\n","      5.🚪 EXIT");
													  System.out.println("\u255A" + "\u2550".repeat(62) +"\u255D");
													 System.out.println("\nEnter the choice");
													 choice=sc.nextInt();
													 sc.nextLine();
													  
													 	if(choice==1)
														 {
															System.out.println("Enter the Customer Id");
															String id=sc.nextLine();
															if(ps.checkIdExists(id))
															{
																if(as.checkIdExists(id))
																{
																		System.out.println("Enter the Account Type (SAVING / CURRENT)");
																		String accountType=sc.nextLine();
																		if("saving".equalsIgnoreCase(accountType) || "current".equalsIgnoreCase(accountType))
																		{
																			System.out.println("Enter the Branch Name");
																			String branch=sc.nextLine();
																			String ifscCode=as.checkBranchExists(branch);
																			if(ifscCode !=null)
																			{
																				System.out.println("Enter the ID Proof Type (PAN / AADHAR / LICENSE / VOTEID");
																				String idProofType=sc.nextLine();
																				if("pan".equalsIgnoreCase(idProofType) || "aadhar".equalsIgnoreCase(idProofType) || "license".equalsIgnoreCase(idProofType) || "voteid".equalsIgnoreCase(idProofType) )
																				{
																					System.out.println("Enter the ID Proof Number");
																					String idProofNumber=sc.nextLine();
																					
																					System.out.println("Enter the Amount Do you deposit for Opening balance");
																					double balance=sc.nextDouble();
	//																				sc.nextLine();
																					
																					boolean flag=as.addAccountList(id, accountType, balance, branch, ifscCode, idProofType, idProofNumber);
																					
																					if(flag)
																					{
																						System.out.println(green+"\n\nAccount Creation Successfully Completed\nYour Account Details :\n\n"+reset);
																						List<String> list=as.retrieveAccountList(id);
																						 System.out.println("\u2554"+ "\u2550".repeat(52) +"\u2557");
																						  System.out.printf("\u2551 %-50s \u2551\n","            ACCOUNT DETAILS");
																						  System.out.println("\u2551" + "\u2550".repeat(52) +"\u2551" );
																						  System.out.printf("\u2551 %-50s \u2551\n","1.CUSTOMER_ID        :"+list.get(0));
																						  System.out.printf("\u2551 %-50s \u2551\n","2.CUTOMER_NAME       :"+list.get(1));
																						  System.out.printf("\u2551 %-50s \u2551\n","3.CONTACT_NUMBER     :"+list.get(2));
																						  System.out.printf("\u2551 %-50s \u2551\n","4.EMAIL_ID           :"+list.get(3));
																						  System.out.printf("\u2551 %-50s \u2551\n","5.ACCOUNT_NUMBER     :"+list.get(4));
																						  System.out.printf("\u2551 %-50s \u2551\n","6.ACCOUNT_TYPE       :"+list.get(6));
																						  System.out.printf("\u2551 %-50s \u2551\n","7.OPENING BALANCE    :"+(long)Double.parseDouble(list.get(7)));
																						  System.out.printf("\u2551 %-50s \u2551\n","8.BRANCH             :"+list.get(8));
																						  System.out.printf("\u2551 %-50s \u2551\n","9.IFSCCODE           :"+list.get(9));
																						  System.out.printf("\u2551 %-50s \u2551\n","10.IDPROOFTYPE       :"+list.get(10));
																						  System.out.printf("\u2551 %-50s \u2551\n","11.IDPROOFNUMBER     :"+list.get(11));
																						  System.out.println("\u255A" + "\u2550".repeat(52) +"\u255D");
																						
																					}
																					else
																					{
																						System.out.println(red+"\nAccount Creation Not Successfully Completed"+reset);
																					}
																				}
																				else
																				{
																					System.out.println(red+idProofType+" is Invalid Type"+reset);
																				}
																				
																			}
																			else
																			{
																				System.out.println(red+"\nGiven Branch Name is Invalid"+reset);
																			}
																		}
																		else
																		{
																			System.out.println(red+"\nGiven Account Type is Invalid"+reset);
																		}
																}
																else
																{
																	System.out.println(yellow+"\n\nYou already have a Account"+reset);
																}
															}
															else
															{
																System.out.println(red+"Customer Id not Exists. Please check Entered Id"+reset);
															}
														 }
													 	else if(choice==2)
														 {
													 			System.out.println("Enter the Customer ID to View Your Account Details");
													 			String id=sc.nextLine();
													 			if(ps.checkIdExists(id))
													 			{
													 				System.out.println("\nYour Account Details :\n\n");
																	List<String> list=as.retrieveAccountList(id);
																	 System.out.println("\u2554"+ "\u2550".repeat(52) +"\u2557");
																	  System.out.printf("\u2551 %-50s \u2551\n","            ACCOUNT DETAILS");
																	  System.out.println("\u2551" + "\u2550".repeat(52) +"\u2551" );
																	  System.out.printf("\u2551 %-50s \u2551\n","1.CUSTOMER_ID        :"+list.get(0));
																	  System.out.printf("\u2551 %-50s \u2551\n","2.CUSTOMER_NAME      :"+list.get(1));
																	  System.out.printf("\u2551 %-50s \u2551\n","3.CONTACT_NUMBER     :"+list.get(2));
																	  System.out.printf("\u2551 %-50s \u2551\n","4.EMAIL_ID           :"+list.get(3));
																	  System.out.printf("\u2551 %-50s \u2551\n","5.ACCOUNT_NUMBER     :"+list.get(4));
																	  System.out.printf("\u2551 %-50s \u2551\n","6.ACCOUNT_TYPE       :"+list.get(6));
																	  System.out.printf("\u2551 %-50s \u2551\n","7.CURRENT_BALANCE    :"+(long)Double.parseDouble(list.get(7)));
																	  System.out.printf("\u2551 %-50s \u2551\n","8.BRANCH             :"+list.get(8));
																	  System.out.printf("\u2551 %-50s \u2551\n","9.IFSCCODE           :"+list.get(9));
																	  System.out.printf("\u2551 %-50s \u2551\n","10.IDPROOFTYPE       :"+list.get(10));
																	  System.out.printf("\u2551 %-50s \u2551\n","11.IDPROOFNUMBER     :"+list.get(11));
																	  System.out.println("\u255A" + "\u2550".repeat(52) +"\u255D");
													 			}
													 			else
													 			{
													 				System.out.println(red+id+" is Invalid Customer Id .Please enter a Valid ID"+reset);
													 			}
														 }
													 	else if(choice==3)
														 {
													 		System.out.println("Enter the Account Type to Get All Account Number (SAVING/CURRENT)");
												 			String type=sc.nextLine();
												 			
												 			if("saving".equalsIgnoreCase(type) || "current".equalsIgnoreCase(type))
												 			{
												 				List<String> list=as.retrieveBasedOnType(type);
												 				if(list.size()>0)
												 				{
												 					  System.out.println("\u2554"+ "\u2550".repeat(52) +"\u2557");
																	  System.out.printf("\u2551 %-50s \u2551\n","            ACCOUNT NUMBER BASED ON TYPE");
																	  System.out.printf("\u2551 %-50s \u2551\n","            NUMBER OF ACCOUNT IN BANK :"+list.size());
																	  System.out.println("\u2551" + "\u2550".repeat(52) +"\u2551" );
												 					for(int i=0;i<list.size();i++)
												 					{
												 						System.out.printf("\u2551 %-50s \u2551\n",(i+1)+"."+list.get(i));
												 					}
												 					System.out.println("\u255A" + "\u2550".repeat(52) +"\u255D");
												 				}
												 				else
												 				{
												 					System.out.println(yellow+"\n\nNo account is created in this "+type+" Type"+reset);
												 				}
												 			}
												 			else
												 			{
												 				System.out.println("\n\n"+red+type+"is a Invalid type. Please Give vaid Type"+reset );
												 			}
														 }
													 	else if(choice==4)
														 {
													 		System.out.println("Enter the Customer ID to Delete Your Account");
												 			String id=sc.nextLine();
												 			if(ps.checkIdExists(id))
												 			{
												 				System.out.println(yellow+"\nDo you really want to delete a account (YES/NO)"+reset);
																 String check=sc.next();
																 sc.nextLine();
																 if("yes".equalsIgnoreCase(check))
																 {
																	 if(as.deleteAccount(id))
																	 {
																		 System.out.println("\n\nYour Account has been Deleted");
																	 }
																	 else
																	 {
																		 System.out.println("Refresh your page");
																	 }
																 }
																 else
																 {
																	 System.out.println("\n\nYour account deletion has been canceled");
																 }
												 			}
												 			else
												 			{
												 				System.out.println(red+id+" is Invalid Customer Id .Please enter a Valid ID"+reset);
												 			}
														 }												 	
													 	else if(choice==5)
													 	{
													 		System.out.println("--------------RETURNING TO HOME PAGE-------------");
													 		break;
													 	}
													 
													 
											 }while(true);
											 
											
										 }
									 	else if(choice==3)
										 {
									 		TransactionService ts=new TransactionService();
											 
											 do{
	//												 System.out.println("1. Money Transfer");
	//												 System.out.println("2. Balance Enquiry");
	//											     System.out.println("3. view transaction");
	//												 System.out.println("3. Exit");
												 
												 	System.out.println("\u2554"+ "\u2550".repeat(52) +"\u2557");	
													  System.out.printf("\u2551 %-50s \u2551\n","         📑  TRANSACTION PAGE");
													  System.out.println("\u2551" + "\u2550".repeat(52) +"\u2551" );
													  System.out.printf("\u2551 %-50s \u2551\n","      1.💸 MONEY TRANSFER");
													  System.out.printf("\u2551 %-50s \u2551\n","      2.💰 BALANCE ENQUIRY");
													  System.out.printf("\u2551 %-50s \u2551\n","      3.📊 VIEW TRANSACTION");
													  System.out.printf("\u2551 %-50s \u2551\n","      4.📊 VIEW ALL TRANSACTION");
													  System.out.printf("\u2551 %-50s \u2551\n","      5.🚪 EXIT");
													  System.out.println("\u255A" + "\u2550".repeat(52) +"\u255D");
												 	
													 System.out.println("\nEnter the choice");
													  choice=sc.nextInt();
													 sc.nextLine();
													  	if(choice==1)
														 {
													  		 System.out.println(green+bold+"                        "+"*".repeat(54) );
															  System.out.printf("                        "+"* %-50s *\n","         WELCOME TO MONEY TRANSFER PAGE");
															  System.out.println("                        "+"*".repeat(54) +reset);
															  System.out.println("\nEnter your Account Number");
															  long accountNumber=sc.nextLong();
															  if(ts.checkAccountNumberExists(accountNumber))
															  {
																  System.out.println("Enter the Reciever Account Number");
																  long receiverAccountNumber=sc.nextLong();
																  sc.nextLine();
																  if(ts.checkAccountNumberExists(receiverAccountNumber))
																  {
																	  if(accountNumber!=receiverAccountNumber)
																	  {
																			  System.out.println("Enter the Transaction Type (INTER / INTRA) BANK");
																			  String type=sc.nextLine();
																			  
																			  if("inter".equalsIgnoreCase(type) || "intra".equalsIgnoreCase(type))
																			  {
																				  System.out.println("Enter the Amount ");
																				  double amount=sc.nextDouble();
																				  sc.nextLine();
																				  
																				  System.out.println(yellow+"Confirm your Transaction with amount RS."+amount+"  (YES/NO)"+reset);
																					 String check=sc.next();
																					 sc.nextLine();
																					 if("yes".equalsIgnoreCase(check))
																					 {
																						  Account sender= as.retrieveAccountListForTransaction(accountNumber);
																						  Account receiver= as.retrieveAccountListForTransaction(receiverAccountNumber);
																						  
																						  int res=ts.depositAmount(sender, receiver, type, amount);
																						  
																						  if(res==1)
																						  {
																							  System.out.println(green+"Your Transaction successfully completed\n"+reset);
																							  System.out.println("\nYour Transaction Details :\n\n");
																								List<String> list=ts.retrieveTransactionsListForReceipt(accountNumber);
																								System.out.println("\u2554"+ "\u2550".repeat(52) +"\u2557");	
																								  System.out.printf("\u2551 %-50s \u2551\n","              TRANSACTION RECEIPT");
																								  System.out.println("\u2551" + "\u2550".repeat(52) +"\u2551" );
																								  System.out.printf("\u2551 %-50s \u2551\n","1.TRANSACTION_ID     :"+list.get(0));
																								  System.out.printf("\u2551 %-50s \u2551\n","2.CUSTOMER_NAME      :"+list.get(7));
																								  System.out.printf("\u2551 %-50s \u2551\n","3.ACCOUNT_NUMBER     :"+list.get(8));
																								  System.out.printf("\u2551 %-50s \u2551\n","4.CONTACT_NUMBER     :"+list.get(10));
																								  System.out.printf("\u2551 %-50s \u2551\n","5.TRANSACTION_TYPE   :"+list.get(11));
																								  System.out.printf("\u2551 %-50s \u2551\n","6.AMOUNT             :"+(long)Double.parseDouble(list.get(12)));
																								  System.out.printf("\u2551 %-50s \u2551\n","7.CURREN_BALANCE     :"+(long)Double.parseDouble(list.get(13)));
																								  System.out.printf("\u2551 %-50s \u2551\n","8.TRANSACTION_DATE   :"+list.get(14));
																								  System.out.printf("\u2551 %-50s \u2551\n","9.STATUS             :"+list.get(15));
																								  System.out.println("\u255A" + "\u2550".repeat(52) +"\u255D");
																						  }
																						  else
																						  {
																							  System.out.println(red+"YOUR TRANSACTION FAILED"+reset);
																						  }
																						  
																					 }
																					 else
																					 {
																						 System.out.println(red+"Your Transaction has been canceled"+reset);
																					 }
																			  }
																			  else
																			  {
																				  System.out.println(type+"is a Invalid Type. Please enter a Valid Type");
																			  }
																	  }
																	  else
																	  {
																		  System.out.println(yellow+"Both account number are same. Please give a reciever Account Number"+reset);
																	  }
																	 
																  }
																  else
																  {
																	  System.out.println(red+accountNumber+" is not Exists. Please give a Valid Account Number"+reset);
																  }
															  }
															  else
															  {
																  System.out.println(red+accountNumber+" is not Exists. Please give a Valid Account Number"+reset);
															  }
															  
														 }
													  	else if(choice==2)
														 {
															 System.out.println("Enter the Account Number to check your Balance");
															 long accnumber=sc.nextLong();
															 sc.nextLine();
															 double balance=as.retrieveBalance(accnumber);
															 
															 if(balance==-1)
															 {
																 System.out.println(red+accnumber+" is not Exists. Please give a Valid Account Number"+reset);
															 }
															 else
															 {
																  System.out.println("\u2554"+ "\u2550".repeat(52) +"\u2557");	
																  System.out.printf("\u2551 %-50s \u2551\n","              BALANACE RECEIPT");
																  System.out.println("\u2551" + "\u2550".repeat(52) +"\u2551" );
																  System.out.printf("\u2551 %-50s \u2551\n","1.ACCOUNT_NUMBER     :"+accnumber);
																  System.out.printf("\u2551 %-50s \u2551\n","2.CURRENT_BALANCE     :"+(long)balance);																  
																  System.out.println("\u255A" + "\u2550".repeat(52) +"\u255D");
																  
															 }
														 }
													  	else if(choice==3)
														 {
															 System.out.println("Enter your Transaction ID");
															 String id=sc.nextLine();
															 
															 List<String> list=ts.retrieveTransactionsList(id);
															 
															 if(list!=null)
															 {
																 System.out.println("\nYour Transaction Details for the Given ID:\n\n");																
//																	 
																 
																 System.out.println("\u2554"+ "\u2550".repeat(72) +"\u2557");
																 System.out.printf("\u2551 %-70s \u2551\n","            TRANSACTION DETAILS");
																  System.out.println("\u2551" + "\u2550".repeat(72) +"\u2551" );
																  System.out.printf("\u2551 %-70s \u2551\n","1.TRANSACTION_ID              :"+list.get(0));
																  System.out.printf("\u2551 %-70s \u2551\n","2.CUSTOMER_ID                 :"+list.get(1));
																  System.out.printf("\u2551 %-70s \u2551\n","3.CUSTOMER_NAME               :"+list.get(2));
																  System.out.printf("\u2551 %-70s \u2551\n","4.CONTACT_NUMBER              :"+list.get(3));
																  System.out.printf("\u2551 %-70s \u2551\n","5.ACCOUNT_NUMBER              :"+list.get(4));
																  System.out.printf("\u2551 %-70s \u2551\n","6.ACCOUNT_TYPE                :"+list.get(5));
																  System.out.printf("\u2551 %-70s \u2551\n","7.BANK_NAME                   :"+list.get(6));
																  System.out.printf("\u2551 %-70s \u2551\n","8.SENDER_NAME                 :"+list.get(7));
																  System.out.printf("\u2551 %-70s \u2551\n","9.SENDER_ACCOUNT_NUMBER       :"+list.get(8));
																  System.out.printf("\u2551 %-70s \u2551\n","10.SENDER_BANK_NAME           :"+list.get(9));
																  System.out.printf("\u2551 %-70s \u2551\n","11.SENDER_CONTACT_NUMBER      :"+list.get(10));
																  System.out.printf("\u2551 %-70s \u2551\n","12.TRANSACTION_TYPE           :"+list.get(11));
																  System.out.printf("\u2551 %-70s \u2551\n","13.AMOUNT                     :"+(long)Double.parseDouble(list.get(12)));
																  System.out.printf("\u2551 %-70s \u2551\n","14.CURRENT_BALANCE            :"+(long)Double.parseDouble(list.get(13)));
																  System.out.printf("\u2551 %-70s \u2551\n","15.TRANSACTION_DATE           :"+list.get(14));
																  System.out.printf("\u2551 %-70s \u2551\n","16.STATUS                     :"+list.get(15));																  
																 System.out.println("\u255A" + "\u2550".repeat(72) +"\u255D");
															 }
															 else
															 {
																 System.out.println(red+id+" is not Exists. Please enter a valid ID"+reset);
															 }
														 }
													  	else if(choice==4)
														 {
															 System.out.println("Enter your Account Number");
															 long number =sc.nextLong();
															 sc.nextLine();
															 if(as.checkIdExists(number))
															 {;
															 
																 List<Transactions> list=ts.retrieveTransactionsUsingAccount(number);
																
																 
																 if(list!=null)
																 {
																	 System.out.println("\nYour Transaction Details for the Given ID:\n\n");																
	//																	 
																	 for(int i=0;i<list.size();i++)
																	 {
																		 System.out.println("\u2554"+ "\u2550".repeat(72) +"\u2557");
																		 System.out.printf("\u2551 %-70s \u2551\n","            TRANSACTION DETAILS NO : "+(i+1));
																		  System.out.println("\u2551" + "\u2550".repeat(72) +"\u2551" );
																		  System.out.printf("\u2551 %-70s \u2551\n","1.TRANSACTION_ID              :"+list.get(i).getTransactionId());
																		  System.out.printf("\u2551 %-70s \u2551\n","2.CUSTOMER_ID                 :"+list.get(i).getCustomerId());
																		  System.out.printf("\u2551 %-70s \u2551\n","3.CUSTOMER_NAME               :"+list.get(i).getCustomerName());
																		  System.out.printf("\u2551 %-70s \u2551\n","4.CONTACT_NUMBER              :"+list.get(i).getContactNumber());
																		  System.out.printf("\u2551 %-70s \u2551\n","5.ACCOUNT_NUMBER              :"+list.get(i).getAccountNumber());
																		  System.out.printf("\u2551 %-70s \u2551\n","6.ACCOUNT_TYPE                :"+list.get(i).getAccountType());
																		  System.out.printf("\u2551 %-70s \u2551\n","7.BANK_NAME                   :"+list.get(i).getBankName());
																		  System.out.printf("\u2551 %-70s \u2551\n","8.SENDER_NAME                 :"+list.get(i).getSenderName());
																		  System.out.printf("\u2551 %-70s \u2551\n","9.SENDER_ACCOUNT_NUMBER       :"+list.get(i).getSenderAccountNumber());
																		  System.out.printf("\u2551 %-70s \u2551\n","10.SENDER_BANK_NAME           :"+list.get(i).getSenderBankName());
																		  System.out.printf("\u2551 %-70s \u2551\n","11.SENDER_CONTACT_NUMBER      :"+list.get(i).getSenderContactNumber());
																		  System.out.printf("\u2551 %-70s \u2551\n","12.TRANSACTION_TYPE           :"+list.get(i).getTransactionType());
																		  System.out.printf("\u2551 %-70s \u2551\n","13.AMOUNT                     :"+(long)list.get(i).getAmount());
																		  System.out.printf("\u2551 %-70s \u2551\n","14.CURRENT_BALANCE            :"+(long)list.get(i).getCurrentBalance());
																		  System.out.printf("\u2551 %-70s \u2551\n","15.TRANSACTION_DATE           :"+list.get(i).getTransactionDate());
																		  System.out.printf("\u2551 %-70s \u2551\n","16.STATUS                     :"+list.get(i).getStatus());																  
																		 System.out.println("\u255A" + "\u2550".repeat(72) +"\u255D\n\n");
																	 }
																 }
																 else
																 {
																	 System.out.println(yellow+"\n\n"+number+" in the Account Number. No Transactions has been Done"+reset);
																 }
															 }
															 else
															 {
																 System.out.println(red+number+" is not Exists. Please give a valid Accout number"+reset);
															 }
														 }
													  	else if(choice==5)
														 {
													  		System.out.println("--------------RETURNING TO HOME PAGE-------------");
															 break;
														 }
													 
												 
												 }while(true);
											  
										 }
									 	else if(choice==4)
										 {
									 		CheckBookRequestService cs=new CheckBookRequestService();
											  
											 do {
												 	System.out.println("\u2554"+ "\u2550".repeat(52) +"\u2557");
												 	System.out.printf("\u2551 %-50s \u2551\n","         📓  CHECKBOOK REQUEST PAGE");
												 	System.out.println("\u2551" + "\u2550".repeat(52) +"\u2551" );
													 System.out.printf("\u2551 %-50s \u2551\n","           1.📝 Request Generation");
													 System.out.printf("\u2551 %-49s \u2551\n","           2.❌ Delete Request");
													 System.out.printf("\u2551 %-50s \u2551\n","           3.🚪 Exit");
													 System.out.println("\u255A" + "\u2550".repeat(52) +"\u255D");
													 
													 System.out.println("\nEnter yor choice");
													 choice=sc.nextInt();
													 sc.nextLine();
													 	if(choice==1)
														 {
															  System.out.println("\n------------Check Book Request---------\n");
															  System.out.println("Enter the Account number For Check Book Request");
															  long number=sc.nextLong();
															  String id=cs.retrieveId(number);
															  
															  if(id==null)
															  {
																	  int res=cs.buildCheckBookRequestList(number);
																	  if(res==-1)
																	  {
																		  System.out.println(red+"Your balance is not Sufficient to Apply Checkbook"+reset);
																	  }
																	  else if(res==-2)
																	  {
																		  System.out.println(red+"You not done any Transaction"+reset);
																	  }
																	  else if(res==-3)
																	  {
																		  System.out.println(red+"Your number of transaction is less to Apply CheckBook"+reset);
																	  }
																	  else if(res==-4)
																	  {
																		  System.out.println(red+"\n\nAccount number Not exists\n"+reset);
																	  }
																	  else if(res==1)
																	  {
																		  id=cs.retrieveId(number);
																		  System.out.println(green+"\n\nYour CheckBook Request has been SuccessFully Completed"+reset);
																		  
																		  System.out.println("\n\nYour Request ID is :"+yellow+id+reset);
																	  }
															  }
															  else
															  {
																  System.out.println(yellow+"\n\nYou already given a request for CheckBook and your ID is :"+id+reset);
															  }
															  
														 }
													 	else if(choice==2)
														 {
															  System.out.println("Enter the CheckBookRequest ID to delete");
															  
															  String id=sc.nextLine();
															  
															  System.out.println(yellow+"Do you really want to delete a account (YES/NO)"+reset);
																 String check=sc.next();
																 if("yes".equalsIgnoreCase(check))
																 {
																	 boolean flag=cs.deleteCheckBookRequest(id);
																	 if(flag)
																	 {
																		 System.out.println("Your CheckBookRequest Id has been deleted Successfully");
																	 }
																	 else
																	 {
																		 System.out.println(red+"ID not Exists.Enter a valid ID"+reset);
																	 }
																 }
																 else
																 {
																	 System.out.println("Your checkbookrequest ID deletion has been canceled");
																 }

														 }
													 	else if(choice==3)
														 {
													 		System.out.println("--------------RETURNING TO HOME PAGE-------------");
															 break;
														 }
													 
										 }while(true);
											 
										
										 }
									 	else if(choice==5)
										 {
											 System.out.println("Thank you for reaching us");
											 
											 break;
										 }
									 
							 }while(true);
						 }
						 else
						 {
							 System.out.println(red+"\n\nUser Id or Password is Invalid"+reset);
						 }
						 
	
					}
					 else if(choice==2)
					 {
						 System.out.println(green+bold+" "+ "—".repeat(52) );
						  System.out.printf("│ %-50s │\n","         📝  WELCOME TO REGISTER PAGE");
						  System.out.println(" " + "—".repeat(52)+reset );
						  
						  System.out.println("Enter the Details in the Below Format");
						  System.out.println("\n(NAME : DOB (yyyy/MM/dd) : EMAIL : ADDRESS : CONTACT)\n");
						  String str=sc.nextLine();
						  String []arr=str.split(":");
						  String name=arr[0];
						  String email=arr[2];
						  int res=ps.buildProfileList(str);
						  if(res==-1)
						  {
							  System.out.println(red+"check your Entered format of details"+reset);
						  }
						  else if(res==-2)
						  {
							  System.out.println(red+"Please check your DOB Format"+reset);
						  }
						  else if(res==-3)
						  {
							  System.out.println(red+"Please check your Contact number"+reset);
						  }
						  else if(res==1)
						  {
							  String id=ps.retrieveCustomerId(email);
							  System.out.println("\n--Profile created Successfully--\n\nYour generated Customer Id is :"+bold+underline+yellow+id+"\n\nPlease note your Customer Id"+reset);
							  
							  System.out.println("\nBuild Login Credentials 🔑🔑🔑🔑🔑\n");						  
							  String userName=ls.buildNewLoginId(name);
							  System.out.println("Your generated User Id is "+bold+underline+yellow+userName+reset);
							  
							  System.out.println(yellow+"\n\nPassword must contain atleast one alphabet,one special character,one number .Minimum 8 digit"+reset);
							  
							  do 
							  {
								  System.out.println("\n\nEnter the PassWord");
								  String password=sc.nextLine();
								  if(ls.checkPassword(password))
								  {
									  System.out.println("Enter the Confirm Password");
									  String confirmPassword=sc.nextLine();
									  
									  if(ls.checkBothPassword(password, confirmPassword))
									  {
										  boolean flag=ls.addNewLoginDetails(userName, password,id);
										  if(flag)
										  {
											  System.out.println(green+"\n\nYour Password is Generated Successfully"+reset);
											  break;
										  }
										  else
										  {
											  System.out.println(red+"\n\nYour Password is Generation is Failed"+reset);
										  }
									  }
									  else
									  {
										  System.out.println(red+"Entered Password and Confirm Password are not Same"+reset);
									  }
								  }
								  else
								  {
									  System.out.println(red+"\n\nPlease enter a strong password include digit,alphabet,special character"+reset);
								  }
							  }while(true);
							  
							  
							  
						  }
						  else
						  {
							  System.out.println(red+"\nProfile Creation Failed"+reset);
						  }
					 }
					 else if(choice==3)
					 {
						 System.out.println("\n\nThanks for using our Application"+"\033[31m❤️\033[0m"+"\033[31m❤️\033[0m"+"\033[31m❤️\033[0m");
						 break;
					 }
				  
			 }while(true);
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}









