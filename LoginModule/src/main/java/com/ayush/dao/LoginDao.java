package com.ayush.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	public boolean authenticate(String username, String password) {
		
		String url = "jdbc:mysql://localhost:3306/LoginModule";
		String dbUser = "root";
		String dbPassword = "1234";
		try {
			String query = "select * from login where username = \"" + username + "\" and password = \"" + password + "\"";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
			PreparedStatement st = con.prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		return false;
	}
}
