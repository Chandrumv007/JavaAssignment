<%@page import="com.te.securewithspringsecurity.dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="navbar.jsp"%>
<%
List<User> data =(List<User>) request.getAttribute("users");
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
 <th>Password</th> 
  <th>Role</th> 

</tr>
<%
	for (User list : data) {
	%>
	<tr>
	<td><%=list.getUserId()%></td>
	<td><%=list.getUserName()%></td>
	<td><%=list.getUserPassword()%></td>
	<td><%=list.getUserRole()%></td>
	</tr>
	<%
	}
	%>
</table>
	
</body>
</html>