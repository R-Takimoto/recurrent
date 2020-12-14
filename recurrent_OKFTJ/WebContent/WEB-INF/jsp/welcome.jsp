<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ようこそリカレント亭へ</title>
<jsp:include page="../include/include_css.jsp" />
<link rel="stylesheet" href="css/welcome.css">
</head>
<body>
	<div class="container">
		<div class="d-flex align-items-center">
			<h6>Welcome to リ・カレント亭</h6>
			<div class="button_wrapper but">
				<form action="/recurrent/WelcomeServlet?key=s&orderTypeId=1" method="post">
					<input type="submit" value="注文・メニューへ" class="button">
				</form>
			</div>
		</div>
	</div>
	<%@ include file="../include/bootstrap_script.jsp" %>
</body>
</html>