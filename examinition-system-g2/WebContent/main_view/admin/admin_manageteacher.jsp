<%@page import="com.henu.utils.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.henu.utils.DbUtil,java.sql.*,java.util.*,com.henu.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询教师</title>

<!-- <script type="text/javascript">
//验证用户名是否规范
function check_username(){	
	//在每个函数中定义check变量是为了在表单提交后，能够逐个验证每个函数是否通过
    var check; 
    var username = document.getElementById("username").value; 
    if (username.length > 18 || username.length < 6) { 
      alert("用户名输入不合法，请重新输入！");
      //若输入错误，则在此处获取焦点，继续输入
      document.getElementById("username").focus();
      check = false; 
     } else { 
      document.getElementById("check_username").innerHTML = "* 用户名由6-18位字符组成 √"; 
      check = true; 
     } 
     return check; 
}

//验证真实姓名是否规范
function check_name(){	
    var check; 
    var reg = "^[a-zA-Z\u4e00-\u9fa5]+$";
    var name = document.getElementById("name").value; 
    if (reg.test(name)==true) { 
    	document.getElementById("check_password").innerHTML = "* 姓名输入成功 √"; 
        check = true;
        
      } else { 
    	alert("姓名不合法，请重新输入！");
        document.getElementById("password").focus();
        check = false; 
      } 
      return check;     
}

//利用正则表达式判断密码是否符合规范
function check_password() { 
  var check; 
  var reg = /[^A-Za-z0-9_]+/;
  var password = document.getElementById("password").value; 
  if (password.length < 6 || password.length > 18) { 
    alert("密码长度不合法，请重新输入！");
    document.getElementById("password").focus();
    check = false; 
  } else if(reg.test(password)) { 
    document.getElementById("check_password").innerHTML = "* 密码输入成功 √"; 
    check = true; 
  }else{
	 alert("密码输入不合法，请重新输入！");
	 document.getElementById("password").focus();
	 check = false; 
  } 
  return check; 
} 


//验证密码是否一致
function check_confirm_password() { 
  var check; 
  var password = document.getElementById("password").value; 
  var confirm_password = document.getElementById("confirm_password").value; 
  if (password != confirm_password) { 
    alert("两次输入密码不一致，请重新输入！");
    document.getElementById("confirm_password").focus();
    check = false; 
  } else { 
    document.getElementById("check_confirm_password").innerHTML = "* 请再次输入你的密码 √"; 
    check = true; 
  } 
  return check; 
}

function check_email(){
	var check; 
    var email = document.getElementById("email").value;
	var reg = /^[a-zA-Z0-9_-]{5,}@([a-zA-Z0-9_-]{2,})+.+(com|gov|net|com.cn|edu.cn)$/;
	if(reg.test(email)==true){
		document.getElementById("check_email").innerHTML = "*<font color='#0F0'> 邮箱合法 √</font>";
		check = true;
	}else{
		alert("邮箱地址输入不规范，请重新输入！");
	    document.getElementById("email").focus();
	    check = false; 
}

function check_all() { 
    var check = check_username() && check_name() && check_password(); 
    return check;  
  } 
  
  



</script> -->
</head>
<body>
	<%	String error=(String)session.getAttribute("pwderror");
	out.print(error);
	session.setAttribute("pwderror", "");
	%>
	<%
		request.setCharacterEncoding("utf-8");
		//查询所有教师信息
	
		List<Teacher> list=DaoFactory.getTeacherDaoInstance().search();
		StringBuffer sb = new StringBuffer();
		for(Teacher teacher:list)
		{
			sb.append("<tr><td>");
			sb.append(teacher.getT_username());
			sb.append("</td><td>");
			sb.append(teacher.getT_name());
			sb.append("</td><td>");
			if(teacher.getT_manager()){
				sb.append("<span class=\"glyphicon glyphicon-ok\"></span>");
			}else{
				sb.append("");
			}
			sb.append("</td><td>");
			//此处缺少href跳转
			sb.append("<a href='admin_editTeacher.jsp?edit_username="+teacher.getT_username()+"&edit_name="+teacher.getT_name()+"&edit_password="+teacher.getT_pwd()+"'><span class='glyphicon glyphicon-edit' title='编辑'></span></a>");
			sb.append("&nbsp&nbsp&nbsp");
			sb.append("<a href='../../admin_deleteTeacher?delete_username="+teacher.getT_username()+"'><span class='glyphicon glyphicon-trash' title='删除'></span></a>");
			sb.append("</td></tr>");
		}
	
	%>
	<jsp:include page="admin_head.jsp"></jsp:include>
	<div class="container">
		<!-- <div class="alert navbar-inverse"
			style="background-color: #eeeeee; margin-top: 10px;">
			<strong style="margin-left: 20px; font-size: 18px">添加教师</strong>
			<form class="form-horizontal" role="form"
				 onsubmit="return check_all()" action="../../admin_addTeacher">
				<div class="form-group" style="text-align: center">
				<label class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-10">
      					<input type="text" class="form-control" style="width: 300px"
      					 placeholder="* 用户名由6-18位字符组成" id="username" name="username" onchange="check_username()">
      					 <td id="check_username"></td>
    				</div>    				
				</div>			
				<div class="form-group">
					<label class="col-sm-2 control-label">真实姓名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" style="width: 300px"
						placeholder="* 真实姓名由英文或汉字组成" id="name" name="name" onchange="check_name()">
						<td id="check_name"></td>
					</div>					
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">教师工号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" style="width: 300px"
						placeholder="* 教师职工号由数字组成" id="schoolID" name="schoolID" onchange="check_schoolID()">
					<td id="check_schoolID"></td>
					</div>
				</div>	
				<div class="form-group">
					<label class="col-sm-2 control-label">邮箱</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" style="width: 300px"
						placeholder="* 用于找回密码" id="email" name="email" onchange="check_email()">
					<td id="check_email"></td>
					</div>
				</div>			
				<div class="form-group">
					<label class="col-sm-2 control-label">登录密码</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" style="width: 300px"
						placeholder="* 6-18位，必须包含字母和数字" id="password" name="password" onchange="check_password()">
					<td id="check_password"></td>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">确认密码</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" style="width: 300px"
						placeholder="确认登录密码*" id="confirm_password" name="confirm_password" onchange="check_confirm_password()">
					<td id="check_confirm_password"></td>
					</div>
				</div>
				
				<div class="checkbox" style="">
					<label class="col-sm-2 control-label" style="font-size: 15px"><input type="checkbox"
						name="manager">管理员 
					</label>					
				</div>
				<div><button type="submit" class="btn btn-info" style="margin-left:1S0px;">添加</button></div>
				
			</form>
		</div> -->
		<table class="table table-bordered" style="margin-top: 10px">
			<tr>
				<th class="col-md-3">用户名</th>
				<th class="col-md-3">全名</th>
				<th class="col-md-3">是否为管理员</th>
				<th class="col-md-3"></th>
			</tr>
			<%=sb.toString()%>
		</table>
	</div>
</body>
</html>