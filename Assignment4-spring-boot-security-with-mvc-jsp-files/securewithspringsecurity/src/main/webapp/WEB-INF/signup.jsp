<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sign Up</title>
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
      <h4>Sign Up</h4>
    </div>
    <form class="form" id="form" action="/Home" method="post">


      <div class="form1">
        <label for="userId">User Id</label>
        <input type="number" class="form-control"   placeholder="199" name="UserId">
      </div>
      <div class="form1">
        <label for="userName">User Name</label>
        <input type="text" class="form-control" onkeypress="return /[a-z]/i.test(event.key)" placeholder="Mark" name="userName">
      </div>
  
      
      <div class="form1">
        <label for="userPassword">Password</label>
        <input type="password" class="form-control" placeholder="password" name="userPassword">
      </div>
      
      <div class="form1">
        <label for="role">Role</label> <br>
        <select  class="form-control" name="userRole" >
          <option value="ROLE_USER">ROLE_USER</option>
          <option value="ROLE_ADMIN">ROLE_ADMIN</option>
        </select>
      </div>

      <div class="col-auto my-1 form1">
        <button type="submit" class="btn btn-primary">Submit</button>
        <button  class="btn btn-secondary" onclick="reset()">Reset</button>

      </div>
    </form>

  </div>

  <script>
  function reset(){
		form.reset();
		
	}</script>  
</body>

</html>