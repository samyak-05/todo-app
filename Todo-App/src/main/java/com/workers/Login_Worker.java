package com.workers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.structure.*;
import com.dao.*;

@WebServlet("/Login")
public class Login_Worker extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("uname");
        String password = request.getParameter("pass");

        UserDAO dao = new UserDAO();
        try {
            User user = dao.login(username, password);
            if (user != null) {
                // store BOTH:
                HttpSession session = request.getSession();
                session.setAttribute("userId", user.getId());           // CRUCIAL
                session.setAttribute("username", user.getUsername());
                response.sendRedirect("App_Worker");
            } else {
                request.getSession().setAttribute("loginError", "Invalid credentials");
                response.sendRedirect("Login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


