<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color: violet">SALEORDER DATA PAGE</h3>
<body>
	<c:choose>
		<c:when test="${!empty list}">
			<table align='center' border='1' width='50%'>
				<tr>
					<th>ID</th>
					<th>CODE</th>
					<th>SHIPCODE</th>
					<th>CUSTOMER</th>
					<th>REF NUMBER</th>
					<th>STOCKMODE</th>
					<th>SOURCE</th>
					<th>STATUS</th>
					<th>NOTE</th>
					<th colspan="3">ACTION</th>
				</tr>
				<c:forEach items="${list}" var="so">
					<tr>
						<td>${so.saleId}</td>
						<td>${so.ordCode}</td>
						<td>${po.shipCodeOb.shipCode}</td>
						<td>${po.userCustomerOb.userCode}</td>
						<td>${so.refNumber}</td>
						<td>${so.stockMode}</td>
						<td>${so.stockSource}</td>
						<td>${so.defaultStatus}</td>
						<td>${so.saleDesc}</td>
						<td><a href="view?saleid=${so.saleId}"><img
								src="../resources/images/viewimg2.png" width="30" height="30"></a></td>
						<td><a href="edit?saleid=${so.saleId}"><img
								src="../resources/images/editimg2.png" width="30" height="30"></a></td>
						<td><a href="delete?saleid=${so.saleId}"><img
								src="../resources/images/deleteimg3.png" width="30" height="30"></a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h4 style="color: red">NO DATA FOUND</h4>
		</c:otherwise>
	</c:choose>
	<a href="excel"><img src="../resources/images/excelimg2.png"
		width="50" height="50"></a> &nbsp; &nbsp; &nbsp;
	<a href="pdf"><img src="../resources/images/pdfimg2.jpg" width="50"
		height="50"></a>



</body>
</html>