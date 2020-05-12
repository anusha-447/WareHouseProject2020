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
<h3>Welcome to Uom data</h3>
<a href="excel">ExcelExport</a>|
<a href="pdf">PdfExport</a>
<c:choose>
<c:when test="${!empty list}">
<table border=1>
<tr>

<th>UOMTYPE</th>
<th>UOMMODEL</th>
<th>DESCRIPTION</th>
<th colspan="3">OPERATION</th>
</tr>
<c:forEach items="${list}" var="ob">
<tr>

<td>${ob.uomType}</td>
<td>${ob.uomModel}</td>
<td>${ob.description}</td>
<td>
<a href="delete?uoid=${ob.uomId }">DELETE</a>
</td>
<td>
<a href="edit?uoid=${ob.uomId }">EDIT</a>
</td>
<td>
<a href="view?uoid=${ob.uomId }">VIEW</a>
</td>
</tr>
</c:forEach>
</table>
<h3>${message}</h3>
</c:when>
<c:otherwise>
no data found
</c:otherwise>
</c:choose>
</body>
</html>