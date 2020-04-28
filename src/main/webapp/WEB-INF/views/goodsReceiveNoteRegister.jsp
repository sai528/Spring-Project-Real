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
				<h3 align="center" style="color: black">WELCOME TO GOODS
					RECEIVE NOTE (GRN) REGISTER FORM</h3>
			</div>

			<div class="card-body">
				<form:form action="savegoods" method="post"
					modelAttribute="goodsReceiveNote">

					<div class="row">
						<div class="col-4">
							<label for="goodsCode">GRN CODE</label>
						</div>
						<div class="col-4">
							<form:input path="goodsCode" class="form-control" />
						</div>
						<div class="col-4" id="goodsCodeError"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="goodsType">GRN TYPE</label>
						</div>
						<div class="col-4">
							<form:input path="goodsType" class="form-control" />
						</div>
						<div class="col-4" id="goodsTypeError"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="purseOrdCodeOb.purseId">PURCHASE ORDER CODE</label>
						</div>
						<div class="col-4">
							<form:select path="purseOrdCodeOb.purseId" class="form-control">
								<form:option value="">----select---</form:option>
								<form:options items="${purseOrdMap}" />
							</form:select>
						</div>
						<div class="col-4" id="purseOrdCodeObpurseIdError"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="goodsDesc">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:textarea path="goodsDesc" class="form-control" />
						</div>
						<div class="col-4" id="goodsDescError"></div>
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
	</div>

	<script>
		$(document)
				.ready(
						function() {

							$("#goodsCodeError").hide();
							$("#goodsTypeError").hide();
							//$("#purseOrdCodeObpurseIdError").hide();
							$("#goodsDescError").hide();

							var goodsCodeError = false;
							var goodsTypeError = false;
							//var purseOrdCodeObpurseIdError = false;
							var goodsDescError = false;

							$("#goodsCode").keyup(function() {
								validate_goodsCode();
							});
							$("#goodsType").keyup(function() {
								validate_goodsType();
							});
							/* $("#purseOrdCodeOb.purseId").change(function() {
								validate_purseOrdCodeObpurseId();
							}); */

							$("#goodsDesc").keyup(function() {
								validate_goodsDesc();
							});

							function validate_goodsCode() {
								var val = $("#goodsCode").val();
								var exp = /^[A-Z0-9]{2,8}$/
								if (val == "") {
									$("#goodsCodeError").show();
									$("#goodsCodeError").html(
											"Enter <b> Goods Code </b>");
									$("#goodsCodeError").css("color", "red");
									goodsCodeError = false;
								} else if (!exp.test(val)) {
									$("#goodsCodeError").show();
									$("#goodsCodeError")
											.html(
													"Enter <b> Only Upper Case Letters And Digits<br/>   MIN=2 Chars , MAX=8 Chars</b>");
									$("#goodsCodeError").css("color", "red");
									goodsCodeError = false;
								} else {
									$("#goodsCodeError").hide();
									goodsCodeError = true;
								}
							}

							function validate_goodsType() {
								var val = $("#goodsType").val();
								//var exp=/^[A-Za-z]{2,20}$/ (or)
								var exp = /^[A-z]{2,20}$/
								if (val == "") {
									$("#goodsTypeError").show();
									$("#goodsTypeError").html(
											"Enter <b> Goods Type </b>");
									$("#goodsTypeError").css("color", "red");
									goodsTypeError = false;
								} else if (!exp.test(val)) {
									$("#goodsTypeError").show();
									$("#goodsTypeError")
											.html(
													"Enter <b>Only Alphabets Chars </br>MIN=2, MAX=20</b>");
									$("#goodsTypeError").css("color", "red");
									goodsTypeError = false;
								} else {
									$("#goodsTypeError").hide();
									goodsTypeError = true;
								}
							}

							function validate_goodsDesc() {
								var val = $("#goodsDesc").val();
								var exp = /^[\.\-\w]{2,255}$/ //here w=Alpha Numeric with underscore(_)
								//var exp=/^[a-zA-Z0-9]{2,255}$/
								if (val == "") {
									$("#goodsDescError").show();
									$("#goodsDescError").html(
											"Enter <b> Goods Description </b>");
									$("#goodsDescError").css("color", "red");
									goodsDescError = false;
								} else if (!exp.test(val)) {
									$("#goodsDescError").show();
									$("#goodsDescError")
											.html(
													"Enter <b>Only Alpha Numeric And ( . - _ )</br/> MIN=2 Chars, MAX=255 Chars </b>");
									$("#goodsDescError").css("color", "red");
									goodsDescError = false;
								} else {
									$("#goodsDescError").hide();
									goodsDescError = true;
								}
							}
							$("#register").click(
									function() {
										
										goodsCodeError = false;
										goodsTypeError = false;
										//purseOrdCodeObpurseIdError=false;
										goodsDescError = false;

										validate_goodsCode();
										validate_goodsType();
										//validate_purseOrdCodeObpurseId();
										validate_goodsDesc();

										if (goodsCodeError && goodsTypeError
												/* && purseOrdCodeObpurseIdError */
												&& goodsDescError) {
											return true;
										} else {
											return false;
										}
									});

						});
	</script>
</body>
</html>