<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/boot.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>伝票</title>
</head>
<body>
	<jsp:include page="/WEB-INF/include/menuTab.jsp" />
	<div class="container">


		<div class="row">
			<jsp:include page="/WEB-INF/include/menuButton.jsp" />
			<div class="col-sm-10 main">

				<p></p>
				<p></p>
				<h3>
					<p class="text-sm-center">伝票</p>
				</h3>


				<h3>
					<a href="/recurrent/SlipServlet?action=kaikei"><p
							class="text-sm-center">会計</p></a>
				</h3>
			</div>
		</div>
		<jsp:include page="/WEB-INF/include/margin.jsp" />
	</div>

</body>
</html>