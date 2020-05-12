<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@include file="UserMenu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper">
    <!-- Sidebar -->
    <nav id="sidebar">
        <div class="sidebar-header">
            <h3>MODULES</h3>
        </div>

        <ul class="list-unstyled components">
            <p></p>
            <li class="active">
                <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Shipment Type</a>
                <ul class="collapse list-unstyled" id="homeSubmenu">
                    <li>
                        <a href="${url}/shipment/register">Shipment Register</a>
                    </li>
                    <li>
                        <a href="${url}/shipment/all">Shipment Data</a>
                    </li>
                    <li>
                        <a href="#"></a>
                    </li>
                </ul>
            </li>
              <li class="active">
                <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Purchase Order</a>
                <ul class="collapse list-unstyled" id="homeSubmenu">
                    <li>
                        <a href="${url}/purchase/register">PurchaseOrder Register</a>
                    </li>
                    <li>
                        <a href="${url}/purchase/all">PurchaseOrder  Data</a>
                    </li>
                    <li>
                        <a href="#"></a>
                    </li>
                </ul>
            </li>
             <li class="active">
                <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Part</a>
                <ul class="collapse list-unstyled" id="homeSubmenu">
                    <li>
                        <a href="${url}/part/register">Part Register</a>
                    </li>
                    <li>
                        <a href="${url}/part/all">Part  Data</a>
                    </li>
                    <li>
                        <a href="#"></a>
                    </li>
                </ul>
            </li>
            <li class="active">
                <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">WhUser Type</a>
                <ul class="collapse list-unstyled" id="homeSubmenu">
                    <li>
                        <a href="${url}/whuser/register">WhUser Register</a>
                    </li>
                    <li>
                        <a href="${url}/whuser/all">WhUser  Data</a>
                    </li>
                    <li>
                        <a href="#"></a>
                    </li>
                </ul>
            </li>
            <li class="active">
                <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Uom</a>
                <ul class="collapse list-unstyled" id="homeSubmenu">
                    <li>
                        <a href="${url}/uom/register">Uom Register</a>
                    </li>
                    <li>
                        <a href="${url}/uom/all">Uom  Data</a>
                    </li>
                    <li>
                        <a href="#"></a>
                    </li>
                </ul>
            </li>
            <li class="active">
                <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Order Method</a>
                <ul class="collapse list-unstyled" id="homeSubmenu">
                    <li>
                        <a href="${url}/order/register">Uom Register</a>
                    </li>
                    <li>
                        <a href="${url}/or/all">Uom  Data</a>
                    </li>
                    <li>
                        <a href="#"></a>
                    </li>
                </ul>
            </li>
           
    </nav>

	<h3>welcome to Shipment Type Register</h3>
	<br>
	<br>
	<pre>
	<form:form action="save" method="post" modelAttribute="shipmentType">
		
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
<form:option value="YES">YES</form:option>
<form:option value="NO">NO</form:option>
</form:select>
Shipment Grade:
<form:radiobutton path="shipmentGrade" value="A"/>A
<form:radiobutton path="shipmentGrade" value="B"/>B
<form:radiobutton path="shipmentGrade" value="c"/>C
Description:
<form:textarea path="shipDescription"></form:textarea>
<input type="submit" value="REGISTER">

	</form:form>
	</pre>
<h3>${message}</h3>
</div>
</body>

</html>