<%@page import="com.henu.utils.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.henu.utils.DbUtil,java.sql.*,java.util.*,com.henu.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administrator</title>
<link rel="stylesheet"
	href="../../css/bootstrap.min.css">
<script
	src="../../js/jquery.min.js"></script>
<script
	src="../../js/bootstrap.min.js"></script>
</head>
<body>
	<%
		boolean hidding = false;
		request.setCharacterEncoding("utf-8");
		
		List<Teacher> list=DaoFactory.getTeacherDaoInstance().search();
		int i = 0;
		String username = "";
		for(Teacher teacher:list)
		{
			if (teacher.getT_manager()) {
				username =teacher.getT_name();
				i++;
			}
		}
		if (i == 1 && username.equals("admin")) {
			hidding = true;
		}
	%>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="navbar-collapse collapse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li style="font-size: 18px; text-color: #ffffff;"><a>上机考试系统</a></li>
				<li><a href="admin_about.jsp"><span
						class="glyphicon glyphicon-home"></span>首页</a></li>
				<li class="dropdown">
					<a href="admin_manageteacher.jsp" class="dropdown-toggle" data-toggle="dropdown"><span
						class="glyphicon glyphicon-user"></span>教师管理<b class="caret"></b></a>
					<ul class="dropdown-menu">
					<li><a href="admin_addTeacher.jsp">添加教师</a></li>
					<li><a href="admin_manageteacher.jsp">查询教师</a></li>
					</ul>
				</li>
				<li><a href="admin_clearexam.jsp"><span
						class="glyphicon glyphicon-minus"></span>考试清理</a></li>
				<li><a href="admin_system.jsp"><span
						class="glyphicon glyphicon-wrench"></span>系统配置</a></li>
			</ul>
			<ul class="nav navbar-nav" style="float: right">
				<li><a><span class="glyphicon glyphicon-user"></span>欢迎您,<%=(String) session.getAttribute("username")%></a></li>
				<li><a href="" data-toggle="modal" data-target="#myModal"><span
						class="glyphicon glyphicon-pencil"></span>修改口令</a></li>
				<li><a href="../../login/main_login.jsp"><span
						class="glyphicon glyphicon-remove"></span> 退出</a></li>
			</ul>
		</div>
		</div>
	</nav>
	<div class="container" style="margin-top: 35px;">
		<h1>
			<!-- <img src="../../image/exam-admin.png" />欢迎管理员登录 -->
		</h1>
	</div>
	<div class="container alert navbar-inverse"
		<%if (!hidding) {
				out.print("style=\"display:none\"");
			}%>>
		<strong style="color: white; margin-left: 20px; font-size: 15px">没有设置管理员账号，默认管理员账号存在风险，请尽快处理！</strong>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 300px">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">
						<b>修改口令</b>
					</h4>
				</div>
				<form action="../../ChangeAdminPwd" method="post">
					<div class="alert navbar-inverse "
						style="background-color: #eeeeee; height: auto; margin-top: 20px">
						<input style="width: 250px" name="oldPwd" type="password" placeholder="原口令"
							class="form-control"> <br /> <input type="password"
							style="width: 250px" placeholder="新口令" name="newPwd1" class="form-control">
						<br /> <input type="password" style="width: 250px"
							placeholder="重输新口令" name="newPwd2" class="form-control"> <br />
						<button type="submit" style="width: 250px" class="btn btn-primary">
							修改</button>
					</div>
				</form>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>
</html>