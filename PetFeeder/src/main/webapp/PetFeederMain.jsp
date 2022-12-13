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
<title>User Register</title>
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
		
		<div class="main-div" align="center">
			<%
			HttpSession session = request.getSession(false);
			String user = (String) session.getAttribute("username");
			%>
			<h1 id=main-page-heading>
				Welcome back to Pet Feeder,
				<%=user%>!
			</h1>
			<br>
			<h2 id=main-page-message>Your pet's food will end in ${daysUntilEmpty} days.</h2><br>
						<img class="dog-house" src="./Images/dog-house.png" alt="small-dog-clipart10" />
									<img class="vintage-pup" src="./Images/vintage-pup.png" alt="small-dog-clipart10" />
			
			<div class="table-enclose-div">
				<!-- <div class="alert alert-success" *ngIf='message'>{{message}} </div> -->
				<div class="container">
					<h3 id=table-title-main class="text-center">
					<br>
						<i>List of dogs registered to <%=user%>:
						</i>
					</h3>
					<hr>
					<br>
					<table style="with: 80%" class="table table-bordered">
						<thead>
							<tr>
								<th>&nbsp;Dog Name&nbsp;</th>
								<th>&nbsp;Dog Type&nbsp;</th>
								<th>&nbsp;Dog Daily Intake (cups)&nbsp;</th>
								<th>&nbsp;Actions&nbsp;</th>
							</tr>
						</thead>
						<tbody>
							<!--   for (Todo todo: todos) {  -->
							<c:forEach var="dog" items="${listDog}">
								<tr>
									<td><c:out value="${dog.dogName}" /></td>
									<td><c:out value="${dog.dogType}" /></td>
									<td style="text-align: center;"><c:out
											value="${dog.dogDailyAmount}" /></td>
									<td><a
										href="?action=edit&id=<c:out value='${dog.id}' />
                                    	">Edit</a>
										&nbsp;&nbsp;&nbsp;&nbsp; <a
										href="?action=delete&id=<c:out value='${dog.id}' />">Delete</a>
									</td>
								</tr>
							</c:forEach>
							<!-- } -->
						</tbody>
					</table>
				</div>
				<br> <br>
				<div class="container text-left">
					<form
						action="<%=request.getContextPath()%>/DogServlet?action=new"
						method="post">
						<input class="add-dog-btn" type="submit" value="Add new dog" />
					</form>
				</div>
				<hr>
				<div class="container">
					<h3 id=bag-list class="text-center">List of Food Bags</h3>
					<hr>
					<br>
					<table style="with: 80%" class="table table-bordered">
						<thead>
							<tr>
								<th>&nbsp;Food Bag Brand&nbsp;</th>
								<th>&nbsp;Food Bag Size (kg)&nbsp;</th>
								<th>&nbsp;Bag Size (cups)&nbsp;</th>
								<th>&nbsp;Opened Date&nbsp;</th>

							</tr>
						</thead>
						<tbody>
							<!--   for (Todo todo: todos) {  -->
							<c:forEach var="foodbag" items="${listBag}">
								<tr>
									<td style="text-align: center;"><c:out
											value="${foodbag.fbBrand}" /></td>
									<td style="text-align: center;"><c:out
											value="${foodbag.fbSize}" /></td>
									<td style="text-align: center;"><c:out
											value="${foodbag.SCups}" /></td>
									<td style="text-align: center;"><c:out
											value="${foodbag.dayOpened}" /></td>

								</tr>
							</c:forEach>
							<!-- } -->
						</tbody>
					</table>
				</div>
				<br>
				<h3 class="text-center"></h3>
				<div class="container text-left">
					<form action="<%=request.getContextPath()%>/AddFoodBag.jsp"
						method="post">
						<input class="add-bag-btn" type="submit" value="Add new food bag" />
					</form>
					<br>
				</div>
				<hr>
			</div>
			<br> <br> <br><br>
		</div>
	</body>
</div>
</html>
