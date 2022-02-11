<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="navbar2.jsp" %>
    <% String name=(String) request.getAttribute("name");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1 align="center">Welcome <%=name %> To Home Page</h1>
</body>
</html>