<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<style>  
	table,tr,td
	{
border:1px solid black;
width:30%;
text-align:center;
}
</style>
</head>
<center>
<h2>customer List</h2>
<body>

<c:forEach  var="s" items="${lis}">
<table>
<tr>
<td><h3><c:out value="${s.getCid()}"></c:out></h3></td>
<td><h3><c:out value="${s.getName()}"></c:out></h3></td>
<td><h3><c:out value="${s.getPass()}"></c:out></h3></td>
<td><h3><c:out value="${s.getBalance()}"></c:out></h3></td>

</tr>
</c:forEach>
</table>
</body>
</center>
</html>         