<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="../include/include_meta.jsp" %>
	<title>メニュー変更完了</title>
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

	<c:if test="${process=='update'}">
		<h2>メニュー修正</h2>
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
  		<h2>メニュー削除</h2>
	  	<p><c:out value="${alterMenuProductConfirm.typeCode}"/> <c:out value="${alterMenuProductConfirm.productName}"/>をメニューから削除しました</p>
	</c:if>

	<!-- ログアウトボタン -->
	<div class="bottombutton">
			<a href="/recurrent/ConfirmLoginServlet" class="rightbutton btn btn-outline-danger">ログアウト</a>
		</div>
	</div>
</body>
</html>