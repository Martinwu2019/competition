<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>教师列表</title>
    <link rel="stylesheet" href="../public/layui/css/layui.css" media="all">
    <style>
        .layui-table, .layui-table-view {
            margin: 0 0px;
        }
    </style>

    <%@ include file="adminheader.jsp" %>
</head>
<body>
<!-- 表单 -->
<table class="layui-hide" id="ruleTable" lay-filter="formFilter"></table>
<script src="../public/layui/layui.js" charset="UTF-8"></script>
<!-- 头部工具栏 -->
<script type="text/html" id="headBar">
<%--<button type="button" class="layui-btn  layui-btn-sm" lay-event="add"><i class="layui-icon">新增教师</i></button>--%>
<%--<button type="button" class="layui-btn  layui-btn-sm" lay-event="send"><i class="layui-icon">分配审核团队</i></button>--%>
</script>

<!-- 表格后面的操作 -->
<script type="text/html" id="operate">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="edit">审核</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" href="${pageContext.request.contextPath}/downloadServlet?filePath={{d.upload}}">下载</a>
<%--     	 	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>--%>
</script>
<script type="text/html" id="time">
    {{layui.util.toDateString(d.usertime, 'yyyy-MM-dd HH:mm:ss')}}
</script>
<script>
    var row;
    layui.use(['table', 'jquery'], function () {
        $ = layui.jquery;
        var table = layui.table;
        table.render({
            id: 'formFilter'
            , elem: '#ruleTable'
            , height: 'full-10'
            , url: '${pageContext.request.contextPath}/teamCheckServlet'
            , title: '数据表单'
            , toolbar: '#headBar'
            , page: true
            , cols: [[
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'teamName', title: '团队名称', fixed: 'left'}
                , {field: 'loginName', title: '团队登录名', fixed: 'left'}
                , {field: 'teacherName', title: '指导老师1', fixed: 'left'}
                , {field: 'teacherName2', title: '指导老师2', fixed: 'left'}
                , {field: 'studentName', title: '团队负责人', fixed: 'left'}
                , {field: 'upload', title: '上传路径', fixed: 'left'}
                , {field: 'audit', title: '审核状态', fixed: 'left'}
                , {field: 'worksName', title: '作品名称', fixed: 'left'}
                , {field: 'category', title: '作品大类', fixed: 'left'}
                , {field: 'subclass', title: '作品小类', fixed: 'left'}
                , {field: 'worksCode', title: '作品编码', fixed: 'left'}
                , {field: 'createTime', title: '创建时间', fixed: 'left'}
                , {field: 'operate', title: '操作', width: 150, templet: '#operate'}
            ]], limits: [3, 5, 10, 20]
            , limit: 10
            , parseData: function (res) {
                var result;
                console.log(this);
                console.log(JSON.stringify(res));
                if (this.page.curr) {
                    result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                } else {
                    result = res.data.slice(0, this.limit);
                }
                return {"code": res.code, "msg": res.msg, "count": res.count, "data": result};
            }
        });
        console.log("刷新")
        // 头部工具栏事件
        table.on('toolbar(formFilter)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
// 添加规则
                case 'add':
                    var addCardLayer = layer.open({
                        type: 2,
                        title: '新增教师',
                        area: ['800px', '500px'],
                        maxmin: true,
                        content: 'teacheradd.jsp'
                    });
                    break;
                // 添加规则
                case 'send':
                    layer.confirm("确认后将会给所有教师分配团队审核", function () {
                        $.ajax({
                            url: '${pageContext.request.contextPath}/teamCheckServlet',
                            data: "id=" + id,
                            type: 'get',
                            dataType: 'json',
                            timout: 3000,
                            success: function (data) {
                                if (data.code == "0") {
                                    layer.msg(data.msg, {
                                        icon: 6,
                                        anim: 5,
                                        time: 500
                                    })
                                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                                } else {
                                    layer.msg(data.msg, {
                                        icon: 5,
                                        anim: 6
                                    })
                                }
                            },
                            error: function () {
                                layer.msg("连接超时");
                            }
                        })
                    })
                    break;
            }
            ;
        });

        // 侧边工具栏事件
        table.on(('tool(formFilter)'), function (obj) {
            row = obj.data;
            var layEvent = obj.event;
            var tr = obj.tr;
            var id = row.id;
            switch (obj.event) {
                case 'edit':
                    layer.open({
                        type: 2,
                        title: '更改信息',
                        area: ['800px', '600px'],
                        maxmin: true,
                        shadeClose: true,
                        content: 'teamAudit.jsp?id=' + id,
                    })
                    break;
                case 'del':
                    layer.confirm("确认要删除么，非必要请勿删除", function () {
                        $.ajax({
                            url: '${pageContext.request.contextPath}/teacherDelServlet',
                            data: "id=" + id,
                            type: 'get',
                            dataType: 'json',
                            timout: 3000,
                            success: function (data) {
                                if (data.code == "0") {
                                    layer.msg(data.msg, {
                                        icon: 6,
                                        anim: 5,
                                        time: 500
                                    })
                                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                                } else {
                                    layer.msg(data.msg, {
                                        icon: 5,
                                        anim: 6
                                    })
                                }
                            },
                            error: function () {
                                layer.msg("连接超时");
                            }
                        })
                    })
            }
        })
    });
</script>
</body>
<%@ include file="tail.jsp" %>
</html>