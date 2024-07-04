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
         <label class="layui-form-label">团队名称</label>
         <div class="layui-input-block">
             <input type="text" name="teamName" required lay-verify="required" placeholder="请输入团队名称" autocomplete="off" class="layui-input" >
         </div>
     </div>
<%--     <div class="layui-form-item">--%>
<%--         <label class="layui-form-label">登录名称</label>--%>
<%--         <div class="layui-input-block">--%>
<%--             <input type="text" name="loginName" required lay-verify="required" placeholder="请输入登录名称" autocomplete="off" class="layui-input" >--%>
<%--         </div>--%>
<%--     </div>--%>
<%--     <div class="layui-form-item">--%>
<%--         <label class="layui-form-label">登录密码</label>--%>
<%--         <div class="layui-input-block">--%>
<%--             <input type="text" name="password" required lay-verify="required" placeholder="请输入登录密码" autocomplete="off" class="layui-input" >--%>
<%--         </div>--%>
<%--     </div>--%>
     <div class="layui-form-item">
         <label class="layui-form-label">指导老师1</label>
         <div class="layui-input-block">
             <input type="text" name="teacherName" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" >
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">指导老师2</label>
         <div class="layui-input-block">
             <input type="text" name="teacherName2" placeholder="" autocomplete="off" class="layui-input" >
         </div>
     </div>
     <div class="layui-form-item layui-hide">
         <label class="layui-form-label">stuId</label>
         <div class="layui-input-block">
             <input type="text" name="studentId" placeholder="" autocomplete="off" class="layui-input" value="${stuId}" >
         </div>
     </div>
     <div class="layui-form-item layui-hide">
         <label class="layui-form-label">stuName</label>
         <div class="layui-input-block">
             <input type="text" name="studentName" placeholder="" autocomplete="off" class="layui-input" value="${student.realName}" >
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
	    	url: '${pageContext.request.contextPath}/teamAddServlet',
	    	method: 'GET',
	    	data: {...data.field, "competitionId": parent.row.id},
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