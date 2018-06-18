<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>On Board Examination System</title>
<link href="../css/exam_login.css" rel="stylesheet" type="text/css"> 
<link rel="stylesheet"
	href="../css/bootstrap.min.css">
<script
	src="../js/jquery.min.js"></script>
<script
	src="../js/bootstrap.min.js"></script>
<script src="../iconfont/iconfont.js"></script>
<style type="text/css">
body {
	padding-top: 40px;
}
.icon {
   width: 1.4em; height: 1.4em;
   vertical-align: -0.15em;
   fill: currentColor;
   overflow: hidden;
}
</style>

</head>
<body style="background-image:url(../image/background/p3.jpg);background-size:cover;">
<nav class="navbar-nav navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<!-- <input class="navbar-brand"> -->
			<!-- <span class="h3 .vertical-center">On board examination system</span> -->
		</div>
		<div class="collapse navbar-collapse" id="example-navbar-collapse">
			<ul id="main_nav" class="nav nav-pills">
				<li class="active"><a href="#student" data-toggle="tab" style="height:50px;color:white;">学生登录</a></li>
				<li><a href="#teacher" data-toggle="tab" style="height:50px;color:white;">教师登录</a></li>
				<li><a href="#admin" data-toggle="tab" style="height:50px;color:white;">管理员登录</a></li>
				<li class="nav navbar-right" style="font-size: 29px; margin-top:10px;margin-right:-45px;">
					<em style="margin-right:-55px; color:#ff8000;">Welcome to On Board Examination System</em>
				</li>
				<!-- <li class="nav navbar-right"> 
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" style="height:50px;">
					<b class="glyphicon glyphicon-user"></b> 欢迎您  <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">For Newer</a></li>
						<li><a href="#">Other</a></li>
					</ul>
				</li> -->
			</ul>					
			<div id="myTabContent" class="tab-content" style="margin-top: 90px">
				<div class="tab-pane fade in active" id="student">
				<jsp:include page="student_login.jsp"></jsp:include>
				</div>
				<div class="tab-pane fade" id="teacher">
					<jsp:include page="teacher_login.jsp"></jsp:include>
				</div>
				<div class="tab-pane fade" id="admin">
					<jsp:include page="admin_login.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
</nav>	

	<%-- <div class="container">
		<ul id="main_nav" class="nav nav-pills">
			<li class="active"><a href="#student" data-toggle="tab">学生登录</a></li>
			<li><a href="#teacher" data-toggle="tab">教师登录</a></li>
			<li><a href="#admin" data-toggle="tab">管理员登录</a></li>
		</ul>
		<div id="myTabContent" class="tab-content" style="margin-top: 30px">
			<div class="tab-pane fade in active" id="student">
				<jsp:include page="student_login.jsp"></jsp:include>
			</div>
			<div class="tab-pane fade" id="teacher">
				<jsp:include page="teacher_login.jsp"></jsp:include>
			</div>
			<div class="tab-pane fade" id="admin">
				<jsp:include page="admin_login.jsp"></jsp:include>
			</div>
		</div>
	</div> --%>
</body>
</html>