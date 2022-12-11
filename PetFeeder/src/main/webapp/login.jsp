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
</head>
<body>
	<header class="index-heading1">

		<div>
			<img class="dog1" src="dog1.png" alt="small-dog-clipart1" />
			<h1>
				<i> PET FEEDER </i>
			</h1>

		</div>

	</header>
	<div class="index-welcome-login" align="center">
	<br>
		<br><br><br><br>

		<div class="inner-login-div">
			<img class="dog2" src="dog2.png" alt="small-dog-clipart2" /> <img
				class="dog3" src="dog3.png" alt="small-dog-clipart3" /> <br>
			<br>
			<h1>Welcome to Pet Feeder!</h1>
			&nbsp;
			<h2 align="center" id="red-med-text">Please login:</h2>
			<form action="<%=request.getContextPath()%>/LoginServlet"
				method="post">
				Username <input type="text" name="username" /> <br> <br>
				Password <input type="password" name="password" /> <br> <br>
				<input class="submit-btn" type="submit" value="Login" />
			</form>
			<p>First time here?
			<p>
				<a style="color: magenta" href="userregister.jsp"><i>Register
						Here</i></a> <br>
				<br>
				<br>
				<br>
				<br>
				<br>
		</div>
		
	</div>
	
</body>
</html>
