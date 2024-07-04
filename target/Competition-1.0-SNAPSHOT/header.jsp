<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>登录</title>
    <!-- Favicon-->
    <!-- <link rel="icon" type="image/x-icon" href="assets/favicon.ico" /> -->
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/bootstrap.css" rel="stylesheet"/>
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
<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
            aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="homepage.jsp" onclick="highlightLink(this)">首页</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="dasaijianjie.jsp" onclick="highlightLink(this)">大赛简介</a>
            </li>
            <%--				<li class="nav-item">--%>
            <%--					<a class="nav-link" href="#" onclick="highlightLink(this)">参赛通知</a>--%>
            <%--				</li>--%>
            <li class="nav-item">
                <a class="nav-link" href="competitionlist.jsp" onclick="highlightLink(this)">报名参赛</a>
            </li>
        </ul>
        <script>
            function highlightLink(link) {
                var links = document.getElementsByClassName("nav-link");
                for (var i = 0; i < links.length; i++) {
                    links[i].classList.remove("active");
                }
                link.classList.add("active");
            }
        </script>
        <div class="form-inline my-2 my-lg-0">
            <i class="fa fa-light fa-clock"></i>
            <div id="current_time"></div>
            <ul class="navbar-nav mr-auto  mt-lg-0>
					<li class=" nav-item
            ">
            <a class="nav-link">欢迎来到计算机学科竞赛及报名系统！</a>
            </li>
            </ul>
            <c:if test="${student!= null}">
                <div class="dropdown">
                    <ul class="layui-nav">
                        <li class="layui-nav-item">
                                <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                                    ${student.userName}
                        </li>
                        <li class="layui-nav-item"><a href="/studentOutServlet">退出</a></li>
                    </ul>
                </div>
            </c:if>
            <c:if test="${student== null}">
                <div class="dropdown">
                    <button class="btn btn-info dropdown-toggle" type="button" id="dropdownMenuButton"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        登录 / 注册
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item " href="login.jsp">登录</a>
                        <div role="separator" class="dropdown-divider"></div>
                        <a class="dropdown-item" href="register.jsp">注册</a>
                    </div>
                </div>
            </c:if>

        </div>
    </div>
</nav>

</body>

</html>