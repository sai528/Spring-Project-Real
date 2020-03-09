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
				<h3 align="center" style="color: gold">ORDER METHOD VIEW PAGE</h3>

			</div>
			<div class="card-body">
				<a href="excel?id=${om.ordId}"><img
					src="../resources/images/excelimg2.png" width="50" height="50"></a>&nbsp;
				&nbsp; &nbsp; <a href="pdf?id=${om.ordId}"><img
					src="../resources/images/pdfimg2.jpg" width="50" height="50"></a>


				<table align='center' border='1' cellpadding='7' width='30%'>
					<tr class="bg-success text-white">
						<th>ID</th>
						<td>${om.ordId}</td>
					</tr>
					<tr>
						<th>MODE</th>
						<td>${om.ordMode}</td>
					</tr>
					<tr>
						<th>CODE</th>
						<td>${om.ordCode}</td>
					</tr>
					<tr>
						<th>TYPE</th>
						<td>${om.ordType}</td>
					</tr>
					<tr>
						<th>ACCEPT</th>
						<td>${om.ordAccept}</td>
					</tr>
					<tr>
						<th>NOTE</th>
						<td>${om.ordDesc}</td>
					</tr>

				</table>

			</div>
		</div>
		<!-- card end -->
	</div>
	<!-- container end -->
</body>
</html>