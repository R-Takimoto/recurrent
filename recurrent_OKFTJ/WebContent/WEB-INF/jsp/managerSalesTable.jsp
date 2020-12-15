<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="../include/include_meta.jsp" %>
	<title>売上詳細</title>
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

		<h2>売上詳細</h2>

		<p>店舗名：<c:out value="${store}"/></p>
		<p>日付（期間）：<c:out value="${fromDate}"/>～<c:out value="${toDate}"/></p>
		<p>商品名：<c:out value="${productName}"/></p>

		<!-- 注文がない場合 -->
		<c:if test="${empty salesProduct}">
			<p>注文はありません</p>
		</c:if>

		<!-- 注文がある場合 -->
		<c:if test="${not empty salesProduct}">
			<table class="dbtable" border="1" >
				<tr>
					<th>注文日</th>
					<th>品名</th>
					<th>金額</th>
					<th>カロリー</th>
					<th>数量</th>
					<th>品目</th>
					<th>品種</th>
					<th>注文方法</th>
				</tr>
				<c:forEach var="salesProduct" items="${salesProduct.managerSlips}">
					<tr>
						<td><c:out value="${salesProduct.orderDate}"/></td>
						<td><c:out value="${salesProduct.productName}"/></td>
						<td><c:out value="${salesProduct.price}"/>円</td>
						<td><c:out value="${salesProduct.calorie}"/>kcal</td>
						<td><c:out value="${salesProduct.quantity}"/></td>
						<td><c:out value="${salesProduct.item}"/></td>
						<td><c:out value="${salesProduct.variety}"/></td>
						<td><c:out value="${salesProduct.orderType}"/>注文</td>
					</tr>
				</c:forEach>
			</table>
			<br />
			<table class="dbtable" id="totalprice" border="1">
				<tr>
					<th>合計金額</th>
					<td><c:out value="${totalSalesPrice}"/>円</td>
				</tr>
			</table>
		</c:if>


	<!-- ログアウトボタン -->
	<div class="bottombutton">
	        <a href="/recurrent/ManagerSalesServlet" class="leftbutton btn btn-warning">日付（期間）再選択</a>
			<a href="/recurrent/ConfirmLoginServlet" class="rightbutton btn btn-outline-danger">ログアウト</a>
		</div>
	</div>


</body>
</html>