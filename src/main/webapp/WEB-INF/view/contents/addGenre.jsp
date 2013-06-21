<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${genre.id > 0}">
		<c:set var="newGenre" value="false" />
		<c:set var="genreId" value="${genre.id}" />
	</c:when>
	<c:otherwise>
		<c:set var="newGenre" value="true" />
		<c:set var="genreId" value="0" />
	</c:otherwise>
</c:choose>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add genre</title>
</head>

<body>
	<form method="post" action="${pageContext.request.contextPath}/${newGenre ? 'save-genre' : 'update-genre' }">
		<c:if test="${!newGenre}">
			<input id="genreId" name="genreId" type="hidden" value="${genre.id}" />
		</c:if>
		<span>
			<spring:message code="addGenre.name" />
			<strong>*</strong>
			<input id="name" name="name" type="text" value="${genre.name}" />
		</span>
		<br>
		<span>
			<spring:message code="addGenre.description" />
			<strong>*</strong>
			<input id="description" name="description" type="text" value="${genre.description}" />
		</span>
		<br>
		<span>
			<spring:message code="addGenre.movies" />
			<select id="moviesIds" name="moviesIds" multiple size="10">
				<c:forEach var="movie" items="${movies}">
					<option value="${movie.id}">${movie.originalTitle}(${movie.year})</option>
				</c:forEach>
			</select>
		</span>
		<br>
		<span>
			<spring:message code="visible" />
			<input id="visible" name="visible" type="checkbox" value="true" <c:if test="${genre.visible}">checked</c:if> />
		</span>
		<br>

		<input type="submit" value="<spring:message code="save"/>" />
	</form>
</body>
</html>