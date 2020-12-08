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
  <div class="col-sm-10">

<a href="/recurrent/PlayServlet?action=gatya">もう１回ガチャる！！</a>

<form action="/recurrent/CartServlet" method="post">
<input type="submit" value="カートに入れる" />
</form>
 </div>
    </div>
</div>
</body>
</html>
