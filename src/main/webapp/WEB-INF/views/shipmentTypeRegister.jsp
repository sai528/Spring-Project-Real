<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"> 
</script> -->
</head>
<body>
	<%@include file="userMenu.jsp"%>
	<div class="container">

		<div class="card">

			<div
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3 align="center" style="color: red">WELCOME TO SHIPMENTTYPE
					REGISTER FORM</h3>
			</div>

			<div class="card-body">

				<form:form action="save" method="post" modelAttribute="shipmentType">

					<div class="row">
						<div class="col-4">
							<label for="shipMode">SHIPMENT MODE</label>
						</div>
						<div class="col-4">
							<form:select path="shipMode" class="form-control">
								<form:option value="">--select--</form:option>
								<form:option value="Air"> Air </form:option>
								<form:option value="Truck"> Truck </form:option>
								<form:option value="Train"> Train </form:option>
								<form:option value="Ship"> Ship </form:option>
							</form:select>
						</div>
						<div class="col-4" id="shipModeError"></div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="shipCode">SHIPMENT CODE</label>
						</div>
						<div class="col-4">
							<form:input path="shipCode" id="shipCode" class="form-control" />
						</div>
						<div class="col-4" id="shipCodeError"></div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="enableShip">ENABLE SHIPMENT</label>
						</div>
						<div class="col-4">

							<form:select path="enableShip" class="form-control">
								<form:option value="">--select--</form:option>
								<form:option value="Yes">Yes</form:option>
								<form:option value="No">No</form:option>
							</form:select>

						</div>
						<div class="col-4" id="enableShipError"></div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="shipGrad">SHIPMENT GRADE</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="shipGrade" value="A" />
							A
							<form:radiobutton path="shipGrade" value="B" />
							B
							<form:radiobutton path="shipGrade" value="C" />
							C
						</div>
						<div class="col-4" id="shipGradError"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="shipDesc">DESCRIPTION</label>
						</div>
						<div class="col-4">

							<form:textarea path="shipDesc" class="form-control"></form:textarea>
						</div>
						<div class="col-4" id="shipDescError"></div>
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

							$("#shipModeError").hide();
							$("#shipCodeError").hide();
							$("#enableShipError").hide();
							$("#shipGradError").hide();
							$("#shipDescError").hide();

							var shipModeError = false;
							var shipCodeError = false;
							var enableShipError = false;
							var shipGradError = false;
							var shipDescError = false;

							$("#shipMode").change(function() {
								validate_shipMode();
							});

							$("#shipCode").keyup(function() {
								validate_shipCode();
							});

							$("#enableShip").change(function() {
								validate_enableShip();
							});

							$('input[type="radiobutton"][name="shipGrade"]')
									.click(function() {
										validate_shipGrade();
									});

							$("#shipDesc").keyup(function() {
								validate_shipDesc();
							});

							function validate_shipMode() {
								var val = $("#shipMode").val();
								if (val == "") {
									$("#shipModeError").show();
									$("#shipModeError").html(
											"choose any option");
									$("#shipModeError").css("color", "red");
									shipModeError = false;
								} else {
									$("#shipModeError").hide();
									shipModeError = true;
								}
								return shipModeError;
							}

							function validate_shipCode() {
								var val = $("#shipCode").val();
								if (val == '') {
									$("#shipCodeError").show();
									$("#shipCodeError").html(
											"Enter <b>shipCode</b>")
									$("#shipCodeError").css("color", "red");
									shipCodeError = false;
								} else {
									$("#shipCodeError").hide();
									shipCodeError = true;
								}
								return shipCodeError;
							}

							function validate_enableShip() {
								var val = $("#enableShip").val();
								if (val == "") {
									$("#enableShipError").show();
									$("#enableShipError").html(
											"choose any option");
									$("#enableShipError").css("color", "red");
									enableShipError = false;
								} else {
									$("#enableShipError").hide();
									enableShipError = true;
								}
								return enableShipError;
							}

							function validate_shipGrade() {
								var val = $('input[type="radiobutton"][name="shipGrade"]:checked').length;
								if (val == 0) {
									$("#shipGradError").show();
									$("#shipGradError").html("choose any one");
									$("#shipGradError").css("color", "red");
									shipGradError = false;
								} else{
									$("#shipGradError").hide();
									shipGradError = true;
								}
								return shipGradError;
							}

							function validate_shipDesc() {

								var val = $("#shipDesc").val();
								if (val == '') {
									$("#shipDescError").show();
									$("#shipDescError").html(
											"enter description");
									$("#shipDescError").css("color", "red");
									shipDescError = false;
								} else {
									$("#shipDescError").hide();
									shipDescError = true;
								}
								return shipDescError;
							}

							$("#register").click(
									function() {

										shipModeError = false;
										shipCodeError = false;
										enableShipError = false;
										shipGradError = false;
										shipDescError = false;

										validate_shipMode();
										validate_shipCode();
										validate_enableShip();
										validate_shipGrade();
										validate_shipDesc();

										if (shipModeError && shipCodeError
												&& enableShipError
												&& shipGradError
												&& shipDescError) {
											return true;
										} else
											return false;
									});
						});
	</script>

</body>
</html>