<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color: green">WAREHOUSING USER TYPE DATA
	PAGE</h3>
<body>
	<c:choose>
		<c:when test="${!empty list}">
			<table align='center' border='1' width='68%'>
				<tr>
					<th>ID</th>
					<th>TYPE</th>
					<th>CODE</th>
					<th>USER FOR</th>
					<th>EMAIL</th>
					<th>CONTACT</th>
					<th>ID PROOF</th>
					<th>OTHER</th>
					<th>ID NUMBER</th>
					<th colspan="3">ACTION</th>
				</tr>
				<c:forEach items="${list}" var="wt">

					<tr>
						<td>${wt.userId}</td>
						<td>${wt.userType}</td>
						<td>${wt.userCode}</td>
						<td>${wt.userFor}</td>
						<td>${wt.userEmail}</td>
						<td>${wt.userContact}</td>
						<td>${wt.userIdType}</td>
						<td>${wt.ifOther}</td>
						<td>${wt.idNumber}</td>
						<td><a href="view?userid=${wt.userId}"><img src="../resources/images/viewimg2.png" width="30" height="30"></a></td>
						<td><a href="edit?userid=${wt.userId}"><img src="../resources/images/editimg2.png" width="30" height="30"></a></td>
						<td><a href="delete?userid=${wt.userId}"><img src="../resources/images/deleteimg3.png" width="30" height="30"></a></td>
					</tr>
				</c:forEach>
				</c:when>
				<c:otherwise>
					<h4 style="color: green">NO DATA FOUND</h4>
				</c:otherwise>
				</c:choose>
<a href="excel"><img src="../resources/images/excelimg2.png" width="50" height="50"></a>
&nbsp;  &nbsp; &nbsp;
<a href="pdf"><img src="../resources/images/pdfimg2.jpg" width="50" height="50"></a>
</body>
</html>