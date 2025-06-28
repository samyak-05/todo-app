package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.structure.Todo;

public class TodoDAO {
	String user="root";
	String password="Password";
	String url="jdbc:mysql://localhost:3306/todo";
	
	/*Creates Connection and can be used whenever required.*/
	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url,user,password);
		
	}
	
	/*Function to collect data from database regarding  TODOS.*/
	public List<Todo> getTodos(int userId) throws Exception{
		List<Todo> data = new ArrayList<>();
		String query="Select * from todos where user_id=?";
		try(Connection con= getConnection(); PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, userId);
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				Todo todo = new Todo();
				todo.setId(rs.getInt("id"));
                todo.setUserId(userId);
                todo.setTitle(rs.getString("title"));
                todo.setDescription(rs.getString("description"));
                todo.setStatus(rs.getBoolean("status"));
                todo.setDueDate(rs.getDate("due_date"));
                data.add(todo);
			}
			
			
		}
		
		return data;
		
	}
	
	/*Function to add a new TODO into database. */
	public void addTodo(Todo todo) throws Exception {
		String query = "INSERT INTO todos (title, description, due_date, status, user_id) VALUES (?, ?, ?, ?, ?)";
		try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
			pst.setString(1, todo.getTitle());
			pst.setString(2, todo.getDescription());
			pst.setDate(3, todo.getDueDate());
			pst.setBoolean(4, todo.getStatus());
			pst.setInt(5, todo.getUserId());

            pst.executeUpdate();
        }
	}

	//Function to delete a TODO from exsisting database
	
	public void deleteTodo(int id) throws Exception{
		String query="Delete from todos where id=?";
		try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
	}
}
