<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー修正／削除画面</title>
</head>
<body>
	<!--メニュー管理画面トップ＆トップ画面移動ボタン -->
	<a href="/recurrent/ManagerMenuServlet">メニュー一覧へ</a>
	<form action="/recurrent/LoginServlet?action=toppage" method="post">
		<input type="submit" value="トップへ戻る"/>
	</form>

	<p>メニュー修正／削除画面</p>

	<form action="/recurrent/ManagerMenuUpdateServlet" method="post">
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
			<!--------------- 通常表示 -------------------------->
			<c:if test="${empty action}">
				<tr>
					<%-- <td>
						<select name="item">
							<option value="和食" <c:if test="${alterMenuProduct.item=='和食'}">selected</c:if>>和食</option>
							<option value="洋食" <c:if test="${alterMenuProduct.item=='洋食'}">selected</c:if>>洋食</option>
							<option value="トッピング" <c:if test="${alterMenuProduct.item=='トッピング'}">selected</c:if>>トッピング</option>
							<option value="飲み物" <c:if test="${alterMenuProduct.item=='飲み物'}">selected</c:if>>飲み物</option>
							<option value="その他" <c:if test="${alterMenuProduct.item=='その他'}">selected</c:if>>その他</option>
						</select>
					</td> --%>
					<td>
						<input type="hidden" name="item" value="${alterMenuProduct.item}" required/><c:out value="${alterMenuProduct.item}"/>
					</td>
					<td>
						<input type="hidden" name="typeCode" value="${alterMenuProduct.typeCode}" required/><c:out value="${alterMenuProduct.typeCode}"/>
					</td>
					<td>
						<input type="text" name="productName" value="${alterMenuProduct.productName}" required/>
					</td>
					<td>
						<input type="text" name="price"value="${alterMenuProduct.price}" required/>円
					</td>
					<td>
						<input type="text" name="calorie"value="${alterMenuProduct.calorie}" required/>kcal
					</td>
					<%-- <td>
						<select name="variety">
							<option value="単品" <c:if test="${alterMenuProduct.variety=='単品'}">selected</c:if>>単品</option>
							<option value="セット" <c:if test="${alterMenuProduct.variety=='セット'}">selected</c:if>>セット</option>
						</select>
					</td> --%>
					<td>
						<input type="hidden" name="variety" value="${alterMenuProduct.variety}" required/><c:out value="${alterMenuProduct.variety}"/>
					</td>

					<td>
						<input type="text" name="image"value="${alterMenuProduct.image}" required/>
					</td>
				</tr>
			</c:if>
			<!--------------- 通常表示ここまで -------------------------->

			<!--------------------- retuen表示 -------------------------->
			<c:if test="${not empty action}">
				<tr>
					<td>
						<input type="hidden" name="item" value="${alterMenuProductConfirm.item}" required/><c:out value="${alterMenuProductConfirm.item}"/>
					</td>
					<td>
						<input type="hidden" name="typeCode" value="${alterMenuProductConfirm.typeCode}" required/><c:out value="${alterMenuProductConfirm.typeCode}"/>
					</td>
					<td>
						<input type="text" name="productName"value="${alterMenuProductConfirm.productName}" required/>
					</td>
					<td>
						<input type="text" name="price"value="${alterMenuProductConfirm.price}" required/>円
					</td>
					<td>
						<input type="text" name="calorie"value="${alterMenuProductConfirm.calorie}" required/>kcal
					</td>
					<%-- <td>
						<select name="variety">
							<option value="単品" <c:if test="${alterMenuProductConfirm.variety=='単品'}">selected</c:if>>単品</option>
							<option value="セット" <c:if test="${alterMenuProductConfirm.variety=='セット'}">selected</c:if>>セット</option>
						</select>
					</td> --%>
					<td>
						<input type="hidden" name="variety" value="${alterMenuProductConfirm.variety}" required/><c:out value="${alterMenuProductConfirm.variety}"/>
					</td>
					<td>
						<input type="text" name="image"value="${alterMenuProductConfirm.image}" required/>
					</td>
				</tr>
			</c:if>
			<!--------------------- retuen表示ここまで -------------------------->

		</table>


		<!-- 処理選択 -->
		<p>更新処理内容を選択してください</p>
		<label for="update"><input type="radio" name="process" id="update" value="update" checked/>変更</label>
		<label for="delate"><input type="radio" name="process" id="delate" value="delete" <c:if test="${process=='delete'}">checked</c:if>/>削除</label><br />
		<input type="submit" value="確認"/>
	</form>


	<!-- ログアウトボタン -->
	<a href="/recurrent/ConfirmLoginServlet">ログアウト</a>
</body>
</html>