<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Celebrity</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/save-celebrity" accept-charset="UTF-8">
		<input id="celebrityId" name="celebrityId" type="hidden" value="0" />
		<span>
			<spring:message code="addCelebrity.name" />
			<strong>*</strong>
			<input id="name" name="name" type="text" />
		</span>
		<br>
		<span>
			<spring:message code="addCelebrity.imdbLink" />
			<input id="imdbLink" name="imdbLink" type="text" />
		</span>
		<br>
		<span>
			<spring:message code="visible" />
			<input id="visible" name="visible" type="checkbox" value="true"/>
		</span>
		<br>
		
		<input type="submit" value="<spring:message code="save"/>" />
	</form>
</body>
</html>