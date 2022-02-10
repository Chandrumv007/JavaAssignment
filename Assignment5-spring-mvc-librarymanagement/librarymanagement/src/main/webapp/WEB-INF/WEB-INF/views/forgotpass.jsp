<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
boolean check = (boolean) request.getAttribute("msg");
String msg = (String) request.getAttribute("err1");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>reset password</title>
</head>
<body>
	<form action="./forgotpass" method="post">
		<table>
			<tr>
				<td><label>Id:</label></td>
				<td><input type="number" name="id"></td>
			</tr>
			<tr>
				<td><label>Enter Password to Update:</label></td>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<input type="submit" value="Change"> <br>
		<%
		if (msg != null && !msg.isEmpty()) {
		%>
		<label style="color: red"><%=msg%></label>
		<%
		}
		%>
		<br>
		<%
		if (check != false) {
		%>
		<label>password succesfully resetted go to <a href="./login">login</a></label>
		<%
		}
		%>

	</form>
</body>
</html>