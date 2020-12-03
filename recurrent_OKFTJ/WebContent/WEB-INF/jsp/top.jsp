<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="ja">

<head>


<title>>リ・カレント亭</title>
<link rel="stylesheet" href="css/style.css">
	<link href="https://fonts.googleapis.com/earlyaccess/hannari.css" rel="stylesheet">

</head>
<body style=" background-color: #ffffff;" >
<h6>リ・カレント亭</h6>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>


    <div class="row">
<jsp:include page="/WEB-INF/jsp/menuTab.jsp" />

 <jsp:include page="/WEB-INF/jsp/menuButton.jsp" />
  <div class="col-sm-10 main">
	<div class="tab-content" class="menuimg">
			<div id="photo1" class="tab-pane active">


				<a href="/recurrent/ProductServlet">
				<img src="images/setmenu/setmenu1.jpg" class="img-thumbnail" alt="かつ丼セット" /></a>

				<a href="/recurrent/ProductServlet">
				<img src="images/setmenu/setmenu2.jpg" class="img-thumbnail" alt="カレーセット" /></a>


				<img src="images/setmenu/setmenu3.jpg" class="img-thumbnail" alt="コロッケセット" />


				<img src="images/setmenu/setmenu4.jpg" class="img-thumbnail" alt="" />

				<img src="images/setmenu/setmenu5.jpg" class="img-thumbnail" alt="" />

				<img src="images/setmenu/setmenu6.jpg" class="img-thumbnail" alt="" />

				<img src="images/setmenu/setmenu7.jpg" class="img-thumbnail" alt="" />

				<img src="images/setmenu/setmenu8.jpg" class="img-thumbnail" alt="" />

			</div>
			<div id="photo2" class="tab-pane">

				<img src="images/wasyoku/meniu1.jpg" class="img-thumbnail" alt="" />
				<img src="images/wasyoku/menu10.jpg" class="img-thumbnail" alt="" />
				<img src="images/wasyoku/menu5.jpg" class="img-thumbnail" alt="" />
				<img src="images/wasyoku/menu6.jpg" class="img-thumbnail" alt="" />
				<img src="images/wasyoku/menu7.jpg" class="img-thumbnail" alt="" />

			</div>
			<div id="photo3" class="tab-pane">

				<img src="images/yousyoku/menu2.jpg" class="img-thumbnail" alt="" />
				<img src="images/yousyoku/menu3.jpg" class="img-thumbnail" alt="" />
				<img src="images/yousyoku/menu4.jpg" class="img-thumbnail" alt="" />
				<img src="images/yousyoku/menu8jpg.jpg" class="img-thumbnail" alt="" />
				<img src="images/yousyoku/menu9.jpg" class="img-thumbnail" alt="" />

			</div>
			<div id="photo4" class="tab-pane">
				<img src="images/drink/drink9.jpg" class="img-thumbnail" alt="" />
				<img src="images/drink/drink1.jpg" class="img-thumbnail" alt="" />
				<img src="images/drink/drink2.jpg" class="img-thumbnail" alt="" />
				<img src="images/drink/drink3.jpg" class="img-thumbnail" alt="" />
				<img src="images/drink/drink4.jpg" class="img-thumbnail" alt="" />
				<img src="images/drink/drink5.jpg" class="iimg-thumbnail" alt="" />
				<img src="images/drink/drink6.jpg" class="img-thumbnail" alt="" />
				<img src="images/drink/drink7.jpg" class="img-thumbnail" alt="" />
				<img src="images/drink/drink8.jpg" class="img-thumbnail" alt="" />

			</div>
			<div id="photo5" class="tab-pane">

				<img src="images/sweets/sweet1.jpg" class="img-thumbnail" alt="" />
				<img src="images/sweets/sweet2.jpg" class="img-thumbnail" alt="" />
				<img src="images/sweets/sweet3.jpg" class="img-thumbnail" alt="" />
				<img src="images/sweets/sweet4.jpg" class="iimg-thumbnail" alt="" />

			</div>
			<div id="photo6" class="tab-pane">

				<img src="images/topping/topping1.jpg" class="img-thumbnail" alt="" />
				<img src="images/topping/topping2.jpg" class="iimg-thumbnail" alt="" />

			</div>
		</div>



 </div>
    </div>
</div>

</body>
</html>