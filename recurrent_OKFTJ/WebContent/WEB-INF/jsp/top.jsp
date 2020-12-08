<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="ja">

<head>
	<%@ include file="../include/include_meta.jsp" %>
	<title>>リ・カレント亭</title>
	<jsp:include page="../include/include_css.jsp" />
</head>
<body>
	<div class="container">
		<%@ include file="../include/include_header.jsp" %>
		<%@ include file="../include/mode_nav.jsp" %>
		<a href="/recurrent/ProductServlet?typeCode=a-001&key=a">
			<img src="images/sonota-001.jpg" class="img-thumbnail" alt="ごはん" />
			ごはん
		</a>
	</div>
	<%@ include file="../include/bootstrap_script.jsp" %>
</body>

</html>