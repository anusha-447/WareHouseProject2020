<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>OrderMethod Data</h3>

<a href="excel?oId=${ob.orderId} ">ExcelExport</a>|
<a href="pdf?oId=${ob.orderId} ">PdfExport</a>

<table border="1">
<tr>
<th>ORDER ID</th><td>${ob.orderId }</td>
</tr>
<tr>
<th>MODE</th><td>${ob.orderMode }</td>
</tr>
<tr>
<th>METHOD</th><td>${ob.orderMethod }</td>
</tr>
<tr>
<th>CODE</th><td>${ob.orderCode }</td>
</tr>
<tr>
<th>ACCEPTANCE</th><td>${ob.orderAccept }</td>
</tr>
<tr>
<th>DESCRIPTION</th><td>${ob.description }</td>
</tr>


</table>
</body>
</html>