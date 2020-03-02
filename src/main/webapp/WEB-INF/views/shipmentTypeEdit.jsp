<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3  align="center" style="color:red">SHIPMENTTYPE EDIT PAGE </h3>
<body>
	<form:form action="update" method="post" modelAttribute="shipmentType">
<pre>
<table align='center' border='5' cellpadding='7' width='50%' cellspacing='0'>
<!--  <tr><th colspan='2' >  </th></tr>-->

<tr>
<td> SHIP ID:</td><td><form:input path="shipId" readonly="true"/></td>
</tr>

<tr>
<td width="30%">SHIPMENT MODE:</td><td><form:select path="shipMode">
              <form:option value=" ">---select---</form:option>
              <form:option value="Air"> Air </form:option>
              <form:option value="Truck"> Truck </form:option>
              <form:option value="Train"> Train </form:option>
              <form:option value="Ship"> Ship </form:option>
              </form:select></td>
</tr>


<tr>             
<td>SHIPMENT CODE:</td><td><form:input path="shipCode" /></td>
</tr>

<tr>
<td>ENABLE SHIPMENT:</td><td><form:select path="enableShip">
                <form:option value=" ">-----select---</form:option>
                <form:option value="Yes">Yes</form:option>
                <form:option value="No">No</form:option>
                </form:select></td>
</tr>

<tr>          
<td>SHIPMENT GRADE: </td>
<td><form:radiobutton path="shipGrade" value="A"/>A<form:radiobutton path="shipGrade" value="B"/>B<form:radiobutton path="shipGrade" value="C"/>C</td>
</tr>

<tr>
<td>DESCRIPTION:</td><td><form:textarea path="shipDesc"></form:textarea></td>
</tr>

<tr>
<td colspan="3" align="center"><input type="submit" value="UPDATE SHIPMENT" /></td>
</tr>				


</table>
</pre>
<a  href="all" align="right">GET ALL SHIPMENTS DATA</a> 
	
	</form:form>
	${message}
</body>
</html>