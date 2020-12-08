<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="ja">

<head>
<%@ include file="../include/include_meta.jsp"%>
<title>>リ・カレント亭</title>
<%@ include file="../include/include_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="../include/include_header.jsp"%>

		<main>
			<div class="row">



				<jsp:include page="/WEB-INF/include/menuButton.jsp" />
				<div class="col-sm-10 main">
					<h1>カート内</h1>
					<div class="button_wrapper">
						<form action="/recurrent/CartServlet?action=alter" method="post">
							<input type="submit" value="数量変更・削除" class="button" />
						</form>
					</div>
					<div class="button_wrapper">
						<form action="/recurrent/OrderServlet" method="post">

							<input type="submit" value="注文を確定する" class="button">
						</form>
					</div>
				</div>

			</div>
			<jsp:include page="/WEB-INF/include/margin.jsp" />


		</main>
	</div>
	<%@ include file="../include/bootstrap_script.jsp"%>
</body>
</html>