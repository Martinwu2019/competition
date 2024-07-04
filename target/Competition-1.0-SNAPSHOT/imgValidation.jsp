<%@ page language="java" pageEncoding="UTF-8"%>
<%
String vericode = request.getParameter("vericode");
String yzm = request.getSession().getAttribute("yzm").toString();
if (!vericode.equals(yzm))
	response.sendRedirect("login.jsp?err=The validation is error.");
else
	out.println("登录成功！");
%>
