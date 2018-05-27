<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.sql.*,java.util.*,com.henu.bean.*,com.henu.utils.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		setInterval("showInfo()", 1000);
	});

	function showInfo() {
		$.ajax({
			type : "post",
			url : "../../ShowInformation",
			success : function(text) {
				$("#show").html(text);
			}
		});
	}

	function checkupload() {
		var file = document.getElementById("file").value;
		if (file == null || file == "")
			return false;
		else
			return true;
	}
</script>
</head>
<body>
	<%
		String stu_id = (String) session.getAttribute("stu_id");
		String examname = "";
		//查询此用户名和密码是否存在
		//String sqlSearch = "select * from student where stu_id='"+stu_id+"'";

		List<Student> list = DaoFactory.getStudentDaoInstance().search();

		for (Student student : list) {
			if (student.getStu_id().equals(stu_id)) {
				examname = student.getStu_exam();
				session.setAttribute("examname", examname);
			}
		}
	%>
	<jsp:include page="student_head.jsp"></jsp:include>
	<div class="container">
		<div class="jumbotron">
			<div>
				<h3>
					<strong>试卷下载</strong>
				</h3>
				<!-- 隐藏div标签 -->
				<div class="alert"
					style="display:<%if (!examname.equals(""))
				out.print("none");%> ;background-color: gray; margin-top: 5px">
					<span style="color: white;">本次考试没有电子试卷</span>
				</div>
				<!-- 显示a标签 -->
				<a class="btn btn-primary btn-lg" role="button" href="../../exam_download"
					style="margin-left: 10px;display: <%if (examname.equals(""))
				out.print("none");%>"><span
					class="glyphicon glyphicon-eye-open"></span>下载查看</a>
			</div>
			<div >
				<h3>
					<strong>答案上传</strong>
				</h3>
				<span style="font-size: 18px">请按照考试要求将答案文件打包，再次进行上传。同名文件多次上传将会覆盖。</span>
				<form class="form-inline" name="file" role="form"
					action="../../student_Upload" enctype="multipart/form-data"
					method="post"
					style="margin-left: 20px; margin-top: 12px; font-size: 18px">
					<input type="file" id="file" name="file">
					<button type="submit" onclick="return checkupload()"
						style="margin-top: 10px;" class="btn btn-primary btn-lg">上传</button>
				</form>
			</div>
		</div>

		<div class="col-md-6">
			<table id="show" class="table" style="color: red">

			</table>
		</div>

	</div>




</body>
</html>