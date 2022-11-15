<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>PetFeeder Home</title>
		<style>
		table, th, td {border: 1px solid black;}
		</style>
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
  		<h1>Welcome back to Pet Feeder <%= user %>.</h1>
  	   	<br>
    		<div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}} </div> -->
                <div class="container">
                    <h3 class="text-center">List of Dogs Registered to <%= user %></h3>
                    <hr>
                    <br>
                    <table style="with: 80%" class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Dog Name</th>
                                <th>Dog Type</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="dog" items="${listDog}">
                                <tr>
                                    <td>
                                        <c:out value="${dog.dogName}" />
                                    </td>
                                    <td>
                                        <c:out value="${dog.dogType}" />
                                    </td>
                                    <td><a href="?action=edit&id=<c:out value='${dog.id}' />
                                    	">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; 
                                    	<a href="?action=delete&id=<c:out value='${dog.id}' />">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>
                    </table>
                </div>
            	<br>
            	<br>
           		<div class="container text-left">
                  	<form action="<%= request.getContextPath() %>/DogServlet?action=new" method="post">
					<input type="submit" value="Add new dog" /> 
					</form>
            	</div>
            	<hr>
            	<div class="container">
                    <h3 class="text-center">List of Food Bags</h3>
                    <hr>
                    <br>
                    <table style="with: 80%" class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Food Bag Brand</th>
                                <th>Food Bag Size</th>
                                <th>Opened Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="foodbag" items="${listBag}">
                                <tr>
                                    <td>
                                        <c:out value="${foodbag.fbBrand}" />
                                    </td>
                                    <td>
                                        <c:out value="${foodbag.fbSize}" />
                                    </td>
                                    <td>
                                        <c:out value="${foodbag.dayOpened}" />
                                    </td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>
                    </table>
            </div>
               	<br>
            	 <h3 class="text-center"></h3>
           		<div class="container text-left">
                  	<form action="<%= request.getContextPath() %>/AddFoodBag.jsp" method="post">
                 	<input type="submit" value="Add new food bag" />
                 	</form>
            	</div>
            <hr>
          </div>  
		</div>
	</body>
</html>