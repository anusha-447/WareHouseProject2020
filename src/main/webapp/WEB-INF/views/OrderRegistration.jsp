<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order</title>
</head>
<body>

 <h3> Welocome to Order Registration</h3>
 
 <form:form action="save" method="post" modelAttribute="order">
 <pre>
 
 Order Mode  :<form:radiobutton path="orderMode" value="SALE"/>SALE
             
             <form:radiobutton path="orderMode" value="PURCHASE"/>PURCHASE
 
 Order Code  : <form:input type="text" path="orderCode"/>
 
 Order Method:
              <form:select path="orderMethod">
              <form:option value="FIFO">FIFO</form:option>
              <form:option value="LIFO">LIFO</form:option>
              <form:option value="FCFO">FCFO</form:option>
              <form:option value="FEFO">FEFO</form:option>
              </form:select>
 Order Accept:
              <form:checkbox path="orderAccept" value="Multi-Model"/>Multi-Model
              <form:checkbox  path="orderAccept" value="Accept Return"/>Accept Return
 
 
 Description:
             <form:textarea path="description"></form:textarea>
             
             
             <input type="submit" value="REGISTER">
 </pre>
 </form:form>
<h4>${message}</h4>
</body>
</html>