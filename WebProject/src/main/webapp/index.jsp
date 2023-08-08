<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    if(session.getAttribute("Email")==null)
	{
		response.sendRedirect("login.html");
	}
	else
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.sendRedirect("main.jsp");
	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
	
</body>
</html>