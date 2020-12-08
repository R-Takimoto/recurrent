<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<%@ include file="../include/include_meta.jsp" %>
	<title>カート</title>
	<jsp:include page="../include/include_css.jsp" />
</head>

<body>
	<div class="container">
		<%@ include file="../include/include_header.jsp" %>
		<%@ include file="../include/mode_nav.jsp" %>
		<div class="row">
			<div class="col-sm-10 main">
				<div class="button_wrapper">
					<form action="/recurrent/CartServlet?action=alter" method="post">
						<input type="submit" value="数量変更・削除"/>
					</form>
				</div>
				<div class="button_wrapper">
					<table>
						<tr>
							<th>ご注文商品</th>
							<th>数量</th>
							<th>金額</th>
							<th>カロリー</th>
							<th>ご注文方法</th>
						</tr>
					</table>
					<form action="/recurrent/OrderServlet" method="post">
						<table>
							<tr>
								<td><c:out value="${orders.orders[0].productName }" /></td>
								<td><c:out value="${orders.orders[0].quantity }" /></td>
								<td><c:out value="${orders.orders[0].price }" /></td>
								<td><c:out value="${orders.orders[0].calorie }" /></td>
								<td><c:out value="${orders.orders[0].ordertypeId }" /></td>
								</tr>
						</table>
						<input type="submit" value="注文を確定する" class="button">
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/jsp/margin.jsp" />
</body>

</html>