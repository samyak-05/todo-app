<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Todo</title>
<link rel="stylesheet" href="addTodo.css">
</head>
<body>



<%
//To check if a user is logged-in or not
  Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (userId == null) {
            response.sendRedirect("Login.jsp");
            return;
        }
%>

<header>
    Todo-App
</header>

<main>
    <form action="addTodo" method="post">
        <h2>Add Todo</h2>
        
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>
        
        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea>
        
        <label for="dueDate">Due Date:</label>
		<input type="date" id="dueDate" name="dueDate" required>
        
        
        <button type="submit">Add</button>
    </form>
</main>

</body>
</html>
