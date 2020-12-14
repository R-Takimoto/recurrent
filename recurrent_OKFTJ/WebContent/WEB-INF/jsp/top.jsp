<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="ja">

<head>
	<%@ include file="../include/include_meta.jsp" %>
	<title>>リ・カレント亭</title>
	<jsp:include page="../include/include_css.jsp" />
	<link rel="stylesheet" href="css/top.css">
</head>
<body>
	<div class="container">
		<%@ include file="../include/include_header.jsp" %>
		<div class="row main-wrapper">
			<%@ include file="../include/mode_nav.jsp" %>
			<main class="main">
				<div class="products-wrapper">
					<ul>
						<li class="product-wrapper">
							<a href="/recurrent/ProductServlet?typeCode=w-005&key=w">
								<img src="images/wasyoku-005.jpg" class="img" alt="だし巻き" />
								<span>だし巻き</span>
							</a>
						</li>
						<li class="product-wrapper">
							<a href="/recurrent/ProductServlet?typeCode=w-005&key=w">
								<img src="images/wasyoku-005.jpg" class="img" alt="だし巻き" />
								だし巻き卵
							</a>
						</li>
						<li class="product-wrapper">
							<a href="/recurrent/ProductServlet?typeCode=w-005&key=w">
								<img src="images/wasyoku-005.jpg" class="img" alt="だし巻き" />
								だし巻き卵
							</a>
						</li>
						<li class="product-wrapper">
							<a href="/recurrent/ProductServlet?typeCode=w-005&key=w">
								<img src="images/wasyoku-005.jpg" class="img" alt="だし巻き" />
								だし巻き卵
							</a>
						</li>
						<li class="product-wrapper">
							<a href="/recurrent/ProductServlet?typeCode=w-005&key=w">
								<img src="images/wasyoku-005.jpg" class="img" alt="だし巻き" />
								だし巻き卵
							</a>
						</li>
						<li class="product-wrapper">
							<a href="/recurrent/ProductServlet?typeCode=w-005&key=w">
								<img src="images/wasyoku-005.jpg" class="img" alt="だし巻き" />
								だし巻き卵
							</a>
						</li>
					</ul>
				</div>
			</main>
		</div>
	</div>
	<%@ include file="../include/bootstrap_script.jsp" %>
</body>
</html>