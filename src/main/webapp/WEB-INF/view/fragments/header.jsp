<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<span class="header-links">
		<a href="${pageContext.request.contextPath}/movies/">
			<spring:message code="menu.movies" />
		</a>
		<br>
		<a href="${pageContext.request.contextPath}/add-movie/">
			<spring:message code="menu.addMovie" />
		</a>
	</span>

	<span class="header-links">
		<a href="${pageContext.request.contextPath}/celebrities/">
			<spring:message code="menu.celebrities" />
		</a>
		<br>
		<a href="${pageContext.request.contextPath}/add-celebrity/">
			<spring:message code="menu.addCelebrity" />
		</a>
	</span>

	<span class="header-links">
		<a href="${pageContext.request.contextPath}/genres/">
			<spring:message code="menu.genres" />
		</a>
		<br>
		<a href="${pageContext.request.contextPath}/add-genre/">
			<spring:message code="menu.addGenre" />
		</a>
	</span>

	<span class="header-rigth">
		<a href="?lang=hu">hu</a>
		|
		<a href="?lang=en">en</a>
		<br>
		<a href="?theme=default">def</a>
		|
		<a href="?theme=alter">alt</a>
	</span>
</body>
</html>