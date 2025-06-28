package com.workers;

import java.io.IOException;
import com.structure.*;
import com.dao.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addTodo")
public class addTodo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (userId == null) {
            response.sendRedirect("Login.jsp");
            return;
        }
        System.out.println("Session userId: " + userId);


        Todo todo = new Todo();
        todo.setUserId(userId);
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setStatus(false);
        String dueDateStr = request.getParameter("dueDate");
        java.sql.Date dueDate = java.sql.Date.valueOf(dueDateStr);
        todo.setDueDate(dueDate);


        TodoDAO dao = new TodoDAO();
        try {
            dao.addTodo(todo);
            // redirect to App_Worker
            response.sendRedirect("App_Worker");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error adding todo: " + e.getMessage()); //In case we get error we can know what is the error by e.getMessage()
        }
    }
}


