package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ApplicationUtil 
{
	 public List<String> splitDetails(String str)
	 {
		 List<String> list=new ArrayList<String>();
		 String [] arr=str.split(":");
		 if(arr.length==5)
		 {
			 list=Arrays.asList(arr);
		 }
		 else
		 {
			 list=null;
		 }
		 return list;
	 }
	 
	 public String dateFormat(String date)
	 {
		 Date dobj=null;
		 String formatdate="";
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		 try {
//			 sdf.setLenient(false);
		 dobj=sdf.parse(date);
		 formatdate=sdf.format(dobj);
		 if(!(date.equals(formatdate)))
		 {
			 formatdate=null;
		 }
		 
		 }
		 catch(ParseException e)
		 {
			 e.printStackTrace();
		 }
		 return formatdate;
	 }
	 
	 public boolean checkPasword(String password)
	 {
		 boolean flag=false;
			
			if(password.length()>=8)
			{
				Pattern p=Pattern.compile("[@#$*&+!]");
				Matcher m=p.matcher(password);
				int special=0;
				while(m.find())
				{
					special++;
				}
				if(special>0)
				{
					p=Pattern.compile("[0-9]");
					m=p.matcher(password);
					int number=0;
					while(m.find())
					{
						number++;
					}
					if(number>0)
					{
						p=Pattern.compile("[a-zA-Z]");
						m=p.matcher(password);
						int alpha=0;
						while(m.find())
						{
							alpha++;
						}
						if(alpha>0)
						{
							flag=true;
						}
					}
				}
			}
			
			return flag;
			
	 }



	 // meenatchi

	 public  String generateTransactionId()
	 {
		     Random rand=new Random();
	        long timestamp = System.currentTimeMillis(); 
	        int randomNum = rand.nextInt(1000); 
	        return "TRANS" + timestamp + randomNum;
	  }
		
	
//	 public java.sql.Date convertSqlDate(java.util.Date obj){
//			java.sql.Date d1=new java.sql.Date(obj.getTime());
//			return d1;
//		}
//	 if (dobj == null) {
////	        throw new IllegalArgumentException("Input date cannot be null");
////	    }
//	 public String convertStringDate(java.sql.Date obj)
//	 {
//			return obj.toString();
//	}
//	 public String utilToString(java.util.Date d) {
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//			String date=sdf.format(d);
//			return date;
//		}
//	 public java.util.Date convertUtilDate(String date){
//		 
//			java.util.Date obj=null;
//			try {
//				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//				obj=sdf.parse(date);
//						
//			} 
//			catch (ParseException e) {
//				
//				e.printStackTrace();
//			}
//			return obj;
//		}
	 public String getCurrentDate(){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date obj=new java.util.Date();
			String date=sdf.format(obj);
			return date;
		}


}
