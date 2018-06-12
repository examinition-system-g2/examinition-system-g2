<%@page import="com.henu.utils.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.henu.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息</title>
</head>
<body>
	<jsp:include page="teacher_index.jsp"></jsp:include>
	<div class="container">
		<div class="alert navbar-inverse"
			style="background-color: #eeeeee; margin-top: 10px">
			<strong style="margin-left: 20px; font-size: 18px">当前考试:<%=session.getAttribute("studentinfo") %></strong>
			<strong style="margin-left: 20px; font-size: 18px">添加单个学生</strong>
			<form class="form-inline" role="form"
				style="margin-left: 20px; margin-top: 5px;"
				action="../../TeacherAddStudent?id=2" method="post">
				<div class="form-group">
					<input type="text" class="form-control" style="width: 250px"
						placeholder="学号*" name="xuehao"> <input type="text"
						class="form-control" style="width: 250px" placeholder="姓名*"
						name="xingming"> <input type="text" class="form-control"
						style="width: 250px" placeholder="班级*" name="banji"> <input
						type="submit" class="btn btn-info" value="添加" />
				</div>
			</form>
		</div>
		<table class="table table-bordered" style="margin-top: 10px">
			<tr>
				<th class="col-md-3">学号</th>
				<th class="col-md-3">姓名</th>
				<th class="col-md-3">班级</th>
				<th class="col-md-3">考试</th>				
			</tr>
			<%
				StringBuilder sb = (StringBuilder) session.getAttribute("info");
				out.print(sb);
			%>
		</table>
		<ul class="pagination pagination-lg">
			<li><a href="../../FenYe?page=<%=session.getAttribute("current1")%>">&laquo;</a></li>
				<%=(String)session.getAttribute("bar") %>
			<li><a href="../../FenYe?page=<%=session.getAttribute("current2")%>">&raquo;</a></li>
		</ul>
	</div>
</body>
</html>