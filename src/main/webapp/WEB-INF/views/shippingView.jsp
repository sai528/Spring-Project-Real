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
				<h3 align="center" style="color: gold">SHIPPING VIEW PAGE</h3>

			</div>
			<div class="card-body">
				<a href="excel?id=${sp.shippingId}"><img
					src="../resources/images/excelimg2.png" width="50" height="50"></a>&nbsp;
				&nbsp; &nbsp; <a href="pdf?id=${sp.shippingId}"><img
					src="../resources/images/pdfimg2.jpg" width="50" height="50"></a>


				<table align='center' border='1' cellpadding='7' width='30%'>
					<tr class="bg-success text-white">
						<th>ID</th>
						<td>${sp.shippingId}</td>
					</tr>
					<tr>
						<th>CODE</th>
						<td>${sp.shippingCode}</td>
					</tr>
					<tr>
						<th>SHIPPING REF NUM</th>
						<td>${sp.shippingRefNum}</td>
					</tr>
					<tr>
						<th>COURIER REF NUM</th>
						<td>${sp.courierRefNum}</td>
					</tr>
					<tr>
						<th>CONTACT DETAILS</th>
						<td>${sp.contactDetails}</td>
					</tr>
					<tr>
						<th>SALE ORDER CODE</th>
						<td>${sp.saleOrdCodeOb.ordCode}</td>
					</tr>
					<tr>
						<th>DESCRIPTION</th>
						<td>${sp.shippingDesc}</td>
					</tr>
					<tr>
						<th>BILL TO ADDRESS</th>
						<td>${sp.billToAddr}</td>
					</tr>
					<tr>
						<th>SHIP TO ADDRESS</th>
						<td>${sp.shipToAddr}
					</tr>

				</table>
			</div>
		</div>
		<!-- card end -->
	</div>
	<!-- container end -->

</body>
</html>