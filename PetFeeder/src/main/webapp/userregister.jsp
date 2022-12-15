<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="styles.css">
		<link rel="stylesheet" type="text/css"
			href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">
		<title>User Register</title>
		<link rel="icon" type="image/x-icon" href="./Images/dish.svg">
	</head>
	<div id=wrapper>
		<body style="height: 100%; background-color: rgba(54, 202, 197, 0.8); background-image: repeating-linear-gradient(120deg, 
			rgba(255, 255, 255, .1), rgba(255, 255, 255, .1) 3px, transparent 3px, transparent 60px), repeating-linear-gradient(60deg, 
			rgba(255, 255, 255, .1), rgba(255, 255, 255, .1) 1px, transparent 3px, transparent 60px), linear-gradient(60deg, rgba(139, 
			139, 139, .6) 25%, transparent 25%, transparent 75%, rgba(139, 139, 139, .6) 75%, rgba(139, 139, 139, .6)), linear-gradient(120deg, 
			rgba(139, 139, 139, .6) 25%, transparent 25%, transparent 75%, rgba(139, 0, 139, .6) 75%, rgba(255, 0, 0, .6)); 
			background-size: 70px 120px; opacity: 95%">
			<div class=index-welcome-login></div>
			<header class="index-heading1">
				<img class="dog1" src="./Images/dog1.png" alt="small-dog-clipart1" />
				<div>
					<img class="other-dog" src="./Images/dog7.png" alt="7-dog-clipart" />
					<h1>
						<i> PET FEEDER </i>
					</h1>
				</div>
			</header>
			<img class=dog-pic1 style="" src="./Images/dog-6.png" alt="6-dog-clipart" />
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<div class="reg-div1" align="center">
				<h1>Pet Feeder Registration Form</h1>
				<form action="<%=request.getContextPath()%>/register" method="post">
					<table class="table1" style="with: 80%">
						<tr>
							<td>First Name</td>
							<td>
								<input class="tomato-input" type="text" name="firstName" required="required" />
							</td>
						</tr>
						<tr>
							<td>Last Name</td>
							<td>
								<input class="tomato-input" type="text" name="lastName" required="required" />
							</td>
						</tr>
						<tr>
							<td>Email</td>
							<td>
								<input class="tomato-input" type="text" name="email" required="required" />
							</td>
						</tr>
						<tr>
							<td>Username</td>
							<td>
								<input class="tomato-input" type="text" name="username" required="required" />
							</td>
						</tr>
						<tr>
							<td>Password</td>
							<td>
								<input class="tomato-input" type="password" name="password" required="required" />
							</td>
						</tr>
					</table>
					<br> 
					<br> 
					<br> 
					<input class="another-submit-btn" type="submit" value="Submit" /> 
					<br> 
					<br>
				</form>
				<p>
					<i>If you don't have an account, please make one now with this form. </i>
				<p>
				<p>PetFeeder will send you email notifications as well as display in-app information about your dog's food quantity.
				<p>
			</div>
		</body>
	</div>
</html>
