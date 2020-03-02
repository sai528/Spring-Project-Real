<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h3 align="center" style="color: gray">WELCOME TO DOCUMENT UPLOAD
	PAGE</h3>
<body>
	<form action="upload" method="post" enctype="multipart/form-data">
		<pre>
<table align='center' border='5' cellpadding='7' width='50%'
				cellspacing='0'>
<tr>
<td>ID:</td>
					<td><input type="text" name="fileId" /></td>
</tr>
<tr>
<td> DOC:</td>
					<td><input type="file" name="fileOb" /></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="upload"/></td>
</tr>
</table>
</pre>

	</form>
	
	<table border="1">
	
	<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Link</th>
	</tr>
	
	<c:forEach items="${list}" var="ob">
	<tr>
	<td>${ob[0]}</td>
	<td>${ob[1]}</td>
	<td><a href="download?fid=${ob[0]}"><img src="../resources/images/downloadimg.jpg" width="30" height="30"></a></td>
	</tr>
	
	</c:forEach>
	</table>
	
	
	
${message}
</body>
</html>