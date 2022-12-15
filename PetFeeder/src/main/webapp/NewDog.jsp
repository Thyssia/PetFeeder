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
		<title>Add dog</title>
		<link rel="icon" type="image/x-icon" href="./Images/doggo.png">
	</head>
<div id=wrapper>
	<body style="height: 100%; background-color: rgba(54, 202, 197, 0.8); background-image: repeating-linear-gradient(120deg, 
		rgba(255, 255, 255, .1), rgba(255, 255, 255, .1) 3px, transparent 3px, transparent 60px), repeating-linear-gradient(60deg, 
		rgba(255, 255, 255, .1), rgba(255, 255, 255, .1) 1px, transparent 3px, transparent 60px), 
		linear-gradient(60deg, rgba(139, 139, 139, .6) 25%, transparent 25%, transparent 75%, rgba(139, 139, 139, .6) 75%, 
		rgba(139, 139, 139, .6)), linear-gradient(120deg, rgba(139, 139, 139, .6) 25%, transparent 25%, transparent 75%, 
		rgba(139, 0, 139, .6) 75%, rgba(0, 255, 0, .6)); background-size: 70px 120px; opacity: 95%">
		<header class="index-heading1">
			<div>
				<img class="dog1" src="./Images/dog1.png" alt="small-dog-clipart1" />
				<div class="logout-btn-div" role="navigation">
					<form action="<%=request.getContextPath()%>/user?action=LOGOUT" method="post">
						<input class="logout-btn" type="submit" value="Logout" />
					</form>
				</div>
				<h1>
					<i> PET FEEDER </i>
				</h1>
			</div>
		</header>
		<div class=newdog-div align="center">
			<%HttpSession session = request.getSession(false);
				String user = (String) session.getAttribute("username");%>
			<br>
			<h1 class=newdog-div> Let's add a new dog, <%=user%>: </h1>
			<br> 
			<br>
			<form class=form-label action="<%=request.getContextPath()%>/DogServlet?action=insert" method="post">
				Dog name: <input class=newdog-div type="text" name="dogName" /> 
				<br>
				<br> 
				Dog size: 
				<select class=new-dog-select name="dogType">
					<option value="small">Small</option>
					<option value="medium">Medium</option>
					<option value="large">Large</option>
				</select> 
				<input type="hidden" name="owner" value="<%=user%>"> 
				<br>
				<br> 
				<br> 
				<input class=yet-another-submit-btn type="submit" value="Submit" />
			</form>
			<br> 
			<br>
		</div>
		<img style="padding: 27px" src="./Images/doggo.png" alt="small-dog-clipart1" />
	</body>
</div>
</html>
