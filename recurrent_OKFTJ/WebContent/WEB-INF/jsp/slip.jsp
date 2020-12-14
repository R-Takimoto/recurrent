<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>

<html lang="ja">

<head>
	<%@ include file="../include/include_meta.jsp" %>
	<title>>リ・カレント亭</title>
	<%@ include file="../include/include_css.jsp" %>
	<link rel="stylesheet" href="css/cart.css">
	<link rel="stylesheet" href="css/slip.css">
</head>
<body>
	<div class="container">
		<%@ include file="../include/include_header.jsp" %>
		<div class="row main-wrapper">
			<%@ include file="../include/mode_nav.jsp" %>
			<main class="main">
				<h3>伝票</h3>
				<table class="cart-form-table">
					<tr>
						<th>ご注文商品</th>
						<th>数量</th>
						<th>金額</th>
						<th>カロリー</th>
					</tr>
					<c:forEach var="kaikei1" items="${kaikei.slips}" >
						<tr>
							<td><c:out value="${kaikei1.product}"/></td>
							<td><c:out value="${kaikei1.quantity}"/></td>
							<td><c:out value="${kaikei1.price}"/></td>
							<td><c:out value="${kaikei1.calorie}"/></td>
						</tr>
					</c:forEach>
				</table>
				<div class="c">
					<p><a href="/recurrent/SlipServlet?action=kaikei" class="button">会計</a></p>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../include/bootstrap_script.jsp" %>
</body>
</html>