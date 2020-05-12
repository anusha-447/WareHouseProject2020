<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>SHIPMENT TYPE LIST </h3>
<a href="excel">ExcelExport</a>|
<a href="pdf">PdfExport</a>
<c:choose>
<c:when test="${!empty list}">
<table border="1">
<tr>
<th>ID</th>
<th>MODE</th>
<th>CODE</th>
<th>GRADE</th>
<th>ENABLE</th>
<th>NOTE</th>
<th colspan="3">OPERATION</th>
<!-- <th>ID</th> -->

</tr>
<c:forEach items="${list}" var="ob">
<tr>
<td>${ob.shipmentId}</td>
<td>${ob.shipmentMode}</td>
<td>${ob.shipCode}</td>
<td>${ob.shipmentGrade}</td>
<td>${ob.enableShipment}</td>
<td>${ob.shipDescription}</td>
<td> 
<a href="delete?sid=${ob.shipmentId}">DELETE</a>
</td>
<td> 
<a href="edit?sid=${ob.shipmentId}">EDIT</a>
</td>
<td> 
<a href="view?sid=${ob.shipmentId}">VIEW</a>
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