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

	<%@ include file="header.jsp" %>
</head>

<body>
	<% request.removeAttribute("student");%>
	<div class="container" style="margin-top:30px">
		<div class="row">
			<div class="col-sm-4">
				<!-- Sidebar-->
				<div class="border-end bg-white" id="sidebar-wrapper">
					<div class="border-bottom bg-light">
						<div id="myTime" class="py-3"> </div>
					</div>
					<h2 class="py-3">关于我们</h2>
					<img src="img/about-image.jpg" class="img-fluid" alt="about">
					<p style="text-indent: 40px ;" align="justify" class="pt-3">
						为贯彻实施教育部关于创新高校人才培养机制的有关要求，培养上海市大学生的创新精神和创新实践能力，调动大学生学习计算机技术的积极性，提高大学生运用信息技术解决实际问题的综合水平，鼓励计算机学科类学生参加学科竞赛，我们定期举办与计算机相关的比赛，<span
							class="text-danger">欢迎大家踊跃报名参加。</span></p>

				</div>
			</div>
			<div class="col-sm-8">
				<form class="form-horizontal center" action="loginServlet" method="post">
					<div class="form-group">
						<!--样式control-label使内容居右-->
						<label for="userName" class="col-sm-3 control-label">帐号：</label>
						<div class="col-sm-9 has-feedback">
							<input type="text" class="form-control" id="userName" name="userName" placeholder="请输入帐号" />
							<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-3 control-label">密码：</label>
						<div class="col-sm-9 has-feedback">
							<input type="password" class="form-control" id="password" name="password" placeholder="请输入密码" />
							<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9 col-sm-offset-3">
							<!--样式checkbox为input[type='checkbox']指定合适的样式，相应的还有input[type='radio']的样式radio-->
							<div class="checkbox">
								<label>
									<input type="checkbox" /> 记住密码
								</label>
							</div>
						</div>
					</div>
					<span style="color: red;font-size: 15px" id="tip">${tip}</span>
					<div class="form-group">
						<div class="col-sm-9 col-sm-offset-3">
							<button type="submit" class="btn btn-primary btn-md px-4">登录</button>
							&nbsp;
							<button type="button" class="btn btn-success btn-md px-4"><a href="register.jsp" class="signup">注册</a></button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


</body>


<%@ include file="tail.jsp" %>
</html>