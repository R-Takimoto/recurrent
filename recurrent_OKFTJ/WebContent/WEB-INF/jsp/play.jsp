<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ガチャ画面</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<jsp:include page="/WEB-INF/jsp/menuTab.jsp" />
			<jsp:include page="/WEB-INF/jsp/menuButton.jsp" />
			<div class="col-sm-10 main">
        １回８００円！！キャンセル可能！！
				<h3>
					<p class="text-sm-center">わくわくガチャ</p>
				</h3>
				<h3>
					<p class="text-sm-center">１回８００円！！キャンセル可能！！</p>
				</h3>

				<a href="/recurrent/PlayServlet?action=gatya"><p
						class="text-sm-center">ガチャる！！</p></a>
			</div>

		</div>
	</div>
</body>

</html>

