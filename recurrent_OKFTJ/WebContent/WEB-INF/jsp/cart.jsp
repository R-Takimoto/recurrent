<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>カート</title>
</head>

<body>
	<h1>カート内</h1>
	<div class="container">
		<div class="row">
			<jsp:include page="/WEB-INF/jsp/menuTab.jsp" />
			<jsp:include page="/WEB-INF/jsp/menuButton.jsp" />
			<div class="col-sm-10">
				<table>
						<tr>
							<th>ご注文商品</th>
							<th>数量</th>
							<th>金額</th>
							<th>カロリー</th>
						</tr>
				</table>
				<form action="/recurrent/CartServlet?action=alter" method="post">
					<table>
						<tr>
							<td><c:out value="${orders.orders[0].productName }" /></td>
							<td><c:out value="${orders.orders[0].quantity }" /></td>
							<td><c:out value="${orders.orders[0]. }" /></td>
							<td><c:out value="${orders.orders[0].productName }" /></td>
						</tr>
					</table>
					<input type="submit" value="数量変更・削除"/>
				</form>
				<form action="/recurrent/OrderServlet" method="post">
					<input type="submit" value="注文を確定する" class="button">
				</form>
			</div>
		</div>
	</div>
</body>

</html>