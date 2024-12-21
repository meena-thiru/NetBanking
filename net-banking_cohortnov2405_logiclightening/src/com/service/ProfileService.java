 
package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.management.LoginManagement;
import com.management.ProfileManagement;
import com.model.Profile;
import com.util.ApplicationUtil;

public class ProfileService {

	 ProfileManagement pm=new ProfileManagement();
	 LoginManagement lm=new LoginManagement();
	 ApplicationUtil au=new ApplicationUtil();
	 
	 public int buildProfileList(String str)
	 {
		 int res=0;
			 List<String>list =au.splitDetails(str);
			 if(list==null)
			 {
				 return -1;
			 }
			 
			 String name=list.get(0);		 
			 String dob=au.dateFormat(list.get(1)); 			 
			 String email=list.get(2);			
			 String address=list.get(3);
			 String contact=list.get(4);	
			 
			 if(dob==null)
			 {
				 return -2;
			 }
			 else if(!contact.matches("^[9876][0-9]{9}"))
			 {
				 return -3;
			 }
			 
//generating customer id
			 String customerId=generateCustId();
//creating profile object			 
			 Profile p=new Profile(customerId,name,dob,email,address,Long.parseLong(contact));
// adding profile to database			 
			 if(addProfileList(p))
			 {
				 res=1;
			 }
			 
		 
		 return res;
	 }
	 
// method for add profile to database  
	 public boolean addProfileList(Profile p)
	 {
		return pm.addProfile(p);
	 } 	 
	 
// generate customer id method
	 public String generateCustId()
	 {
		 String id="";
//		 Random rand=new Random();
		 String retrieve=pm.retrieveCount();
		 id="CUS000";
		 
		 if(retrieve!=null)
		 {
			 long num=Long.parseLong(retrieve.substring(6));
			 id=id+ (++num);
		 }
		 else
		 {
			 id=id+ 1;
		 }
//		 if(checkIdExists(id))
//		 {
//			 return generateCustId( name, dob);
//		 }
		 
		 
		 return id;
	 }
// check whether id exists or not in database
	 public boolean checkIdExists(String id)
	 {		 
		 return pm.checkIdExists(id);		  
	 }
	 
// updating address in profile - method
	 public boolean updateEmailInProfile(String id,String detail)
	 {
		
			return pm.updateEmailInProfile(id, detail);
	 }
	 public boolean updateAddressInProfile(String id,String detail)
	 {
		
			return pm.updateAddressInProfile( id, detail);
	 }
	 
	 public boolean updateContactInProfile(String id,long detail)
	 {
		
			return pm.updateContactInProfile( id, detail);
	 }
	 
	 public Profile retrieveProfileDetails(String name)
	 {
		 Profile p=null;
		
		 String id=retrieveCustomerIdFromLogin(name);
//		 if(checkIdExists(id))
//		 {
			 p=pm.retrieveProfileDetails(id);
			 
//			 res="Customer Id : "+p.getCustomerId()+"\nCustomer Name :"+p.getCustomerName()+"\nCustomer DOB :"+p.getDob()+"\nEmail :"+p.getEmailId()+"\nAddress :"+p.getAddress()+"\nContact Number :"+p.getContactNumber();
//		 }
//		 else
//		 {
//			 res= "Customer Id not Exists. Please check Entered Id";
//		 }
		 return p;
	 }
	 
	 public String retrieveCustomerIdFromLogin(String name)
	 {
		 return lm.retrieveCustomerId(name);
	 }
	 
	 public String retrieveCustomerId(String email)
	 {
		 return pm.retrieveCustomerId(email);
	 }
	 
	 
	 public String deleteProfileDetails(String id)
	 {
		 String res="";
		 

			 boolean flag= pm.deleteProfileDetails(id);
			 
			 if(flag)
			 {
				 res="The Details of the given Customer Id is Successfully Deleted";
			 }
			 else
			 {
				 res="Something went Wrong";
			 }

		 return res;
	 }
	 
	 
	
	 
	 public Profile retrieveProfileList(String id)
	 {
		 Profile p=null;
		 if(checkIdExists(id))
		 {
			 p=pm.retrieveProfileDetails(id);
		 }
		 return p;
	 }
	 
}
