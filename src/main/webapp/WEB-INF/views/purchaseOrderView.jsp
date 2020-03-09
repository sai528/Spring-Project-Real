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
				<h3 align="center" style="color: brown">PURCHASE ORDER VIEW
					PAGE</h3>
			</div>
			<div class="card-body">
				<a href="excel?id=${po.purseId}"><img
					src="../resources/images/excelimg2.png" width="50" height="50"></a>
				&nbsp; &nbsp; &nbsp; <a href="pdf?id=${po.purseId}"><img
					src="../resources/images/pdfimg2.jpg" width="50" height="50"></a>

				<table align='center' border='1' cellpadding='7' width='30%'>
					<tr class="bg-success text-white">
						<th>ID</th>
						<td>${po.purseId}</td>
					</tr>
					<tr>
						<th>CODE</th>
						<td>${po.ordCode}</td>
					</tr>
					<tr>
						<th>SHIPCODE</th>
						<td>${po.shipCodeOb.shipCode}</td>
					</tr>
					<tr>
						<th>VENDOR</th>
						<td>${po.userVendorOb.userCode}</td>
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
			</div>
		</div>
		<!-- card end -->
	</div>
	<!-- container end -->
</body>
</html>