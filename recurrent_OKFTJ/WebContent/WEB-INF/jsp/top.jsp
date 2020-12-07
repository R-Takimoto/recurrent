<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="ja">

<head>
	<meta charset="UTF-8">
	<title>>リ・カレント亭</title>
	<jsp:include page="/WEB-INF/jsp/boot.jsp" />
	<link rel="stylesheet" href="css/style.css">
	<link href="https://fonts.googleapis.com/earlyaccess/hannari.css" rel="stylesheet">
</head>
<body style="background-color: #ffffff;">
	<h6>リ・カレント亭</h6>
	<div class="row">
		<jsp:include page="/WEB-INF/jsp/menuTab.jsp" />
		<jsp:include page="/WEB-INF/jsp/menuButton.jsp" />
		<div class="col-sm-10 main">
			<div class="tab-content" class="menuimg">
				<div id="photo1" class="tab-pane active">
					<a href="/recurrent/ProductServlet">
						<img src="images/setmenu/setmenu1.jpg" class="img-thumbnail" alt="かつ丼セット" />かつ丼セット
					</a>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/include/bootstrapScript.jsp" />
</body>

</html>