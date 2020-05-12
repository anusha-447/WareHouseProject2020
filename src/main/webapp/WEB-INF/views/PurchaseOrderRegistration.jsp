<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
            <li>
                <a href="#">About</a>
            </li>
            <li>
                <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Pages</a>
                <ul class="collapse list-unstyled" id="pageSubmenu">
                    <li>
                        <a href="#">Page 1</a>
                    </li>
                    <li>
                        <a href="#">Page 2</a>
                    </li>
                    <li>
                        <a href="#">Page 3</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#">Portfolio</a>
            </li>
            <li>
                <a href="#">Contact</a>
            </li>
        </ul>
    </nav>

<h3>Welcome Purchase Registration Page</h3>

<pre>

<form:form action="save" method="post" modelAttribute="purchaseOrder">



Reference Number  : <form:input path="referenceNum"/> 

Order Code        : <form:input path="orderCode"/> 

Quality Check     : <form:radiobutton path="qualityCheck" value="Required"/>Required
                  <form:radiobutton path="qualityCheck" value="Not Required"/>Not Required
               
               
ShipmentType Code :<form:select path="shipOb.shipmentId">
                 <form:option value="">--SELECT</form:option>
                 <form:options items="${shipMap}"/>
                 </form:select>
                 
Vendor          : <form:select path="vendor.userId">
                 <form:option value="">--SELECT</form:option>
                 <form:options items="${userMap}"/>
                 </form:select>   
Default Status   :<form:input path="status"/>

Description      :<form:input path="Description"/>


                  <input type="submit" value="PLACE ORDER">


</form:form>
</pre>
${message }
</div>
</body>
</html>
