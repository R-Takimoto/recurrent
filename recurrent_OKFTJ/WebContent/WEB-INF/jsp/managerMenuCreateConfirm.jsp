<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="../include/include_meta.jsp" %>
	<title>メニュー新規登録</title>
	<%@ include file="../include/include_css.jsp" %>
	<link rel="stylesheet" href="css/managerStyle.css">
</head>

<body>

	<div class="wrapper">
	<!--メニュー管理画面トップ＆トップ画面移動ボタン -->
	<div class="topbutton">
		<table class="rightbutton">
			<tr>
				<td><a href="/recurrent/ManagerMenuServlet" class="leftbutton btn btn-outline-info">メニュー一覧へ</a></td>
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

	<h2>メニュー新規登録画面</h2>

	<p>品目：<c:out value="${newMenuProduct.item}"/></p>
	<p>商品コード：<c:out value="${newMenuProduct.typeCode}"/></p>
	<p>品名：<c:out value="${newMenuProduct.productName}"/></p>
	<p>金額：<c:out value="${newMenuProduct.price}"/></p>
	<p>カロリー：<c:out value="${newMenuProduct.calorie}"/></p>
	<p>品種：<c:out value="${newMenuProduct.variety}"/></p>
	<p>画像ファイアル名：<c:out value="${newMenuProduct.image}"/></p>
	<table class="buttontable">
		<tr>
			<td><a href="/recurrent/ManagerMenuRegistrationServlet?action=return" class="btn btn-warning">修正</a></td>
			<td>
				<form action="/recurrent/ManagerMenuRegistrationServlet?action=done" method="post">
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