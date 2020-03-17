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
				<h3 align="center" style="color: gold">SHIPPING DATA PAGE</h3>
			</div>
			<div class='card-body'>
				<a href="excel"><img src="../resources/images/excelimg2.png"
					width="50" height="50"></a> &nbsp; &nbsp; &nbsp; <a href="pdf"><img
					src="../resources/images/pdfimg2.jpg" width="50" height="50"></a>

				<c:choose>
					<c:when test="${!empty list}">
						<table class="table table-hover">
							<tr class="bg-success text-white">
								<th>ID</th>
								<th>CODE</th>
								<th>SHIPPING REF NUM</th>
								<th>COURIER REF NUM</th>
								<th>CONTACT DETAILS</th>
								<th>SALE ORDER CODE</th>
								<th>DESCRIPTION</th>
								<th>BILL TO ADDRESS</th>
								<th>SHIP TO ADDRESS</th>
								<th colspan='3'>OPERATIONS</th>
							</tr>
							<c:forEach items='${list}' var='sp'>
								<tr>
									<td>${sp.shippingId}</td>
									<td>${sp.shippingCode}</td>
									<td>${sp.shippingRefNum}</td>
									<td>${sp.courierRefNum}</td>
									<td>${sp.contactDetails}</td>
									<td>${sp.saleOrdCodeOb.ordCode}</td>
									<td>${sp.shippingDesc}</td>
									<td>${sp.billToAddr}</td>
									<td>${sp.shipToAddr}</td>
									<td><a href="view?shippingid=${sp.shippingId}"><img
											src="../resources/images/viewright3.png" width="30"
											height="30"></a></td>
									<td><a href="edit?shippingid=${sp.shippingId}"><img
											src="../resources/images/editgreen.png" width="30"
											height="30"></a></td>
									<td><a href="delete?shippingid=${sp.shippingId}"><img
											src="../resources/images/deletecross.jpg" width="30"
											height="30"></a></td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<h4 style="color: red">NO DATA FOUND</h4>
					</c:otherwise>
				</c:choose>
			</div>
			<c:if test="${!empty message }">
				<c:choose>
					<c:when test="${opr eq 'DEL'}">
						<div class="card-footer bg-danger text-white text-center">
							<b>${message }</b>
						</div>
					</c:when>
					<c:otherwise>
						<div class="card-footer bg-info text-white text-center">
							<b>${message }</b>
						</div>

					</c:otherwise>
				</c:choose>
			</c:if>
		</div>
	</div>

</body>
</html>