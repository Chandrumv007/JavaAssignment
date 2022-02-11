<%@page import="java.util.List"%>
<%@page import="com.te.librarymanagement.bean.LibraryBooks"%>
<%@page import="com.te.librarymanagement.bean.Author"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="navbar.jsp"%>
<%
String msg = (String) request.getAttribute("msg");
List<LibraryBooks> books = (List<LibraryBooks>) request.getAttribute("books");
Author author = (Author) request.getAttribute("author");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update details</title>
</head>
<body>
	<h3>Note:Only Your Book Details Can Be Changed Here</h3>

	<form action="./update" method="post">
		<table>
			<tr>
				<td><label> Author Id:</label></td>
				<td><input type="number" value="<%=author.getId()%>"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td><label> Book Id:</label></td>
				<td><select name="id">
						<option>select book id</option>
						<%
						for (LibraryBooks list : books) {
						%>
							<option value="<%=list.getId()%>"><%=list.getId()%></option>
						<%
						}
						%>
						<option value=""></option>

				</select></td>
			</tr>
			<tr>
				<td><label>Enter Book Name to Update:</label></td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><label>Enter Book Author to Update:</label></td>
				<td><input type="text" name="authorname" value="<%=author.getName()%>" disabled="disabled"></td>
			</tr>
			<tr>
				<td><label>Enter Book Price to Update:</label></td>
				<td><input type="number" name="price"></td>
			</tr>
		</table>
		<input type="submit" value="Update"> <br>
		<%
		if (msg != null && !msg.isEmpty()) {
		%>
		<h4><%=msg%></h4>
		<%
		}
		%>
		<br> <br>
	</form>




</body>
</html>