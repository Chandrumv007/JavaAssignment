
<%@page import="com.te.securewithspringsecurity.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@include file="navbar.jsp"%>
<%
User data =(User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
<style type="text/css">
table,td,th,tr{
      border: 2px solid rgba(0,0,0,0.5);
      border-collapse: collapse;
}
</style>
</head>
<body>
<br>
<br>
<form action="./seeById" method="post">
<label>Enter id</label>
<input type="number" name="id">
<input type="submit" value="Submit">
</form>


<%if(data!=null){ %>
<h1>User Details</h1>
<table>
<tr>
 <th>Id</th> 
 <th>Name</th> 
 <th>Password</th> 
  <th>Role</th> 

</tr>
	<tr>
	<td><%=data.getUserId()%></td>
	<td><%=data.getUserName()%></td>
	<td><%=data.getUserPassword()%></td>
	<td><%=data.getUserRole()%></td>
	</tr>
</table>
	<%} %>
</body>
</html>