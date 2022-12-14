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
    <br>
    <div class="container col-md-5">
    	<div class="card">
    		<div class="card-body">
    			<form action="<%= request.getContextPath() %>/DogServlet?action=update" method="post">
                <caption>
                	<h2>                	
                    Edit Dog
                	</h2>
                </caption>
                <c:if test="${dog != null}">
                	<input type="hidden" name="id" value="<c:out value='${dog.id}' />" />
                </c:if>

                <fieldset class="form-group">
                	<label>Dog Name</label>
                	<input type="text" value="<c:out value='${dog.dogName}' />
                	" class="form-control" name="dogName" required="required">
                </fieldset>

                <fieldset class="form-group">
                	<label>Current Dog Type</label>
                	<input type="text" value="<c:out value='${dog.dogType}' />
                	" class="form-control" readonly>
                	
                	<label>New Dog Type</label>
       					<select name="dogType" >
					        <option value="small">Small</option>
					        <option value="medium">Medium</option>
					        <option value="large">Large</option>
					    </select>
                </fieldset>

				<button type="submit" class="btn btn-success">Save</button>
               </form>
			</div>
		</div>
	</div>
</body>
</div>
</html>
