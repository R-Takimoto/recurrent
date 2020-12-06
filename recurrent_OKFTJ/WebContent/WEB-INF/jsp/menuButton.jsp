<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <div class="col-sm-2">
	<div class="btn-group-vertical">
		<form action="/recurrent/WelcomeServlet" method="post">
			<input type="submit" value="通常メニュー">
		</form>
		<a href="/recurrent/CartServlet"><button type="button" class="btn btn-warning">注文カート</button></a>
		<a href="/recurrent/AssistServlet?action=calorieSelect"><button type="button" class="btn btn-dark">カロリー絞り込み</button></a>
		<a href="/recurrent/AssistServlet?action=priceSelect"><button type="button" class="btn btn-success">価格絞り込み</button></a>
		<a href="/recurrent/PlayServlet"><button type="button" class="btn btn-info">ガチャ注文</button></a>
		<a href="/recurrent/SlipServlet"><button type="button" class="btn btn-primary">伝票</button></a>
	</div>
</div>