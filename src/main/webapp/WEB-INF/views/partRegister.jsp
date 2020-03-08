<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
				<h3 align="center" style="color: orange">WELCOME TO PART
					REGISTER FORM</h3>
			</div>
			<div class="card-body">
				<form:form action="save" method="post" modelAttribute="part">
					<div class='row'>
						<div class='col-3'>
							<label for="partCode">PART CODE</label>
						</div>
						<div class='col-6'>
							<form:input path="partCode" class="form-control" />
						</div>
						<div class='col-3'></div>
					</div>

					<div class='row'>
						<div class='col-3'>
							<label>DIMENSIONS</label>
						</div>
						<div class='col-6'>
							<div class='row'>
								<div class='col-2'>
									<label for="partWidth">WIDTH</label>
								</div>
								<div class='col-2'>
									<form:input path="partWidth" class="form-control" />
								</div>
								<div class='col-2'>
									<label for="partLength">LENGTH</label>
								</div>
								<div class='col-2'>
									<form:input path="partLength" class="form-control" />
								</div>
								<div class='col-2'>
									<label for="partHeight">HEIGHT</label>
								</div>
								<div class='col-2'>
									<form:input path="partHeight" class="form-control" />
								</div>
							</div>
						</div>
						<div class='col-3'></div>
					</div>


					<div class='row'>
						<div class='col-3'>
							<label for="partBaseCost">BASE COST</label>
						</div>
						<div class='col-6'>
							<form:input path="partBaseCost" class="form-control" />
						</div>
						<div class='col-3'></div>
					</div>

					<div class='row'>
						<div class='col-3'>
							<label for="partBaseCurrency">BASE CURRENCY</label>
						</div>
						<div class='col-6'>
							<form:select path="partBaseCurrency" class="form-control">
								<form:option value="">--select--</form:option>
								<form:option value="INR">INR</form:option>
								<form:option value="USD">USD</form:option>
								<form:option value="AUS">AUS</form:option>
								<form:option value="ERU">ERU</form:option>
							</form:select>
						</div>
						<div class='col-3'></div>
					</div>

					<div class='row'>
						<div class='col-3'>
							<label for="uomOb.uomId">UOM</label>
						</div>
						<div class='col-6'>
							<form:select path="uomOb.uomId" class="form-control">
								<form:option value=" ">--select--</form:option>
								<form:options items="${uomMap}"></form:options>
								<%-- itemValue="uomId"
								itemLabel="uomModel"/> --%>
							</form:select>
						</div>
						<div class='col-3'></div>
					</div>

					<div class='row'>
						<div class='col-3'>
							<label>ORDER METHOD CODE</label>
						</div>
						<div class='col-6'>
							<div class='row'>
								<div class='col-3'>
									<label for='ordSaleOb.ordId'>ORDER SALE</label>
								</div>
								<div class='col-3'>
									<form:select path="ordSaleOb.ordId" class="form-control">
										<form:option value="">--select--</form:option>
										<form:options items="${orderMap}"></form:options>
									</form:select>
								</div>
								<div class='col-3'>
									<label for='ordPurchaseOb.ordId'>ORDER PURCHASE</label>
								</div>
								<div class='col-3'>
									<form:select path="ordPurchaseOb.ordId" class="form-control">
										<form:option value="">--select--</form:option>
										<form:options items="${ordMap}"></form:options>
									</form:select>
								</div>
							</div>
						</div>
						<div class='col-3'></div>
					</div>

					<div class='row'>
						<div class='col-3'>
							<label for="partDesc">DESCRIPTION</label>
						</div>
						<div class='col-6'>
							<form:textarea path="partDesc" class="form-control" />
						</div>
						<div class='col-3'></div>
					</div>

					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="Create" class="btn btn-success" /> <input
								type="reset" value="Clear" class="btn btn-danger" />

						</div>
					</div>
				</form:form>
			</div>
			<c:if test="${!empty message }">
				<div class="card-footer bg-info text-white text-center">
					<b>${message}</b>
				</div>
			</c:if>
		</div>
		<!-- card end -->
	</div>
	<!-- container end -->
</body>
</html>