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