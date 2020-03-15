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
							<label for="ordCode">ORDER CODE</label>
						</div>
						<div class='col-4'>
							<form:input path="ordCode" class="form-control"/>
						</div>
						<div class='col-4'></div>
					</div>

					 <div class='row'>
						<div class='col-4'>
							<label for="shipCodeOb.shipId">SHIP CODE</label>
						</div>
						<div class='col-4'>
							<form:select path="shipCodeOb.shipId" class="form-control">
								<form:option value=" ">--select--</form:option>
								<form:options items="${shipMap}"></form:options>
							</form:select>
						</div>
						<div class='col-4'></div>

					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="userVendorOb.userId">VENDOR</label>
						</div>
						<div class='col-4'>
							<form:select path="userVendorOb.userId" class="form-control">
								<form:option value=" ">--select--</form:option>
								<form:options items="${usertypeMap}"></form:options>
							</form:select>
						</div>
						<div class='col-4'></div>
					</div> 

					<div class='row'>
						<div class='col-4'>
							<label for="refNumber">REFERENCE NUMBER</label>
						</div>
						<div class='col-4'>
							<form:input path="refNumber" class="form-control"/>
						</div>
						<div class='col-4'></div>

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
						<div class='col-4'></div>

					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="defaultStatus">DEFAULT STATUS</label>
						</div>
						<div class='col-4'>
							<form:input path="defaultStatus" value="OPEN" readonly="true" class="form-control"/>
						</div>
						<div class='col-4'></div>

					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="purDesc">DESCRIPTION</label>
						</div>
						<div class='col-4'>
							<form:textarea path="purDesc" class="form-control"/>
						</div>
						<div class='col-4'></div>
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