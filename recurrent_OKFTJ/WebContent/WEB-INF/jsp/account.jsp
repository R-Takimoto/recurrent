<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="../include/include_meta.jsp" %>
	<title>アカウント管理</title>
	<%@ include file="../include/include_css.jsp" %>
	<link rel="stylesheet" href="css/managerStyle.css">
</head>
<body>
	<div class="wrapper">
		<div class="topbutton">
			<form action="/recurrent/LoginServlet?action=toppage" method="post">
				<input type="submit" value="トップへ戻る" class="rightbutton btn btn-outline-primary"/>
			</form>
		</div>
		<div class="space">
		</div>

		<h2>アカウント管理画面</h2>

		<!-- 登録アカウントがない場合 -->
		<c:if test="${empty managersAll}">
			<p>登録アカウントがありません</p>
		</c:if>

		<!-- 登録アカウントがある場合 -->
		<c:if test="${not empty managersAll}">
			<p>修正・削除するアカウントの管理者IDを選択してください</p>
			<table class="dbtable" border="1" >
				<tr>
					<!-- <td>店舗</td> -->
					<td>管理者ID</td>
					<td>名前</td>
				</tr>
				<c:forEach var="managers" items="${managersAll}" varStatus="status">
					<tr>
						<%-- <td><c:if test="${managers.id=='koube-m'}">神戸店</c:if></td>
						<td><c:if test="${managers.id=='osaka.*'}">大阪店</c:if></td> --%>
						<%-- <td><c:out value="${storeName}"/></td> --%>
						<%-- <td><a href="/recurrent/AccountUpdateServlet?accountNum=${status.index}"><c:out value="${managers.id}"/></a></td> --%>
						<td><c:out value="${managers.id}"/></td>
						<td><c:out value="${managers.name}"/></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>



		<div class="bottombutton">
		 	<a href="/recurrent/AccountRegistrationServlet" class="leftbutton btn btn-success">新規登録</a>
			<a href="/recurrent/ConfirmLoginServlet" class="rightbutton btn btn-outline-danger">ログアウト</a>
		</div>
	</div>
</body>
</html>