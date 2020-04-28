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
				<h3 align="center" style="color: white">Welcome To WAREHOUSING
					USER TYPE Register Form</h3>
			</div>
			<div class='card-body'>
				<form:form action="save" method="post" modelAttribute="whUserType">

					<div class='row'>
						<div class='col-4'>
							<label for="userType">USER TYPE</label>
						</div>
						<div class='col-4'>
							<form:radiobutton path="userType" value="Vendor" />
							Vendor
							<form:radiobutton path="userType" value="Customer" />
							Customer
						</div>
						<div class='col-4' id="userTypeError"></div>
					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="userCode">USER CODE</label>
						</div>
						<div class='col-4'>
							<form:input path="userCode" class="form-control" />
						</div>
						<div class='col-2' id="userCodeError"></div>
						<div class='col-2'>
							<form:errors path="userCode" cssClass="text-danger" />
						</div>
					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="userFor">USER FOR</label>
						</div>
						<div class='col-4'>
							<form:input path="userFor" readonly="true" class="form-control" />
						</div>
						<div class='col-4'></div>
					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="userEmail">USER EMAIL</label>
						</div>
						<div class='col-4'>
							<form:input path="userEmail" class="form-control" />
						</div>
						<div class='col-2' id="userEmailError"></div>
						<div class='col-2'>
							<form:errors path="userEmail" cssClass="text-danger" />
						</div>

					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="userContact">USER CONTACT</label>
						</div>
						<div class='col-4'>
							<form:input path="userContact" class="form-control" />
						</div>
						<div class='col-2' id="userContactError"></div>
						<div class='col-2'>
							<form:errors path="userContact" cssClass="text-danger" />
						</div>
					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="userIdType">USER ID TYPE</label>
						</div>
						<div class='col-4'>
							<form:select path="userIdType" class="form-control">
								<form:option value="">---SELECT---</form:option>
								<form:option value="PAN CARD">PAN CARD</form:option>
								<form:option value="AADHAR CARD">AADHAR CARD</form:option>
								<form:option value="VOTER ID CARD">VOTER ID CARD</form:option>
								<form:option value="OTHER">OTHER</form:option>
							</form:select>
						</div>
						<div class='col-4' id="userIdTypeError"></div>
					</div>

					<div class='row' id="ifOtherHide">
						<div class='col-4'>
							<label for="ifOther">* IF OTHER</label>
						</div>
						<div class='col-4'>
							<form:input path="ifOther" class="form-control" />
						</div>
						<div class='col-4' id="ifOtherError"></div>
					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="idNumber">ID TYPE NUMBER</label>
						</div>
						<div class='col-4'>
							<form:input path="idNumber" class="form-control" />
						</div>
						<div class='col-2' id="idNumberError"></div>
						<div class='col-2'>
						
						<form:errors path="idNumber" cssClass="text-danger"/>
						</div>
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

							$("#userTypeError").hide();
							$("#userCodeError").hide();
							$("#userEmailError").hide();
							$("#userContactError").hide();
							$("#userIdTypeError").hide();
							$("#ifOtherHide").hide();
							/* $("#ifOtherError").hide(); */
							$("#idNumberError").hide();

							var userTypeError = false;
							var userCodeError = false;
							var userEmailError = false;
							var userContactError = false;
							var userIdTypeError = false;
							var ifOtherHide = false;
							/* var ifOtherError = false; */
							var idNumberError = false;

							$('input[type="radio"][name="userType"]').change(
									function() {
										validate_userType();
										autoFill_userFor();
									});

							$("#userCode").keyup(function() {
								validate_userCode();
							});

							$("#userEmail").keyup(function() {
								validate_userEmail();
							});

							$("#userContact").keyup(function() {
								validate_userContact();
							});

							$("#userIdType").change(function() {
								validate_userIdType();
							});

							/* $("#ifOther").keyup(function() {
							validate_ifOther();
							}); */

							$("#idNumber").keyup(function() {
								validate_idNumber();
							});

							function autoFill_userFor() {
								var val = $(
										'input[type="radio"][name="userType"]:checked')
										.val();
								if (val == 'Vendor') {
									$("#userFor").val("PURCHASE");
								} else if (val == 'Customer') {
									$("#userFor").val("SALE");
								}
							}

							function validate_userType() {

								var val = $('input[type="radio"][name="userType"]:checked').length;
								if (val == 0) {
									$("#userTypeError").show();
									$("#userTypeError").html(
											"Choose <b> User Type </b>");
									$("#userTypeError").css("color", "red");
									userTypeError = false;
								} else {
									$("#userTypeError").hide();
									userTypeError = true;
								}
								return userTypeError;
							}

							function validate_userCode() {
								var val = $("#userCode").val();
								var exp = /^[A-Z0-9]{2,8}$/;
								if (val == "") {
									$("#userCodeError").show();
									$("#userCodeError").html(
											"Enter <b>User Code</b>");
									$("#userCodeError").css("color", "red");
									usrCodeError = false;
								} else if (!exp.test(val)) {
									$("#userCodeError").show();
									$("#userCodeError")
											.html(
													"Enter <b>Only UPPER CASE Letters And DIGITS<br/>MIN=2 , MAX=8 Chars</b>");
									$("#userCodeError").css("color", "red");
									usrCodeError = false;
								} else {
									$("#userCodeError").hide();
									userCodeError = true;
								}
								return userCodeError;
							}

							function validate_userEmail() {
								var val = $("#userEmail").val();
								var exp = /^[a-zA-Z0-9-_]+\@[a-z]{2,8}\.[a-z]{2,6}$/;
								if (val == "") {
									$("#userEmailError").show();
									$("#userEmailError").html(
											"Enter <b>User Email</b>");
									$("#userEmailError").css("color", "red");
									userEmailError = false;
								} else if (!exp.test(val)) {
									$("#userEmailError").show();
									$("#userEmailError").html(
											"Enter <b>Valid User Mail</b>");
									$("#userEmailError").css("color", "red");
									userEmailError = false;
								} else {
									$("#userEmailError").hide();
									userEmailError = true;
								}
								return userEmailError;
							}

							function validate_userContact() {
								var val = $("#userContact").val();
									var exp = /^(\+91)?[6-9][0-9]{9}$/;
								if (val == "") {
									$("#userContactError").show();
									$("#userContactError").html(
											"Enter <b>Contact Number</b>");
									$("#userContactError").css("color", "red");
									userContactError = false;
								} else if (!exp.test(val)) {
									$("#userContactError").show();
									$("#userContactError").html(
											"Enter <b> Valid Phone Number</b>");
									$("#userContactError").css("color", "red");
									userContactError = false;
								} else {
									$("#userContactError").hide();
									userContactError = true;
								}
								return userContactError;
							}

							function validate_userIdType() {
								var val = $("#userIdType").val();
								if (val == "") {
									$("#userIdTypeError").show();
									$("#ifOtherHide").hide();
									$("#userIdTypeError").html(
											"Choose <b>Id Type</b>");
									$("#userIdTypeError").css("color", "red");
									userIdTypeError = false;
								} else if (val == "OTHER") {
									$("#userIdTypeError").hide();
									$("#ifOtherHide").show();
									$("#ifOther").attr('readOnly', false);
									userIdTypeError = true;
								} else {
									$("#userIdTypeError").html("");
									$("#ifOtherHide").hide();
									$("#ifOther").attr('readOnly', true);
									$("#ifOther").val("");
									userIdTypeError = true;
								}
								return userIdTypeError;
							}

							/* /*  function validate_ifOther() {
							var val = $("#ifOther").val();
							var exp = /^[a-zA-Z]{3,30}$/
							if (val == "") {
								$("#ifOtherError").show();
								$("#ifOtherError").html(
										"enter <b>User Id Type</b>");
								$("#ifOtherError").css("color", "red");
								ifOtherError = false;
							} else if (!exp.test(val)) {
								$("#ifOtherError").show();
								$("#ifOtherError").html(
										"enter <b>Id Type</b>");
								$("#ifOtherError").css("color", "red");
								ifOtherError = false;
							} else {
								$("#ifOtherError").hide();
								ifOtherError = true;
							}
							return ifOtherError;
							}  */

							function validate_idNumber() {
								var val = $("#idNumber").val();
								var exp = /^[a-zA-Z0-9.-_]{4,20}$/
								if (val == "") {
									$("#idNumberError").show();
									$("#idNumberError").html(
											"Enter <b>Id Number</b>");
									$("#idNumberError").css("color", "red");
									idNumberError = false;
								} else if (!exp.test(val)) {
									$("#idNumberError").show();
									$("#idNumberError")
											.html(
													"Enter <b>Valid Id Type Number</b>");
									$("#idNumberError").css("color", "red");
									idNumberError = false;
								} else {
									$("#idNumberError").hide();
									idNumberError = true;
								}
								return idNumberError;
							}
							$("#register").click(
									function() {

										userTypeError = false;
										userCodeError = false;
										userEmailError = false;
										userContactError = false;
										userIdTypeError = false;
										/* ifOtherHide = false;  */
										/* ifOtherError = false; */
										idNumberError = false;

										validate_userType();
										validate_userCode();
										validate_userEmail();
										validate_userContact();
										validate_userIdType();
										/* validate_ifOther(); */
										validate_idNumber();

										if (userTypeError && userCodeError
												&& userEmailError
												&& userContactError
												&& userIdTypeError
												/*  && ifOtherError */
												&& idNumberError) {
											return true;
										} else
											return false;
									})

						});
	</script>

</body>
</html>