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
		<h1>New Ninja</h1>
		<form:form action="/ninjas/create" method="POST" modelAttribute="newNinja">
			<form_label path="allTheDojos">Dojo:</form_label>
			<form:select path="dojo">
				<c:forEach var="dojo" items="${allTheDojos}">
					<form:option value="${dojo.id}">${dojo.name}</form:option>
				</c:forEach>
			</form:select>
			<form:errors style="color:red" path="firstName"/>
			<form:label path="firstName">First Name:</form:label>
			<form:input type="text" path="firstName" required="true"/>
			<form:errors style="color:red" path="lastName"/>
			<form:label path="lastName">Last Name:</form:label>
			<form:input type="text" path="lastName" required="true"/>
			<form:errors style="color:red" path="age"/>
			<form:label path="age">Age:</form:label>
			<form:input type="number" path="age" required="true"/>
			<form:button>Create</form:button>
		</form:form>
	</div>
</body>
</html>