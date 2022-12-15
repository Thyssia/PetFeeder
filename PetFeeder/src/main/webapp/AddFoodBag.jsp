<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">
<title>Add Food Bag</title>
<link rel="icon" type="image/x-icon" href="./Images/doggo.png">
</head>
<div id=wrapper>
	<body
		style="height: 100%; background-color: rgba(54, 202, 197, 0.8); 
		background-image: repeating-linear-gradient(120deg, rgba(255, 255, 255, .1), rgba(255, 255, 255, .1) 3px, 
		transparent 3px, transparent 60px), repeating-linear-gradient(60deg, rgba(255, 255, 255, .1), rgba(255, 255, 255, .1) 1px,
		transparent 3px, transparent 60px), linear-gradient(60deg, rgba(139, 139, 139, .6) 25%, transparent 25%, transparent 75%, 
		rgba(139, 139, 139, .6) 75%, rgba(139, 139, 139, .6)), linear-gradient(120deg, rgba(139, 139, 139, .6) 25%, transparent 25%,
		transparent 75%, rgba(119, 41, 83, .6) 75%, rgba(119, 41, 83, .6)); background-size: 70px 120px; opacity: 95%">
		<header class="index-heading1">

			<div>

				<img class="dog1" src="./Images/dog1.png" alt="small-dog-clipart1" />
				<div class="logout-btn-div" role="navigation">
					<form action="<%=request.getContextPath()%>/user?action=LOGOUT"
						method="post">
						<input class="logout-btn" type="submit" value="Logout" />
					</form>

				</div>


				<h1>
					<i> PET FEEDER </i>
				</h1>

			</div>

		</header>

		<div class=special-div align="center">
			<br>
			<%
			HttpSession session = request.getSession(false);
			String user = (String) session.getAttribute("username");
			%>
			<h1>
				Let's add a new bag of food,
				<%=user%>:
			</h1>
			<div class=wrangle>
				<form action="<%=request.getContextPath()%>/FoodBagServlet" method="post">
					&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
					Food brand <input class=special-div-input type="text" name="food_bag_brand" /> 
					<br>
					<br> 
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					Food bag size (kg)
					<input class=special-div-input type="text" name="food_bag_size" />
					<br> 
					<br> 
					Date bag opened (yyyy-mm-dd)
					<input class=special-div-input type="text" name="day_opened" /> 
					<br>
					<br>
					<br> 
					<input type="hidden" name="owner" value="<%=user%>"> 
					<input class=add-food-btn type="submit" value="Add new food bag" />
				</form>
			</div>
			<img style="float: left; padding: 27px" src="./Images/doggo.png"
				alt="7-dog-clipart" /> <img style="float: right; padding: 27px"
				class=dish src="./Images/dish.svg" alt="7-dog-clipart" /> <br>
			<br>
			<br> <br>
			<br> <br>
			<br> <br>
			<br> <br>
			<br> <br>
		</div>
	</body>
	<br>
	<br>
</div>

</html>
