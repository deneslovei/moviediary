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
			<input id="originalTitle" name="originalTitle"  />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.englishTitle" />
			<input id="englishTitle" name="englishTitle"  />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.hungarianTitle" />
			<input id="hungarianTitle" name="hungarianTitle"  />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.year" />
			<strong>*</strong>
			<input id="year" name="year"  />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.runningTime" />
			<strong>*</strong>
			<input id="runningTime" name="runningTime"  />
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
			<input id="rating" name="rating"  />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.language" />
			<strong>*</strong>
			<input id="language" name="language"  />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.imdbLink" />
			<input id="imdbLink" name="imdbLink"  />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.genres" />
			<select id="genres" name="genres" multiple>
				<c:forEach var="genre" items="${genres}">
					<option value="${genre.id}">${genre.name}</option>
				</c:forEach>
			</select>
			<select id="idsOfGenres" name="idsOfGenres" multiple>
				<c:forEach var="genre" items="${movie.genres}">
					<option value="${genre.id}">${genre.name}</option>
				</c:forEach>
			</select>
		</span>
		<br>
		<span>
			<spring:message code="addMovie.actors" />
			<input id="actors" />
			<select id="actors" name="actors" multiple size="10">
				<c:forEach var="actor" items="${movie.featuredIn}">
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
<script>
$('#genres').change(function() {
	$("#idsOfGenres").append($("<option></option>").text($(this).text()).val($(this).val()));
});
</script>

</html>