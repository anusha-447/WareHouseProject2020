<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>welcome to PurchaseParts</h3>
<table border="1">
<tr>
		<th>ORDER CODE</th>
		<th>ORDER STATUS</th>
		</tr>
		<tr>
		<td><b>${parent.orderCode}</b></td>
		<td><b>${parent.status}</b></td>
	</tr>


</table>
<hr>
<c:if test="${'OPEN' eq parent.status || 'PICKING' eq parent.status}">
<form:form action="addPart" method="post" modelAttribute="purchaseDtl">
<pre>
SELECT PART:<form:select path="part.pid">
 <form:options items="${partMap}"/>
             </form:select>
Quantity  : <form:input path="qty"/>
		<input type="hidden" name="po.id" value="${parent.id}"/>
	<input type="submit" value="Add Part"/>	
</pre>
</form:form>
</c:if>
	
</body>
</body>
</html>