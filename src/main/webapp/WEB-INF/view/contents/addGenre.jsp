<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${genre.id > 0}">
		<c:set var="newGenre" value="false" />
	</c:when>
	<c:otherwise>
		<c:set var="newGenre" value="true" />
	</c:otherwise>
</c:choose>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add genre</title>
<script src="${pageContext.request.contextPath}/scripts/page-specifics/add-genre.js"></script>
</head>

<body>
	<form id="genreForm" method="post" action="${pageContext.request.contextPath}/${newGenre ? 'save-genre' : 'update-genre' }">
		<c:if test="${!newGenre}">
			<input id="genreId" name="genreId" type="hidden" value="${genre.id}" />
		</c:if>
		<span>
			<spring:message code="addGenre.name" />
			<strong>*</strong>
			<input id="name" name="name" value="${genre.name}" />
		</span>
		<br>
		<span>
			<spring:message code="addGenre.description" />
			<strong>*</strong>
			<input id="description" name="description" value="${genre.description}" />
		</span>
		<br>
		<span>
			<spring:message code="addGenre.movies" />
			<input id="titles" />
			<select id="moviesIds" name="moviesIds" multiple size="5">
				<c:forEach var="movie" items="${genre.movies}">
					<option value="${movie.id}">${movie.originalTitle}&nbsp;(${movie.year})</option>
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