<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- ハンバーガーメニュー部分 -->
<div class="drawer">
	<!-- ハンバーガーメニューの表示・非表示を切り替えるチェックボックス -->
	<input type="checkbox" id="drawer-check" class="drawer-hidden" >
	<!-- ハンバーガーアイコン -->
	<label for="drawer-check" class="drawer-open"><span></span></label>
	<!-- メニュー -->
	<nav class="drawer-content">
		<ul class="drawer-list">
			<li class="drawer-item"><a href="/recurrent/WelcomeServlet">通常メニュー</a></li>
			<li class="drawer-item"><a href="/recurrent/CartServlet">注文カート</a></li>
			<li class="drawer-item"><a href="/recurrent/AssistServlet?action=calorieSelect">カロリー絞り込み</a></li>
			<li class="drawer-item"><a href="/recurrent/AssistServlet?action=priceSelect">価格絞り込み</a></li>
			<li class="drawer-item"><a href="/recurrent/PlayServlet">ガチャ注文</a></li>
			<li class="drawer-item"><a href="/recurrent/SlipServlet">伝票</a></li>
		</ul>
	</nav>
</div>
<!--
<div class="col-sm-2">
	<form action="/recurrent/WelcomeServlet" method="post">
		<input type="submit" value="通常メニュー">
	</form>
	<p><a href="/recurrent/CartServlet"><button type="button" class="btn btn-warning">注文カート</button></a></p>
	<p><a href="/recurrent/AssistServlet?action=calorieSelect"><button type="button" class="btn btn-dark">カロリー絞り込み</button></a></p>
	<p><a href="/recurrent/AssistServlet?action=priceSelect"><button type="button" class="btn btn-success">価格絞り込み</button></a></p>
	<p><a href="/recurrent/PlayServlet"><button type="button" class="btn btn-info">ガチャ注文</button></a></p>
	<p><a href="/recurrent/SlipServlet"><button type="button" class="btn btn-primary">伝票</button></a></p>
</div>
 -->