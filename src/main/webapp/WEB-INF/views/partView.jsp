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
				<h3 align="center" style="color: yellow">PART VIEW PAGE</h3>
			</div>
			<div class="card-body">
				<a href="excel?id=${pt.partId}"><img
					src="../resources/images/excelimg2.png" width="50" height="50"></a>
				&nbsp; &nbsp; &nbsp; <a href="pdf?id=${pt.partId}"><img
					src="../resources/images/pdfimg2.jpg" width="50" height="50"></a>

				<table align='center' border='1' cellpadding='7' width='30%'>
					<tr class="bg-success text-white">
						<th>ID</th>
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
					<tr>
						<th>UOM</th>
						<td>${pt.uomOb.uomModel}</td>
					</tr>
					<tr>
						<th>ORDER SALE</th>
						<td>${pt.ordSaleOb.ordCode}</td>
					</tr>
					<tr>
						<th>ORDER PURCHASE</th>
						<td>${pt.ordPurchaseOb.ordCode}</td>
					</tr>
					<tr>
						<th>NOTE</th>
						<td>${pt.partDesc}</td>
					</tr>

				</table>
			</div>
		</div>
		<!-- card end -->
	</div>
	<!-- container end -->
</body>
</html>