<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="ja">

<head>
	<%@ include file="../include/include_meta.jsp" %>
	<title>リ・カレント亭</title>
	<%@ include file="../include/include_css.jsp" %>
</head>
<body>
	<div class="container">
		<%@ include file="../include/include_header.jsp" %>
		<%@ include file="../include/mode_nav.jsp" %>
		<main>
			<div class="row" id="gatya">
				<jsp:include page="/WEB-INF/include/menuButton.jsp" />
				<div class="col-sm-10 main">
					<h3>わくわくガチャ</h3>
					<h4>１回８００円！！キャンセル可能！！</h4>
					<div id="gatyaImage">
						<img src="/recurrent/gatyaImg.png"  alt="ガチャイラスト" />
					</div>
					<p>
						<a href="/recurrent/PlayServlet?action=gatya" class="button" id="gatyaA">ガチャる！！</a>
					</p>
				</div>

			</div>
			<jsp:include page="/WEB-INF/include/margin.jsp" />
		</main>
	</div>
  	<%@ include file="../include/bootstrap_script.jsp" %>
</body>
</html>