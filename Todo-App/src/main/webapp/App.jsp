<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.structure.Todo" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Todo App</title>
  <link rel="stylesheet" href="App.css">
  <script src="App.js"></script>      <!-- link to separate JS file -->
</head>
<body>
<%
    Integer userId = (Integer) session.getAttribute("userId");
    if (userId == null) {
        response.sendRedirect("Login.jsp");
        return;
    }
    String username = (String) session.getAttribute("username");

    @SuppressWarnings("unchecked")
    List<Todo> todos = (List<Todo>) request.getAttribute("todos");

    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //To ensure that once we logout this page cant be accessed again
%>
<header>
  <div class="app-title">Todo-App</div>
  <div class="user-name">Welcome Back, <span class="uname"><%= username %></span></div>
  <form action="LogOut" method="post" style="margin:0;">
    <button class="Logout">Logout</button>
  </form>
</header>

<main>
  <section class="todo-list">
    <h2>Your Todos</h2>
    <table>
      <thead>
        <tr>
          <th>Title</th>
          <th>Description</th>
          <th>Due Date</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
      <% if (todos != null && !todos.isEmpty()) {
           for (Todo t : todos) { %>
        <tr id="row-<%= t.getId() %>">
          <td><%= t.getTitle() %></td>
          <td><%= t.getDescription() %></td>
          <td><%= t.getDueDate() != null ? t.getDueDate() : "N/A" %></td>
          <td>
            <button type="button" class="delete-btn" onclick="deleteTodo(<%= t.getId() %>)">Delete</button>
            
          </td>
        </tr>
      <%   }
         } else { %>
        <tr><td colspan="4">No todos yet. Go ahead and add one!</td></tr>
      <% } %>
      </tbody>
    </table>
    <br>
    <a href="AddTodo.jsp" class="add-btn">+ Add New Todo</a>
  </section>
</main>

</body>
</html>
