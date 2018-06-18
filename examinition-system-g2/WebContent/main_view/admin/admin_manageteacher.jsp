<%@page import="com.henu.utils.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.henu.utils.DbUtil,java.sql.*,java.util.*,com.henu.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询教师</title>
</head>
<body style="background-image:url(../../image/background/h13.jpg);background-size:cover;">
	<jsp:include page="admin_head.jsp"></jsp:include>
	<div class="container">		
		<table class="table table-bordered" style="margin-top: 10px">
			<tr>
				<th class="col-md-3">用户名</th>
				<th class="col-md-3">全名</th>
				<th class="col-md-3">是否为管理员</th>
				<th class="col-md-3"></th>
			</tr>
			<%
				StringBuilder sbinfo = (StringBuilder) session.getAttribute("info");
				if(sbinfo == null)
				{
					response.sendRedirect("../../FenYe_Teacher");
				}
				
				/* sb.append("examname"); */
				out.print(sbinfo);
			%>
			</table>
			<ul class="pagination pagination-lg">
				<li><a href="../../FenYe_Teacher?page=<%=session.getAttribute("current1")%>">&laquo;</a></li>
					<%=(String)session.getAttribute("bar") %>
				<li><a href="../../FenYe_Teacher?page=<%=session.getAttribute("current2")%>">&raquo;</a></li>
			</ul>
	</div>
</body>
</html>