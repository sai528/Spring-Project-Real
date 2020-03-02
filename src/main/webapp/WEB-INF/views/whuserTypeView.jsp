<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color: green">WHUSER TYPE VIEW PAGE</h3>
<body>
<a href="excel?id=${wt.userId}">Excel Export</a><br><br>
<a href="pdf?id=${wt.userId}">Pdf Export</a>
	<pre>
	<table align="center" border="1" cellpadding="7" width="30%">
		<tr>
			<th width="30%">ID</th>
				<td>${wt.userId}</td>
		</tr>
		<tr>
			<th>TYPE</th>
				<td>${wt.userType}</td>
		</tr>
		<tr>
			<th>CODE</th>
				<td>${wt.userCode}</td>
		</tr>
		<tr>
			<th>USER FOR</th>
				<td>${wt.userFor}</td>
		</tr>
		<tr>
			<th>EMAIL</th>
				<td>${wt.userEmail}</td>
		</tr>
		<tr>
			<th>CONTACT</th>
				<td>${wt.userContact}</td>
		</tr>
		<tr>
			<th>ID PROOF</th>
				<td>${wt.userIdType}</td>
		</tr>
		<tr>
			<th>OTHER</th>
				<td>${wt.ifOther}</td>
		</tr>
		<tr>
			<th>ID NUMBER</th>
				<td>${wt.idNumber}</td>
		</tr>

	</table>
	</pre>
	<a href="register">GOTO WHUSERTYPE REGISTER</a>

</body>
</html>