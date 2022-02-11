<%@page import="com.te.securewithspringsecurity.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
User user =(User) request.getAttribute("user");
    String msg=(String) request.getAttribute("msg");
%>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Update Details</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link rel="stylesheet" href="./form.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
    integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">

<style type="text/css">
body{
      background-color: lightseagreen;
      display: flex;
      align-items: center;
      justify-content: center;
      min-height: 100vh;

}
.container{
      background-color: white;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0,0,0,0.3);
      width: 400px;
      max-width: 100%;
  }
</style>
</head>

<body>
  <div class="container">
    <div class="header">
      <h4>Update Details</h4>
    </div>
    <form class="form" id="form" action="/update" method="post">


      <div class="form1">
        <label >User Id</label>
        <input type="number" class="form-control"  value="<%=user.getUserId() %>" disabled="disabled"  name="UserId">
      </div>
      <div class="form1">
        <label>Name</label>
        <input type="text" class="form-control"  name="userRealName" onkeypress="return /[a-z]/i.test(event.key)" >
      </div>
      <div class="form1">
        <label>Age</label>
        <input type="number" class="form-control"  name="userAge">
      </div>
      <div class="form1">
        <label>Address</label>
        <input type="text" class="form-control"  name="userAddress">
      </div>
      <div class="form1">
        <label>User Name</label>
        <input type="text" class="form-control" value="<%=user.getUserName() %>" disabled="disabled" name="userName">
      </div>  
      
      <div class="form1">
        <label for="role">Role</label> <br>
      <input type="text" class="form-control" value="<%=user.getUserRole() %>" disabled="disabled" name="userRole">
      </div>

      <div class="col-auto my-1 form1">
        <button type="submit" class="btn btn-primary">Submit</button>
      </div>
      <a href="/user">Redirect To Home</a>
     	<%
			if (msg != null && !msg.isEmpty()) {
			%>
			<h4 style="color: green"><%=msg%></h4>
			<%
			}
			%>
    </form>
  </div>
</body>

</html>