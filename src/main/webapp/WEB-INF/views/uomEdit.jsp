<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color: blue">UOM EDIT PAGE</h3>
<body>
	<form:form action="update" method="post" modelAttribute="uom">
		<pre>
<table align='center' border='5' cellpadding='7' width='50%'
				cellspacing='0'>
<!--  <tr><th colspan='2' >  </th></tr>-->
<tr>
<td>UOM ID:</td><td><form:input path="uomId" readonly="true"/></td>
</tr>

<tr>
<td width="30%">UOM TYPE:</td><td><form:select path="uomType">
				        <form:option value=" ">--select--</form:option>
				        <form:option value="PACKING">PACKING</form:option>
				        <form:option value="NO PACKING">NO PACKING</form:option>
				        <form:option value="NA">--NA--</form:option>
				        </form:select></td>
</tr>

<tr>
<td>UOM MODEL:</td><td><form:input path="uomModel" /></td>
</tr>

<tr>
<td>DESCRIPTION:</td><td><form:textarea path="uomDesc"></form:textarea></td>
</tr>

<tr>
<td colspan="3" align="center"><input type="submit" value="UPDATE UOM" /></td>
</tr>

</table>
</pre>
<a  href="alluoms" align="right">GET ALL UOMS DATA</a> 
	</form:form>
	${message}
</body>
</html>