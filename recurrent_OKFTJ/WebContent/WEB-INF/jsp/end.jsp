<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<%@ include file="../include/include_meta.jsp" %>
	<title>お会計</title>
	<jsp:include page="../include/include_css.jsp" />
</head>

<body>
	<div class="container">
		<c:if test="${empty action }">
		<h3 class="text-sm-center">会計は<c:out value="${ total }" />になります.</h3>
		<p class="text-sm-center"><a href="/recurrent/SlipServlet?action=bye">終了</a></p>
		</c:if>
		<c:if test="${action == 'bye' }">
		<h3 class="text-sm-center">ありがとうございました</h3>
		</c:if>
	</div>
	<%@ include file="../include/bootstrap_script.jsp" %>
</body>

</html>