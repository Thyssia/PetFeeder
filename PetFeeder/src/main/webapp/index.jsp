<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First Landing Page</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			<div>
				<br>
				<br>
				<br>
            </div>
        </nav>
    </header>
<div align="center">
<h1>Welcome to Pet Feeder!</h1>
<h2>Please login</h2>
<form action="<%= request.getContextPath() %>/LoginServlet" method="post">
  Username <input type="text" name="username" />
  <br>
  <br>
  Password <input type="password" name="password" />
  <br>
  <br>
  <input type="submit" value="Submit" />
</form>
<p>
  First time here?   <a href="userregister.jsp">Register Here</a>
</div>
</body>
</html>
