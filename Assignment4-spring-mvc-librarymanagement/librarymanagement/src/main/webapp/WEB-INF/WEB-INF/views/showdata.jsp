
<%@page import="com.te.librarymanagement.bean.LibraryBooks"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="navbar.jsp"%>
<%
String msg = (String) request.getAttribute("msg");
 LibraryBooks book=(LibraryBooks) request.getAttribute("data");
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
	if (msg!= null && !msg.isEmpty()) {
	%>
	<h4 style="color: red"><%=msg%></h4>
	<%
	}
	%>

	<form action="./showdata" method="post">
		<label>Enter the id:</label> 
		<input type="number" name="id">
		<input type="submit" value="Fetch Data">
	</form>
	<%
	if (book!= null) {
	%>
	<h4 >Book Id is: <%=book.getId()%></h4>
	<h4 >Book Name is: <%=book.getName()%></h4>
	<h4 >Book Author is: <%=book.getAuthorname()%></h4>
	<h4 >Book Price is: <%=book.getPrice()%></h4>
	<%
	}
	%>
	

</body>
</html>