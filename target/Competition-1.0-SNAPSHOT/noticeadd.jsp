<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生用户添加</title>
<!-- layui -->
<link rel="stylesheet" href="../public/layui/css/layui.css">
<script src="../public/layui/layui.js"></script>
<style>
  .layui-form{
    margin: 10px 20px;
      
 }
 .layui-form-pane .layui-form-label{
 	width: 120px;
 }
 .layui-form-pane .layui-input-block{
 	margin-left: 120px;
 }
</style>
</head>
<body>
 <form class="layui-form   layui-form-pane" action="/noticeAddServlet" method="post" enctype="multipart/form-data">
     <input type="id" name="id" value="3" class="layui-hide">
     <div class="layui-form-item">
         <label class="layui-form-label">公告标题</label>
         <div class="layui-input-block">
             <input type="text" name="title" required lay-verify="required" placeholder="请输入公告标题" autocomplete="off" class="layui-input" >
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">公告内容</label>
         <div class="layui-input-block">
             <input type="text" name="content" required lay-verify="required" placeholder="请输入公告内容" autocomplete="off" class="layui-input" >
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">图片</label>
         <div class="layui-input-block">
             <input type="file" name="img" required lay-verify="required" placeholder="请输入图片" autocomplete="off" class="layui-input" >
         </div>
     </div>
     <div class="layui-form-item">
         <div class="layui-input-block">
             <button class="layui-btn" lay-submit="" lay-filter="submitButton">立即提交</button>
             <button type="reset" class="layui-btn layui-btn-primary">重置</button>
         </div>
     </div>
</form>
<script>


layui.use(['form', 'jquery','laydate'], function(){
	  $ = layui.jquery;
	  var form = layui.form
	  ,layer = layui.layer
    var laydate = layui.laydate;
    //执行一个laydate实例
    laydate.render({
        elem: '.rsbirth' ,//指定元素
        type:'datetime',
        trigger: 'click'
    });
	  //监听提交
	});

</script>
</body>
</html>