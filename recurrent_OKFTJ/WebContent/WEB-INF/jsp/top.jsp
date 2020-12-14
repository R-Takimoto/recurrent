<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="ja">

<head>
	<%@ include file="../include/include_meta.jsp" %>
	<title>リ・カレント亭</title>
	<jsp:include page="../include/include_css.jsp" />
	<link rel="stylesheet" href="css/top.css">
</head>
<body>
	<div class="container">
		<%@ include file="../include/include_header.jsp" %>
		<div class="row main-wrapper">
			<%@ include file="../include/mode_nav.jsp" %>
			<main class="main">
				<div class="products-wrapper">
					<ul>
						<c:set var="orderType" value="${ orderTypeId }" />
						<c:if test="${ orderType == 1 }"><c:set var="map" value="${ menu }" /></c:if>
						<c:if test="${ orderType == 2 || orderType == 3 }"><c:set var="map" value="${ selectMenu }" /></c:if>
						<c:forEach var="list" items="${map[key].getProducts()}" >
							<li class="product-wrapper">
								<a href="/recurrent/ProductServlet?typeCode=${list.typeCode}&key=${key}">
									<img src="images/${list.image}" class="img" alt="${list.productName}" />
									<span class="s1"><c:out value="${list.productName}"/></span>
									<span class="s2"><c:out value="${list.price}"/>円</span>
									<span class="s3"><c:out value="${list.calorie}"/>カロリー</span>
								</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../include/bootstrap_script.jsp" %>
</body>
</html>