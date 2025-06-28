<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<link rel="stylesheet" href="Register.css">
</head>
<body>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>

<header>
    Todo-App
</header>

<main>
    <form action="Register" method="post">
        <h2>Register</h2>
        
        <label for="uname">Username:</label>
        <input type="text" name="uname" id="uname" required>
        
        <label for="pass">Password:</label>
        <input type="password" name="pass" id="pass" required>
        
        <input type="submit" value="Register">
        
        <% if (request.getParameter("error") != null) { %>
            <p class="error-msg">Username already exists.</p>
        <% } %>
        
        <p class="register-link">
            Already have an account? <a href="Login.jsp">Login here</a>
        </p>
    </form>
</main>

</body>
</html>
