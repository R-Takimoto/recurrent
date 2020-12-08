<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="ja">

<head>
	<%@ include file="../include/include_meta.jsp" %>
	<title>>リ・カレント亭</title>
	<%@ include file="../include/include_css.jsp" %>
</head>
<body>
	<div class="container">
		<%@ include file="../include/include_header.jsp" %>

	<main>
				<div class="row">
			<jsp:include page="/WEB-INF/include/menuButton.jsp" />
			<div class="col-sm-10 main">


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
		<jsp:include page="/WEB-INF/include/margin.jsp" />
	</main>
	</div>
  <%@ include file="../include/bootstrap_script.jsp" %>
</body>
</html>