<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<span>
		${movie.originalTitle} (${movie.year})
	</span>
	<br>
	<span>
			<spring:message code="addMovie.runningTime" /> ${movie.runningTime}
	</span>
	<br>
	<span>
			<spring:message code="addMovie.director" /> ${movie.director.name}
	</span>
</body>
</html>