<%@page import="com.henu.utils.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.henu.bean.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>student_login</title>
</head>
<body>
<%
	List<Exam> list=DaoFactory.getExamDaoInstance().search();
	String examname=null;
	for(Exam exam:list)
	{
		if(exam.getE_isstart())
		{
			examname=exam.getE_name();
			session.setAttribute("examname", examname);
		}
	}
%>

<div class="container">
		<div id="myAlert" class="alert alert-warning alert-dismissable" style="margin-top: -75px;width: ;">
			<button type="button" href="#" class="close" data-dismiss="alert">&times;</button>
			<strong style="margin-left: 20px; font-size: 20px">
				<% if(examname!=null) out.print("考试"+examname+" 正在进行中"); 
					else out.print("当前没有进行中的考试，不能登陆");%>
			</strong>
		</div>
		<div class="exam-login row vertical-center" style="margin-top: 200px;">
			<h1><span class="glyphicon glyphicon-thumbs-up"></span></h1>
			<h2 class="text-center" style="margin-top: 6px">
				<!-- <img src="../image/exam-student.png" /> --> 学生登录
			</h2>
			<form class="bs-example bs-example-form" role="form" action="../StudentLogin">
				<div class="input-group input-group-lg" style="margin: 20px">
					<span class="input-group-addon">
						<svg class="icon" aria-hidden="true" style="">
  							<use xlink:href="#icon--happy-1"></use>
						</svg>
					</span>									
					<input type="text" class="form-control" name="stu_id"
						placeholder="schoolID">
				</div>
				<div class="input-group input-group-lg" style="margin: 20px">
				<span class="input-group-addon">
					<svg class="icon" aria-hidden="true" style="fill: #008000;">
  							<use xlink:href="#icon-user-boy"></use>
					</svg>
				</span>
					<input type="text" class="form-control" name="stu_username"
						placeholder="username">
				</div>
				<div class="form-group" style="margin: 20px">
					<button type="submit" class="btn btn-primary btn-lg btn-block"style="disabled=<%if(examname==null) out.print("disabled");%>">Sign In</button>
				</div>
			</form>
		</div>
</div>

	<%-- <div class="container">
		<div class="alert navbar-inverse">
			<strong style="color: white; margin-left: 20px; font-size: 20px"><% if(examname!=null) out.print("考试"+examname+" 正在进行中"); else out.print("当前没有进行中的考试，不能登陆");%></strong>
		</div>
		<div class="exam-login row vertical-center">
			<h3>
				<img src="../image/exam-student.png" /> 学生登录
			</h3>
			<form class="form-horizontal"
				style="margin-left: 20px; margin-right: 20px" role="form"  action="../StudentLogin">
				<div class="form-group">
					<input type="text" class="form-control" name="stu_id"
						placeholder="学号">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="stu_username"
						placeholder="姓名">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-default" style="width: 100%;disabled=<%if(examname==null) out.print("disabled");%>">登录</button>
				</div>
			</form>
		</div>
	</div> --%>
</body>
</html>