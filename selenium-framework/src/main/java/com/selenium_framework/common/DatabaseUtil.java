package com.selenium_framework.common;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mongodb.connection.Connection;

public class DatabaseUtil 
{
    Connection getConnection() throws SQLException
    {
	     Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("dbUrl", "admin", "admin");
	     
	     Statement stmt = con.createStatement();
	     ResultSet rs = stmt.executeQuery("Select * from users");
	     String UserName = rs.getString("userName");
	     
    }
    catch(Exception ex)
    	{
    	ex.printStackTrace();
    	System.out.println(ex.getMessage());
    	}
    
    (con.isClosed())
    {
    	System.out.println("***************Connection is closed**********");
    }

}
}