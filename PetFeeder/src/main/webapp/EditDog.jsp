<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Dog</title>
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

</html>