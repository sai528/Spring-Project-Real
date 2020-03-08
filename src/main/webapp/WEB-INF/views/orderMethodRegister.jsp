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
						<div class='col-4'></div>
					</div>
					<div class='row'>
						<div class='col-4'>
							<label for='ordCode'>ORDER CODE</label>
						</div>
						<div class='col-4'>
							<form:input path="ordCode" class="form-control" />
						</div>
						<div class='col-4'></div>
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
								<form:option value="FCFO">FCFO</form:option>
								<form:option value="FEFO">FEFO</form:option>
							</form:select>

						</div>
						<div class='col-4'></div>
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
						<div class='col-4'></div>
					</div>
					<div class='row'>
						<div class='col-4'>
							<label for='ordDesc'>DESCRIPTION</label>
						</div>
						<div class='col-4'>
							<form:textarea path="ordDesc" class="form-control"></form:textarea>
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