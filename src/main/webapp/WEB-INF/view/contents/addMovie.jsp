<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add movie</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/save-movie">
		<input id="movieId" name="movieId" value="0" type="hidden">
		<span>
			<spring:message code="addMovie.originalTitle" />
			<strong>*</strong>
			<input id="originalTitle" name="originalTitle" type="text" />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.englishTitle" />
			<input id="englishTitle" name="englishTitle" type="text" />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.hungarianTitle" />
			<input id="hungarianTitle" name="hungarianTitle" type="text" />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.year" />
			<strong>*</strong>
			<input id="year" name="year" type="text" />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.runningTime" />
			<strong>*</strong>
			<input id="runningTime" name="runningTime" type="text" />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.director" />
			<strong>*</strong>
			<select id="directorId" name="directorId">
				<c:forEach var="celebrity" items="${celebrities}">
					<option value="${celebrity.id}">${celebrity.name}</option>
				</c:forEach>
			</select>
		</span>
		<br>
		<span>
			<spring:message code="addMovie.rating" />
			<input id="rating" name="rating" type="text" />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.language" />
			<strong>*</strong>
			<input id="language" name="language" type="text" />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.imdbLink" />
			<input id="imdbLink" name="imdbLink" type="text" />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.genres" />
			<select id="genres" name="genres" multiple>
				<c:forEach var="genre" items="${genres}">
					<option value="${genre.id}">${genre.name}</option>
				</c:forEach>
			</select>
		</span>
		<br>
		<span>
			<spring:message code="addMovie.actors" />
			<select id="actors" name="actors" multiple size="10">
				<c:forEach var="actor" items="${celebrities}">
					<option value="${actor.id}">${actor.name}</option>
				</c:forEach>
			</select>
		</span>
		<br>
		<span>
			<spring:message code="visible" />
			<input id="visible" name="visible" type="checkbox" value="true" />
		</span>
		<br>

		<input type="submit" value="<spring:message code="save"/>" />
	</form>
</body>
</html>