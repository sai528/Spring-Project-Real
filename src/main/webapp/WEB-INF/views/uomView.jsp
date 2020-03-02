<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color: blue">UOM VIEW PAGE</h3>
<body>
<a href="excel?id=${ou.uomId }">Excel Export</a>
<a href="pdf?id=${ou.uomId }">PDF Export</a>

	<pre>
<table align="center" border="1" cellpadding="7" width="30%">
<tr>
<th width="30%">ID</th>
				<td>${ou.uomId}</td>
</tr>
<tr>
<th>TYPE</th>
				<td>${ou.uomType}</td>
</tr>
<tr>
<th>MODEL</th>
				<td>${ou.uomModel}</td>
</tr>
<tr>
<th>NOTE</th>
				<td>${ou.uomDesc}</td>
</tr>

</table>
</pre>
	<a href="register">GO TO UOM REGISTER</a>
</body>
</html>