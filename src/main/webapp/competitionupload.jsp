<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传作品</title>
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
 <form class="layui-form   layui-form-pane" action="/competitionuplooadServlet" method="post" enctype="multipart/form-data">
     <input type="id" name="id" value="3" class="layui-hide">
     <div class="layui-form-item">
         <label class="layui-form-label">作品名称</label>
         <div class="layui-input-block">
             <input type="text" name="worksName" required lay-verify="required" placeholder="请输入作品名称" autocomplete="off" class="layui-input" >
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">作品大类</label>
         <div class="layui-input-block">
             <input type="text" name="category" required lay-verify="required" placeholder="请输入作品大类" autocomplete="off" class="layui-input" >
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">作品小类</label>
         <div class="layui-input-block">
             <input type="text" name="subclass" required lay-verify="required" placeholder="请输入作品小类" autocomplete="off" class="layui-input" >
         </div>
     </div>
     <div class="layui-form-item">
         <label class="layui-form-label">文件路径</label>
         <div class="layui-input-block">
             <input type="file" name="filePath" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" >
         </div>
     </div>
     <div class="layui-form-item layui-hide">
         <label class="layui-form-label">comId</label>
         <div class="layui-input-block">
             <input type="text" name="comId" required lay-verify="required" placeholder="请输入作品小类" autocomplete="off" class="layui-input" value="<%=request.getParameter("comId")%>" >
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
	  <%--form.on('submit(submitButton)', function(data){--%>
	  <%--    let comId = <%=request.getParameter("comId")%>--%>
	  <%--  $.ajax({--%>
	  <%--  	url: '${pageContext.request.contextPath}/competitionuplooadServlet',--%>
	  <%--  	method: 'GET',--%>
	  <%--  	data: {...data.field, "comId": comId},--%>
	  <%--  	dataType: 'json',--%>
	  <%--  	success: function(data){--%>
	  <%--  		if(data.code == "0"){--%>
	  <%--  			parent.layer.msg("添加成功",{--%>
	  <%--  				icon: 6,--%>
	  <%--  				time: 500--%>
	  <%--  			});--%>
	  <%--  			setTimeout(function(){--%>
	  <%--  				parent.location.reload();--%>
	  <%--  			}, 500);--%>
	  <%--  		}else{--%>
	  <%--  			alert(data.msg);--%>
	  <%--  		}--%>
	  <%--  			--%>
	  <%--  	    //parent.layer.msg('您将标记 [ sdf ] 成功传送给了父窗口');--%>
	  <%--  	    --%>
	  <%--  	}--%>
	  <%--  })--%>
	  <%--  --%>
	  <%--  --%>
	  <%--  return false;--%>
	  <%--});--%>
	});

</script>
</body>
</html>