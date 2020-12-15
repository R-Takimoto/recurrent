<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="../include/include_meta.jsp" %>
	<title>アカウント新規登録</title>
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

	<!-- 入力画面（戻るボタンから再表示していない場合） -->
	<c:if test="${empty action}">
		<h2>新規アカウント登録</h2>
		<p>作成するアカウント情報を入力してください</p>

		<!-- IDが重複した場合エラーメッセージ表示 -->
		<c:if test="${not empty idDuplicateMsg}">
			<c:out value="${idDuplicateMsg}"/>
		</c:if>

		<!-- 入力フォーム -->
		<form action="/recurrent/AccountRegistrationServlet" method="post">
			新規管理者ID：<input type="text" name="id" value="${newManager.id}" placeholder="英字15文字以内" required/><c:out value="${errMsg.get('id')}"/><br />
			※神戸店は「koube-」、大阪店は「osaka-」から始まるID名にしてください<br />
			<!-- <label><input type="radio" name="storeName" value="1" id="kobeStore" onClick="select(this.value)"/>神戸店</label>
			<label><input type="radio" name="storeName" value="大阪店"/>大阪店</label><br />
			新規管理者ID：<input type="text" name="id" id="storeNameTop"/><br /> -->
			パスワード：<input type="password" name="pass"  placeholder="数字15文字以内" required/><c:out value="${errMsg.get('pass')}"/><br />
			名前：<input type="text" name="name" value="${newManager.name}" placeholder="例）山田太郎" required/><c:out value="${errMsg.get('name')}"/><br />
			<input type="submit" value="確認" class="btn btn-primary"/>
		</form>
	</c:if>


	<!-- 修正入力画面（確認画面より戻るボタンから入力値再表示した場合） -->
	<c:if test="${action=='return'}">
		<h2>新規アカウント登録</h2>
		<p>作成するアカウント情報を入力してください</p>

		<form action="/recurrent/AccountRegistrationServlet" method="post">
			新規管理者ID：<input type="text" name="id" value="${newManager.id}" placeholder="英字15文字以内" required/><br />
			※神戸店は「koube-」、大阪店は「osaka-」から始まるID名にしてください<br />
			パスワード：<input type="password" name="pass" placeholder="数字15文字以内" required/><br />
			名前：<input type="text" name="name" value="${newManager.name}" placeholder="例）山田太郎" required/><br />
			<input type="submit" value="確認" class="btn btn-primary"/>
		</form>
	</c:if>
	<div class="space">
	</div>

	<!-- ログアウトボタン -->
	<div class="bottombutton">
		<a href="/recurrent/ConfirmLoginServlet" class="rightbutton btn btn-outline-danger">ログアウト</a>
	</div>
	</div>
</body>
</html>