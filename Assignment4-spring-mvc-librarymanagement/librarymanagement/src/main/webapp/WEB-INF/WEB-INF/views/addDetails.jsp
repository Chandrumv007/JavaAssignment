<%@page import="com.te.librarymanagement.bean.Author"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="navbar.jsp" %>
    <%String msg=(String) request.getAttribute("msg");
    Author author=(Author) request.getAttribute("author");
    String err=(String) request.getAttribute("err");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
            <%
			if (msg != null && !msg.isEmpty()) {
			%>
			<h4 style="color: green"><%=msg%></h4>
			<%
			}
			%>
			<%
			if (err != null && !err.isEmpty()) {
			%>
			<h4 style="color: red"><%=err%></h4>
			<%
			}
			%>
		<legend>Add Books</legend>
		<form action="./add" method="post">
			<table>
				<tr>
					<td><label>Enter the Book Id:</label></td>
					<td><input type="number" name="id">
					</td>
				</tr>
				<tr>
					<td><label>Enter the Book Name:</label></td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td><label>Enter the Book Author:</label></td>
					<td><input type="text" name="authorname" value="<%=author.getName()%>" disabled="disabled"></td>
				</tr>
				<tr>
					<td><label>Enter the Book Price:</label></td>
					<td><input type="number" name="price"></td>
				</tr>

			</table>
			<input type="submit" value="Add Book"> <br>
			</form>
</fieldset>
</body>
</html>