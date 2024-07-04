<%@page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>登录</title>
	<!-- Favicon-->
	<!-- <link rel="icon" type="image/x-icon" href="assets/favicon.ico" /> -->
	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="css/bootstrap.min.css" rel="stylesheet" />
	<link href="css/bootstrap.css" rel="stylesheet" />
	<!--         <link href="css/styles.css" rel="stylesheet" /> 
--><!--	<link href="https://cdn.bootcdn.net/ajax/libs/font-awesome/6.4.2/css/all.css" rel="stylesheet">
-->
	<!-- Bootstrap core JS-->
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/popper.min.js"></script>

	<script src="js/bootstrap.min.js"></script>

	<style>
		.fakeimg {
			height: 200px;
			background: #aaa;
		}

		.navbar-nav .active {
			background-color: deepskyblue;
		}
	</style>
	<script type="text/javascript">
		function showTime() {
			var time = new Date(); /*获取当前时间 年月日时分秒*/
			var y = time.getFullYear();
			var mon = time.getMonth() + 1; //0-11 
			var d = time.getDate();
			var h = time.getHours();
			var m = time.getMinutes();
			var s = time.getSeconds();
			var day = time.getDay();
			/*向div中插入内容   年月日时分秒  val()只能用在表单中*/
			$("#myTime").html(y + "年" + mon + "月" + d + "日 " + h + ":" + m + ":" + s + ", 星期" + "日一二三四五六".charAt(new Date().getDay()));
		}
		//页面加载事件 
		$(function () {
			//定时器 
			var clock = window.setInterval("showTime()", 1000);
		});
	</script>
</head>

<body>
	<div class="jumbotron text-center py-4" style="margin-bottom:0">
		<h1>计算机学科竞赛及报名系统</h1>
		<p>计算机科学与技术学院</p>
	</div>

</body>

</html>