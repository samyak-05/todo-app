package com.workers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;
@WebServlet("/deleteTodo")
public class deleteTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		TodoDAO obj = new TodoDAO();
		try {
			obj.deleteTodo(id);
			request.getRequestDispatcher("App_Worker").forward(request, response);

		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
