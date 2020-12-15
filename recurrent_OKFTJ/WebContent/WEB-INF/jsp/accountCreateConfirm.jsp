<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<%@ include file="../include/include_meta.jsp" %>
	<title>アカウント新規登録確認</title>
	<%@ include file="../include/include_css.jsp" %>
	<link rel="stylesheet" href="css/managerStyle.css">

</head>
<body>
<div class="wrapper">
	<!-- アカウント管理トップ画面移動ボタン＆トップ画面移動ボタン -->
	<div class="topbutton">
		<table class="rightbutton">
			<tr>
				<td><a href="/recurrent/AccountServlet" class="btn btn-outline-info">アカウント一覧へ</a></td>
				<td>
					<form action="/recurrent/LoginServlet?action=toppage" method="post">
						<input type="submit" value="トップへ戻る" class=" btn btn-outline-primary"/>
					</form>

				</td>
			</tr>
		</table>
	</div>
	<div class="space">
	</div>

	<h2>新規アカウント登録</h2>

	<p>新規管理者ID：<c:out value="${newManager.id}"/></p>
	<p>パスワード：<c:out value="${newManager.pass}"/></p>
	<p>名前：<c:out value="${newManager.name}"/></p>
	<table class="buttontable">
		<tr>
			<td><a href="/recurrent/AccountRegistrationServlet?action=return" class="btn btn-warning">修正</a></td>
			<td>
				<form action="/recurrent/AccountRegistrationServlet?action=done" method="post">
					<input type="submit" value="登録" class="btn btn-danger"/>
				</form>
			</td>
		</tr>
	</table>


	<!-- ログアウトボタン -->
	<div class="bottombutton">
			<a href="/recurrent/ConfirmLoginServlet" class="rightbutton btn btn-outline-danger">ログアウト</a>
		</div>
	</div>

</body>
</html>