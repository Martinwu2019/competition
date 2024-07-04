<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>主页ҳ</title>
    <!-- Favicon-->
    <!-- <link rel="icon" type="image/x-icon" href="assets/favicon.ico" /> -->
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/bootstrap.css" rel="stylesheet"/>
    <link rel="stylesheet" href="../public/layui/css/layui.css" media="all">
    <style>
        .layui-table, .layui-table-view {
            margin: 0 0px;
        }
    </style>
    <!--         <link href="css/styles.css" rel="stylesheet" />
--><!--	<link href="https://cdn.bootcdn.net/ajax/libs/font-awesome/6.4.2/css/all.css" rel="stylesheet">
-->
    <!-- Bootstrap core JS-->
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/popper.min.js"></script>

    <script src="js/bootstrap.min.js"></script>

    <%@ include file="header.jsp" %>
</head>

<body>
>>>首页

<div class="container" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-4">
            <!-- Sidebar-->
            <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="border-bottom bg-light">
                    <div id="myTime" class="py-3"></div>
                </div>
                <h2 class="py-3">关于我们</h2>
                <img src="img/about-image.jpg" class="img-fluid" alt="about">
                <p style="text-indent: 40px ;" align="justify" class="pt-3">
                    为贯彻实施教育部关于创新高校人才培养机制的有关要求，培养上海市大学生的创新精神和创新实践能力，调动大学生学习计算机技术的积极性，提高大学生运用信息技术解决实际问题的综合水平，鼓励计算机学科类学生参加学科竞赛，我们定期举办与计算机相关的比赛，<span
                        class="text-danger">欢迎大家踊跃报名参加。</span></p>

            </div>
        </div>
        <div class="col-sm-8">
            <!-- 表单 -->
            >>>公告查看
                        <table class="layui-hide" id="ruleTable" lay-filter="formFilter"></table>
            <br/>
            >>>团队审核情况
            <table class="layui-hide" id="teamTable" lay-filter="formFilter"></table>

<%--        <form class="form-inline pt-2 pb-3">--%>
<%--            <input class="form-control mr-sm-2" type="search" placeholder="查询往届比赛信息" aria-label="Search">--%>
<%--            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">查询</button>--%>
<%--        </form>--%>
<%--        <c:forEach items="${noticeList}" var="notice">--%>
<%--            <h2>${notice.title}</h2>--%>
<%--            <h5>${notice.createTime}</h5>--%>
<%--            <img src="${notice.img}">--%>
<%--            <p>${notice.content}</p>--%>
<%--            <br>--%>
<%--        </c:forEach>--%>

<%--        <c:if test="${currentPage > 1}">--%>
<%--            <a href="studentList.jsp?page=${currentPage - 1}">上一页</a>--%>
<%--        </c:if>--%>
<%--        <c:if test="${currentPage < totalPages}">--%>
<%--            <a href="studentList.jsp?page=${currentPage + 1}">下一页</a>--%>
<%--        </c:if>--%>

<%--        <ul class="pagination justify-content-center pt-3">--%>
<%--            <c:if test="${currentPage > 1}">--%>
<%--                <li class="page-item disabled">--%>
<%--                    <a class="page-link" href="noticeServlet.jsp?page=${currentPage - 1}">上一页</a>--%>
<%--                </li>--%>
<%--            </c:if>--%>
<%--            <c:if test="${currentPage < totalPages}">--%>
<%--                <li class="page-item">--%>
<%--                    <a class="page-link" href="noticeServlet.jsp?page=${currentPage + 1}">下一页</a>--%>
<%--                </li>--%>
<%--            </c:if>--%>
<%--        </ul> --%>
        </div>
    </div>
</div>

</body>

<%@ include file="tail.jsp" %>
<script src="../public/layui/layui.js" charset="UTF-8"></script>
<!-- 头部工具栏 -->
<script type="text/html" id="headBar">
    <%--		<button type="button" class="layui-btn  layui-btn-sm" lay-event="add"><i class="layui-icon">添加</i></button>--%>
</script>

<script type="text/html" id="tplImg">
    {{# if(d.img) { }}
    <img src="{{ d.img }}" alt="图片">
    {{# } else { }}
    无图片
    {{# } }}
</script>
<!-- 表格后面的操作 -->
<script type="text/html" id="operate">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <%-- 	 	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>--%>
</script>
<script>
    var row;
    layui.use(['table', 'jquery'], function () {
        $ = layui.jquery;
        var table = layui.table;
        table.render({
            id: 'formFilter'
            , elem: '#ruleTable'
            , url: '${pageContext.request.contextPath}/noticeServlet'
            , title: '数据表单'
            , page: true
            , cols: [[
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'title', title: '标题', fixed: 'left'}
                , {field: 'content', title: '内容', fixed: 'left'}
                , {field: 'img', title: '图片', fixed: 'left', templet: '#tplImg'}
                , {field: 'createTime', title: '创建时间', fixed: 'left'}
            ]] ,limits: [3,5,10,20]
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

        table.render({
            id: 'formFilter'
            , elem: '#teamTable'
            , url: '${pageContext.request.contextPath}/teamWithStuServlet'
            , title: '数据表单'
            , page: true
            , cols: [[
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'teamName', title: '团队名称', fixed: 'left'}
                , {field: 'audit', title: '审核状态', fixed: 'left'}
                , {field: 'createTime', title: '创建时间', fixed: 'left'}
            ]] ,limits: [3,5,10,20]
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
                        title: '添加user表信息',
                        area: ['800px', '500px'],
                        maxmin: true,
                        content: 'competitionadd.jsp',
                    });
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

</html>