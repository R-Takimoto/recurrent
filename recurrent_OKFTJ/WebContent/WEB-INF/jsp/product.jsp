<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細画面</title>
</head>
<body>
<div class="container">
    <div class="row">
<jsp:include page="/WEB-INF/jsp/menuTab.jsp" />
 <jsp:include page="/WEB-INF/jsp/menuButton.jsp" />
  <div class="col-sm-10 main">

<!-- 商品詳細画面 -->
<c:if test="${empty action}">
<img src="image/katsudon.jpg" alt="カツ丼セット（仮）" />

<h3>商品タイトル</h3>
<h3>●●●円</h3>
<h3>●●●カロリー</h3>
<form action="/recurrent/CartServlet" method="post">
	数量：<input type="number" name="quantity" value="1" min="1" max="20" requied/><br>
	<input type="submit" value="注文カートに入れる" class="button"/>
</form>
<a href="javascript:history.back()">メニューに戻る</a>
</c:if>
<!-- 商品詳細画面ここまで -->


<!-- カート数量変更画面 -->
<c:if test="${action=='alter'}">
<img src="image/katsudon.jpg" alt="カツ丼セット（仮）" />
<h3>商品タイトル</h3>
<h3>●●●円</h3>
<h3>●●●カロリー</h3>
<form action="/recurrent/CartServlet?action=confirm" method="post">
	<!-- ↓カート内の数量の数が初期値に入るようにする -->
	数量：<input type="number" name="quantity" value="1" min="1" max="20" requied/><br>
	<input type="submit" name="quantityChange" value="数量変更" class="button"/>
	<input type="submit" name="delate" value="商品削除" class="button"/>
</form>
</c:if>
<!-- カート数量変更画面ここまで -->
 </div>
    </div>
</div>

</body>
</html>