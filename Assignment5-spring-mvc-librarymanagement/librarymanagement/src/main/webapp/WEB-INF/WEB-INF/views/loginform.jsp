<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String err = (String) request.getAttribute("err");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<fieldset>
		<legend>Author Login</legend>
		<form action="./home" method="post">
			<table>
				<tr>
					<td><label>Enter the Id:</label></td>
					<td><input type="number" name="id" placeholder="username">
					</td>
				</tr>
				<tr>
					<td><label>Enter the Password:</label></td>
					<td><input type="password" name="password"
						placeholder="password"></td>
				</tr>

			</table>
			<input type="submit" value="Login"> <br> <br>
			
			<small> <a href="./forgotpass">Forgot password?</a> </small>
			<%
			if (err != null && !err.isEmpty()) {
			%>
			<p style="color: red"><%=err%></p>
			<%
			}
			%>
			

		</form>
	</fieldset>
</body>
</html>