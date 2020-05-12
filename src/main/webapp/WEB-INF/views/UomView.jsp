<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>UOM Data</h3>

<a href="excel?uoid=${ob.uomId} ">ExcelExport</a>|
<a href="pdf?uoid=${ob.uomId} ">PdfExport</a>
<table border="1">
<tr>
<th>UOM ID</th><td>${ob.uomId }</td>
</tr>
<tr>
<th>UOM MODEL</th><td>${ob.uomModel }</td>
</tr>
<tr>
<th>UOM TYPE</th><td>${ob.uomType }</td>
</tr>
<tr>
<th>DESCRIPTION</th><td>${ob.description }</td>
</tr>


</table>
</body>
</html>