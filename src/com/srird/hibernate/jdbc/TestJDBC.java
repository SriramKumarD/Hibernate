package com.srird.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String args[]) {
		String jdbcurl = "jdbc:mysql://127.0.0.1:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pwd = "hbstudent";
		
		try {
			
			System.out.println("Connecting to JDBC.....");
			
			Connection myConn = DriverManager.getConnection(jdbcurl, user, pwd);
			
			System.out.println("Connection is successfull.....");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
