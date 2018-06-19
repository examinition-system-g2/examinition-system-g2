<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生</title>
</head>
<body style="background-image:url(../../image/background/h6.jpg);background-size:cover;">
	<jsp:include page="teacher_index.jsp"></jsp:include>
	<div class="container alert btn-primary">
		<strong style="color: white; margin-left: 20px; font-size: 15px;">完成学生名单的导入和修改后,&nbsp;&nbsp;</strong>
		<a href="teacher_addexam.jsp" class="btn btn-default"><span
			class="glyphicon glyphicon-pencil"></span>返回编辑</a>
	</div>
	<div class="container">
		<div class="alert navbar-inverse"
			style="background-color: #eeeeee; margin-top: 10px">
			<strong style="margin-left: 20px; font-size: 18px">添加单个学生</strong>
			<form class="form-inline" role="form"
				style="margin-left: 20px; margin-top: 5px;"
				action="../../TeacherAddStudent" method="post">
				<div class="form-group">
					<input type="text" class="form-control" style="width: 250px"placeholder="学号*" name="xuehao"> 
					<input type="text"
						class="form-control" style="width: 250px" placeholder="姓名*"name="xingming"> 
						<input type="text" class="form-control" style="width: 250px" placeholder="班级*" name="banji"> 
						<input type="submit" class="btn btn-primary" value="添加" />
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
			<li><a href="../../FenYe?page=<%=session.getAttribute("current1")%>&exam=<%=session.getAttribute("studentinfo")%>">&laquo;</a></li>
				<%=(String)session.getAttribute("bar") %>
			<li><a href="../../FenYe?page=<%=session.getAttribute("current2")%>&exam=<%=session.getAttribute("studentinfo")%>">&raquo;</a></li>
		</ul>
		<div class="alert navbar-inverse"
			style="background-color: #eeeeee; margin-top: 20px">
			<strong style="margin-left: 20px; font-size: 18px">批量导入学生名单</strong>
			<form action="../../ImportStuFromExcel" method="post"
				class="form-inline" role="form"  enctype="multipart/form-data"
				style="margin-left: 20px; margin-top: 12px;">
				<input type="file" name="file" />
				<button type="submit" style="margin-top: 5px" class="btn btn-primary">导入</button>
			</form>
		</div>
	</div>
</body>
</html>