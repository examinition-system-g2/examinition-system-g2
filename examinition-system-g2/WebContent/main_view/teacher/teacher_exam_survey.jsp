<%@page import="com.henu.utils.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.henu.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试情况</title>
</head>
<body>
<%
	List<Exam> list=DaoFactory.getExamDaoInstance().search();
	String  examname=null;
	for(Exam exam:list)
	{
		if(exam.getE_isstart())
			examname=exam.getE_name();
	}
	List<Student> list2=DaoFactory.getStudentDaoInstance().search();
	int all_count=0;
	int login_count=0;
	int submit_count=0;
	for(Student s:list2)
	{
		if(s.getStu_exam().equals(examname))
		{
			all_count++;
			if(!s.getStu_ip().equals("null"))
			{
				login_count++;
			}
			if(!s.getStu_submit().equals("null"))
			{
				submit_count++;
			}
		}
			
	}
	int null_login=all_count-login_count;
	int null_submit=all_count-submit_count;
%>
<jsp:include page="teacher_index.jsp"></jsp:include>
<div class="container">
	<div class="col-md-12" style="padding-left: 5px; padding-right: 5px;display: <%if(examname==null) out.print("null");%>>">
			<div class="alert navbar-inverse "
				style="background-color: #eeeeee; height: 200px; margin-top: 10px;">
				<strong style="margin-left: 20px; font-size: 18px">
				<span>考试 </span><%if(examname!=null) out.print(examname);%><!--  得到该场考试的信息-->
				进行情况：</strong>
		
				<p style="margin-left:20px ;margin-top:12px;">参加考试的学生总数:<span><%=all_count %></span><!-- 得到参加的总人数 -->
				</p>
				<p style="margin-left:20px;margin-top:12px;">已登录学生数量:<span><%=login_count %></span><!-- 得到已经登录的总人数 -->，
				未登录的学生数量：<span><%=null_login %></span><!-- 得到未登录的总人数，两者相减 -->
				</p>
				<p style="margin-left:20px;margin-top:12px;">已登录学生中，提交文件学生数量:<span><%=submit_count %></span><!-- 得到提交文件的学生数量-->，
				未提交文件学生的数量：<span><%=null_submit %></span><!-- 两者相减 -->
				</p>
			</div>
			</div>
			</div>
</body>
</html>