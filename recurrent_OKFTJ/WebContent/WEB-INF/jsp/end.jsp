<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<%@ include file="../include/include_meta.jsp" %>
	<title>お会計</title>
	<jsp:include page="../include/include_css.jsp" />
	<link rel="stylesheet" href="css/end.css">
</head>

<body>
	<div class="container">
		<div class="outer">
			<c:if test="${empty action }">
				<div class="inner">
					<h3 class="text-sm-center">会計は<c:out value="${ total }" />になります</h3>
					<p class="text-sm-center"><a href="/recurrent/SlipServlet?action=bye">終了</a></p>
				</div>
			</c:if>
			<c:if test="${action == 'bye' }">
				<div class="inner">
					<h3 class="text-sm-center">ありがとうございました</h3>
				</div>
			</c:if>
		</div>
	</div>
	<%@ include file="../include/bootstrap_script.jsp" %>
</body>

</html>