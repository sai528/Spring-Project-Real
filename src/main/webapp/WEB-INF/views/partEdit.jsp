<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color:orange">PART EDIT PAGE</h3>
<body>
<form:form action="update" method="post" modelAttribute="part">
<pre>
<table align='center' border='5' cellpadding='7' width='50%' cellspacing='0'>
<tr>
<td>Part Id : </td><td><form:input path="partId" readonly="true"/></td>

<tr>
<td width="30%" colspan='3'>Code : <form:input path="partCode"/></td>
</tr>
<tr>
<td>Width : <form:input path="partWidth"/></td><td >Length :<form:input path="partLength"/></td><td >Height :<form:input path="partHeight"/></td>
</tr>
<tr>
<td width="30%" colspan='3'>Base Cost : <form:input path="partBaseCost"/></td>
</tr>
<tr>
<td colspan='3'>Base Currency : <form:select path="partBaseCurrency">
                             <form:option value="">--SELECT--</form:option> 
                             <form:option value="INR">INR</form:option> 
                             <form:option value="USD">USD</form:option> 
                             <form:option value="AUS">AUS</form:option> 
                             <form:option value="ERU">ERU</form:option> 
                             </form:select></td>
</tr>
<%-- <tr>
<td>Uom :</td><td><form:select path="uom"></form:select></td>
</tr>
<tr>
<td>Order Method Code :</td><td><form:select path="OrderMethodCode">
                                <form:option value="">sale(only one select)</form:option>
                                </form:select></td>                             
                            <td><form:select path="OrderMethodCode">
                            <form:option value="">purchase(only one select)</form:option>
                            </form:select></td> 
</tr> --%>
<tr>
<td colspan='3'>Descripition : <form:textarea path="partDesc"></form:textarea></td>
</tr>
<tr>
<td colspan="3" align="center"><input type="submit" value="UPDATE PART"/></td>
</tr>
</table>
</pre>
		<a href="allparts" align="right">GET ALL PART DATA</a>
</form:form>

</body>
</html>