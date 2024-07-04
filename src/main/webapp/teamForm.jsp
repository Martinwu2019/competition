<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>团队信息查看</title>
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
<form class="layui-form   layui-form-pane" action="" lay-filter="team">
    <input type="id" name="id" value="3" class="layui-hide">
    <div class="layui-form-item">
        <label class="layui-form-label">ID</label>
        <div class="layui-input-block">
            <input type="text" name="id" required lay-verify="required" placeholder="请输入ID" autocomplete="off" class="layui-input" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">团队名称</label>
        <div class="layui-input-block">
            <input type="text" name="teamName" required lay-verify="required" placeholder="请输入ID" autocomplete="off" class="layui-input" disabled>
        </div>
    </div>
<%--    <div class="layui-form-item">--%>
<%--        <label class="layui-form-label">登录名称</label>--%>
<%--        <div class="layui-input-block">--%>
<%--            <input type="text" name="loginName" required lay-verify="required" placeholder="请输入ID" autocomplete="off" class="layui-input" disabled>--%>
<%--        </div>--%>
<%--    </div>--%>
    <div class="layui-form-item">
        <label class="layui-form-label">指导老师1</label>
        <div class="layui-input-block">
            <input type="text" name="teacherName" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">指导老师2</label>
        <div class="layui-input-block">
            <input type="text" name="teacherName2" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">团队负责人</label>
        <div class="layui-input-block">
            <input type="text" name="studentName" required lay-verify="required" placeholder="请输入ID" autocomplete="off" class="layui-input" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">上传路径</label>
        <div class="layui-input-block">
            <input type="text" name="upload" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">作品名称</label>
        <div class="layui-input-block">
            <input type="text" name="worksName" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">作品大类</label>
        <div class="layui-input-block">
            <input type="text" name="category" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">作品小类</label>
        <div class="layui-input-block">
            <input type="text" name="subclass" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">作品编码</label>
        <div class="layui-input-block">
            <input type="text" name="worksCode" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">团队审核</label>
        <div class="layui-input-block">
            <input type="text" name="audit" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">创建时间</label>
        <div class="layui-input-block">
            <input type="text" name="createTime" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" disabled>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
<%--            <button class="layui-btn" lay-submit="" lay-filter="submitButton">立即提交</button>--%>
<%--            <button type="reset" class="layui-btn layui-btn-primary">重置</button>--%>
        </div>
    </div>
</form>
<script>
    var parentdata = parent.row;
    let layer, form;
layui.use(['layer','form', 'jquery','laydate'], function(){

	  $ = layui.jquery;
	  form = layui.form
	  ,layer = layui.layer
	  //监听提交
    var laydate = layui.laydate;
    //执行一个laydate实例
    laydate.render({
        elem: '.rsbirth' ,//指定元素
        type:'datetime',
        trigger: 'click'
    });
    console.log(parent.row);
     initData();
	  form.on('submit(submitButton)', function(data){
	    $.ajax({
	    	url: '${pageContext.request.contextPath}/userUpdate',
	    	method: 'get',
	    	data: data.field,
	    	dataType: 'json',
	    	success: function(data){
	    		if(data.code === "0"){
	    			parent.layer.msg("修改成功",{
	    				icon: 6,
	    				time: 500
	    			});
	    			setTimeout(function(){
	    				parent.location.reload();
	    			}, 500);
	    		}else{
	    			leyer.msg("修改失败");
	    		}
	    			
	    	    // parent.layer.msg('您将标记 [ sdf ] 成功传送给了父窗口');
	    	    
	    	}
	    })
	    return false;
	  });
	});
function initData(){
    if(null!=parent.row){//子调父
        //点击编辑按钮的时候
        let stuId = ${stuId}
        //$.extend({}, parent.row || {}) 的作用是创建一个新的对象，并将 parent.row 中的键值对复制到该新对象中，达到给表单赋值的目的
        $.ajax({
            url: '${pageContext.request.contextPath}/teamInfoServlet',
            method: 'get',
            data: {"competitionId":parent.row.id,"stuId":stuId},
            dataType: 'json',
            success: function(data){
                console.log("data   "+data.data)
                if(data.code == "0"){
                    console.log(data)
                    form.val('team',
                        $.extend({}, data.data || {})
                    );//将父页面传递的行数据赋值到名为 'user' 的表单中
                }else{
                    alert(data.msg);
                }

                // parent.layer.msg('您将标记 [ sdf ] 成功传送给了父窗口');

            }
        })

        // $('#name').attr('readonly','readonly');//readonly：设置为只读状态
    }
}
</script>
</body>
</html>