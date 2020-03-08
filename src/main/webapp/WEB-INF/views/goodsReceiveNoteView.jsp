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

<a href="excel?id=${grn.goodsId }">Excel Export</a>
<a href="pdf?id=${grn.goodsId }">PDF Export</a>

	<pre>
<table align="center" border="1" cellpadding="7" width="30%">
<tr>
<th width="30%">ID</th>
				<td>${grn.goodsId}</td>
</tr>
<tr>
<th>CODE</th>
				<td>${grn.goodsCode}</td>
</tr>
<tr>
<th>TYPE</th>
				<td>${grn.goodsType}</td>
</tr>
<%-- <tr>
<th>ORDER CODE</th>
				<td>${grn ordCode}</td>
</tr> --%>
<tr>
<th>NOTE</th>
				<td>${grn.goodsDesc}</td>
</tr>

</table>
</pre>
	<a href="register">GO TO GRN REGISTER</a>
</body>
</html>