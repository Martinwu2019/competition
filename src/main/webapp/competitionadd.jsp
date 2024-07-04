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
 <form class="layui-form   layui-form-pane" action="">
     <input type="id" name="id" value="3" class="layui-hide">
     <div class="layui-form-item">
         <label class="layui-form-label">ID</label>
         <div class="layui-input-block">
             <input type="text" name="id" required lay-verify="required" placeholder="请输入ID" autocomplete="off" class="layui-input">
         </div>
     </div>
     <!-- 作者 -->
     <div class="layui-form-item">
         <label class="layui-form-label">用户名</label>
         <div class="layui-input-block">
             <input type="text" name="username" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
         </div>
     </div>

     <div class="layui-form-item">
         <label class="layui-form-label">用户密码</label>
         <div class="layui-input-block">
             <input type="text" name="password" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">年龄</label>
         <div class="layui-input-block">
             <input type="text" name="age" required  lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input">
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">电话号码</label>
         <div class="layui-input-block">
             <input type="text" name="telephone" required  lay-verify="required" placeholder="请输入电话号码" autocomplete="off" class="layui-input">
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">邮箱</label>
         <div class="layui-input-block">
             <input type="text" name="email" required  lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">地址</label>
         <div class="layui-input-block">
             <input type="text" name="address" required  lay-verify="required" placeholder="请输入地址" autocomplete="off" class="layui-input ">
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">性别</label>
         <div class="layui-input-block">
             <input type="text" name="sex" required  lay-verify="required" placeholder="请输入性别" autocomplete="off" class="layui-input">
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">状态</label>
         <div class="layui-input-block">
             <input type="text" name="state" required  lay-verify="required" placeholder="请输入状态" autocomplete="off" class="layui-input">
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">图片地址</label>
         <div class="layui-input-block">
             <input type="text" name="pic" required  lay-verify="required" placeholder="请输入图片地址" autocomplete="off" class="layui-input">
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
	  form.on('submit(submitButton)', function(data){
	    $.ajax({
	    	url: '${pageContext.request.contextPath}/userAdd',
	    	method: 'GET',
	    	data: data.field,
	    	dataType: 'json',
	    	success: function(data){
	    		if(data.code == "0"){
	    			parent.layer.msg("添加成功",{
	    				icon: 6,
	    				time: 500
	    			});
	    			setTimeout(function(){
	    				parent.location.reload();
	    			}, 500);
	    		}else{
	    			alert(data.msg)
	    		}
	    			
	    	    //parent.layer.msg('您将标记 [ sdf ] 成功传送给了父窗口');
	    	    
	    	}
	    })
	    
	    
	    return false;
	  });
	});

</script>
</body>
</html>