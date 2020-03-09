<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<%@include file="userMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg bg-primary text-white text-center">
				<h3 align="center" style="color: white">WHUSER TYPE VIEW PAGE</h3>

			</div>
			<div class="card-body">

				<a href="excel?id=${wt.userId}"><img
					src="../resources/images/excelimg2.png" width="50" height="50"></a>
				&nbsp; &nbsp; &nbsp; <a href="pdf?id=${wt.userId}"><img
					src="../resources/images/pdfimg2.jpg" width="50" height="50"></a>

				<table align="center" border="1" cellpadding="7" width="30%">
					<tr class="bg-success text-white">
						<th>ID</th>
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
			</div>
		</div>
		<!-- card end -->
	</div>
	<!-- container end -->

</body>
</html>