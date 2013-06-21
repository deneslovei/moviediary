<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/<spring:theme code="css"/>" type="text/css" />
<title>
	<tiles:insertAttribute name="title" ignore="true" />
</title>
</head>
<body>
	<div class="tiles-header width800">
		<tiles:insertAttribute name="header" />
	</div>
	<div class="tiles-body width800">
		<tiles:insertAttribute name="body" />
	</div>
	<div class="tiles-footer width800">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>