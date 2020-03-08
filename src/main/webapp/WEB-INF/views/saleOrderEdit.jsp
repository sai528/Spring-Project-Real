<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color: violet">WELCOME TO SALE ORDER
	REGISTER FORM</h3>
<body>
	<form:form action="update" method="post" modelAttribute="saleOrder">
		<pre>
<table align='center' border='5' cellpadding='7' width='50%'
				cellspacing='0'>
<tr>
<td>Sale Id :</td>
					<td><form:input path="saleId" readonly="true" /></td>
</tr>

<tr>
<td width="30%">Order Code :</td>
					<td><form:input path="ordCode" /></td>
</tr>

<tr>
<td>Ship Code: </td>
					<td><form:select path="shipCodeOb.shipId">
					<form:option value=" ">--select--</form:option>
                  <form:options items="${shipMap}"></form:options>
					</form:select></td>
</tr>
<tr>
<td>Vendor :</td>
					<td><form:select path="userCustomerOb.userId">
					<form:option value=" ">--select--</form:option>
                  <form:options items="${usertypeMap}"></form:options>
					</form:select></td>
</tr> 

<tr>
<td>Reference Number :</td>
					<td><form:input path="refNumber" /></td>
</tr>
<tr>
<td>Stock Mode :</td>
					<td><form:radiobutton path="stockMode" value="Grade" />Grade<form:radiobutton
							path="stockMode" value="Margin" />Margin</td>
</tr>
<tr>
<td>Stock Source :</td>
					<td><form:select path="stockSource">
                           <form:option value=" ">---select---</form:option>
                           <form:option value="OPEN"> OPEN </form:option>
                           <form:option value="AVAIL"> AVAIL </form:option>
                           <form:option value="REFUND"> REFUND </form:option>
                           </form:select></td>
</tr>                           
<tr>
<td>Default Status: </td>
					<td><form:input style="bgcolor:silver" path="defaultStatus"
							value="SALE-OPEN" readonly="true" /></td>
</tr>
<tr>
<td>Description :</td>
					<td><form:textarea path="saleDesc" /></td>
</tr>
<tr>
<td colspan="3" align="center"><input type="submit"
						value="SALE ORDER" /></td>
</tr>				


</table>
</pre>
		<a href="allsales" align="right">GET ALL SALE DATA</a>

	</form:form>
	${message}

</body>
</html>