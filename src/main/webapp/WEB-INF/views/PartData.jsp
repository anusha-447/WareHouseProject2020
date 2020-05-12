<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>part data</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
</body>
<div class="container">
<div class="card">
<div class="card-header">
</div>
<div class="card-body">
<c:choose>
					<c:when test="${!empty list }">
						<table class="table table-hover">
							<tr class="bg-success text-white">
								
								<th>CODE</th>
								<th>WIDTH</th>
								<th>HEIGHT</th>
								<th>lENGTH</th>
								<th>COST</th>
								<th>CURRENCY</th>
								<th>UOMTYPE</th>
								<th>NOTE</th>
								<th colspan="3">OPERATIONS</th>
							</tr>
							<!-- for(ShipmentType ob:list){} -->
							<c:forEach items="${list}" var="ob">
								<tr>

									<td>${ob.pcode}</td>
									<td>${ob.width}</td>
									<td>${ob.height}</td>
									<td>${ob.length}</td>
									<td>${ob.baseCost}</td>
									<td>${ob.baseCurrency}</td>
									<td>${ob.uomObj.uomModel}</td>
									<td>${ob.description}</td>
									
									<td><a href="delete?partId=${ob.pid}" > 
									<!-- <img src="../resources/images/delete.png" width="20" height="20" /> -->
									DELETE
									</a></td>
									<td><a href="edit?partId=${ob.pid}" > 
									<!-- <img	src="../resources/images/edit.png" width="20" height="20" /> -->
									EDIT
									</a></td>
									<td><a href="view?partId=${ob.pid}" > 
									<!-- <img src="../resources/images/view.png" width="20" height="20" /> -->
									VIEW
									
									</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<H4>NO DATA FOUND!!</H4>
					</c:otherwise>
				</c:choose>
			</div>
			
			
			
			
		</div> <!-- card end -->


	</div>
	<!-- container end -->






</html>