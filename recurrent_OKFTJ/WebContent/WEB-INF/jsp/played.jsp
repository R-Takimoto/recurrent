<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ガチャ結果画面</title>
</head>
<body>
<div class="container">
    <div class="row">
<jsp:include page="/WEB-INF/jsp/menuTab.jsp" />
 <jsp:include page="/WEB-INF/jsp/menuButton.jsp" />
  <div class="col-sm-10 main">

<a href="/recurrent/PlayServlet?action=gatya"><p class="text-sm-center">もう１回ガチャる！！</p></a>

<form action="/recurrent/CartServlet" method="post">
<input type="submit" value="カートに入れる" class="button"/>
</form>
 </div>
    </div>
</div>
</body>
</html>
