<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会計</title>
</head>
<body>
<div class="container">
    <div class="row">
<jsp:include page="/WEB-INF/jsp/menuTab.jsp" />
 <jsp:include page="/WEB-INF/jsp/menuButton.jsp" />
  <div class="col-sm-10 main">
<h3><p class="text-sm-center">会計は○○○になります。</p></h3>


<a href="/recurrent/WelcomeServlet?hoge=foo"><p class="text-sm-center">終了</p></a>

 </div>
    </div>
</div>
</body>
</html>