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

	<h2>メニュー新規登録</h2>
	<p>登録するメニュー情報を入力してください</p>

	<!-- 入力画面（戻るボタンから再表示していない場合） -->
	<c:if test="${empty action}">

		<!-- IDが重複した場合エラーメッセージ表示 -->
		<c:if test="${not empty idDuplicateMsg}">
			<c:out value="${idDuplicateMsg}"/>
		</c:if>

		<!-- 入力フォーム -->
		<form action="/recurrent/ManagerMenuRegistrationServlet" method="post">
			<div>品目：
				<select name="item">
					<option value="" disabled <c:if test="${empty newMenuProduct}">selected</c:if>>選択してください</option>
					<option value="和食" <c:if test="${newMenuProduct.item=='和食'}">selected</c:if>>和食</option>
					<option value="洋食" <c:if test="${newMenuProduct.item=='洋食'}">selected</c:if>>洋食</option>
					<option value="トッピング" <c:if test="${newMenuProduct.item=='トッピング'}">selected</c:if>>トッピング</option>
					<option value="飲み物" <c:if test="${newMenuProduct.item=='飲み物'}">selected</c:if>>飲み物</option>
					<option value="その他" <c:if test="${newMenuProduct.item=='その他'}">selected</c:if>>その他</option>
				</select>
			</div>
			商品コード：<input type="text" name="typeCode" value="${newMenuProduct.typeCode}" placeholder="例）w-001 ※英数字15文字以内" required/><c:out value="${errMsg.get('typeCode')}"/><br />
			※和食は「w-」、和食セットは「ws-」、洋食は「y-」、トッピングは「t-」、飲み物は「d-」、その他商品は「a-」から始まる英字+数字の商品コードにしてください<br />
			品名：<input type="text" name="productName" value="${newMenuProduct.productName}" placeholder="15文字以内" required/><c:out value="${errMsg.get('productName')}"/><br />
			金額：<input type="text" name="price" value="${newMenuProduct.price}" placeholder="数字" required/><c:out value="${errMsg.get('price')}"/>円<br />
			カロリー：<input type="text" name="calorie" value="${newMenuProduct.calorie}" placeholder="数字" required/><c:out value="${errMsg.get('calorie')}"/>kcal<br />
			<div>品種：
				<select name="variety">
					<option value="" disabled <c:if test="${empty newMenuProduct}">selected</c:if>>選択してください</option>
					<option value="単品" <c:if test="${newMenuProduct.variety=='単品'}">selected</c:if>>単品</option>
					<option value="セット" <c:if test="${newMenuProduct.variety=='セット'}">selected</c:if>>セット</option>
				</select>
			</div>
			画像ファイル名：<input type="text" name="image" value="${newMenuProduct.image}" placeholder="例）商品コード.jpg" required/><c:out value="${errMsg.get('image')}"/><br />

			<input type="submit" value="確認" class="btn btn-primary"/>
		</form>
	</c:if>


	<!-- 修正入力画面（確認画面より戻るボタンから入力値再表示した場合） -->
	<c:if test="${action=='return'}">

		<form action="/recurrent/ManagerMenuRegistrationServlet" method="post">
			<div>品目：
				<select name="item">
					<option value="和食" <c:if test="${newMenuProduct.item=='和食'}">selected</c:if>>和食</option>
					<option value="洋食" <c:if test="${newMenuProduct.item=='洋食'}">selected</c:if>>洋食</option>
					<option value="トッピング" <c:if test="${newMenuProduct.item=='トッピング'}">selected</c:if>>トッピング</option>
					<option value="飲み物" <c:if test="${newMenuProduct.item=='飲み物'}">selected</c:if>>飲み物</option>
					<option value="その他" <c:if test="${newMenuProduct.item=='その他'}">selected</c:if>>その他</option>
				</select>
			</div>
			商品コード：<input type="text" name="typeCode" value="${newMenuProduct.typeCode}" placeholder="例）w-001 ※英数字15文字以内" required/><br />
			※和食は「w-」、和食セットは「ws-」、洋食は「y-」、トッピングは「t-」、飲み物は「d-」、その他商品は「a-」から始まる英字+数字の商品コードにしてください<br />
			品名：<input type="text" name="productName" value="${newMenuProduct.productName}" placeholder="15文字以内" required/><br />
			金額：<input type="text" name="price" value="${newMenuProduct.price}" placeholder="数字" required/>円<br />
			カロリー：<input type="text" name="calorie" value="${newMenuProduct.calorie}" placeholder="数字" required/>kcal<br />
			<div>品種：
				<select name="variety">
					<option value="単品" <c:if test="${newMenuProduct.variety=='単品'}">selected</c:if>selected>単品</option>
					<option value="セット" <c:if test="${newMenuProduct.variety=='セット'}">selected</c:if>>セット</option>
				</select>
			</div>
			画像ファイル名：<input type="text" name="image" value="${newMenuProduct.image}" placeholder="例）商品コード.jpg" required/><br />

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