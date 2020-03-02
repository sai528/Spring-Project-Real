<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color: orange">PART VIEW PAGE</h3>
<body>
	<a href="excel?id=${pt.partId}">Excel Export</a>
	<br>
	<br>
	<a href="pdf?id=${pt.partId}">Pdf Export</a>
	<pre>
<table align='center' border='1' cellpadding='7' width='30%'>
<tr>
<th width="30%">ID</th>
				<td>${pt.partId}</td>
</tr>
<tr>
<th>CODE</th>
				<td>${pt.partCode}</td>
</tr>
<tr>
<th>WIDTH</th>
				<td>${pt.partWidth}</td>
</tr>
<tr>
<th>LENGTH</th>
				<td>${pt.partLength}</td>
</tr>
<tr>
<th>HEIGHT</th>
				<td>${pt.partHeight}</td>
</tr>
<tr>
<th>COST</th>
				<td>${pt.partBaseCost}</td>
</tr>
<tr>
<th>CURRENCY</th>
				<td>${pt.partBaseCurrency}</td>
</tr>
<%-- <tr>
<th>UOM</th><td>${pt.uom}</td>
</tr>
<tr>
<th>ORDER METHOD CODE</th><td>${pt.orderMethodCode}</td>
</tr> --%>
<tr>
<th>NOTE</th>
				<td>${pt.partDesc}</td>
</tr>

</table>
</pre>
	<a href="register">GO TO PART REGISTER</a>
</body>
</html>