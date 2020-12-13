<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="ja">

<head>
	<%@ include file="../include/include_meta.jsp" %>
	<title>商品詳細画面</title>
	<jsp:include page="../include/include_css.jsp" />
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
	<link rel="stylesheet" href="css/product.css">
</head>
<body>
	<div class="container">
		<%@ include file="../include/include_header.jsp" %>
		<div class="row wrapper">
			<%@ include file="../include/mode_nav.jsp" %>
			<main class="main">
				<div class="products-wrapper">
					<ul>
						<li class="product-wrapper">
							<img src="images/<c:out value="${product.image }"/>" alt="<c:out value="${product.productName }" />" />
							<p><c:out value="${product.productName }" /></p>
							<div class="price-calolie-wrapper">
								<p><c:out value="${product.price }"/>円</p>
								<p><c:out value="${product.calorie }"/>カロリー</p>
							</div>
						</li>
					</ul>
				</div>
				<div class="product-detail-wrapper">
					<c:if test="${ empty change || change == 'change' }">
						<form action="/recurrent/CartServlet<c:if test="${change=='change'}">?action=confirm</c:if>" method="post">
							<input type="hidden" name="typeCode" value="<c:out value="${product.typeCode }"/>" />
							<input type="hidden" name="productName" value="<c:out value="${product.productName }"/>" />
							<input type="hidden" name="price" value="<c:out value="${product.price }"/>" />
							<input type="hidden" name="calorie" value="<c:out value="${product.calorie }"/>" />
							<input type="hidden" name="image" value="<c:out value="${product.image }"/>" />
							<input type="hidden" name="orderTypeId" value="<c:out value="${orderTypeId }"/>" />
							<div class="form-button-wrapper">
								<button id="downButton" class="btn" type="button"><i class="fa-5x fas fa-minus-circle"></i></button>
								<input id="count" class="num-area" type="number" name="quantity" value="1" min="1" max="20" requied />
								<button id="upButton" class="btn" type="button"><i class="fa-5x fas fa-plus-circle"></i></button>
							</div>
							<c:if test="${ empty change }"><input type="submit" value="${button }" class="button" /></c:if>
							<c:if test="${ change == 'change' }"><input type="submit" value="${button }" class="button" /></c:if>
							<!-- <a href="javascript:history.back()" class="button">戻る</a>-->
						</form>
					</c:if>
					<c:if test="${change=='delete'}">
						<form action="/recurrent/CartServlet?action=confirm" method="post">
							<input type="hidden" name="quantity" value="1"/>
							<input type="hidden" name="delete" value="delete" />
							<input type="submit" value="商品取消" class="button" />
						</form>
					</c:if>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../include/bootstrap_script.jsp" %>
</body>
</html>