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
<title>All User Info</title>
<style type="text/css">
table,td,th,tr{
      border: 2px solid rgba(0,0,0,0.5);
      border-collapse: collapse;
}
</style>
</head>
<body>
<h1>User Details</h1>
<table>
<tr>
 <th>Id</th> 
 <th>Name</th> 
 <th>Age</th> 
 <th>Address</th> 
 <th>User Name</th> 
 <th>User Password</th>
  <th>Role</th> 

</tr>
	<tr>
	<td><%=data.getUserId()%></td>
	<td><%=data.getUserRealName()%></td>
	<td><%=data.getUserAge()%></td>
	<td><%=data.getUserAddress()%></td>
	<td><%=data.getUserName()%></td>
	<td><%=data.getUserPassword()%></td>
	<td><%=data.getUserRole()%></td>
	</tr>

</table>
	
</body>
</html>