package com.workers;

import java.io.IOException;
import java.util.List;

import com.structure.*;
import com.dao.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class App_Worker
 */
@WebServlet("/App_Worker")
public class App_Worker extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (userId == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        TodoDAO dao = new TodoDAO();
        try {
        	List<Todo> todos = dao.getTodos(userId);
        	request.setAttribute("todos", todos);
        	request.getRequestDispatcher("App.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error loading todos: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // handles both GET and POST the same
    }
}




