<%@page import="com.henu.utils.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*,com.henu.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>考后操作</title>
</head>
<body>
	<%
		StringBuffer sb = new StringBuffer();
		//查询所有考试信息
		List<Exam> list = DaoFactory.getExamDaoInstance().search();
		for (Exam exam : list) {
			sb.append("<tr><td>");
			sb.append(exam.getE_name());
			sb.append("</td><td>");
			sb.append(exam.getE_starttime());
			sb.append("</td><td>");
			sb.append(exam.getE_teacher());
			sb.append("</td><td>");
			if (exam.getE_examination().equals("null"))
				sb.append("");
			else
				sb.append("<span class='glyphicon glyphicon-ok'></span>");
			sb.append("</td><td>");//glyphicon glyphicon-ok
			if (!exam.getE_autostart())
				sb.append("");
			else
				sb.append("<span class='glyphicon glyphicon-ok'></span>");
			sb.append("</td><td>");
			if (!exam.getE_isend())
				sb.append("");
			else
				sb.append("<span class='glyphicon glyphicon-ok'></span>");
			sb.append("</td><td>");
			if (!exam.getE_file())
				sb.append("");
			else
				sb.append("<span class='glyphicon glyphicon-ok'></span>");
			sb.append("</td><td>");
			if (!exam.getE_clear())
				sb.append("");
			else
				sb.append("<span class='glyphicon glyphicon-ok'></span>");
			sb.append("</td><td>");
			if (!exam.getE_isstart() && !exam.getE_isend()) {
				sb.append("<span>考试未开启</span>");
			} else {
				if (!exam.getE_isend())
					sb.append("<a href='../../teacher_stopexam?examname=" + exam.getE_name()
							+ "&id=1' title='停止考试' class='btn btn-primary'>停止考试</a>");
				else if (!exam.getE_clear()) {
					sb.append("<a href='../../teacher_downloadexam?examname=" + exam.getE_name()
							+ "&id=1' title='下载考生答案' class='btn btn-primary'>考生提交</a>");
					sb.append("&nbsp;&nbsp;<a href='../../teacher_clearexam?examname=" + exam.getE_name()
							+ "&id=1' title='清理考试' class='clear_btn btn btn-primary'>清理考试</a>");
				} else
					sb.append("");
			}
			sb.append("</td></tr>");
		}
	%>
	<jsp:include page="teacher_index.jsp"></jsp:include>
	<div class="container">
		<table class="table table-bordered" style="margin-top: 10px">
			<tr>
				<th class="col-md-1">考试名称</th>
				<th class="col-md-2">考试时间</th>
				<th class="col-md-1">创建人</th>
				<th class="col-md-1">上传试卷</th>
				<th class="col-md-1">自动开始</th>
				<th class="col-md-1">已结束</th>
				<th class="col-md-1">已归档</th>
				<th class="col-md-1">已清理</th>
				<th class="col-md-2"></th>
			</tr>
			<%=sb.toString()%>
		</table>
	</div>
	<script type="text/javascript">
		$(".clear_btn").click(function() {
			var a = confirm("确定清楚考试资料?");

			if (a == true) {
				return true;
			} else {
				return false;
			}
		})
	</script>
</body>
</html>