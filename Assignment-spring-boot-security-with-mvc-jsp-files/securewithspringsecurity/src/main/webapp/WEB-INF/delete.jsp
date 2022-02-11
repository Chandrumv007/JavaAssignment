
<%@page import="com.te.securewithspringsecurity.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@include file="navbar2.jsp"%>
<%
String msg =(String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>delete</title>
</head>
<body>
<br>
<form action="./delete" method="post">
<label>Enter id</label>
<input type="number" name="id">
<input type="submit" value="Delete">
</form>
<br>

<%if(msg!=null && !msg.isBlank()){ %>
<h1><%=msg %></h1>
<%} %>
</body>
</html>