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
				<h3 align="center" style="color: red">SHIPMENT TYPE VIEW PAGE</h3>

			</div>
			<div class="card-body">
				<a href="excel?id=${ob.shipId}"><img
					src="../resources/images/excelimg2.png" width="50" height="50"></a>
				&nbsp; &nbsp; &nbsp; <a href="pdf?id=${ob.shipId}"><img
					src="../resources/images/pdfimg2.jpg" width="50" height="50"></a>
					
					<table align="center" border="1" cellpadding="7" width="30%">
				<!-- <table class="table table-hover"> -->
					<tr class="bg-success text-white">
						<th>ID</th>
						<td>${ob.shipId}</td>
					</tr>
					<tr>
						<th>MODE</th>
						<td>${ob.shipMode}</td>
					</tr>
					<tr>
						<th>CODE</th>
						<td>${ob.shipCode}</td>
					</tr>
					<tr>
						<th>ENABLE</th>
						<td>${ob.enableShip}</td>
					</tr>
					<tr>
						<th>GRADE</th>
						<td>${ob.shipGrade}</td>
					</tr>
					<tr>
						<th>NOTE</th>
						<td>${ob.shipDesc}</td>
					</tr>

				</table>
				</div>
			</div>
			<!-- card end -->
		</div>
		<!-- container end -->

</body>
</html>