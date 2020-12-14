<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"
      uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>

<head>
	<%@ include file="../include/include_meta.jsp" %>
	<title>注文完了</title>
	<jsp:include page="../include/include_css.jsp" />
	<link rel="stylesheet" href="css/order-done.css">
</head>

<body>
	<div class="container">
		<%@ include file="../include/include_header.jsp" %>
		<div class="row main-wrapper">
			<%@ include file="../include/mode_nav.jsp" %>
			<main class="main">
				<div class="relative">
					<div class="order-done">
						<p>注文を受け付けました</p>
						<p><a href="/recurrent/WelcomeServlet?key=s&orderTypeId=1" class="button">メニューへ</a></p>
					</div>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../include/bootstrap_script.jsp" %>
	<script src="js/main.js" type="text/javascript"></script>
</body>

</html>