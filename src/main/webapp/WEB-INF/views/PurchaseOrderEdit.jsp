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
<h3>Welcome Purchase update Page</h3>

<pre>

<form:form action="update" method="post" modelAttribute="purchaseOrder">

Id              : <form:input path="purchaseId" readOnly="true"/> 

Reference Number: <form:input path="referenceNum"/> 

Order Code      : <form:input path="orderCode"/> 

Quality Check   : <form:radiobutton path="qualityCheck" value="Required"/>Required
                  <form:radiobutton path="qualityCheck" value="Not Required"/>Not Required
            
Default Status  :<form:input path="status"/>

Description     :<form:input path="Description"/>


                  <input type="submit" value="UPDATE">


</form:form>
</pre>
${message }
</body>
</html>