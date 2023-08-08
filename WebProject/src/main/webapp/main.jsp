<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link rel="stylesheet" href="mainstyle.css">
</head>

<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("Email")==null)
	{
		response.sendRedirect("login.html");
	}
	%>
	<div class="menu_bar">
		<div id="img"><img alt="SK" src="" ></div>
		<div id="h"><a href="index.jsp">Home</a></div>
        <div id="p"><a href="profile">Profile</a></div>
        <div id="a"><a href="about">about</a></div>
		<div id="l"><form action="logout"><input type="submit" value="logout"></form>
		</div>
	</div>
</body>
</html>