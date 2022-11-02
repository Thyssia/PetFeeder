<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main User Page</title>
</head>
<body>
 <div align="center">
<%
HttpSession session = request.getSession(false);
String user = (String) session.getAttribute("username");

%>
  <h1>Welcome back <%= user %> to Pet Feeder.</h1>
 
 <form action="<%= request.getContextPath() %>/NewDog.jsp" method="post">
<input type="submit" value="Add new dog" />
 </form>

</div>
</body>
</html>
