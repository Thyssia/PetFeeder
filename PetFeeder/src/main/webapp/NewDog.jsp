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
<div class=newdog-div align="center">
<%
HttpSession session = request.getSession(false);
String user = (String) session.getAttribute("username");
%><br>

<h1 class=newdog-div >Let's add a new dog, <%= user %>:</h1><br><br>
<form action="<%= request.getContextPath() %>/DogServlet?action=insert" method="post">
  Dog name:  <input class=newdog-div type="text" name="dogName" />
  <br>
  <br>
  Dog type: 
       <select class=new-dog-select name="dogType" >
        <option value="small">Small</option>
        <option value="medium">Medium</option>
        <option value="large">Large</option>
      </select>
  <input type="hidden" name="owner" value="<%= user %>">
  <br>
  <br><br>
  <input class=yet-another-submit-btn type="submit" value="Submit" />
 </form>
 <br>
<br>
</div>

</body>
</div>
</html>
