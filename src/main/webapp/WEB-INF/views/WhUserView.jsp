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

<a href="pdf?uid=${ob.userId }">ExportPdf</a>|

<a href="excel">ExportExcel</a>

<table border="1">
<tr>
<th>USER ID</th><td>${ob.userId }</td>
</tr>

<tr>
<th>USER TYPE</th><td>${ob.userType }</td>
</tr>
<tr>
<th>USERCODE</th><td>${ob.userCode }</td>
</tr>
<tr>
<th>USERFOR</th><td>${ob.userFor }</td>
</tr>
<tr>
<th>USEREMAIL</th><td>${ob.userEmail }</td>
</tr>

<tr>
<th>USERID TYPE</th><td>${ob.userIdType }</td>
</tr>
<tr>
<th>IF OTHER</th><td>${ob.ifOther }</td>
</tr>


</table>
</body>
</html>