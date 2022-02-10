<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">


body {
  font-family: 'Roboto', sans-serif;
  padding: 0;
  margin: 0;
}

/* NAVIGATION */
nav {
  width: 100%;
  margin: 0 auto;
  background: white;
  box-shadow: 0px 5px 0px #dedede;
  background-color: green;
}

nav ul {
  list-style: none;
  text-align: center;
}
nav ul li {
  display: inline-block;
}
nav ul li a {
  display: block;
  padding: 15px;
  text-decoration: none;
  color: white;
  font-weight: 800;
  text-transform: uppercase;
  margin: 0 10px;
}
nav ul li a,
nav ul li a:after,
nav ul li a:before {
  transition: all .5s;
}
nav ul li a:hover {
  color: red;
}


nav.stroke ul li a {
  position: relative;
}
nav.stroke ul li a:after {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  margin: auto;
  width: 0%;
  content: '.';
  color: transparent;
  background: #333;
  height: 1px;
}
nav.stroke ul li a:hover:after {
  width: 100%;
}






</style>
</head>
<body>
	 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Stroke</title>
    <link rel="stylesheet" href="style.css">
  </head>
  
 <body>

  <nav class="stroke">
    <ul>
      <li><a href="/user">Home</a></li>
      <li><a href="./seeAll">See All UserDetails</a> </li>
      <li><a href="./seeById">See By UserId</a></li>
      <li><a href="./logout">Logout</a></li>
    </ul>
    
 </nav>
</body>
</html>






</body>
</html>