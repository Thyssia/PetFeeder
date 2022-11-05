<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
  <h1>Pet Feeder Registration Form</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>First Name</td>
     <td><input type="text" name="firstName" required="required"/></td>
    </tr>
    <tr>
     <td>Last Name</td>
     <td><input type="text" name="lastName" required="required"/></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" required="required"/></td>
    </tr>
    <tr>
     <td>Username</td>
     <td><input type="text" name="username" required="required" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" required="required"/></td>
    </tr>
    
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>