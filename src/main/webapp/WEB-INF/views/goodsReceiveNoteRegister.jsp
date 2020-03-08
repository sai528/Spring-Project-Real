<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color: black">WELCOME TO GOODS RECEIVE
	NOTE (GRN) REGISTER FORM</h3>
<body>
	<form:form action="savegoods" method="post"
		modelAttribute="goodsReceiveNote">
		<pre>
<table align='center' border='5' cellpadding='7' width='50%'
				cellspacing='0'>

<tr>
<td width="30%">GRN CODE:</td>
					<td><form:input path="goodsCode" /></td>
</tr>
<tr>
<td>GRN TYPE:</td>
					<td><form:input path="goodsType" /></td>
</tr>
<%-- <tr>
<td>Order Code:</td><td><form:select path="ordCode" /></td>
</tr> --%>

<tr>
<td>DESCRIPTION:</td>
					<td><form:textarea path="goodsDesc"></form:textarea></td>
</tr>

<tr>
<td colspan="3" align="center"><input type="submit"
						value="CREATE GOODS" /></td>
</tr>

</table>
</pre>
		<a href="allgoods" align="right">GET ALL GOODS DATA</a>
	</form:form>
	${message}
</body>
</html>