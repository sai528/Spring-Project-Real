<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
				<h3 align="center" style="color: gold">ORDER METHOD DATA PAGE</h3>
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
								<th>MODE</th>
								<th>CODE</th>
								<th>TYPE</th>
								<th>ACCEPT</th>
								<th>NOTE</th>
								<th colspan="3">ACTION</th>
							</tr>
							<c:forEach items="${list}" var="om">
								<tr>
									<td>${om.ordId}</td>
									<td>${om.ordMode}</td>
									<td>${om.ordCode}</td>
									<td>${om.ordType}</td>
									<td>${om.ordAccept}</td>
									<td>${om.ordDesc}</td>
									<td><a href="view?ordid=${om.ordId}"><img
											src="../resources/images/viewright3.png" width="30"
											height="30"></a></td>
									<td><a href="edit?ordid=${om.ordId}"><img
											src="../resources/images/editgreen.png" width="30"
											height="30"></a></td>
									<td><a href="delete?ordid=${om.ordId}"><img
											src="../resources/images/deletecross.jpg" width="30"
											height="30"></a></td>
								</tr>

							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<h4 style="color: yellow">NO DATA FOUND</h4>
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