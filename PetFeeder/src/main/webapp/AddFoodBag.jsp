<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add food page</title>
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
	<h1>Let's add a new bag of food <%= user %></h1>
	<form action="<%= request.getContextPath() %>/FoodBagServlet" method="post">
            Food brand <input type="text" name="food_bag_brand" />
            <br>
            <br> 
            Food bag size (kg) <input type="text" name="food_bag_size" />
            <br>
            <br> 
            Date bag opened (yyyy-mm-dd)<input type="text" name="day_opened" />
            <br>
            <br> 
            <input type="hidden" name="owner" value="<%= user %>">
			<input type="submit" value="Add new food bag" />
	</form>
	</div>
</body>
</html>