<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/boot.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ガチャ結果画面</title>
</head>
<body>
	<jsp:include page="/WEB-INF/include/menuTab.jsp" />
	<div class="container">


		<div class="row">
			<jsp:include page="/WEB-INF/include/menuButton.jsp" />
			<div class="col-sm-10 main">

				<a href="/recurrent/PlayServlet?action=gatya"><p
						class="text-sm-center">もう１回ガチャる！！</p></a>

				<form action="/recurrent/CartServlet" method="post">
					<input type="submit" value="カートに入れる" class="button" />
				</form>
			</div>
		</div>
		<jsp:include page="/WEB-INF/include/margin.jsp" />
	</div>

</body>
</html>
