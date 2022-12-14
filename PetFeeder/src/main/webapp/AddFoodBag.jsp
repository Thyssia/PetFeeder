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
</head>
<div id=wrapper>
	<body>
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
				<form action="<%=request.getContextPath()%>/FoodBagServlet"
					method="post">

					&nbsp; &nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Food brand <input
						class=special-div-input type="text" name="food_bag_brand" /> <br>
					<br> &nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Food bag size (kg)
					<input class=special-div-input type="text" name="food_bag_size" />
					<br> <br> Date bag opened (yyyy-mm-dd)<input
						class=special-div-input type="text" name="day_opened" /> <br>
					<br> <input type="hidden" name="owner" value="<%=user%>">
					<input class=add-food-btn type="submit" value="Add new food bag" />
				</form>
			</div>
			<br> <br>
		</div>
	</body>
</div>

<img class="dish" src="./Images/dish.svg" alt="7-dog-clipart" />
</html>
