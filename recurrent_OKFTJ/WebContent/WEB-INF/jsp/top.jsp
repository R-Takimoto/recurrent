<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="ja">

<head>
	<%@ include file="../include/include_meta.jsp" %>
	<title>>リ・カレント亭</title>
	<jsp:include page="../include/include_css.jsp" />
</head>

<body>

	<div class="container">
		<%@ include file="../include/menu_nav.jsp" %>
		<%@ include file="../include/menuButton.jsp" %>
	</div>

	<div>
		<main>
			<h1>ご希望の商品を選択してください。</h1>

		<div class="container-fluid container-m bg-warning">
			<div class="card-deck"><%--横並べ --%>
			<c:forEach var="list" items="${menu.get(key).getProducts()}" >
				<div class="row align-items-center" style="height:400px">
				<div class="col-auto flex-md-fill">
				<div class="text-center">
				<div class="card border-success" style="width:35rem">
					<a href="/recurrent/ProductServlet?typeCode=${list.typeCode}&key=${key}">
					<img src="images/${list.image}" class="rounded" alt="${list.productName}" class="img-thumbnail" loading="lazy">
						<div class="card-body text-secondary">
							<h6 class="card-text"><c:out value="${list.productName}"/></h6>
						    <h5 class="card-text"><c:out value="${list.price}"/>円</h5>
							<h5 class="card-text"><c:out value="${list.calorie}"/>カロリー</h5>
						</div>
					</a><br>
				</div>
				</div>
				</div>
				</div>
			</c:forEach>
			</div>
		</div>

		</main>


	</div>
	<%@ include file="../include/bootstrap_script.jsp" %>
</body>

</html>