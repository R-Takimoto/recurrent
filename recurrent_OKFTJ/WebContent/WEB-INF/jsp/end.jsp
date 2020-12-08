<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/boot.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会計</title>
</head>
<body>
	<jsp:include page="/WEB-INF/include/menuTab.jsp" />
	<div class="container">


		<div class="row">
			<jsp:include page="/WEB-INF/include/menuButton.jsp" />
			<div class="col-sm-10 main">
				<h3>
					<p class="text-sm-center">会計は○○○になります。</p>
				</h3>


				<a href="/recurrent/WelcomeServlet?hoge=foo"><p class="text-sm-center">終了</p></a>

			</div>
		</div>
		<jsp:include page="/WEB-INF/include/margin.jsp" />
	</div>

</body>
</html>