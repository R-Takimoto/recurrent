<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="../include/include_meta.jsp" %>
	<title>メニュー管理</title>
	<%@ include file="../include/include_css.jsp" %>
	<link rel="stylesheet" href="css/managerStyle.css">
</head>
<body>
	<!-- トップ画面移動ボタン -->
	<div class="wrapper">
		<div class="topbutton">
			<form action="/recurrent/LoginServlet?action=toppage" method="post">
				<input type="submit" value="トップへ戻る" class="rightbutton btn btn-outline-primary"/>
			</form>
		</div>
		<div class="space">
		</div>

	<h2>メニュー管理画面</h2>
	<p>修正・削除するメニューの品名を選択してください</p>

	<!-- 登録メニューがない場合 -->
	<c:if test="${empty menuAll}">
		<p>登録メニューがありません</p>
	</c:if>

	<!-- 登録メニューがある場合 -->
	<c:if test="${not empty menuAll}">
		<table class="dbtable" border="1" >
			<tr>
				<th>品目</th>
				<th>商品コード</th>
				<th>品名</th>
				<th>金額</th>
				<th>カロリー</th>
				<th>品種</th>
				<th>画像ファイル名</th>
			</tr>
			<c:forEach var="menu" items="${menuAll.managerProducts}" varStatus="status">
				<tr>
					<td><c:out value="${menu.item}"/></td>
					<td><c:out value="${menu.typeCode}"/></td>
					<td><a href="/recurrent/ManagerMenuUpdateServlet?menuNum=${status.index}"><c:out value="${menu.productName}"/></a></td>
					<td><c:out value="${menu.price}"/>円</td>
					<td><c:out value="${menu.calorie}"/>kcal</td>
					<td><c:out value="${menu.variety}"/></td>
					<td><c:out value="${menu.image}"/></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<div class="bottombutton">
		<a href="/recurrent/ManagerMenuRegistrationServlet" class="leftbutton btn btn-success">新規登録</a>

		<!-- ログアウトボタン -->
		<a href="/recurrent/ConfirmLoginServlet" class="rightbutton btn btn-outline-danger">ログアウト</a>
		</div>
	</div>
</body>
</html>