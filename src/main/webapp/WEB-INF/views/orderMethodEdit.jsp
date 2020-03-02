<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color: gold">ORDER EDIT PAGE</h3>
<body>
	<form:form action="update" method="post" modelAttribute="orderMethod">
		<pre>
<table align='center' border='5' cellpadding='7' width='50%'
				cellspacing='0'>
				
<tr>
<td> Order Id:</td>
					<td><form:input path="ordId" readonly="true" /></td>
</tr>
<tr>
<td width="30%">Order Mode:</td>
					<td><form:radiobutton path="ordMode" value="Sale" />Sale<form:radiobutton
							path="ordMode" value="Purchase" />Purchase</td>
</tr>

<tr>
<td>Order Code:</td>
					<td><form:input path="ordCode" /></td>
</tr>

<tr>
<td>Order Type:</td>
					<td><form:select path="ordType">
                          <form:option value="">--select--</form:option>
                          <form:option value="FIFO">FIFO</form:option>
                          <form:option value="LIFO">LIFO</form:option>
                          <form:option value="FCFO">FCFO</form:option>
                          <form:option value="FEFO">FEFO</form:option>
                          </form:select></td>
</tr>

<tr>
<td>Order Accept:</td>
					<td><form:checkbox path="ordAccept" value="Multi-Model" />Multi-Model<form:checkbox
							path="ordAccept" value="Accept Return" />Accept Return</td>
</tr>

<tr>
<td>Description:</td>
					<td><form:textarea path="ordDesc"></form:textarea></td>
</tr>

<tr>
<td colspan="3" align="center"><input type="submit"
						value="UPDATE ORDER" /></td>
</tr>

</table>
</pre>


		<a href="register">GO TO ORDER METHOD REGISTER</a>
	</form:form>
	${message}

</body>
</html>