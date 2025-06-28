package com.structure;

public class Todo {
	private int id;
	private String title;
	private String description;
	private Boolean status;
	private int userId;
	private java.sql.Date dueDate;

	//Getter & Setters
	
	public java.sql.Date getDueDate() {
	    return dueDate;
	}

	public void setDueDate(java.sql.Date dueDate) {
	    this.dueDate = dueDate;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
