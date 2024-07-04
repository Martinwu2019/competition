<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="robots" content="all,follow">
  <!-- Bootstrap CSS-->
  <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome CSS-->
  <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
  <!-- Fontastic Custom icon font-->
  <link rel="stylesheet" href="css/fontastic.css">
  <!-- Google fonts - Poppins -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
  <!-- theme stylesheet-->
  <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
  <!-- Custom stylesheet - for your changes-->
  <link rel="stylesheet" href="css/custom.css">
  <!-- Favicon-->
  <link rel="shortcut icon" href="img/favicon.ico">
  <!-- Tweaks for older IEs--><!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/popper.js/umd/popper.min.js"> </script>
  <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
  <script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
  <script src="vendor/chart.js/Chart.min.js"></script>
  <script src="vendor/jquery-validation/jquery.validate.min.js"></script>
  <title>比赛审核管理系统-登录</title>
</head>
<body>
<div class="page login-page">
  <div class="container d-flex align-items-center">
    <div class="form-holder has-shadow">
      <div class="row">
        <!-- Logo & Information Panel-->
        <div class="col-lg-6">
          <div class="info d-flex align-items-center">
            <div class="content">
              <div class="logo">
                <h1>比赛审核管理系统-登录界面</h1>
              </div>
              <p>Please login first.</p>
            </div>
          </div>
        </div>
        <!-- Form Panel    -->
        <div class="col-lg-6 bg-white">
          <div class="form d-flex align-items-center">
            <div class="content">

              <form action="/adminLoginServlet"  method="get" class="form-validate" >
                <div class="form-group">
                  <input id="userAccount" type="text" name="userAccount" required data-msg="请输入你的用户名" class="input-material">
                  <label for="userAccount" class="label-material">用户名</label>
                </div>
                <div class="form-group">
                  <input id="userPassword" type="password" name="userPassword" required data-msg="请输入你的密码" class="input-material">
                  <label for="userPassword" class="label-material">密 码</label>
                </div>
                <div class="form-group terms-conditions">
                  <input id="radio-student" name="radio" type="radio" value="teacher" class="radio-template">&nbsp;<label for="radio-student">教师</label>
                  &nbsp;&nbsp;
                  <input id="radio-admin" name="radio" type="radio" value="admin" class="radio-template">&nbsp;<label for="radio-admin">管理员</label>
                  <span style="color: red;font-size: 15px" id="tip">${tip}</span>
                </div>
                <input id="login" type="submit" class="btn btn-primary" value="登录">

                <!-- This should be submit button but I replaced it with <a> for demo purposes-->
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="copyrights text-center">
    <p>Design by <a href="#" class="external">哗啦哗啦you</a>
      <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
    </p>
  </div>
</div>
<!-- JavaScript files-->
<script>
  $(document).ready(function(e) {
    changeCode();
    $("#codeImg1").bind("click",changeCode);
  });
  function genTimestamp(){
    var time = new Date();
    return time.getTime();
  }
  function changeCode(){
    $("img[name='codeImg']").attr("src","${pageContext.request.contextPath}/validCode?t="+genTimestamp());
  }
</script>
<!-- Main File-->
<script src="js/front.js"></script>
</body>
</html>