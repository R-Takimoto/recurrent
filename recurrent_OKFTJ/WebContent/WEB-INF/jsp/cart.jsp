<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート</title>
</head>
<body>
<h1>カート内</h1>
<div class="container">
    <div class="row">
<jsp:include page="/WEB-INF/jsp/menuTab.jsp" />
 <jsp:include page="/WEB-INF/jsp/menuButton.jsp" />
  <div class="col-sm-10">


 <form action="/recurrent/CartServlet?action=alter" method="post">
	<input type="submit" value="数量変更・削除"/>
</form>

 <form action="/recurrent/OrderServlet" method="post">




<p><input type="submit" value="注文を確定する"></p>
</form>
 </div>
    </div>
</div>
</body>
</html>