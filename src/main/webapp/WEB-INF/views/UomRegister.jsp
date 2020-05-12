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
<pre>
<h4>Welcome to UOM Register</h4>

<form:form action="save" method="post" modelAttribute="uom">
UOM Type   : <form:select path="uomType">
            <form:option value="">---SELECT----</form:option>
            <form:option  value="PACKING">PACKING</form:option>
            <form:option  value="NO PACKING">NO PACKING</form:option>
            <form:option  value="NA">NA</form:option>
            </form:select>
              
            
UOM Model   :<form:input type="text" path="uomModel"/>

Description :
             <form:textarea path="Description"></form:textarea>
            
            
             
             <input type="submit" value="REGISTER"/>
             
  </form:form>      
  ${message }     
        
</pre>
</body>
</html>