<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="../include/include_meta.jsp" %>
	<title>売上管理</title>
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

		<h2>売上管理</h2>

		<p>売上確認をする条件を入力してください</p>

		<form action="/recurrent/ManagerSalesServlet" method="post">
			<div>店舗：
				<select name="store">
					<option value="" disabled selected>選択してください</option>
					<option value="k">神戸店</option>
					<option value="o">大阪店</option>
				</select>
			</div>

			日付（期間）：<input type="date" name="fromDate">～<input type="date" name="toDate"><br />
			<div>商品名：
				<select name="productName">
					<option value="" disabled selected>選択してください</option>
					<option value="allProduct" >全商品</option>
					<c:forEach var="menu" items="${menuSales.managerProducts}">
						<option value="${menu.typeCode}"><c:out value="${menu.productName}"/></option>
					</c:forEach>
				</select>
			</div>

			<input type="submit" value="売上確認" class="btn btn-danger"/>

		</form>



	<!-- ログアウトボタン -->
	<div class="bottombutton">
			<a href="/recurrent/ConfirmLoginServlet" class="rightbutton btn btn-outline-danger">ログアウト</a>
		</div>
	</div>

</body>
</html>