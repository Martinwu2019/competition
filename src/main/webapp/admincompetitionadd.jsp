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
         <label class="layui-form-label">比赛标题</label>
         <div class="layui-input-block">
             <input type="text" name="title" required lay-verify="required" placeholder="请输入比赛标题" autocomplete="off" class="layui-input" >
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">比赛内容</label>
         <div class="layui-input-block">
             <input type="text" name="content" required lay-verify="required" placeholder="请输入比赛内容" autocomplete="off" class="layui-input" >
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">团队注册时间从</label>
         <div class="layui-input-block">
             <input type="date" name="teamRegTimeFm" required lay-verify="required" placeholder="请输入团队注册时间从" autocomplete="off" class="layui-input" >
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">团队注册时间到</label>
         <div class="layui-input-block">
             <input type="date" name="teamRegTimeTo" required lay-verify="required" placeholder="请输入团队注册时间到" autocomplete="off" class="layui-input" >
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">作品上传时间从</label>
         <div class="layui-input-block">
             <input type="date" name="worksTimeFm" required lay-verify="required" placeholder="请输入图片" autocomplete="off" class="layui-input" >
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">作品上传时间到</label>
         <div class="layui-input-block">
             <input type="date" name="worksTimeTo" required lay-verify="required" placeholder="请输入图片" autocomplete="off" class="layui-input" >
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">审核时间从</label>
         <div class="layui-input-block">
             <input type="date" name="checkTimeFm" required lay-verify="required" placeholder="请输入图片" autocomplete="off" class="layui-input" >
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">审核时间到</label>
         <div class="layui-input-block">
             <input type="date" name="checkTimeTo" required lay-verify="required" placeholder="请输入图片" autocomplete="off" class="layui-input" >
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
	    	url: '${pageContext.request.contextPath}/competitionAddServlet',
	    	method: 'GET',
	    	data: {...data.field},
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
	    			alert(data.msg);
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