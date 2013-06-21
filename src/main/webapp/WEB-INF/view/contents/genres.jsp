<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Genres</title>
</head>
<body>
	<c:forEach var="genre" items="${genres}">
		<a href="${pageContext.request.contextPath}/edit-genre/?genreId=${genre.id}">${genre.name}</a>
		<br>
	</c:forEach>
</body>
</html>