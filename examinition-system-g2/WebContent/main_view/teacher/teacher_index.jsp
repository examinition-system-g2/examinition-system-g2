<%@page import="com.henu.utils.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.henu.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Teacher</title>
<link rel="stylesheet"
	href="../../css/bootstrap.min.css">
<script
	src="../../js/jquery.min.js"></script>
<script
	src="../../js/bootstrap.min.js"></script>
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
		String teacher = (String) session.getAttribute("teacher");
		System.out.print(teacher);
	%>
	<%
		int flag=0;
		List<Exam> list=DaoFactory.getExamDaoInstance().search();
		for(Exam e:list)
		{
			if(e.getE_isstart())
				flag=1;
		}
	%>
	<nav class="navbar bg-warning navbar-fixed-top">
	<div class="navbar-collapse collapse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li style="font-size: 25px;margin-right:20px; vertical-align: middle; text-color: #004000; text-shadow: #bcbc78 3px 3px 3px;">
				<em>On Board Exam</em></li>
				<li><a href="teacher_about.jsp"><span
						class="glyphicon glyphicon-home"></span>首页</a></li>
				<li><a href="teacher_exam_before.jsp"><span
						class="glyphicon glyphicon-list"></span>考前操作</a></li>
				<li <%if(flag!=1) out.print("style='pointer-events:none;'");%> class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><span class="glyphicon glyphicon-time"></span>考中管理<b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li ><a href="teacher_exam_survey.jsp">考试概况</a></li>
						<li><a href="../../FenYe">学生信息</a></li>
						<li><a href="teacher_unlocked.jsp">解除绑定</a></li>
						<li><a href="teacher_notice.jsp">通知管理</a></li>
					</ul></li>
				<li <%if(flag!=1) out.print("style='pointer-events:none;'");%>><a href="teacher_exam_after.jsp"><span
						class="glyphicon glyphicon-check"></span>考后操作</a></li>
			</ul>
			<ul class="nav navbar-nav" style="float: right">
				<li><a><span class="glyphicon glyphicon-user"></span>欢迎您<%=teacher%></a></li>

				<li><a href="" data-toggle="modal" data-target="#myModal"><span
						class="glyphicon glyphicon-pencil"></span>修改口令</a></li>
				<li><a href="../../login/main_login.jsp"><span
						class="glyphicon glyphicon-remove"></span> 退出</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container" style="margin-top: 50px">
		<h1>
			<%-- <img src="../../image/exam-teacher.png" />教师<%=teacher%>，欢迎您登录 --%>
		</h1>
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
				<form action="../../ChangeTeacherPwd" method="post">
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