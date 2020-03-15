<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<h3 align="center" style="color: blue">GOODS RECEIVE NOTE (GRN)
					DATA PAGE</h3>
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
								<th>TYPE</th>
								<th>PURCHASE ORDER CODE</th>
								<th>NOTE</th>
								<th colspan="3">ACTION</th>
							</tr>
							<c:forEach items="${list}" var="grn">
								<tr>
									<td>${grn.goodsId}</td>
									<td>${grn.goodsCode}</td>
									<td>${grn.goodsType}</td>
									<td>${grn.purseOrdCodeOb.ordCode}</td>
									<td>${grn.goodsDesc}</td>
									<td><a href="view?goodsid=${grn.goodsId}"><img
											src="../resources/images/viewimg2.png" width="30" height="30"></a></td>
									<td><a href="edit?goodsid=${grn.goodsId}"><img
											src="../resources/images/editimg2.png" width="30" height="30"></a></td>
									<td><a href="delete?goodsid=${grn.goodsId}"><img
											src="../resources/images/deleteimg3.png" width="30"
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
		<!-- card end -->
	</div>
	<!-- container end -->



</body>
</html>