<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="Login.css">
</head>
<body>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<%
    String error = (String) session.getAttribute("loginError");
    if (error != null) {
%>
    <p style="color:red;"><%= error %></p>
<%
        session.removeAttribute("loginError"); // clear after showing
    }
%>



<header>
	Todo-App
</header>

<main>
	<form action="Login" method="post">
    <h1>Login!</h1>
    
    <label for="uname">Username: </label>
    <input type="text" id="uname" name="uname" required autocomplete="off">
    
    <label for="pass">Password: </label>
    <input type="password" id="pass" name="pass" required>
    
    <button>Submit</button>
    
    <p class="register-link">
        New user? <a href="Register.jsp">Register here</a>
    </p>
</form>
</main>
	
</body>
</html>