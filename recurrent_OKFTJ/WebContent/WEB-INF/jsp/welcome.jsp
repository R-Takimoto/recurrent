<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/include/boot.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ようこそリカレント亭へ</title>
</head>
<body style="background-color: #ffbf1f;">
	<h6>Welcome to リ・カレント亭</h6>
	<div class="button_wrapper">
		<form action="/recurrent/WelcomeServlet" method="post">
			<input type="submit" value="注文・メニューへ" class="button">
		</form>
	</div>
</body>
</html>