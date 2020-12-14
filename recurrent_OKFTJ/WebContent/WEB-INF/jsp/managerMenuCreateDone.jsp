<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>メニュー新規登録完了</title>
</head>

<body>

	<!--メニュー管理画面トップ＆トップ画面移動ボタン -->
	<a href="/recurrent/ManagerMenuServlet">メニュー一覧へ</a>
	<form action="/recurrent/LoginServlet?action=toppage" method="post">
		<input type="submit" value="トップへ戻る"/>
	</form>

	<p>メニュー新規登録完了</p>

	<p>品目：<c:out value="${newMenu.item}"/></p>
	<p>商品コード：<c:out value="${newMenu.typeCode}"/></p>
	<p>品名：<c:out value="${newMenu.productName}"/></p>
	<p>金額：<c:out value="${newMenu.price}"/></p>
	<p>カロリー：<c:out value="${newMenu.calorie}"/></p>
	<p>品種：<c:out value="${newMenu.variety}"/></p>
	<p>画像ファイアル名：<c:out value="${newMenu.image}"/></p>



	<!-- ログアウトボタン -->
	<a href="/recurrent/ConfirmLoginServlet">ログアウト</a>
</body>
</html>