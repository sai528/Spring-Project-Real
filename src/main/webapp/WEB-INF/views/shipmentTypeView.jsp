<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color:red">SHIPMENT TYPE VIEW PAGE</h3>
<body>
<a href="excel?id=${ob.shipId}">Excel Export</a><br><br>
<a href="pdf?id=${ob.shipId}">Pdf Export</a>
<pre>
<table align='center' border='1' cellpadding='7' width='30%'>
<tr>
<th width="30%">ID</th><td>${ob.shipId}</td>
</tr>
<tr>
<th>MODE</th><td>${ob.shipMode}</td>
</tr>
<tr>
<th>CODE</th><td>${ob.shipCode}</td>
</tr>
<tr>
<th>ENABLE</th><td>${ob.enableShip}</td>
</tr>
<tr>
<th>GRADE</th><td>${ob.shipGrade}</td>
</tr>
<tr>
<th>NOTE</th><td>${ob.shipDesc}</td>
</tr>

</table>
</pre>
<a href="register">GO TO SHIPMENT REGISTER</a>
</body>
</html>