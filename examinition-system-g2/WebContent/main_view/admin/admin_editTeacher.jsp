<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改教师账号</title>
<style type="text/css">
.inputclass {
	height: 30px;
	width: 350px;
}
tr {
	line-height: 50px;
}
</style>
</head>
<body style="background-image:url(../../image/background/h13.jpg);background-size:cover;">
	<%	
	
		String username=request.getParameter("edit_username");
		String name=request.getParameter("edit_name");
		String password=request.getParameter("edit_password");
	
		
	%>

	<jsp:include page="admin_head.jsp"></jsp:include>
	<div class="container">
		<h3><strong>修改教师账号</strong></h3>
		<form action="../../EditTeacherPwd" method="post">
		<table style="margin-left: 50px">
			<tr>
				<td align="right"><b>用户名:<b></td>
				<td style="padding-left: 20px"><input readonly="readonly" type="text"  name="edit_teacher_username"
					class="form-control inputclass" value="<%=username %>"></td>
			</tr>
			<tr>
				<td align="right"><b>密码:<b></td>
				<td style="padding-left: 20px"><input type="password" name="edit_teacher_password"
					class="form-control inputclass" value="<%=password %>"></td>
				<td align="right"><b>&nbsp;当前为加密后的密码<b></td>
			</tr>
			<tr>
				<td align="right"><b>全名:<b></td>
				<td style="padding-left: 20px"><input type="text" 
					class="form-control inputclass" name="edit_teacher_name" value="<%=name%>"></td>
			</tr>
			<tr>
				<td></td>
				<td style="padding-left: 20px"><label style="font-size: 15px">
						<input type="checkbox" name="edit_teacher_manage">管理员
				</label></td>
			</tr>
			<tr>
				<td></td>
				<td style="padding-left: 20px"><button class="btn btn-primary"  type="submit">修改</button></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>