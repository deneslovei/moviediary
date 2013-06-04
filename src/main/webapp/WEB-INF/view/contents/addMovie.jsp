<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add movie</title>
</head>
<body>
	<form method="post" action="save-movie">
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
			<spring:message code="addMovie.length" />
			<strong>*</strong>
			<input id="length" name="length" type="text" />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.director" />
			<strong>*</strong>
			<input id="director" name="director" type="text" />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.imdbLink" />
			<input id="imdbLink" name="imdbLink" type="text" />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.imdbPoint" />
			<input id="imdbPoint" name="imdbPoint" type="text" />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.language" />
			<strong>*</strong>
			<input id="language" name="language" type="text" />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.genres" />
			<input id="genres" name="genres" type="text" />
		</span>
		<br>
		<span>
			<spring:message code="addMovie.actors" />
			<input id="actors" name="actors" type="text" />
		</span>

		<input type="submit" value="<spring:message code="save"/>" />
	</form>
</body>
</html>