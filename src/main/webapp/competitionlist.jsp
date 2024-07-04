<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>报名参赛</title>
    <link rel="stylesheet" href="../public/layui/css/layui.css" media="all">
    <style>
        .layui-table, .layui-table-view {
            margin: 0 0px;
        }
    </style>

    <%@ include file="header.jsp" %>
</head>
<body>
<div>
>>>报名参赛
</div>
    <!-- 表单 -->
<table class="layui-hide" id="ruleTable" lay-filter="formFilter"></table>
<script src="../public/layui/layui.js" charset="UTF-8"></script>
<!-- 头部工具栏 -->
<script type="text/html" id="headBar">
</script>

<!-- 表格后面的操作 -->
<script type="text/html" id="operate">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="addteam">添加团队信息</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="team">查看团队信息</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="student">查看队员信息</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="upload">上传作品</a>
    <%-- 	 	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>--%>
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
            , url: '${pageContext.request.contextPath}/competitionServlet'
            , title: '数据表单'
            , toolbar: '#headBar'
            , page: true
            , cols: [[
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'title', title: '比赛题目', fixed: 'left'}
                , {field: 'content', title: '比赛内容', fixed: 'left'}
                , {field: 'teamRegTimeFm', title: '团队注册时间从', fixed: 'left'}
                , {field: 'teamRegTimeTo', title: '团队注册时间到', fixed: 'left'}
                , {field: 'worksTimeFm', title: '作品提交时间从', fixed: 'left'}
                , {field: 'worksTimeTo', title: '作品提交时间到', fixed: 'left'}
                , {field: 'checkTimeFm', title: '审核时间从', fixed: 'left'}
                , {field: 'checkTimeTo', title: '审核时间到', fixed: 'left'}
                , {field: 'createTime', title: '创建时间', fixed: 'left'}
                , {field: 'operate', title: '操作', width: 400, templet: '#operate'}
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
                        content: 'competitionedit.jsp?id=' + id,
                    })
                    break;
                // 添加规则
                case 'addteam':
                    layer.open({
                        type: 2,
                        title: '添加团队信息',
                        area: ['800px', '500px'],
                        maxmin: true,
                        content: 'teamadd.jsp',
                    });
                    break;
                // 添加规则
                case 'team':
                    layer.open({
                        type: 2,
                        title: '查看团队信息',
                        area: ['800px', '500px'],
                        maxmin: true,
                        content: 'teamForm.jsp',
                    });
                    break;
                // 添加规则
                case 'student':
                    layer.open({
                        type: 2,
                        title: '查看队友信息',
                        area: ['800px', '500px'],
                        maxmin: true,
                        content: 'competitionStulist.jsp?comId=' + id,
                    });
                    break;
                // 添加规则
                case 'upload':
                    layer.open({
                        type: 2,
                        title: '上传作品',
                        area: ['800px', '500px'],
                        maxmin: true,
                        content: 'competitionupload.jsp?comId=' + id,
                    });
                    break;
                case 'del':
                    layer.confirm("确认要删除么，非必要请勿删除", function () {
                        $.ajax({
                            url: '${pageContext.request.contextPath}/userDelete',
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