<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movies</title>
</head>
<body>
	<c:forEach var="movie" items="${movies}">
		<a href="movie/${movie.getId()}/">${movie.getOriginalTitle()} (${movie.getYear()})</a>
	</c:forEach>
</body>
</html>