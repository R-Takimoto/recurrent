<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/jsp/boot.jsp" %>

 <div class="col-sm-2">
	<div class="btn-group-vertical">

		</div>
       <p></p>
		<p></p>
		<p></p>
		<form action="/recurrent/WelcomeServlet" method="post">
		<input type="submit" value="通常メニュー"></form>
		<p></p>
		<a href="/recurrent/CartServlet"><button type="button" class="btn btn-warning">注文カート</button></a>
		<p></p>
		<a href="/recurrent/AssistServlet?action=calorieSelect"><button type="button" class="btn btn-dark">カロリー絞り込み</button></a>
		<p></p>
		<a href="/recurrent/AssistServlet?action=priceSelect"><button type="button" class="btn btn-success">価格絞り込み</button></a>
		<p></p>
		<a href="/recurrent/PlayServlet"><button type="button" class="btn btn-info">ガチャ注文</button></a>
		<p></p>
		<a href="/recurrent/SlipServlet"><button type="button" class="btn btn-primary">伝票</button></a>
	</div>

</body>
</html>