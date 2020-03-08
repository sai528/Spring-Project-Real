<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color: orange">PART EDIT PAGE</h3>
<body>
	<form:form action="update" method="post" modelAttribute="part">
		<pre>
<table align='center' border='5' cellpadding='7' width='50%'
				cellspacing='0'>
<tr>
<td colspan='3'>Part Id : <form:input path="partId" readonly="true" /></td>

</tr>
				<tr>
<td width="30%" colspan='3'>Code : <form:input path="partCode" /></td>
</tr>
<tr>
<td>Width : <form:input path="partWidth" /></td>
					<td>Length :<form:input path="partLength" /></td>
					<td>Height :<form:input path="partHeight" /></td>
</tr>
<tr>
<td width="30%" colspan='3'>Base Cost : <form:input
							path="partBaseCost" /></td>
</tr>
<tr>
<td colspan='3'>Base Currency : <form:select
							path="partBaseCurrency">
                             <form:option value="">--SELECT--</form:option> 
                             <form:option value="INR">INR</form:option> 
                             <form:option value="USD">USD</form:option> 
                             <form:option value="AUS">AUS</form:option> 
                             <form:option value="ERU">ERU</form:option> 
                             </form:select></td>
</tr>
 <tr>
<td colspan='3'>Uom : <form:select path="uomOb.uomId">
                  <form:option value=" ">--select--</form:option>
                  <form:options items="${uomMap}"></form:options>
                   <%-- itemValue="uomId"
								itemLabel="uomModel"/> --%>
                 </form:select></td>
</tr>
<tr>
<td colspan="3" >Order Sale :    <form:select path="ordSaleOb.ordId">
                                <form:option value="">--select--</form:option>
                                <form:options items="${orderMap}"></form:options>
                                </form:select>       Order Purchase :     <form:select path="ordPurchaseOb.ordId">
                            <form:option value="">--select--</form:option>
                            <form:options items="${ordMap}"></form:options>
                            </form:select></td> 
</tr>
<tr>
<td colspan='3'>Descripition : <form:textarea path="partDesc"></form:textarea></td>
</tr>
<tr>
<td colspan="3" align="center"><input type="submit"
						value="UPDATE PART" /></td>
</tr>
</table>
</pre>
		<a href="allparts" align="right">GET ALL PART DATA</a>
	</form:form>

</body>
</html>