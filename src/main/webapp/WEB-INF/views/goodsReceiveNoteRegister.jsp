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
						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="goodsType">GRN TYPE</label>
						</div>
						<div class="col-4">
							<form:input path="goodsType" class="form-control" />
						</div>
						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="purseOrdCodeOb.purseId">Order Code</label>
						</div>
						<div class="col-4">
							<form:select path="purseOrdCodeOb.purseId" class="form-control">
								<form:option value="">----select---</form:option>
								<form:options items="${purseOrdMap}" />
							</form:select>
						</div>
						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="goodsDesc">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:textarea path="goodsDesc" class="form-control"/>
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

			</div>

			<c:if test="${!empty message }">
				<div class="card-footer bg-info text-white text-center">
					<b>${message}</b>
				</div>
			</c:if>



		</div>

	</div>

</body>
</html>