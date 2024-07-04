<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>比赛审核管理系统</title>
	<!-- layui -->
	<link rel="stylesheet" href="../public/layui/css/layui.css">
	<script src="../public/layui/layui.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">比赛审核管理系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">首页</a></li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          ${username}
        </a>
        <dl class="layui-nav-child">
          <dd id="updatePassword"><a href="javascript:;">修改密码</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="../adminlogin.jsp">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item">
          <a href="javascript:;" arget="content" class="layui-icon layui-icon-user" style="font-size: 16px; color: #1E9FFF"> 比赛信息管理</a>
          <dl class="layui-nav-child layui-nav-itemed">
            <dd><a href="noticelist.jsp" target="content">新闻公告</a></dd>
              <dd><a href="admincompetitionlist.jsp" target="content">比赛记录</a></dd>
            <dd><a href="teacherlist.jsp" target="content">教师信息</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <iframe src="data.jsp" name="content" height="100%" width="100%" frameborder="0" scrolling="no"></iframe>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    ©  比赛审核管理系统
  </div>
</div>

<script>
//JavaScript代码区域
layui.use(['element', 'jquery', 'layer'], function(){
  $ = layui.jquery;
  var element = layui.element
  $ = layui.jquery;
  var form = layui.form
  ,layer = layui.layer;

  $("#updatePassword").click(function(){
	  layer.open({
	    title: '修改密码',
	    type: 2,
	    area: ['300px', '300px'],
	    maxmin: true,
  	  	shadeClose: true,
  	  	content: 'updatePassword.jsp'
	  })
  })
});
</script>
</body>
</html>