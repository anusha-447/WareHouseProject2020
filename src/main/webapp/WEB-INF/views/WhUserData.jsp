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
 <h4>WhUser Data</h4>
 <a href="excel">ExcelExport</a>|
 <a href="pdf">PdfExport</a>
 <c:choose>
 <c:when test="${!empty list}">

 
 <table border=1>
  <tr>
 <th>USER TYPE</th>
 <th>USER CODE</th>
  <th>USER FOR</th>
 <th>USER EMAIL</th>
 <th>USER ID TYPE</th>
 <th>IF OTHER</th>
 <th>ID NUMBER</th>
 <th colspan="3">OPERATION</th>
</tr>

<c:forEach items="${list}" var="ob">

<tr>
<td>${ob.userType}</td>
<td>${ob.userCode}</td>
<td>${ob.userFor }</td>
<td>${ob.userEmail }</td>
<td>${ob.userIdType }</td>
<td>${ob.ifOther }</td>
<td>${ob.idNumber }</td>

<td>
<a href="delete?uid=${ob.userId}">DELETE</a> 


</td>
<td>
<a href="edit?uid=${ob.userId}">EDIT</a>
</td>
<td>
<a href="view?uid=${ob.userId}">VIEW</a>
</td>
</tr>
</c:forEach>


</table>
</c:when>
<c:otherwise>
<h4>no data found</h4>
</c:otherwise>
</c:choose>
</body>
</html>