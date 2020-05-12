<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>purchase order data</title>
</head>
<body><c:choose>
<c:when test="${!empty list}">
<table border="1">
<tr>
<th>ID</th>
<th>ORDER CODE</th>
<th>REFERENCE NUMBER</th>
<th>QUALITY CHECK</th>
<th>STATUS</th>
<th>DESCRIPTION</th>
<th>SHIPMENTCODE</th>
<th colspan="3">OPERATION</th>

</tr>
<c:forEach items="${list}" var="ob">
<tr>
<td>${ob.purchaseId}</td>
<td>${ob.orderCode}</td>
<td>${ob.referenceNum}</td>
<td>${ob.qualityCheck}</td>
<td>${ob.status}</td>
<td>${ob.description}</td>
<td>${ob.shipOb.shipCode}</td>
<td> 
<a href="delete?pid=${ob.purchaseId}">DELETE</a>
</td>
<td> 
<a href="edit?pid=${ob.purchaseId}">EDIT</a>
</td>
<td> 
<a href="view?pid=${ob.purchaseId}">VIEW</a>
</td>
<td> 
<a href="parts?pid=${ob.purchaseId}">ADD PARTS</a>
</td>
</tr>

</c:forEach>
</table>
${message}
</c:when>

<c:otherwise>
<h4>data not found</h4>
</c:otherwise>
</c:choose>


</body>
</html>