Todo-App
========

A simple Todo Application built with JSP, Servlets, and JDBC following the MVC architecture. It supports user login, registration, and personal todo management.

------------------------------------------------------------

Tech Stack
----------
- Java (JSP & Servlets)
- JDBC (MySQL Database)
- HTML, CSS, JavaScript
- Apache Tomcat
- MySQL

------------------------------------------------------------

Features
--------
- User Registration & Login
- Add, Edit, Delete Todos
- Mark Todos as Completed
- Session-based user management
- Simple and intuitive UI

------------------------------------------------------------

Project Structure
-----------------
.
├── src/
│   └── (Servlet Java files)
├── WebContent/
│   ├── css/
│   ├── js/
│   └── jsp/
│       └── (JSP views)
├── WEB-INF/
│   └── web.xml
└── SQL/
    └── (database schema.sql)

------------------------------------------------------------

Getting Started
---------------
If you want to fork or clone this repository and run it locally, follow these steps:

1) Prerequisites:
   - JDK 8 or higher
   - Apache Tomcat 9 or higher
   - MySQL Server
   - MySQL Workbench (optional)
   - Any Java IDE (Eclipse or IntelliJ recommended)

2) Database Setup:
   - Open MySQL Workbench or command-line
   - Create a database:
     CREATE DATABASE todo_app;
   - Import the schema.sql from the SQL/ directory into your database
   - Update DB credentials in your Java code (DAO or database utility classes)

3) Running the App:
   - Import the project in your IDE
   - Configure Apache Tomcat
   - Clean and build the project
   - Deploy to Tomcat
   - Visit: http://localhost:8080/todo-app (context path may vary)

------------------------------------------------------------

Fork and Contribute
--------------------
- Click Fork on GitHub
- Clone your fork:
  git clone https://github.com/YOUR_USERNAME/todo-app.git
- Create a new branch:
  git checkout -b my-feature
- Make your changes
- Commit and push:
  git add .
  git commit -m "Add my feature"
  git push origin my-feature
- Open a Pull Request with your changes

------------------------------------------------------------

Contributing
------------
Contributions are welcome! Feel free to:
- Open issues for bugs or new ideas
- Fork and submit pull requests
- Suggest new features

------------------------------------------------------------

Troubleshooting
---------------
- 404 or 500 errors?
  -> Ensure Tomcat is running and database connection is correct
- Database errors?
  -> Make sure MySQL is up and the schema is imported
- Port conflicts?
  -> Change the port in Tomcat's server.xml

------------------------------------------------------------

Contact
-------

https://github.com/user-attachments/assets/fe29c1f8-9947-41f4-a72b-05f7d987f61f


Author: Samyak Nigam
LinkedIn: https://www.linkedin.com/in/samyak-nigam-11in/
Email: samyaknigam.11@gmail.com

------------------------------------------------------------

Show Your Support
-----------------
If you like this project, please star the repository and share it — it really helps! 🚀

