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
	<%@include file='userMenu.jsp'%>
	<div class='container'>
		<div class='card'>
			<div
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3 align="center" style="color: violet">WELCOME TO SALE ORDER
					REGISTER FORM</h3>
			</div>

			<div class="card-body">
				<form:form action="save" method="post" modelAttribute="saleOrder">
					<div class='row'>
						<div class='col-4'>
							<label for="ordCode">SALE ORDER CODE</label>
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
							<label for="userCustomerOb.userId">CUSTOMER</label>
						</div>
						<div class='col-4'>
							<form:select path="userCustomerOb.userId" class="form-control">
								<form:option value="">--select--</form:option>
								<form:options items="${usertypeMap}"></form:options>
							</form:select>
						</div>
						<div class='col-4' id="userCustomerObuserIdError"></div>
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
							<label for="stockMode">STOCK MODE</label>
						</div>
						<div class='col-4'>
							<form:radiobutton path="stockMode" value="Grade" />
							Grade
							<form:radiobutton path="stockMode" value="Margin" />
							Margin
						</div>
						<div class='col-4' id="stockModeError"></div>
					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="stockSource">STOCK SOURCE</label>
						</div>
						<div class='col-4'>
							<form:select path="stockSource" class="form-control">
								<form:option value="">---select---</form:option>
								<form:option value="OPEN"> OPEN </form:option>
								<form:option value="AVAIL"> AVAIL </form:option>
								<form:option value="REFUND"> REFUND </form:option>
							</form:select>
						</div>
						<div class='col-4' id="stockSourceError"></div>
					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="defaultStatus">DEFAULT STATUS</label>
						</div>
						<div class='col-4'>
							<form:input path="defaultStatus" value="SALE-OPEN"
								readonly="true" class="form-control" />
						</div>
						<div class='col-4'></div>
					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="saleDesc">DESCRIPTION</label>
						</div>
						<div class='col-4'>
							<form:textarea path="saleDesc" class="form-control" />
						</div>
						<div class='col-4' id="saleDescError"></div>
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
							$("#ordCodeError").hide();
							/* $("#shipCodeObshipIdError").hide();
							$("#userCustomerObuserIdError").hide(); */
							$("#refNumberError").hide();
							$("#stockModeError").hide();
							$("#stockSourceError").hide();
							$("#saleDescError").hide();

							var ordCodeError = false;
							/* var shipCodeObshipIdError = false;
							var userCustomerObuserIdError = false; */
							var refNumberError = false;
							var stockModeError = false;
							var stockSourceError = false;
							var saleDescError = false;

							$("#ordCode").keyup(function() {
								validate_ordCode();
							});

							/* $("#shipCodeOb.shipId").change(function() {
								validate_shipCodeObshipId();
							});

							$("#userCustomerOb.userId").change(function() {
								validate_userCustomerObuserId();
							}); */

							$("#refNumber").keyup(function() {
								validate_refNumber();
							});

							$('input[type="radio"][name="stockMode"]').click(
									function() {
										validate_stockMode();
									});
							$("#stockSource").change(function() {
								validate_stockSource();
							});

							$("#saleDesc").keyup(function() {
								validate_saleDesc();
							});

							function validate_ordCode() {
								var val = $("#ordCode").val();
								var exp = /^[\w]{2,8}$/
								if (val == '') {
									$("#ordCodeError").show();
									$("#ordCodeError").html(
											"Enter <b> Sale Order Code</b>");
									$("#ordCodeError").css("color", "red");
									ordCodeError = false;
								} else if (!exp.test(val)) {
									$("#ordCodeError").show();
									$("#ordCodeError")
											.html(
													"Enter <b> Only Alphabets And Digits<br/> MIN=2 Chars , MAX=8 Chars</b>");
									$("#ordCodeError").css("color", "red");
									ordCodeError = false;
								} else {
									$("#ordCodeError").hide();
									ordCodeError = true;
								}
								return ordCodeError;
							}

							function validate_refNumber() {
								var val = $("#refNumber").val();
								var exp = /^[0-9]+$/;
								if (val == '') {
									$("#refNumberError").show();
									$("#refNumberError").html(
											"Enter <b> ReferenceNumber</b>");
									$("#refNumberError").css("color", "red");
									refNumberError = false;
								} else if (!exp.test(val)) {
									$("#refNumberError").show();
									$("#refNumberError").html(
											"Enter <b> Only Digits</b>");
									$("#refNumberError").css("color", "red");
									refNumberError = false;
								} else {
									$("#refNumberError").hide();
									refNumberError = true;
								}
								return refNumberError;
							}

							function validate_stockMode() {
								var val = $('input[type="radio"][name="stockMode"]:checked').length;
								if (val == 0) {
									$("#stockModeError").show();
									$("#stockModeError").html(
											"Choose <b>Stock Mode</b>");
									$("#stockModeError").css("color", "red");
									stockModeError = false;
								} else {
									$("#stockModeError").hide();
									stockModeError = true;
								}
								return stockModeError;
							}

							function validate_stockSource() {
								var val = $("#stockSource").val();
								if (val == "") {
									$("#stockSourceError").show();
									$("#stockSourceError").html(
											"Select <b>Stock Source </b>");
									$("#stockSourceError").css("color", "red");
									stockSourceError = false;
								} else {
									$("#stockSourceError").hide();
									stockSourceError = true;
								}
								return stockSourceError;
							}

							function validate_saleDesc() {
								var val = $("#saleDesc").val();
								var exp = /^[\.\-\w]{2,255}$/ //here w=Alpha Numeric with underscore(_)
								//var exp=/^[a-zA-Z0-9]{2,255}$/
								if (val == '') {
									$("#saleDescError").show();
									$("#saleDescError").html(
											"Enter <b> Sale Description</b>");
									$("#saleDescError").css("color", "red");
									saleDescError = false;
								} else if (!exp.test(val)) {
									$("#saleDescError").show();
									$("#saleDescError")
											.html(
													"Enter <b>Only Alpha Numeric And ( . - _ )</br> MIN=2 Chars, MAX=255 Chars </b>");
									$("#saleDescError").css("color", "red");
									saleDescError = false;
								} else {
									$("#saleDescError").hide();
									saleDescError = true;
								}
								return saleDescError;
							}

							$("#register").click(
									function() {

										ordCodeError = false;
										/* shipCodeObshipIdError = false;
										userCustomerObuserIdError = false; */
										refNumberError = false;
										stockModeError = false;
										stockSourceError = false;
										saleDescError = false;

										validate_ordCode();
										/* validate_shipCodeObshipId();
										validate_userCustomerObuserId(); */
										validate_refNumber();
										validate_stockMode();
										validate_stockSource();
										validate_saleDesc();

										if (ordCodeError
												/* && shipCodeObshipIdError
												&& userCustomerObuserIdError */
												&& refNumberError
												&& stockModeError
												&& stockSourceError
												&& saleDescError) {
											return true;
										} else {
											return false;
										}

									});

						});
	</script>


</body>
</html>