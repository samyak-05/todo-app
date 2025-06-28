package com.workers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.*;
import com.structure.*;

@WebServlet("/Register")
public class Register_Worker extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("uname");
		String password=request.getParameter("pass");
		
		User user= new User();
		
		user.setUsername(username);
		user.setPassword(password);
		
		UserDAO client = new UserDAO();
		
		try {
			Boolean registered= client.register(user);
			if(registered) {
				response.sendRedirect("Login.jsp");
			}
			else {
				response.sendRedirect("register.jsp?error=username");
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
