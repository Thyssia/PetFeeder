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
	<title>Edit Dog</title>
	<link rel="icon" type="image/x-icon" href="./Images/doggo.png">
</head>
<div id=wrapper>
	<body style="height: 100%; background-color: rgba(54, 202, 197, 0.8); 
		background-image: repeating-linear-gradient(120deg, rgba(255, 255, 255, .1), rgba(255, 255, 255, .1) 3px, 
		transparent 3px, transparent 60px), repeating-linear-gradient(60deg, rgba(255, 255, 255, .1), 
		rgba(255, 255, 255, .1) 1px, transparent 3px, transparent 60px), linear-gradient(60deg, rgba(139, 139, 139, .6) 25%, transparent 25%, 
		transparent 75%, rgba(139, 139, 139, .6) 75%, rgba(139, 139, 139, .6)), linear-gradient(120deg, rgba(139, 139, 139, .6) 25%,
		transparent 25%, transparent 75%, rgba(139, 0, 139, .6) 75%, rgba(255, 255, 0, .6)); 
		background-size: 70px 120px; opacity: 95%">
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
		<br>
		<div class=main-div>
			<br> 
			<br> 
			<br> 
			<br> 
			<br> 
			<br> 
			<br>
			<br>
			<div class=bg-div class="container col-md-5">
				<br> <br> <br>
				<div class=reg-div1 class="card">
					<div class="card-body">
						<form style="color: #000007"
							action="<%=request.getContextPath()%>/DogServlet?action=update"
							method="post">
							<h2>&nbsp;&nbsp;&nbsp; Edit Dog:</h2>
							
							<c:if test="${dog != null}">
								<input type="hidden" name="id" value="<c:out value='${dog.id}' />" />
							</c:if>
							<fieldset class="form-group">
								&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;
								<label>Dog Name</label> 
								<input class=yellow-input type="text" value="<c:out value='${dog.dogName}' />"
									class="form-control" name="dogName" required="required">
							</fieldset>
							<fieldset class="form-group">
								<br>
								<label>Current dog size</label> 
								<input class=yellow-input type="text" value="<c:out value='${dog.dogType}' />"
									class="form-control" readonly>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<br>
								<br>
								<label>New dog size</label> 
								&nbsp;&nbsp;&nbsp;&nbsp;
								<select class=edit-dog-select name="dogType">
									<option value="small">Small</option>
									<option value="medium">Medium</option>
									<option value="large">Large</option>
								</select>
								<br>
							</fieldset>
							<br>
							<br>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button class=edit-dog-btn type="submit" style="margin-left: 30%">Save!</button>
						</form>
					</div>
					<br>
				</div>
				<br>
				<br> 
				<br>
			</div>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
		</div>
	</body>
</div>

</html>
