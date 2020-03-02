<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color:yellow">ORDER METHOD VIEW PAGE</h3>
<body>
<a href="excel?id=${om.ordId}">EXCEL EXPORT</a>
<a href="pdf?id=${om.ordId}">PDF EXPORT</a>
<pre>
<table align='center' border='1' cellpadding='7' width='30%'>
<tr>
<th width="30%">ID</th><td>${om.ordId}</td>
</tr>
<tr>
<th>MODE</th><td>${om.ordMode}</td>
</tr>
<tr>
<th>CODE</th><td>${om.ordCode}</td>
</tr>
<tr>
<th>TYPE</th><td>${om.ordType}</td>
</tr>
<tr>
<th>ACCEPT</th><td>${om.ordAccept}</td>
</tr>
<tr>
<th>NOTE</th><td>${om.ordDesc}</td>
</tr>

</table>
</pre>
<a href="register">GO TO ORDER METHOD REGISTER</a>
</body>
</html>