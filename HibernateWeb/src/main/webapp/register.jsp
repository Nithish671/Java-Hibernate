<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.UserDao" %>
<jsp:useBean id ="obj1" class="com.example.User"></jsp:useBean>
<jsp:setProperty property="name" name="obj1" />
<jsp:setProperty property="email" name="obj1" />
<jsp:setProperty property="password" name="obj1" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<% 
int i = UserDao.register(obj1);
if(i > 0) {
	out.print("<p>You are successfully registered!</p>");
} else {
	out.print("<h2>Registration Failed!</h2>");
}
%>
<p><a href="index.jsp">Return to Registration Page!</a></p>
</body>
</html>