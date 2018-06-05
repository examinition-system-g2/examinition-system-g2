<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Teacher</title>
</head>
<%	String error=(String)session.getAttribute("teacher_error");
	out.print(error);
	session.setAttribute("teacher_error", "");
	%>
<body>
	<jsp:include page="teacher_index.jsp"></jsp:include>
	<div class="container">
	<div class="panel panel-success" style="margin-top:10px;margin-left:8px;">
    	<div class="panel-heading" style="background-color: #eeeeee; margin-top:;">
        	<!-- <h1 class="panel-title"></h1> -->
        	<strong style="margin-left: 15px; font-size: 20px;">考前操作</strong>
    	</div>
    	<div class="panel-body text-left" style="margin-left: 20px; font-size: 18px;">
        	<p style="">
				<span class="glyphicon glyphicon-tag" style="margin-right: 10px;"></span>
				可以新建考试：指定考试名称、开始时间等
			</p>
			<p>
				<span class="glyphicon glyphicon-tag" style="margin-right: 10px;"></span> 
				可以编辑自己创建的、未创建的的考试，除了修改考试信息，还可以:
			</p>
			<p>
				&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-map-marker" style="margin-right: 10px;"></span>
				<em>上传试卷</em>
			</p>
			<p>
				&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-map-marker" style="margin-right: 10px;"></span>
				<em>学生名单导入</em>
			</p>
			<p>
				&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-map-marker" style="margin-right: 10px;"></span>
				<em>开始考试</em>
			</p>
		</div>
	
	<div class="panel panel-success">		
		<div class="panel-heading" style="background-color: #eeeeee;">
        	<!-- <h1 class="panel-title"></h1> -->
        	<strong style="margin-left: 15px; font-size: 20px">考中管理</strong>
    	</div>
    	<div class="panel-body text-left" style="margin-left: 20px; font-size: 18px;">
        	<p style="">
				<span class="glyphicon glyphicon-tag" style="margin-right: 10px;"></span>
				可以查看考试情况
			</p>
			<p>
				<span class="glyphicon glyphicon-tag" style="margin-right: 10px;"></span>
				可以管理学生信息，手动添加个别学生信息
			</p>
			<p>
				<span class="glyphicon glyphicon-tag" style="margin-right: 10px;"></span>
				 可以解除学生登陆锁定
			</p>
			<p>
				<span class="glyphicon glyphicon-tag" style="margin-right: 10px;"></span>
				可以添加或删除通知信息
			</p>
		</div>
	
	<div class="panel panel-success">		
		<div class="panel-heading" style="background-color: #eeeeee;">
        	<!-- <h1 class="panel-title"></h1> -->
        	<strong style="margin-left: 15px; font-size: 20px">考后操作</strong>
    	</div>
    	<div class="panel-body text-left" style="margin-left: 20px; font-size: 18px;">
        	<p style="">
				<span class="glyphicon glyphicon-tag" style="margin-right: 10px;"></span>
				主考教师（考试创建者）可以结束考试
			</p>
			<p>
				<span class="glyphicon glyphicon-tag" style="margin-right: 10px;"></span>
				主考教师可以打包下载学生的提交文件
			</p>
			<p style="">
				<span class="glyphicon glyphicon-tag" style="margin-right: 10px;"></span>
				主考教师可以到处提交信息
			</p>
			<p>
				<span class="glyphicon glyphicon-tag" style="margin-right: 10px;"></span>
				如果管理员设置，只考教师可以清理和删除考试
			</p>
    	</div>
	</div>
	</div>
	</div>
	</div>
</body>
</html>