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
	<div class='container'>
		<div class='card'>
			<div
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3 align="center" style="color: brown">WELCOME TO PURCHASE
					ORDER REGISTER FORM</h3>
			</div>

			<div class="card-body">
				<form:form action="save" method="post"
					modelAttribute="purchaseOrder">

					<div class='row'>
						<div class='col-4'>
							<label for="ordCode">PURCHASE ORDER CODE</label>
						</div>
						<div class='col-4'>
							<form:input path="ordCode" class="form-control" />
						</div>
						<div class='col-2' id="ordCodeError"></div>
						<div class="col-2">
						<form:errors path="ordCode" cssClass="text-danger"/>
						</div>
					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="shipCodeOb.shipId">SHIP CODE</label>
						</div>
						<div class='col-4'>
							<form:select path="shipCodeOb.shipId" class="form-control">
								<form:option value="">--select--</form:option>
								<form:options items="${shipMap}"></form:options>
							</form:select>
						</div>
						<div class='col-4' id="shipCodeObshipIdError"></div>

					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="userVendorOb.userId">VENDOR</label>
						</div>
						<div class='col-4'>
							<form:select path="userVendorOb.userId" class="form-control">
								<form:option value="">--select--</form:option>
								<form:options items="${usertypeMap}"></form:options>
							</form:select>
						</div>
						<div class='col-4' id="userVendorObuserIdError"></div>
					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="refNumber">REFERENCE NUMBER</label>
						</div>
						<div class='col-4'>
							<form:input path="refNumber" class="form-control" />
						</div>
						<div class='col-4' id="refNumberError"></div>

					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="qualityCheck">QUALITY CHECK</label>
						</div>
						<div class='col-4'>
							<form:radiobutton path="qualityCheck" value="Required" />
							Required
							<form:radiobutton path="qualityCheck" value="Not Required" />
							Not Required
						</div>
						<div class='col-4' id="qualityCheckError"></div>

					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="defaultStatus">DEFAULT STATUS</label>
						</div>
						<div class='col-4'>
							<form:input path="defaultStatus" value="OPEN" readonly="true"
								class="form-control" />
						</div>
						<div class='col-4'></div>

					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="purDesc">DESCRIPTION</label>
						</div>
						<div class='col-4'>
							<form:textarea path="purDesc" class="form-control" />
						</div>
						<div class='col-4' id="purDescError"></div>
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

							$("#ordCodeError").hide;
							/*  $("#shipCodeObshipIdError").hide;
							$("#userVendorObuserIdError").hide; */
							$("#refNumberError").hide;
							$("#qualityCheckError").hide;
							$("#purDescError").hide;

							var ordCodeError = false;
							/* var shipCodeObshipIdError=false;
							var userVendorObuserIdError=false;  */
							var refNumberError = false;
							var qualityCheckError = false;
							var purDescError = false;

							$("#ordCode").keyup(function() {
								validate_ordCode();
							});

							/*  $("shipCodeOb.shipId").change(function() {
								validate_shipCodeObshipId();
							});

							$("userVendorOb.userId").change(function() {
								validate_userVendorObuserId();
							}); */

							$("#refNumber").keyup(function() {
								validate_refNumber();
							});

							$('input[type="radio"][name="qualityCheck"]')
									.click(function() {
										validate_qualityCheck();
									});

							$("#purDesc").keyup(function() {
								validate_purDesc();
							});

							function validate_ordCode() {
								var val = $("#ordCode").val();
								var exp = /^[\w]{2,8}$/
								if (val == "") {
									$("#ordCodeError").show();
									$("#ordCodeError").html(
											"Enter <b>purchase Order Code</b>");
									$("#ordCodeError").css("color", "red");
									ordCodeError = false;
								} else if (!exp.test(val)) {
									$("#ordCodeError").show();
									$("#ordCodeError")
											.html(
													"Enter <b> Only Alphabets And Digits<br/>MIN=2 Chars , MAX=8 Chars</b>");
									$("#ordCodeError").css("color", "red");
									ordCodeError = false;
								} else {
									$("#ordCodeError").hide();
									ordCodeError = true;
								}
								return ordCodeError;
							}

							/* function validate_shipCodeObshipId() {
								var val = $("#shipCodeOb.shipId").val();
								if (val == "") {
									$("#shipCodeObshipIdError").show();
									$("#shipCodeObshipIdError").html(
											"Select <b> Ship Code</b>");
									$("#shipCodeObshipIdError").css("color",
											"red");
									shipCodeObshipIdError = false;
								} else {
									$("#shipCodeObshipIdError").hide();
									shipCodeObshipIdError = true;
								}
								return shipCodeObshipIdError;
							}

							function validate_userVendorObuserId() {
								var val = $("#userVendorOb.userId").val();
								if (val == "") {
									$("#userVendorObuserIdError").show();
									$("#userVendorObuserIdError").html(
											"Enter <b>User Vendor</b>");
									$("#userVendorObuserIdError").css("color",
											"red");
									userVendorObuserIdError = false;
								} else {
									$("#userVendorObuserIdError").hide();
									userVendorObuserIdError = true;
								}
								return userVendorObuserIdError;
							}  */

							function validate_refNumber() {
								var val = $("#refNumber").val();
								var exp = /^[0-9]{0,20}$/;
								if (val == "") {
									$("#refNumberError").show();
									$("#refNumberError").html(
											"Enter <b> Reference Number</b>");
									$("#refNumberError").css("color", "red");
									refNumberError = false;
								} else if (!exp.test(val)) {
									$("#refNumberError").show();
									$("#refNumberError").html(
											"Enter <b>Only Digits </b>");
									$("#refNumberError").css("color", "red");
									refNumberError = false;
								} else {
									$("#refNumberError").hide();
									refNumberError = true;
								}
								return refNumberError;
							}

							function validate_qualityCheck() {
								var val = $('input[type="radio"][name="qualityCheck"]:checked').length;
								if (val == 0) {
									$("#qualityCheckError").show();
									$("#qualityCheckError").html(
											"Choose <b>Quality Check</b>");
									$("#qualityCheckError").css("color", "red");
									qualityCheckError = false;
								} else {
									$("#qualityCheckError").hide();
									qualityCheckError = true;
								}
								return qualityCheckError;
							}

							function validate_purDesc() {
								var val = $("#purDesc").val();
								var exp = /^[\.\-\w]{2,255}$/ //here w=Alpha Numeric with underscore(_)
								//var exp=/^[a-zA-Z0-9]{2,255}$/
								if (val == '') {
									$("#purDescError").show();
									$("#purDescError").html(
											"Enter <b> Description</b>");
									$("#purDescError").css("color", "red");
									purDescError = false;
								} else if (!exp.test(val)) {
									$("#purDescError").show();
									$("#purDescError")
											.html(
													"Enter <b>Only Alpha Numeric And ( . - _ )</br> MIN=2 Chars, MAX=255 Chars </b>");
									$("#purDescError").css("color", "red");
									purDescError = false;
								} else {
									$("#purDescError").hide();
									purDescError = true;
								}
								return purDescError;
							}

							$("#register").click(
									function() {

										ordCodeError = false;
										/* shipCodeObshipIdError=false;
										 userVendorObuserIdError=false;  */
										refNumberError = false;
										qualityCheckError = false;
										purDescError = false;

										validate_ordCode();
										/* validate_shipCodeObshipId();
										validate_userVendorObuserId();  */
										validate_refNumber();
										validate_qualityCheck();
										validate_purDesc();

										if (ordCodeError
												/* && shipCodeObshipIdError
												&& userVendorObuserIdError */
												&& refNumberError
												&& qualityCheckError
												&& purDescError) {
											return true;
										} else {
											return false;
										}

									})

						});
	</script>

</body>
</html>