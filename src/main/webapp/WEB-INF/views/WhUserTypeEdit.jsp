<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome WhUserType Registration Page</h3>
<pre>
<form:form action="update" method="post" modelAttribute="user">
<br>


User Id     :<form:input type="text" path="userId"/>

UserType    :
             <form:radiobutton path="userType" value="Vendor"/>Vendor
              <form:radiobutton path="userType" value="Customer"/>Customer
            
User Code   :<form:input type="text" path="userCode"/>

User For    :<form:input type="text" path="userFor"/> <!-- autofill -->

User Email  :<form:input type="text" path="userEmail"/>

UserId Type : <form:select path="userIdType">
              <form:option value="">--SELECT--</form:option>
              <form:option value="PAN">PAN</form:option>
              <form:option value="ADHAR">ADHAR</form:option>
              <form:option value="VOTER ID">VOTER ID</form:option>
              <form:option value="OTHER">OTHER</form:option>
             </form:select>
             
If other    : <form:input  path="ifOther"/>

ID Number   :<form:input  path="idNumber"/>
     
             <input type="submit" value="UPDATE">


</form:form>
</pre>
<h4>${msg}</h4>
</body>
</html>