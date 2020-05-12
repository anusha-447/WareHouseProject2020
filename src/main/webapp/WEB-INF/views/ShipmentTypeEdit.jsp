<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>welcome to Shipment Type Register</h3>
	<form:form action="update" method="post" modelAttribute="shipmentType">
		<pre>
		
ShipmentId  :
<form:input type="text" path="shipmentId" readonly=true/>
ShipmentMode:
<form:select path="shipmentMode">
<form:option value="">--select--</form:option>
<form:option value="Air">Air</form:option>
<form:option  value="Truck">Truck</form:option>
<form:option  value="Ship">Ship</form:option>
<form:option  value="Train">Train</form:option>
</form:select>
Shipment Code:
<form:input type="text" path="shipCode" />
Enable ShipmentType:
<form:select path="enableShipment">
<form:option value="">--select--</form:option>
<form:option value="Yes">Yes</form:option>
<form:option value="No">No</form:option>
</form:select>
Shipment Grade:
<form:radiobutton path="shipmentGrade" value="A"/>A
<form:radiobutton path="shipmentGrade" value="B"/>B
<form:radiobutton path="shipmentGrade" value="c"/>C
Description:
<form:textarea path="shipDescription"></form:textarea>
<input type="submit" value="UPDATE">
</pre>
	</form:form>
<h3>${message}</h3>
</body>
</html>