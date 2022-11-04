<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add dog Page</title>
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
<%
HttpSession session = request.getSession(false);
String user = (String) session.getAttribute("username");

%>
<h1>Let's add a new dog <%= user %></h1>
<form action="<%= request.getContextPath() %>/DogServlet?action=insert" method="post">
  Dog name <input type="text" name="dogName" /><br>
  <br> Dog type 
       <select name="dogType" >
        <option value="small">Small</option>
        <option value="medium">Medium</option>
        <option value="large">Large</option>
    </select>
    <input type="hidden" name="owner" value="<%= user %>">
   <br><br><input type="submit" value="Submit" />
 </form>


</div>
</body>
</html>
