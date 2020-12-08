<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理トップ画面</title>
<link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/earlyaccess/hannari.css"
	rel="stylesheet">

</head>
<body style="background-color: #c7eff0;">
<div class="center">
<div class="sampleBox">
	<p><c:out value="${store.storeName}"/>ログインしました</p>
	<a href="/recurrent/ConfirmOrderServlet"><button type="button" class="red2button">注文管理</button></a>
	<p></p>
	<a href="/recurrent/SalesServlet?action=login"><button type="button" class="yellowbutton">売上管理</button></a>
	<p></p>
	<a href="/recurrent/AccountServlet?action=login"><button type="button" class="greenbutton">アカウント管理</button></a>
	<p></p>
	<a href="/recurrent/MenuServlet?action=login"><button type="button" class="bluebutton">メニュー管理</button></a>
	<p></p>
	<p></p>

	<a href="/recurrent/ConfirmLoginServlet?action=login"><button type="button" class="logoutbutton">ログアウト</button></a>
	</div>
	</div>
</body>
</html>