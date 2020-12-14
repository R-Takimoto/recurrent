<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="ja">

<head>
	<%@ include file="../include/include_meta.jsp" %>
	<title>リ・カレント亭</title>
	<jsp:include page="../include/include_css.jsp" />
	<link rel="stylesheet" href="css/play.css">
</head>
<body>
	<div class="container">
		<%@ include file="../include/include_header.jsp" %>
		<div class="row main-wrapper">
			<%@ include file="../include/mode_nav.jsp" %>
			<main class="main">
				<div class="ddd">
					<div class="col-sm-10 ddd" id="gatyaResult">
						<table class="table table-bordered table-light table-striped" id="gatyaTable">
							<thead  class="thead-dark">
								<tr>
									<th class="col-xs-3 col-ms-3 col-md-4 col-lg-4">品名</th>
									<th class="col-xs-3 col-ms-3 col-md-4 col-lg-4">金額</th>
									<th class="col-xs-3 col-ms-3 col-md- col-lg-4">カロリー</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="gatyaresult" items="${gatyaMenu.products}">
									<tr>
										<td><c:out value="${gatyaresult.productName}"/></td>
										<td><c:out value="${gatyaresult.price}"/>円</td>
										<td><c:out value="${gatyaresult.calorie}"/>kcal</td>
									</tr>
								</c:forEach>
								<tr>
									<td>合計</td>
									<td><c:out value="${gatyaPriceTotal}"/>円</td>
									<td><c:out value="${gatyaCalorieTotal}"/>kcal</td>
								</tr>

							</tbody>
						</table>
						<div id="gatyaD">
							<div id="gatyaB" class="gatyaC ddd">
								<a href="/recurrent/PlayServlet?action=gatya" class="button" >もう１回ガチャる！！</a>
							</div>
							<div class="ddd">
								<form action="/recurrent/CartServlet?action=gatyaCart" method="post" class="ddd">
									<input type="submit" value="カートに入れる" class="button gatyaC" />
								</form>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../include/bootstrap_script.jsp" %>
</body>
</html>