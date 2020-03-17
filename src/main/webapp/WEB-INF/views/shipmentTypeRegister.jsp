<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js">
</script>
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
								<form:option value=" ">---select---</form:option>
								<form:option value="Air"> Air </form:option>
								<form:option value="Truck"> Truck </form:option>
								<form:option value="Train"> Train </form:option>
								<form:option value="Ship"> Ship </form:option>
							</form:select>
						</div>
						<div class="col-4"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="shipCode">SHIPMENT CODE</label>
						</div>
						<div class="col-4">
							<form:input path="shipCode" id="shipCode" class="form-control" />
						</div>
						<div class="col-4">
							<span id="shipCodeError"></span>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="enbShip">ENABLE SHIPMENT</label>
						</div>
						<div class="col-4">

							<form:select path="enableShip" class="form-control">
								<form:option value=" ">-----select---</form:option>
								<form:option value="Yes">Yes</form:option>
								<form:option value="No">No</form:option>
							</form:select>

						</div>
						<div class="col-4"></div>
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
						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="shipDesc">DESCRIPTION</label>
						</div>
						<div class="col-4">

							<form:textarea path="shipDesc" class="form-control"></form:textarea>
						</div>
						<div class="col-4"></div>
					</div>


					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="Create" class="btn btn-success" /> <input
								type="reset" value="Clear" class="btn btn-danger" />

						</div>
					</div>

				</form:form>
				
				<script>
$(document).ready(function(){

	$("#shipCodeError").hide();

	var shipCodeError=false;

	function validate_shipCode(){

		var val=$("#shipCode").val();

		if(val==" "){
$("#shipCodeError").show();
$("#shipCodeError").html("<b>code cannot be empty</b>");
#("#shipCodeError").css("color","red");
shipCodeError=false
			}else
				{
$("#shipCodeError").hide();
shipCodeError=true;
	}
		return shipCodeError;
		
		}
	$("#shipCode").keyup(function(){
validate_shipCode();
		});
});
	</script>


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