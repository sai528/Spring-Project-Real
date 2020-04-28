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
				<h3 align="center" style="color: gold">WELCOME TO ORDER
					REGISTER FORM</h3>
			</div>

			<div class='card-body'>
				<form:form action="save" method="post" modelAttribute="orderMethod">

					<div class='row'>
						<div class='col-4'>
							<label for='ordMode'>ORDER MODE</label>
						</div>
						<div class='col-4'>
							<form:radiobutton path="ordMode" value="Sale" />
							Sale
							<form:radiobutton path="ordMode" value="Purchase" />
							Purchase
						</div>
						<div class='col-4' id="ordModeError"></div>
					</div>


					<div class='row'>
						<div class='col-4'>
							<label for='ordCode'>ORDER CODE</label>
						</div>
						<div class='col-4'>
							<form:input path="ordCode" class="form-control" />
						</div>
						<div class='col-2' id="ordCodeError"></div>
						<div class='col-2'>
							<form:errors path="ordCode" cssClass="text-danger" />
						</div>
					</div>


					<div class='row'>
						<div class='col-4'>
							<label for='ordType'>ORDER TYPE</label>
						</div>
						<div class='col-4'>
							<form:select path="ordType" class="form-control">
								<form:option value="">--select--</form:option>
								<form:option value="FIFO">FIFO</form:option>
								<form:option value="LIFO">LIFO</form:option>
								<form:option value="FMFO">FMFO</form:option>
								<form:option value="FEFO">FEFO</form:option>
							</form:select>

						</div>
						<div class='col-4' id="ordTypeError"></div>
					</div>


					<div class='row'>
						<div class='col-4'>
							<label for='ordAccept'>ORDER ACCEPT</label>
						</div>
						<div class='col-4'>
							<form:checkbox path="ordAccept" value="Multi-Model" />
							Multi-Model
							<form:checkbox path="ordAccept" value="Accept Return" />
							Accept Return
						</div>
						<div class='col-4' id="ordAcceptError"></div>
					</div>


					<div class='row'>
						<div class='col-4'>
							<label for='ordDesc'>DESCRIPTION</label>
						</div>
						<div class='col-4'>
							<form:textarea path="ordDesc" class="form-control"></form:textarea>
						</div>
						<div class='col-4' id="ordDescError"></div>
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

							$("#ordModeError").hide();
							$("#ordCodeError").hide();
							$("#ordTypeError").hide();
							$("#ordAcceptError").hide();
							$("#ordDescError").hide();

							var ordModeError = false;
							var ordCodeError = false;
							var ordTypeError = false;
							var ordAcceptError = false;
							var ordDescError = false;

							$('input[type="radio"][name="ordMode"]').change(
									function() {
										validate_ordMode();
									});

							$("#ordCode").keyup(function() {
								validate_ordCode();
							});

							$("#ordType").change(function() {
								validate_ordType();
							});

							$('input[type="checkbox"][name="ordAccept"]')
									.change(function() {
										validate_ordAccept();
									});

							$("#ordDesc").keyup(function() {
								validate_ordDesc();
							});

							function validate_ordMode() {
								var val = $('input[type="radio"][name="ordMode"]:checked').length;
								if (val == 0) {
									$("#ordModeError").show();
									$("#ordModeError").html(
											"Choose <b> Order Mode </b>");
									$("#ordModeError").css("color", "red");
									ordModeError = false;
								} else {
									$("#ordModeError").hide();
									ordModeError = true;
								}
								return ordModeError;

							}

							function validate_ordCode() {
								var val = $("#ordCode").val();
								var exp = /^[A-Z0-9]{2,8}$/
								if (val == "") {
									$("#ordCodeError").show();
									$("#ordCodeError").html(
											"Enter <b> Order Code </b>");
									$("#ordCodeError").css("color", "red");
									ordCodeError = false;
								} else if (!exp.test(val)) {
									$("#ordCodeError").show();
									$("#ordCodeError")
											.html(
													"Enter <b> Only Upper Case Letters And Digits<br/>MIN=2 Chars , MAX=8 Chars</b>");
									$("#ordCodeError").css("color", "red");
									ordCodeError = false;
								} else {
									$("#ordCodeError").hide();
									ordCodeError = true;
								}
								return ordCodeError;
							}

							function validate_ordType() {
								var val = $("#ordType").val();
								if (val == "") {
									$("#ordTypeError").show();
									$("#ordTypeError").html(
											"Select <b> Order Type </b>");
									$("#ordTypeError").css("color", "red");
									ordTypeError = false;
								} else {
									$("#ordTypeError").hide();
									ordTypeError = true;
								}
								return ordTypeError;
							}

							function validate_ordAccept() {
								var val = $('input[type="checkbox"][name="ordAccept"]:checked').length;
								if (val == 0) {
									$("#ordAcceptError").show();
									$("#ordAcceptError")
											.html(
													"Choose <b>At Least One Option</b>");
									$("#ordAcceptError").css("color", "red");
									ordAcceptError = false;
								} else {
									$("#ordAcceptError").hide();
									ordAcceptError = true;
								}
								return ordAcceptError;
							}

							function validate_ordDesc() {
								var val = $("#ordDesc").val();
								var exp = /^[a-zA-Z0-9.-_]{2,255}$/;
								//var exp=/^[\.\-\w]{2,255}$/ here w=Alpha Numeric with underscore(_)
								if (val == "") {
									$("#ordDescError").show();
									$("#ordDescError").html(
											"Enter <b> Order Description </b>");
									$("#ordDescError").css("color", "red");
									ordCodeError = false;
								} else if (!exp.test(val)) {
									$("#ordDescError").show();
									$("#ordDescError")
											.html(
													"Enter <b>Only Alpha Numeric And ( . - _ )</br> MIN=2 Chars, MAX=255 Chars </b>");
									$("#ordDescError").css("color", "red");
									ordCodeError = false;
								} else {
									$("#ordDescError").hide();
									ordDescError = true;
								}
								return ordDescError;
							}

							$("#register").click(
									function() {

										ordModeError = false;
										ordCodeError = false;
										ordTypeError = false;
										ordAcceptError = false;
										ordDescError = false;

										validate_ordMode();
										validate_ordCode();
										validate_ordType();
										validate_ordAccept();
										validate_ordDesc();

										if (ordModeError && ordCodeError
												&& ordTypeError
												&& ordAcceptError
												&& ordDescError) {
											return true;
										} else
											return false;

									});

						});
	</script>
</body>
</html>