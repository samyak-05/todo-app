package com.dao;
import com.structure.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import java.sql.*;

public class UserDAO {
	
	String url="jdbc:mysql://localhost:3306/todo";
	String user="root";
	String password="Password";
	
	private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
	
	public Boolean register(User user) throws Exception{
		String query="Insert Into users (username, password) Values(?,?)";
		try(Connection con =getConnection(); PreparedStatement pst= con.prepareStatement(query); ){
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.executeUpdate();
			return true;
		}
		
		catch(SQLIntegrityConstraintViolationException e) {
			return false;
		}
	}
	
	public User login(String username, String password) throws Exception {
	    String query="SELECT * FROM users WHERE username=? AND password=?";
	    try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
	        pst.setString(1, username);
	        pst.setString(2, password);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            User user = new User();
	            user.setId(rs.getInt("id"));  // <<<<<< add this line
	            user.setUsername(rs.getString("username"));
	            return user;
	        }
	        return null;
	    }
	}


}
