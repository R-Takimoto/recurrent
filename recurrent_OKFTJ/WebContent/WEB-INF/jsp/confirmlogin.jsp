<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/earlyaccess/hannari.css"
	rel="stylesheet">

</head>
<body style="background-color: #c7eff0;">
	<div class="center">
		<h2><form action="/recurrent/LoginServlet" method="post">
			管理者ID: <input type="text" name="id"></h2><br>
			<p></p>

			<h2>パスワード: <input type="text" name="pass"></h2><br> <br>
			<br>
			<br>
			<!-- <a href="/recurrent/LoginServlet">ログイン</a> -->

			<input type="submit" value="ログイン" class="redbutton">
	</div>
	</form>
</body>
</html>