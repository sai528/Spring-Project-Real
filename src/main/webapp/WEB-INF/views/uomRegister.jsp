<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>

</head>
<body>
	<%@include file="userMenu.jsp"%>

	<div class="container">

		<div class="card">

			<div
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3 align="center" style="color: orange">Welcome to UOM
					Register form</h3>
			</div>
			<div class="card-body">

				<form:form action="save" method="post" modelAttribute="uom">
					<div class='row'>
						<div class="col-4">
							<label for="uomType">UOM TYPE</label>

						</div>
						<div class="col-4">
							<form:select path="uomType" class="form-control">
								<form:option value="">--select--</form:option>
								<form:option value="PACKING">PACKING</form:option>
								<form:option value="NO PACKING">NO PACKING</form:option>
								<form:option value="NA">--NA--</form:option>
							</form:select>
						</div>
						<div class="col-4" id="uomTypeError"></div>
					</div>
					<div class="row">
						<div class='col-4'>
							<label for="uomModel">UOM MODEL</label>

						</div>
						<div class='col-4'>
							<form:input path="uomModel" class="form-control" />

						</div>
						<div class="col-4" id="uomModelError"></div>
					</div>
					<div class='row'>

						<div class='col-4'>
							<label for="uomDesc">DESCRIPTION</label>

						</div>
						<div class='col-4'>
							<form:textarea path="uomDesc" class="form-control"></form:textarea>
						</div>
						<div class="col-4" id="uomDescError"></div>

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
		$(document).ready(function() {

			$("#uomTypeError").hide();
			$("#uomModelError").hide();
			$("#uomDescError").hide();

			var uomTypeError = false;
			var uomModelError = false;
			var uomDescError = false;

			$("#uomType").change(function() {
				validate_uomType();
			});

			$("#uomModel").keyup(function() {
				validate_uomModel();
			});

			$("#uomDesc").keyup(function() {
				validate_uomDesc();
			});

			function validate_uomType() {
				var val = $("#uomType").val();
				if (val == '') {
					$("#uomTypeError").show();
					$("#uomTypeError").html("Choose <b>UOM TYPE</b>");
					$("#uomTypeError").css("color", "red");
					uomTypeError = false;
				} else {
					$("#uomTypeError").hide();
					uomTypeError = true;
				}
				return uomTypeError;
			}

			function validate_uomModel() {
				var val = $("#uomModel").val();
				if (val == '') {
					$("#uomModelError").show();
					$("#uomModelError").html("Enter <b>UOM MODEL</b>")
					$("#uomModelError").css("color", "red");
					uomModelError = false;
				} else {
					$("#uomModelError").hide();
					uomModelError = true;
				}
				return uomModelError;
			}

			function validate_uomDesc() {
				var val = $("#uomDesc").val();
				if (val == '') {
					$("#uomDescError").show();
					$("#uomDescError").html("note cannot be empty")
					$("#uomDescError").css("color", "red");
					uomDescError = false;
				} else {
					$("#uomDescError").hide();
					uomDescError = true;
				}
				return uomDescError;
			}

			$("#register").click(function() {

				uomTypeError = false;
				uomModelError = false;
				uomDescError = false;

				validate_uomType();
				validate_uomModel();
				validate_uomDesc();

				if (uomTypeError && uomModelError && uomDescError) {
					return true;
				} else
					return false;
			});

		});
	</script>
</body>
</html>