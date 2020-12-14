<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="servlet.*,servlet.SlipServlet.*,dao.*,java.util.ArrayList" %>


<!DOCTYPE html>

<html lang="ja">

<head>
	<%@ include file="../include/include_meta.jsp" %>
	<title>>リ・カレント亭</title>
	<%@ include file="../include/include_css.jsp" %>
</head>
<body>
	<div class="container">
		<%@ include file="../include/include_header.jsp" %>

	<main>
			<div class="row">
			<jsp:include page="/WEB-INF/include/menuButton.jsp" />
			<div class="col-sm-10 main">

				<p></p>
				<p></p>
				<h3>
					<p class="text-sm-center">伝票</p>
				</h3>
<table border="1">
			<tr>
				<th>ご注文商品</th>
				<th>数量</th>
				<th>金額</th>
				<th>カロリー</th>
			</tr>





					<c:forEach var="kaikei1" items="${kaikei.slips}" >
				<tr>

					<td><c:out value="${kaikei1.product}"/></td>
					<td><c:out value="${kaikei1.quantity}"/></td>
					<td><c:out value="${kaikei1.price}"/></td>
					<td><c:out value="${kaikei1.calorie}"/></td>



<%--
					<td><%= request.getAttribute("Product") %></td>
					<td><%= request.getAttribute("Quantity") %></td>
					<td><%= request.getAttribute("Price") %></td>
					<td><%= request.getAttribute("Calorie") %></td> --%>

				</tr>
				</c:forEach>



		</table>

				<h3>
					<a href="/recurrent/SlipServlet?action=kaikei"><p
							class="text-sm-center">会計</p></a>
				</h3>
			</div>
		</div>
		<jsp:include page="/WEB-INF/include/margin.jsp" />
	</main>
	</div>
  <%@ include file="../include/bootstrap_script.jsp" %>
</body>
</html>