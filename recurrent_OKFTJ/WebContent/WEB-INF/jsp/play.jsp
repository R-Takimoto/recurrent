<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ガチャ画面</title>
</head>
<body>
<div class="container">
    <div class="row">
<jsp:include page="/WEB-INF/jsp/menuTab.jsp" />
 <jsp:include page="/WEB-INF/jsp/menuButton.jsp" />
  <div class="col-sm-10">
わくわくガチャ

１回８００円！！キャンセル可能！！

<a href="/recurrent/PlayServlet?action=gatya">ガチャる！！</a>
 </div>
    </div>
</div>
</body>
</html>

