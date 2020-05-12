<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
      <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Part Module</title>
</head>
<body>
<h3>Welcome Part Registration Page</h3>
<pre>

<form:form action="save" method="post" modelAttribute="part">



Code            : <form:input path="pcode"/> 

Dimensions      : Width: <form:input path="width"/> 
                  Length: <form:input path="length"/> 
                  Height: <form:input path="height"/> 
                

Base Cost       : <form:input path="baseCost"/> 

Base Currency   : <form:input path="baseCurrency"/> 

                
Uom             :<form:select path="uomObj.uomId">
                 <form:option value="">--SELECT</form:option>
                 <form:options items="${uomMap}"/>
                 </form:select>
Mode            :
                  <form:select path="omSaleOb.orderId">
                 <form:option value="">--SELECT</form:option>
                 <form:options items="${omSaleMap}"/>
                 </form:select> 
                 
                 <form:select path="omPurcasheOb.orderId">
								<form:option value="">-SELECT PURCHASE-</form:option>
								<form:options items="${omPurchaseMap}" />
							</form:select>
                 

Description     :<form:input path="description"/>


                  <input type="submit" value="CREATE">


</form:form>
</pre>
${message}
</body>
</html>