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
				<h3 align="center" style="color: yellow">WELCOME TO PART
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
						<div class='col-3'>
							<div class='row'>
								<div class='col-6' id="partCodeError"></div>
								 <div class="col-6">
									<form:errors path="partCode" cssClass="text-danger" />
								</div> 
							</div>
						</div>
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
						<div class='col-3'>
							<div class='row'>
								<div class='col-4' id="partWidthError"></div>
								<div class='col-4' id="partLengthError"></div>
								<div class='col-4' id="partHeightError"></div>
							</div>
						</div>
					</div>


					<div class='row'>
						<div class='col-3'>
							<label for="partBaseCost">BASE COST</label>
						</div>
						<div class='col-6'>
							<form:input path="partBaseCost" class="form-control" />
						</div>
						<div class='col-3' id="partBaseCostError"></div>
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
						<div class='col-3' id="partBaseCurrencyError"></div>
					</div>

					<div class='row'>
						<div class='col-3'>
							<label for="uomOb.uomId">UOM</label>
						</div>
						<div class='col-6'>
							<form:select path="uomOb.uomId" class="form-control">
								<form:option value="">--select--</form:option>
								<form:options items="${uomMap}"></form:options>
								itemValue="uomId"
								itemLabel="uomModel"/>
							</form:select>
						</div>
						<div class='col-3' id="uomObuomIdError"></div>
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
						<div class='col-3'>
							<div class='row'>
								<div class='col-6' id="ordSaleObordIdError"></div>
								<div class="col-6" id="ordPurchaseObordIdError"></div>
							</div>
						</div>
					</div>

					<div class='row'>
						<div class='col-3'>
							<label for="partDesc">DESCRIPTION</label>
						</div>
						<div class='col-6'>
							<form:textarea path="partDesc" class="form-control" />
						</div>
						<div class='col-3' id="partDescError"></div>
					</div>

					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="Create" id="register"
								class="btn btn-success" /> <input type="reset" value="Clear"
								class="btn btn-danger" />

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

	 <script>
		$(document)
				.ready(
						function() {

							$("#partCodeError").hide;
							$("#partWidthError").hide;
							$("#partLengthError").hide;
							$("#partHeightError").hide;

							$("#partBaseCostError").hide;
							$("#partBaseCurrencyError").hide;
							$("#uomObuomIdError").hide;
							/*$("#ordSaleObordIdError").hide;
							$("#ordPurchaseObordIdError").hide; */
							$("#partDescError").hide;

							var partCodeError = false;
							var partWidthError = false;
							var partLengthError = false;
							var partHeightError = false;

							var partBaseCostError = false;
							var partBaseCurrencyError = false;
							var uomObuomIdError = false;
							/*var ordSaleObordIdError = false;
							var ordPurchaseObordIdError = false; */
							var partDescError = false;

							$("#partCode").keyup(function() {
								validate_partCode();
							});

							$("#partWidth").keyup(function() {
								validate_partWidth();
							});

							$("#partLength").keyup(function() {
								validate_partLength();
							});

							$("#partHeight").keyup(function() {
								validate_partHeight();
							});

							$("#partBaseCost").keyup(function() {
								validate_partBaseCost();
							});

							$("#partBaseCurrency").change(function() {
								validate_partBaseCurrency();
							});

							$("#uomOb.uomId").change(function() {
								validate_uomObuomId();
							});
							/*
							$("#ordSaleOb.ordId").change(function() {
							validate_ordSaleObordId();
							});

							$("#ordPurchaseOb.ordId").change(function() {
							validate_ordPurchaseObordId();
							}); */

							$("#partDesc").keyup(function() {
								validate_partDesc();
							});

							function validate_partCode() {
								var val = $("#partCode").val();
								var exp = /^[\w]{2,8}$/
								if (val == "") {
									$("#partCodeError").show();
									$("#partCodeError").html(
											"Enter <b> Part Code </b>");
									$("#partCodeError").css("color", "red");
									partCodeError = false;
								} else if (!exp.test(val)) {
									$("#partCodeError").show();
									$("#partCodeError")
											.html(
													"Enter <b>Only Alphabets And Digits<br/>MIN=2 Chars , MAX=8 Chars</b>");
									$("#partCodeError").css("color", "red");
									partCodeError = false;
								} else {
									$("#partCodeError").hide();
									partCodeError = true;

								}
								return partCodeError;
							}

							function validate_partWidth() {
								var val = $("#partWidth").val();
								var exp = /^[0-9]+$/;
								if (val == '') {
									$("#partWidthError").show();
									$("#partWidthError").html(
											"Enter <b>Part Width</b>");
									$("#partWidthError").css("color", "red");
									partWidthError = false;
								} else if (!exp.test(val)) {
									$("#partWidthError").show();
									$("#partWidthError").html(
											"Enter <b>Only Digits</b>");
									$("#partWidthError").css("color", "red");
									partWidthError = false;
								} else {
									$("#partWidthError").hide();
									partWidthError = true;
								}
								return partWidthError;
							}

							function validate_partLength() {
								var val = $("#partLength").val();
								var exp = /^[0-9]+$/;
								if (val == '') {
									$("#partLengthError").show();
									$("#partLengthError").html(
											"Enter <b>Part Length</b>");
									$("#partLengthError").css("color", "red");
									partLengthError = false;
								} else if (!exp.test(val)) {
									$("#partLengthError").show();
									$("#partLengthError").html(
											"Enter <b>Only Digits</b>");
									$("#partLengthError").css("color", "red");
									partLengthError = false;
								} else {
									$("#partLengthError").hide();
									partLengthError = true;
								}
								return partLengthError;
							}

							function validate_partHeight() {
								var val = $("#partHeight").val();
								var exp = /^[0-9]+$/;
								if (val == '') {
									$("#partHeightError").show();
									$("#partHeightError").html(
											"Enter <b>Part Height</b>");
									$("#partHeightError").css("color", "red");
									partHeightError = false;
								} else if (!exp.test(val)) {
									$("#partHeightError").show();
									$("#partHeightError").html(
											"Enter <b>Only Digits</b>");
									$("#partHeightError").css("color", "red");
									partHeightError = false;
								} else {
									$("#partHeightError").hide();
									partHeightError = true;
								}
								return partHeightError;
							}

							function validate_partBaseCost() {
								var val = $("#partBaseCost").val();
								var exp = /^[0-9]+$/;
								if (val == '') {
									$("#partBaseCostError").show();
									$("#partBaseCostError").html(
											"Enter <b>Base Cost</b>");
									$("#partBaseCostError").css("color", "red");
									partBaseCostError = false;
								} else if (!exp.test(val)) {
									$("#partBaseCostError").show();
									$("#partBaseCostError").html(
											"Enter <b>Only Digits</b>");
									$("#partBaseCostError").css("color", "red");
									partBaseCostError = false;
								} else {
									$("#partBaseCostError").hide();
									partBaseCostError = true;
								}
								return partBaseCostError;
							}

							function validate_partBaseCurrency() {
								var val = $("#partBaseCurrency").val();
								if (val == '') {
									$("#partBaseCurrencyError").show();
									$("#partBaseCurrencyError").html(
											"Select <b>Base Currency</b>");
									$("#partBaseCurrencyError").css("color",
											"red");
									partBaseCurrencyError = false;
								} else {
									$("#partBaseCurrencyError").hide();
									partBaseCurrencyError = true;
								}
								return partBaseCurrencyError;
							}

							/*function validate_uomObuomId() {
								var val = $("#uomOb.uomId").val();
								if (val == "") {
									$("#uomObuomIdError").show();
									$("#uomObuomIdError").html(
											"Select <b>Uom Code</b>");
									$("#uomObuomIdError").css("color", "red");
									uomObuomIdError = false;
								} else {
									$("#uomObuomIdError").hide();
									uomObuomIdError = true;
								}
								return uomObuomIdError;
							}

							function validate_ordSaleObordId() {
							var val = $("#ordSaleOb.ordId").val();
							if (val == '') {
								$("#ordSaleObordIdError").show();
								$("#ordSaleObordIdError").html(
										"Select <b>Order Sale</b>");
								$("#ordSaleObordIdError").css("color",
										"red");
								ordSaleOb.ordIdError = false;
							} else {
								$("#ordSaleObordIdError").hide();
								ordSaleObordIdError = true;
							}
							return ordSaleObordIdError;
							}

							function validate_ordPurchaseObordId() {
							var val = $("#ordPurchaseOb.ordId").val();
							if (val == '') {
								$("#ordPurchaseObordIdError").show();
								$("#ordPurchaseObordIdError").html(
										"Select <b>Order Purchase</b>");
								$("#ordPurchaseObordIdError").css("color",
										"red");
								ordPurchaseObordIdError = false;
							} else {
								$("#ordPurchaseObordIdError").hide();
								ordPurchaseObordIdError = true;
							}
							return ordPurchaseObordIdError;
							} */

							function validate_partDesc() {
								var val = $("#partDesc").val();
								var exp = /^[\.\-\w]{2,255}$/ //here w=Alpha Numeric with underscore(_)
								//var exp=/^[a-zA-Z0-9]{2,255}$/
								if (val == '') {
									$("#partDescError").show();
									$("#partDescError").html(
											"Enter <b>Part Description</b>");
									$("#partDescError").css("color", "red");
									partDescError = false;
								} else if (!exp.test(val)) {
									$("#partDescError").show();
									$("#partDescError")
											.html(
													"Enter <b>Only Alpha Numeric And ( . - _ )</br> MIN=2 Chars, MAX=255 Chars </b>");
									$("#partDescError").css("color", "red");
									partDescError = false;
								} else {
									$("#partDescError").hide();
									partDescError = true;
								}
								return partDescError;
							}

							$("#register").click(
									function() {

										 partCodeError = false;
										 partWidthError = false;
										 partLengthError = false;
										 partHeightError = false;
										 partBaseCostError = false;
										 partBaseCurrencyError = false;
										/* uomObuomIdError = false;
										 ordSaleObordIdError = false;
										 ordPurchaseObordIdError = false; */
										 partDescError = false;

										validate_partCode();
										validate_partWidth();
										validate_partLength();
										validate_partHeight();
										validate_partBaseCost();
										validate_partBaseCurrency();
										/*validate_uomObuomId();
										validate_ordSaleObordId();
										validate_ordPurchaseObordId(); */ 
										validate_partDesc();

										if (partCodeError && partWidthError
												&& partLengthError()
												&& partHeightError()
												&& partBaseCoseError
												&& partBaseCurrencyError
												/* && uomObuomIdError
												&& ordSaleObordIdError
												&& ordPurchaseObordIdError*/ 
												&& partDescError) {
											return true;
										} else {
											return false;
										}

									}); 

						});
	</script>
 
</body>
</html>