<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<div
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3> Shipping UPDATE PAGE</h3>
			</div>
			<div class='card-body'>
				<form:form action="update" method="POST" modelAttribute="shipping">
					<div class="row">
						<div class="col-4">
							<label for="shippingId">SHIPPING ID</label>
						</div>
						<div class="col-4">
							<form:input path="shippingId" class="form-control" />
						</div>
						<div class="col-4"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="shippingCode">SHIPPING CODE</label>
						</div>
						<div class="col-4">
							<form:input path="shippingCode" class="form-control" />
						</div>
						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="shippingRefNum">SHIPPING REF NUMBER</label>
						</div>
						<div class="col-4">

							<form:input path="shippingRefNum" class="form-control" />
						</div>
						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="courierRefNum">COURIER REF NUMBER</label>
						</div>
						<div class="col-4">
							<form:input path="courierRefNum" class="form-control" />

						</div>
						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="contactDetails">CONTACT DETAILS</label>
						</div>
						<div class="col-4">
							<form:textarea path="contactDetails" class="form-control" />

						</div>
						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="saleOrdCode">SALE ORDER CODE</label>
						</div>
						<div class="col-4">

							<form:select path="saleOrdCodeOb.saleId" class="form-control">
								<form:option value="">--SELECT--</form:option>
								<form:options items="${saleOrdCodeMap}"></form:options>
							</form:select>
						</div>
						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="shippingDesc">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:textarea path="shippingDesc" class="form-control" />

						</div>
						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="billToAddr">BILL TO ADDRESS</label>
						</div>
						<div class="col-4">
							<form:textarea path="billToAddr" class="form-control" />

						</div>
						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="shipToAddr">SHIP TO ADDRESS</label>
						</div>
						<div class="col-4">

							<form:textarea path="shipToAddr" class="form-control" />
						</div>
						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="UPDATE" class="btn btn-success" /> <input
								type="reset" value="Clear" class="btn btn-danger" />

						</div>

					</div>
				</form:form>
			</div>
			<c:if test="${!empty message}">
				<div class="card-footer bg-info text-white text-center">
					<b>${message}</b>

				</div>
			</c:if>
		</div>
	</div>
</body>
</html>