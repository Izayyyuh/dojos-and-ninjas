<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Testing 123...</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<h1>${dojo.name} Location Ninjas</h1>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th style="text-align:center" scope="col">First Name</th>
					<th style="text-align:center" scope="col">Last Name</th>
					<th style="text-align:center" scope="col">Age</th>
				</tr>
			</thead>
			<c:forEach var="ninja" items="${dojo.ninjas}">
				<tr>
					<td style="text-align:center">
					<p>${ninja.firstName}</p>
					</td>
					<td style="text-align:center">
					<p>${ninja.lastName}</p>
					</td>
					<td style="text-align:center">
					<p>${ninja.age}</p>
					</td>
					</tr>
			</c:forEach>
			
		</table>
	</div>
</body>
</html>