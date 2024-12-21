package com.management;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionManager 
{
	public static Connection getConnection()
	{
		Connection con=null;
		
		
		try(FileReader fr=new FileReader("database.properties"))
		{
			Properties p=new Properties();
			p.load(fr);
			
			Class.forName(p.getProperty("DB_DRIVER_CLASS"));
			
			con=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PASSWORD"));
		}
		catch(SQLException | IOException |ClassNotFoundException  e) 
		{
			System.out.println(e.getMessage());
		}
		
		return con;
	}
}
