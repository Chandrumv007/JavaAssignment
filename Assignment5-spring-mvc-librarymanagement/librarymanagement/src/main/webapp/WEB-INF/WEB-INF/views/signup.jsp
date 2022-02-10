<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
    String err=(String) request.getAttribute("err");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
			
		<legend>Author SignUp</legend>
		<form action="./Home" method="post">
			<table>
				<tr>
					<td><label>Enter the Id:</label></td>
					<td><input type="number" name="id">
					</td>
				</tr>
				<tr>
					<td><label>Enter the Name:</label></td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td><label>Enter the Password:</label></td>
					<td><input type="password" name="password"></td>
				</tr>

			</table>
			<input type="submit" value="Sign Up"> <br>
			</form>
			<%
			if (err != null && !err.isEmpty()) {
			%>
			<h4 style="color: red"><%=err%></h4>
			<%
			}
			%>
</fieldset>
</body>
</html>