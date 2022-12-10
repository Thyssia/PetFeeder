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
		<div class="navbar navbar-expand-md navbar-dark" role="navigation" style="background-color: tomato">
			<form action="<%= request.getContextPath() %>/user?action=LOGOUT" method="post">
					<input type="submit" value="Logout" /> 
			</form>
			<br>
			<br>
			<br>
        </div>
        </header>
     	<div align="center">
		<%
			HttpSession session = request.getSession(false);
			String user = (String) session.getAttribute("username");
			
		%>
  		<h1>Welcome back to Pet Feeder <%= user %>.</h1>
  	   	<h2 style="color: red;"> Your pet's food will end in ${daysUntilEmpty} days.</h2>
    		<div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}} </div> -->
                <div class="container">
                    <h3 class="text-center">List of dogs registered to <%= user %></h3>
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
                                    <td>
                                        <c:out value="${dog.dogName}" />
                                    </td>
                                    <td>
                                        <c:out value="${dog.dogType}" />
                                    </td>
                                    <td style="text-align:center;">
                                    	<c:out value="${dog.dogDailyAmount}" />
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
                                    <td style="text-align:center;">
                                        <c:out value="${foodbag.fbBrand}" />
                                    </td>
                                    <td style="text-align:center;">
                                        <c:out value="${foodbag.fbSize}" />
                                    </td>
                                    <td style="text-align:center;">
                                        <c:out value="${foodbag.SCups}" />
                                    </td>
                                    <td style="text-align:center;">
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