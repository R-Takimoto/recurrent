<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー管理画面</title>
</head>
<body>
	<!-- トップ画面移動ボタン -->
	<form action="/recurrent/LoginServlet?action=toppage" method="post">
		<input type="submit" value="トップへ戻る"/>
	</form>

	<p>メニュー管理画面</p>
	<p>修正・削除するメニューの品名を選択してください</p>
	<table border="1">
		<tr>
			<td>種類</td>
			<td>商品コード</td>
			<td>品名</td>
			<td>金額</td>
			<td>カロリー</td>
			<td>品種</td>
		</tr>
		<tr>
			<td>●●</td>
			<td>●●●●</td>
			<td><a href=>品名</a></td>
			<td>●●●●</td>
			<td>●●●●</td>
			<td>●●●●</td>
		</tr>
	</table>
	<a href="/recurrent/MenuRegistrationServlet">新規登録</a>

	<!-- ログアウトボタン -->
	<a href="/recurrent/ConfirmLoginServlet">ログアウト</a>
</body>
</html>