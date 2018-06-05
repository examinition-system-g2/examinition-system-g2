<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>解除绑定</title>
</head>
<body>
<%
	StringBuffer sb=new StringBuffer();
	try{
		sb=(StringBuffer)session.getAttribute("unlock");
	}catch(Exception e)
	{
		e.printStackTrace();
	}
		session.setAttribute("unlock", null);
		%>
<jsp:include page="teacher_index.jsp"></jsp:include>
	<div class="container">
		<div class="alert navbar-inverse"
			style="background-color: #eeeeee; margin-top: 10px">
			<strong style="margin-left: 20px; font-size: 18px">按学生查找已登录信息</strong>
			<form class="form-inline" role="form" action="../../teacher_unlocked"
				style="margin-left: 20px; margin-top: 5px;">
				<div class="form-group">
					<input type="text" class="form-control" style="width: 250px"
					name="id"	placeholder="学号*">
					<input type="submit" class="btn btn-info" value="查找" />
				</div>
			</form>
		</div>
		<div class="alert navbar-inverse"
			style="background-color: #eeeeee; margin-top: 20px">
			<strong style="margin-left: 20px; font-size: 18px">查找结果</strong>
			<form class="form-inline" role="form"
				style="margin-left: 20px; margin-top: 5px;">
	<table class="table table-bordered" style="margin-top: 10px">
			<tr>
				<th class="col-md-2">学号</th>
				<th class="col-md-2">姓名</th>
				<th class="col-md-2">班级</th>
				<th class="col-md-2">ip地址</th>
				<th class="col-md-2">解除锁定</th>
			</tr>
			<%if(sb!=null) out.print(sb.toString()); %>
		</table>
			</form>
		</div>
		</div>
</body>
</html>