<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/boot.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カートは空です</title>
</head>
<body>
	<jsp:include page="/WEB-INF/include/menuTab.jsp" />
	<div class="container">


		<div class="row">
			<jsp:include page="/WEB-INF/include/menuButton.jsp" />
			<div class="col-sm-10">
				<h1>カートは空です</h1>
			</div>
		</div>
		<jsp:include page="/WEB-INF/include/margin.jsp" />
	</div>

</body>
</html>