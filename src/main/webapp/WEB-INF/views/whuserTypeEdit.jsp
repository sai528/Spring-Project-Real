<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color: green">WAREHOUSING USER TYPE EDIT PAGE</h3>
<body>
	
	<form:form action="update" method="post" modelAttribute="whUserType">
		<pre>
<table align="center" border="5" cellpadding='7' width='50%'
				cellspacing='0'>
<tr>
<td>User Id:</td><td><form:input path="userId" readonly="true"/></td>
</tr>

<tr>
<td width='30%'>User Type:</td><td><form:radiobutton path="userType" autocomplete="Purchase" value="Vendor"/>Vendor<form:radiobutton path="userType" autocomplete="Sale" value="Customer"/>Customer</td>
</tr>

<tr>
<td>User Code:</td>
					<td><form:input path="userCode" /></td>
</tr>

<tr>
<td>User For:</td><td><form:input autocomplete="Purchase/Sale" path="userFor"/></td>
</tr>

<tr>
<td>User Email:</td><td><form:input path="userEmail"/></td>
</tr>

<tr>
<td>User Contact: </td><td><form:input path="userContact"/></td>
</tr>

<tr>
<td>User ID Type: </td><td><form:select path="userIdType">
                         <form:option value="">---SELECT---</form:option>
                         <form:option value="PAN CARD">PAN CARD</form:option>
                         <form:option value="AADHAR CARD">AADHAR CARD</form:option>
                         <form:option value="VOTER ID CARD">VOTER ID CARD</form:option>
                         <form:option value="OTHER">OTHER</form:option>
                         </form:select></td>
</tr>

<tr>
<td>If Other:</td><td><form:input path="ifOther"/></td>
</tr>

<tr>
<td> ID Number:</td><td><form:input path="idNumber"/></td>
</tr>

<tr>
<td colspan="2" align="center"><input type="submit" value="UPDATE USER"/></td>
</tr>

</table>
</pre>
<a href="allwhusers">GET ALL WHUSERS DATA</a>
	</form:form>
${message}
</body>
</html>