<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー管理画面</title>
</head>
<body>
	<!-- トップ画面移動ボタン -->
	<form action="/recurrent/LoginServlet?action=toppage" method="post">
		<input type="submit" value="トップへ戻る"/>
	</form>

	<p>メニュー管理画面</p>
	<p>修正・削除するメニューの品名を選択してください</p>

	<!-- 登録メニューがない場合 -->
	<c:if test="${empty menuAll}">
		<p>登録メニューがありません</p>
	</c:if>

	<!-- 登録メニューがある場合 -->
	<c:if test="${not empty menuAll}">
		<table border="1">
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

	<a href="/recurrent/ManagerMenuRegistrationServlet">新規登録</a>

	<!-- ログアウトボタン -->
	<a href="/recurrent/ConfirmLoginServlet">ログアウト</a>
</body>
</html>