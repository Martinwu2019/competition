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

    <%@ include file="adminheader.jsp" %>
</head>
<body>
<!-- 表单 -->
<table class="layui-hide" id="ruleTable" lay-filter="formFilter"></table>
<script src="../public/layui/layui.js" charset="UTF-8"></script>
<!-- 头部工具栏 -->
<script type="text/html" id="headBar">
<button type="button" class="layui-btn  layui-btn-sm" lay-event="add"><i class="layui-icon">添加公告</i></button>
</script>

<!-- 表格后面的操作 -->
<script type="text/html" id="operate">
<%--    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="edit">编辑</a>--%>
     	 	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
<a class="layui-btn layui-btn-danger layui-btn-xs" href="${pageContext.request.contextPath}/downloadServlet?filePath={{d.img}}">下载</a>
</script>
<script type="text/html" id="tplImg">
    {{# if(d.img) { }}
    <img src="{{ d.img }}" alt="图片">
    {{# } else { }}
    无图片
    {{# } }}
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
            , url: '${pageContext.request.contextPath}/noticeServlet'
            , title: '数据表单'
            , toolbar: '#headBar'
            , page: true
            , cols: [[
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'title', title: '公告标题', fixed: 'left'}
                , {field: 'content', title: '公告内容', fixed: 'left'}
                , {field: 'img', title: '图片', fixed: 'left',templet: '#tplImg'}
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
// 添加规则
                case 'add':
                    var addCardLayer = layer.open({
                        type: 2,
                        title: '新增公告',
                        area: ['800px', '500px'],
                        maxmin: true,
                        content: 'noticeadd.jsp'
                    });
                    break;
                // 添加规则
                case 'getStu':
                    var addCardLayer = layer.open({
                        type: 2,
                        title: '根据身份证添加队员',
                        area: ['800px', '500px'],
                        maxmin: true,
                        content: 'studentaddbyidentity.jsp?comId=' + <%=request.getParameter("comId") %>,
                    });
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
                        content: 'competitionedit.jsp?id=' + id,
                    })
                    break;
                    <%--case 'download':--%>
                    <%--    $.ajax({--%>
                    <%--        url: '${pageContext.request.contextPath}/downloadServlet',--%>
                    <%--        data: "filePath=" + row.img,--%>
                    <%--        type: 'get',--%>
                    <%--        dataType: 'json',--%>
                    <%--        timout: 3000,--%>
                    <%--        success: function (data) {--%>
                    <%--            if (data.code == "0") {--%>
                    <%--                layer.msg(data.msg, {--%>
                    <%--                    icon: 6,--%>
                    <%--                    anim: 5,--%>
                    <%--                    time: 500--%>
                    <%--                })--%>
                    <%--            } else {--%>
                    <%--                layer.msg(data.msg, {--%>
                    <%--                    icon: 5,--%>
                    <%--                    anim: 6--%>
                    <%--                })--%>
                    <%--            }--%>
                    <%--        },--%>
                    <%--        error: function () {--%>
                    <%--            layer.msg("连接超时");--%>
                    <%--        }--%>
                    <%--    })--%>
                    <%--    break;--%>
                case 'del':
                    layer.confirm("确认要删除么，非必要请勿删除", function () {
                        $.ajax({
                            url: '${pageContext.request.contextPath}/noticeDelServlet',
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