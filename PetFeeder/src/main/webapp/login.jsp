<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">
<title>First Landing Page</title>
<link rel="icon" type="image/x-icon" href="./Images/dish.svg">
</head>
<div id=wrapper>
	<body
		style="height: 100%; background-color: rgba(54, 202, 197, 0.8); background-image: repeating-linear-gradient(120deg, rgba(255, 255, 255, .1), rgba(255, 255, 255, .1) 3px, transparent 3px, transparent 60px), repeating-linear-gradient(60deg, rgba(255, 255, 255, .1), rgba(255, 255, 255, .1) 1px, transparent 3px, transparent 60px), linear-gradient(60deg, rgba(139, 139, 139, .6) 25%, transparent 25%, transparent 75%, rgba(139, 139, 139, .6) 75%, rgba(139, 139, 139, .6)), linear-gradient(120deg, rgba(139, 139, 139, .6) 25%, transparent 25%, transparent 75%, rgba(139, 0, 139, .6) 75%, rgba(76, 40, 220, .6)); background-size: 70px 120px; opacity: 95%">
		<header class="index-heading1">

			<div>
				<img class="dog1" src="./Images/dog1.png" alt="small-dog-clipart1" />
				<h1>
					<i> PET FEEDER </i>
				</h1>

			</div>

		</header>
		<div class="index-welcome-login" align="center">
			<br> <br> <br> <br> <br>

			<div class="inner-login-div">
				<img class="dog5" src="./Images/dog5.png" alt="small-dog-clipart5" />
				<img class="dog9" src="./Images/dog9.png" alt="small-dog-clipart9" />
				<br> <br>
				<h1>Welcome to Pet Feeder!</h1>
				&nbsp;
				<h2 align="center" id="red-med-text">Please login:</h2>
				<form action="<%=request.getContextPath()%>/user?action=LOGIN"
					method="post">
					Username <input type="text" name="username" /> <br> <br>
					Password <input type="password" name="password" /> <br> <br>
					<input class="submit-btn" type="submit" value="Login" />
				</form>
				<p>First time here?
				<p>
					<a style="color: magenta" href="user?action=REGISTER"><i>Register
							Here</i></a> <br>
			</div>
			<img src="./Images/dog8.png" alt="small-dog-clipart8" />
		</div>
</div>
</body>
</html>
