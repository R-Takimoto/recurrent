<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント新規登録完了画面</title>
</head>
<body>

	<!-- アカウント管理トップ画面移動ボタン＆トップ画面移動ボタン -->
	<a href="/recurrent/AccountServlet">アカウント管理画面トップへ</a>
	<form action="/recurrent/LoginServlet?action=toppage" method="post">
		<input type="submit" value="トップへ戻る"/>
	</form>

	<p>新規管理者アカウントを登録しました</p>
	<p>新規管理者ID：<c:out value="${newManager.id}"/></p>
	<p>パスワード：<c:out value="${newManager.pass}"/></p>
	<p>名前：<c:out value="${newManager.name}"/></p>


	<!-- ログアウトボタン -->
	<a href="/recurrent/ConfirmLoginServlet">ログアウト</a>

</body>
</html>