<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>ShipmentType Data</h3>
<a href="excel?sid=${ob.shipmentId} ">ExcelExport</a>|
<a href="pdf?sid=${ob.shipmentId} ">PdfExport</a>
<table border="1">
<tr>
<th>ID</th><td>${ob.shipmentId }</td>
</tr>
<tr>
<th>CODE</th><td>${ob.shipCode }</td>
</tr>
<tr>
<th>MODE</th><td>${ob.shipmentMode }</td>
</tr>
<tr>
<th>ENABLE</th><td>${ob.enableShipment }</td>
</tr>
<tr>
<th>GRADE</th><td>${ob.shipmentGrade }</td>
</tr>
<tr>
<th>NOTE</th><td>${ob.shipDescription }</td>
</tr>

</table>
</body>
</html>