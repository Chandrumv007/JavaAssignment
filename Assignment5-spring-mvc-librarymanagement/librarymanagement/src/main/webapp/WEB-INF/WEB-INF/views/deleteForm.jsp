<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="navbar.jsp"%>
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>
	<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<h4 style="color: green"><%=msg%></h4>
	<%
	}
	%>

	<form action="./delete" method="post">
		<label>Enter the Book id:</label> 
		<input type="number" name="id">
		<input type="submit" value="Delete">
	</form>

</body>
</html>