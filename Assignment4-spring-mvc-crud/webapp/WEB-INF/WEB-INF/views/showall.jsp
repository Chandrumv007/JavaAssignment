<%@page import="com.te.librarymanagement.bean.LibraryBooks"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="navbar.jsp"%>
<%
List<LibraryBooks> data =(List<LibraryBooks>) request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>all employee data</title>
<style type="text/css">
table,td,th,tr{
      border: 2px solid rgba(0,0,0,0.5);
      border-collapse: collapse;
}
</style>
</head>
<body>
<h1>Employee Details</h1>
<table>
<tr>
 <th>Book Id</th> 
 <th>Book Name</th> 
 <th>Book Author</th> 
 <th>Book Price</th> 

</tr>
<%
	for (LibraryBooks list : data) {
	%>
	<tr>
	<td><%=list.getId()%></td>
	<td><%=list.getName()%></td>
	<td><%=list.getAuthorname()%></td>
	<td><%=list.getPrice()%></td>
	</tr>
	<%
	}
	%>
</table>
	
</body>
</html>