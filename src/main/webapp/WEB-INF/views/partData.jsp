<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color: orange">PART DATA PAGE</h3>
<body>
	<c:choose>
		<c:when test="${!empty list}">
			<table align='center' border='1' width='50%'>
				<tr>
					<th>ID</th>
					<th>CODE</th>
					<th>WIDTH</th>
					<th>LENGTH</th>
					<th>HEIGHT</th>
					<th>COST</th>
					<th>CURRENCY</th>
					<!-- <th>UOM</th>
<th>ORDER METHOD CODE</th> -->
					<th>NOTE</th>
					<th colspan="3">ACTION</th>
				</tr>
				<c:forEach items="${list}" var="pt">
					<tr>
						<td>${pt.partId}</td>
						<td>${pt.partCode}</td>
						<td>${pt.partWidth}</td>
						<td>${pt.partLength}</td>
						<td>${pt.partHeight}</td>
						<td>${pt.partBaseCost}</td>
						<td>${pt.partBaseCurrency}</td>
						<%-- <td>${pt.uom}</td> 
<td>${pt.orderMethodCode}</td>  --%>
						<td>${pt.partDesc}</td>
						<td><a href="view?pid=${pt.partId}"><img
								src="../resources/images/viewimg2.png" width="30" height="30"></a></td>
						<td><a href="edit?pid=${pt.partId}"><img
								src="../resources/images/editimg2.png" width="30" height="30"></a></td>
						<td><a href="delete?pid=${pt.partId}"><img
								src="../resources/images/deleteimg3.png" width="30" height="30"></a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h4 style="color: red">NO DATA FOUND</h4>
		</c:otherwise>
	</c:choose>
	<a href="excel"><img src="../resources/images/excelimg2.png" width="50" height="50"></a>
&nbsp;  &nbsp; &nbsp;
<a href="pdf"><img src="../resources/images/pdfimg2.jpg" width="50" height="50"></a>
</body>
</html>