<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color: brown">WELCOME TO PURCHASE ORDER
	REGISTER FORM</h3>
<body>
	<form:form action="save" method="post" modelAttribute="purchaseOrder">
		<pre>
<table align='center' border='5' cellpadding='7' width='50%'
				cellspacing='0'>
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
					<td><form:select path="userVendorOb.userId">
					<form:option value=" ">--select--</form:option>
                  <form:options items="${usertypeMap}"></form:options>
					</form:select></td>
</tr> 


<tr>
<td>Reference Number :</td>
					<td><form:input path="refNumber" /></td>
</tr>
<tr>
<td>Quality Check:</td>
					<td><form:radiobutton path="qualityCheck" value="Required" />Required<form:radiobutton
							path="qualityCheck" value="Not Required" />Not Required</td>
</tr>
<tr>
<td>Default Status: </td>
					<td><form:input style="bgcolor:silver" path="defaultStatus"
							value="OPEN" readonly="true" /></td>
</tr>
<tr>
<td>Description :</td>
					<td><form:textarea path="purDesc" /></td>
</tr>
<tr>
<td colspan="3" align="center"><input type="submit"
						value="PURCHASE ORDER" /></td>
</tr>				


</table>
</pre>
		<a href="allpurchases" align="right">GET ALL PURCHASE DATA</a>

	</form:form>
	${message}
</body>
</html>