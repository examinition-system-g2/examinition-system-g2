<%@page import="com.henu.utils.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.henu.utils.*,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student</title>
<link rel="stylesheet"
	href="../css/bootstrap.min.css">
<script
	src="../js/jquery.min.js"></script>
<script
	src="../js/bootstrap.min.js"></script>
<script src="../../iconfont/iconfont.js"></script>
<style type="text/css">
.icon {
   width: 1.4em; height: 1.4em;
   vertical-align: -0.15em;
   fill: currentColor;
   overflow: hidden;
}
.navbar{
    margin-bottom: 0px;
    /* border-radius: 5px; */
    background: ;
        
} 
.navbar ul li a{
    color:#004000;
}
/* .navbar-nav ul li a:hover{
    color: aqua;
    background-color: #282828;        
} */
.nav>li>a:hover, .nav>li>a:focus {
	border-radius: 15px;
	text-decoration: none;
	background-color: #dfdfdf;
}   
</style>
</head>
<body>
	<%
		String stu_name = (String) session.getAttribute("stu_name");
		String examname=DaoFactory.getStudentDaoInstance().search(stu_name).getStu_exam();
		
	%>
	<nav class="navbar bg-warning navbar-fixed-top" style="">
	<div class="navbar-collapse collapse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li style="font-size: 25px;margin-right:20px; vertical-align: middle; text-color: #004000; text-shadow: #bcbc78 3px 3px 3px;">
				<em>On Board Exam</em></li>
				<li><a href="student_about.jsp"><span
						class="glyphicon glyphicon-home"></span>首页</a></li>
				<li><a href="student_submit.jsp"><span
						class="glyphicon glyphicon-eye-open"></span>查看提交</a></li>
			</ul>
			<ul class="nav navbar-nav" style="float: right">
				<li><a><span class="glyphicon glyphicon-user"></span>欢迎您,<%=stu_name%></a></li>
				<li><a href="../../login/main_login.jsp"><span
						class="glyphicon glyphicon-remove"></span> 退出</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container" style="margin-top: 50px;">
		<h1>
			<!-- <img src="../../image/exam-student.png" /> --><%=stu_name%>,上机考试中...
		</h1>
	</div>
</body>
</html>