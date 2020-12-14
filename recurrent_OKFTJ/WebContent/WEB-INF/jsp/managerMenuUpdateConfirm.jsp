<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<c:if test="${process=='update'}">
	  	<title>メニュー修正確認画面</title>
	</c:if>
	<c:if test="${process=='delete'}">
	  	<title>メニュー削除確認画面</title>
	</c:if>
</head>
<body>
	<!-- メニュー管理画面トップ＆トップ画面移動ボタン -->
	<a href="/recurrent/ManagerMenuServlet">メニュー一覧へ</a>
	<form action="/recurrent/LoginServlet?action=toppage" method="post">
		<input type="submit" value="トップへ戻る"/>
	</form>

  	<c:if test="${process=='update'}">
  		<p>メニュー修正画面</p>
  		<p>下記の内容で修正しますか？</p>
  	</c:if>
  	<c:if test="${process=='delete'}">
	  	<p>メニュー削除画面</p>
	  	<p>下記の商品をメニューから削除しますか？</p>
	</c:if>

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

	<a href="/recurrent/ManagerMenuUpdateServlet?action=return&process=${process}">戻る</a>
	<form action="/recurrent/ManagerMenuUpdateServlet?action=done" method="post">
		<c:if test="${process=='update'}">
			<input type="hidden" name="process" value="update" />
		  	<input type="submit" value="修正確定" />
		</c:if>
		<c:if test="${process=='delete'}">
			<input type="hidden" name="process" value="delete"/>
		  	<input type="submit" value="削除確定"/>
		</c:if>

	</form>

	<!-- ログアウトボタン -->
	<a href="/recurrent/ConfirmLoginServlet">ログアウト</a>
</body>
</html>