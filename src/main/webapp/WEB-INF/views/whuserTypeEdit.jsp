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
				<h3 align="center" style="color: white">WAREHOUSING
					USER TYPE UPDATE FORM</h3>
			</div>
			<div class='card-body'>
				<form:form action="update" method="post"
					modelAttribute="whUserType">
					
					<div class='row'>
						<div class='col-4'>
							<label for="userId">USER ID</label>
						</div>
						<div class='col-4'>
							<form:input path="userId" class="form-control" readonly='true'/>
						</div>
						<div class='col-4'></div>
					</div>
					

					<div class='row'>
						<div class='col-4'>
							<label for="userType">USER TYPE</label>
						</div>
						<div class='col-4'>
							<form:radiobutton path="userType" autocomplete="Purchase"
								value="Vendor" />
							Vendor
							<form:radiobutton path="userType" autocomplete="Sale"
								value="Customer" />
							Customer
						</div>
						<div class='col-4'></div>
					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="userCode">USER CODE</label>
						</div>
						<div class='col-4'>
							<form:input path="userCode" class="form-control" />
						</div>
						<div class='col-4'></div>
					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="userFor">USER FOR</label>
						</div>
						<div class='col-4'>
							<form:input autocomplete="Purchase/Sale" path="userFor" class="form-control"/>
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
						<div class='col-4'></div>
					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="userContact">USER CONTACT</label>
						</div>
						<div class='col-4'>
							<form:input path="userContact" class="form-control"/>
						</div>
						<div class='col-4'></div>
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
						<div class='col-4'></div>
					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="ifOther">IF OTHER</label>
						</div>
						<div class='col-4'>
							<form:input path="ifOther" class="form-control"/>
						</div>
						<div class='col-4'></div>
					</div>

					<div class='row'>
						<div class='col-4'>
							<label for="idNumber">ID NUMBER</label>
						</div>
						<div class='col-4'>
							<form:input path="idNumber" class="form-control"/>
						</div>
						<div class='col-4'></div>
					</div>

					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="UPDATE" class="btn btn-success" /> <input
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