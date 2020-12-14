<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー変更完了</title>
</head>
<body>
	<!-- メニュー管理画面トップ＆トップ画面移動ボタン -->
	<a href="/recurrent/ManagerMenuServlet">メニュー一覧へ</a>
	<form action="/recurrent/LoginServlet?action=toppage" method="post">
		<input type="submit" value="トップへ戻る"/>
	</form>

	<c:if test="${process=='update'}">
  		<p>商品を修正しました</p>
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
		<tr>
			<td><c:out value="${alterMenuProductConfirm.item}"/></td>
			<td><c:out value="${alterMenuProductConfirm.typeCode}"/></td>
			<td><c:out value="${alterMenuProductConfirm.productName}"/></td>
			<td><c:out value="${alterMenuProductConfirm.price}"/>円</td>
			<td><c:out value="${alterMenuProductConfirm.calorie}"/>kcal</td>
			<td><c:out value="${alterMenuProductConfirm.variety}"/></td>
			<td><c:out value="${alterMenuProductConfirm.image}"/></td>
		</tr>
	</table>

  	</c:if>
  	<c:if test="${process=='delete'}">
	  	<p><c:out value="${alterMenuProductConfirm.typeCode}"/> <c:out value="${alterMenuProductConfirm.productName}"/>をメニューから削除しました</p>
	</c:if>

	<!-- ログアウトボタン -->
	<a href="/recurrent/ConfirmLoginServlet">ログアウト</a>
</body>
</html>