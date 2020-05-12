<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
      <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="" method="post">

UserName      :<input type="text" name="userName">

UserEmail     :<input type="text" name="userEmail">

Password      :<input type="password" name="password">
                 
Role          :<input type="radio" name="userRoles" value="Admin">Admin
                
               <input type="radio" name="userRoles" value="Employee">Employee
                
               <input type="submit" value="REGISTER">
</form>
</body>
</html>