<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>メニュー新規登録確認画面</title>
</head>

<body>

	<!--メニュー管理画面トップ＆トップ画面移動ボタン -->
	<a href="/recurrent/ManagerMenuServlet">メニュー一覧へ</a>
	<form action="/recurrent/LoginServlet?action=toppage" method="post">
		<input type="submit" value="トップへ戻る"/>
	</form>

	<p>メニュー新規登録確認画面</p>

	<p>品目：<c:out value="${newMenuProduct.item}"/></p>
	<p>商品コード：<c:out value="${newMenuProduct.typeCode}"/></p>
	<p>品名：<c:out value="${newMenuProduct.productName}"/></p>
	<p>金額：<c:out value="${newMenuProduct.price}"/></p>
	<p>カロリー：<c:out value="${newMenuProduct.calorie}"/></p>
	<p>品種：<c:out value="${newMenuProduct.variety}"/></p>
	<p>画像ファイアル名：<c:out value="${newMenuProduct.image}"/></p>

	<a href="/recurrent/ManagerMenuRegistrationServlet?action=return">修正</a>
	<form action="/recurrent/ManagerMenuRegistrationServlet?action=done" method="post">
		<input type="submit" value="登録"/>
	</form>


	<!-- ログアウトボタン -->
	<a href="/recurrent/ConfirmLoginServlet">ログアウト</a>
</body>
</html>