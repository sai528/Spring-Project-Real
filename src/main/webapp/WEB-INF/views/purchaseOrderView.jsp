<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color: brown">PURCHASE ORDER VIEW PAGE</h3>
<body>
	<a href="excel?id=${po.purseId}">Excel Export</a>
	<br>
	<br>
	<a href="pdf?id=${po.purseId}">Pdf Export</a>
	<pre>
<table align='center' border='1' cellpadding='7' width='30%'>
<tr>
<th width="30%">ID</th>
				<td>${po.purseId}</td>
</tr>
<tr>
<th>CODE</th>
				<td>${po.ordCode}</td>
</tr>
<tr>
<th>SHIPCODE</th><td>${po.shipCodeOb.shipCode}</td>
</tr>
<tr>
<th>VENDOR</th><td>${po.userVendorOb.userCode}</td>
</tr>
<tr>
<th>REF NUMBER</th>
				<td>${po.refNumber}</td>
</tr>
<tr>
<th>QUALITY</th>
				<td>${po.qualityCheck}</td>
</tr>
<tr>
<th>STATUS</th>
				<td>${po.defaultStatus}</td>
</tr>
<tr>
<th>NOTE</th>
				<td>${po.purDesc}</td>
</tr>

</table>
</pre>
	<a href="register">GO TO PURCHASE REGISTER</a>

</body>
</html>