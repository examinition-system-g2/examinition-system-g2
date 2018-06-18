<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>teacher_login</title>
</head>
<body>
<div class="container">
		<div class="exam-login row vertical-center" style="margin-top: 260px;margin-left:400px;height:400px">
			<h1><span class="glyphicon glyphicon-hand-up"></span></h1>
			<h2 class="text-center" style="margin-top: 3px">
				<!-- <img src="../image/exam-teacher.png" /> --> 教师登录
			</h2>
			<form class="bs-example bs-example-form" role="form" action="../TeacherLogin">
				<div class="input-group input-group-lg" style="margin: 30px">
					<span class="input-group-addon">
						<svg class="icon" aria-hidden="true" style="">
  							<use xlink:href="#icon--happy"></use>
						</svg>
					</span>
					<input type="text" class="form-control" name="t_id"
						placeholder="username">
				</div>
				<div class="input-group input-group-lg" style="margin: 30px">
					<span class="input-group-addon">
						<svg class="icon" aria-hidden="true" style="fill: #008000;">
  							<use xlink:href="#icon-unie604"></use>
						</svg>
					</span>
					<input type="password" class="form-control" name="t_username"
						placeholder="password">
				</div>
				<div class="form-group" style="margin: 30px">
					<button type="submit" class="btn btn-primary btn-lg btn-block">Sign In</button>
				</div>
			</form>
		</div>
	</div>
	<!-- <div class="container">
		<div class="exam-login row vertical-center">
			<h3>
				<img src="../image/exam-teacher.png" /> 教师登录
			</h3>
			<form class="form-horizontal"
				style="margin-left: 20px; margin-right: 20px" role="form" action="../TeacherLogin">
				<div class="form-group">
					<input type="text" class="form-control" name="t_id"
						placeholder="账号">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" name="t_username"
						placeholder="密码">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-default" style="width: 100%">登录</button>
				</div>
			</form>
		</div>
	</div> -->
</body>
</html>