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
>>>大赛简介

<div class="container" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-12">
            <!-- Sidebar-->
            <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="border-bottom bg-light">
                    <div id="myTime" class="py-3"></div>
                </div>
                <img src="img/about-image.jpg" class="img-fluid" alt="about">
                <p style="text-indent: 40px ;" align="justify" class="pt-3">
                    本比赛旨在贯彻实施教育部关于创新高校人才培养机制的有关要求，为上海市大学生提供一个展示创新精神和创新实践能力的平台。我们希望通过比赛调动大学生学习计算机技术的积极性，提高大学生运用信息技术解决实际问题的综合水平，鼓励计算机学科类学生参加学科竞赛。
                </p>
                <p style="text-indent: 40px ;" align="justify" class="pt-3">
                    比赛主要涉及与计算机相关的技术和知识，包括但不限于编程、算法、数据结构、网络安全等方面。我们欢迎所有对计算机技术有兴趣的同学踊跃报名参加，无论您是否具有相关比赛经验，只要您热爱计算机、勇于挑战自我，就有机会在比赛中展示自己的才华和技能。
                </p>
                <p style="text-indent: 40px ;" align="justify" class="pt-3">
                    比赛设有多个组别和不同难度级别的题目，根据参赛者的实际情况进行分组。我们将为获胜者提供奖金、证书等丰厚奖励，并为表现优异者提供机会参加更高水平的比赛和活动。同时，参赛者还可以通过比赛结识志同道合的伙伴，扩展自己的社交圈子，增强团队协作能力。 </p>
                <p style="text-indent: 40px ;" align="justify" class="pt-3">
                    我们相信，本次比赛将为参赛者提供一个锻炼自身技能、展示才华的机会，也将为推动计算机科学的发展和创新做出积极贡献。
                </p>
            </div>
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
                , {field: 'img', title: '图片', fixed: 'left'}
                , {field: 'createTime', title: '创建时间', fixed: 'left'}
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