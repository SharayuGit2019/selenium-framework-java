package com.selenium_framework.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseUtil 
{ 
	
    public  void getConnection() throws SQLException, ClassNotFoundException
    {
	     Class.forName("oracle.jdbc.driver.OracleDriver");
	     Connection con = DriverManager.getConnection("dbUrl", "admin", "admin");
	     
	     Statement stmt = con.createStatement();
	     ResultSet rs = stmt.executeQuery("Select * from users");
	     String UserName = rs.getString("userName");     
	}
}