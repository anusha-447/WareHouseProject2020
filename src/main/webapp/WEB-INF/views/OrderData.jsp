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
<h3>Welcome to Ordermethods</h3>

<a href ="excel">
<img src="../resources/images/excel.png"/>
</a>|
<a href ="pdf">PdfExport</a>
<c:choose>
<c:when test="${!empty list }">
<table border="1">
<tr>

<th>ORDER MODE</th>
<th>ORDER CODE</th>
<th>ORDER METHOD</th>
<th>ORDER ACCEPATANCE</th>
<th>DESCRIPTION</th>
<th colspan="3">OPERATION</th>

</tr>
<c:forEach items="${list}" var="ob">
<tr>
<td>${ob.orderMode }</td>
<td>${ob.orderCode }</td>
<td>${ob.orderMethod }</td>
<td>${ob.orderAccept }</td>
<td>${ob.description }</td>
<td>
<a href="delete?oId=${ob.orderId }">DELETE</a>
</td>
<td>
<a href="edit?oId=${ob.orderId }">EDIT</a>
</td>
<td>
<a href="view?oId=${ob.orderId }">VIEW</a>
</td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
No data found
</c:otherwise>
</c:choose> 
</body>
</html>   