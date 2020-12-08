<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/boot.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート</title>
</head>
<body>
	<h1>カート内</h1>
	<jsp:include page="/WEB-INF/include/menuTab.jsp" />
	<div class="container">


		<div class="row">
			<jsp:include page="/WEB-INF/include/menuButton.jsp" />
			<div class="col-sm-10 main">
				<div class="button_wrapper">
					<form action="/recurrent/CartServlet?action=alter" method="post">
						<input type="submit" value="数量変更・削除" class="button" />
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
								<td><c:out value="${orders[0].productName }" /></td>
								<td><c:out value="${orders[0].quantity }" /></td>
								<td><c:out value="${orders[0].price }" /></td>
								<td><c:out value="${orders[0].calorie }" /></td>
								<td><c:out value="${orders[0].ordertypeId }" /></td>
								</tr>
						</table>
						<input type="submit" value="注文を確定する" class="button">
					</form>
				</div>
			</div>

		</div>
		<jsp:include page="/WEB-INF/include/margin.jsp" />
	</div>

</body>
</html>