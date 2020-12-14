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
			<li class="drawer-item"><a href="/recurrent/WelcomeServlet?key=s&orderTypeId=1">通常<br class="br">メニュー</a></li>
			<li class="drawer-item"><a href="/recurrent/CartServlet">注文<br class="br">カート</a></li>
			<li class="drawer-item"><a href="/recurrent/AssistServlet?orderTypeId=2">カロリー<br class="br">絞り込み</a></li>
			<li class="drawer-item"><a href="/recurrent/AssistServlet?orderTypeId=3">価格<br class="br">絞り込み</a></li>
			<li class="drawer-item"><a href="/recurrent/PlayServlet">ガチャ<br class="br">注文</a></li>
			<li class="drawer-item"><a href="/recurrent/SlipServlet">伝票</a></li>
		</ul>
	</nav>
</div>