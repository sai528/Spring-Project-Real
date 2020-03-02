<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color: violet">SALE ORDER VIEW PAGE</h3>
<body>
	<a href="excel?id=${so.saleId}">Excel Export</a>
	<br>
	<br>
	<a href="pdf?id=${so.saleId}">Pdf Export</a>
	<pre>
<table align='center' border='1' cellpadding='7' width='30%'>
<tr>
<th width="30%">ID</th>
				<td>${so.saleId}</td>
</tr>
<tr>
<th>CODE</th>
				<td>${so.ordCode}</td>
</tr>
<%-- <tr>
<th>SHIPCODE</th><td>${so.shipCode}</td>
</tr>
<tr>
<th>CUSTOMER</th><td>${so.userType}</td>
</tr> --%>
<tr>
<th>REF NUMBER</th>
				<td>${so.refNumber}</td>
</tr>
<tr>
<th>STOCKMODE</th>
				<td>${so.stockMode}</td>
</tr>
<tr>
<th>SOURCE</th>
				<td>${so.stockSource}</td>
</tr>
<tr>
<th>STATUS</th>
				<td>${so.defaultStatus}</td>
</tr>
<tr>
<th>NOTE</th>
				<td>${so.saleDesc}</td>
</tr>

</table>
</pre>
	<a href="register">GO TO SALE REGISTER</a>


</body>
</html>