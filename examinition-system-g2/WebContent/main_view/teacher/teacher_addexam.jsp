<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="java.sql.*,java.util.*,com.henu.bean.*,com.henu.utils.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="./css/bootstrap-datetimepicker.min.css" rel="stylesheet"
	media="screen">
<script type="text/javascript" src="./css/bootstrap-datetimepicker.js"
	charset="UTF-8"></script>
<title>添加考试</title>
<script type="text/javascript">
	function checkupload() {
		var file = document.getElementById("file").value;
		if (file == null || file == "")
			return false;
		else
			return true;
	}
	
	
	/* //获取上传文件的文件名（有些浏览器默认取到的value值是路径，这里要把路径删除）   --@yy
	function checkFileName(path){
		var test1 = path.lastIndexOf("/");
		var test2 = path.lastIndexOf("\\");
		var test = Math.max(test1,test2);
		if(test < 0){
			document.getElementById("file").value = path;
		}else{
			document.getElementById("test").value = path.substring(test + 1);//赋值文件名
		}
	} */
</script>
</head>
<body style="background-image:url(../../image/background/h6.jpg);background-size:cover;">
	<%
		String examname=null;
		try{
			examname= request.getParameter("examname");
		}catch(Exception e)
		{
			System.out.println("Encoding");
		}
		
		if (examname == null)
			examname = (String) session.getAttribute("examname");
		session.setAttribute("examname", examname);
		System.out.println(examname);
		//String sqlSearch = "select * from exam where e_name='" + examname + "'";
		String exam_starttime = "";
		String upload = "";
		boolean autostart = false;
		Exam exam = DaoFactory.getExamDaoInstance().search(examname);
		exam_starttime = exam.getE_starttime();
		autostart = exam.getE_autostart();
		upload = exam.getE_examination();
	%>
	<%
		//计算参加考试的学生人数
		int count = 0;
		List<Student> list=DaoFactory.getStudentDaoInstance().search();
		for(Student student:list)
		{
			if(student.getStu_exam().equals(examname))
			{
				count++;
			}
		}
	%>
	<jsp:include page="teacher_index.jsp"></jsp:include>
	<div class="container">
		<div class="col-md-12" style="padding-left: 5px; padding-right: 5px;">
			<div class="alert navbar-inverse "
				style="background-color: #eeeeee; height: 200px; margin-top:10px;">
				<strong style="margin-left: 20px; font-size: 18px">编辑考试信息</strong>
				<form class="form-inline" role="form" action="../../teacher_editexam"
					style="margin-left: 20px; margin-top: 5px;">
					<div class="form-group">
						<input type="text" class="form-control" style="width: 250px"
							value="<%=examname%>" placeholder="考试名称*" name="examname">
					</div>
					<div class="form-group">
					<div class="input-group date form_date" data-link-field="dtp_input2">
						<input style="height: 35px" type="text" class="form-control"
							placeholder="考试时间*" name="exam_starttime"
							value="<%=exam_starttime%>"> <span
							class="input-group-btn">
							<!-- <span class="input-group-addon">
								<i class="glyphicon glyphicon-remove "></i>
							</span> 
							<span class="input-group-addon"> 
								<i class="glyphicon glyphicon-calendar"></i>
							</span> -->
							<button style="height: 35px" class="btn btn-defau;t"
								type="button">
								<span class="glyphicon glyphicon-remove"></span>
							</button>
							<button style="height: 35px" class="btn btn-default"
								type="button">
								<span class="glyphicon glyphicon-calendar"></span>
							</button>
						</span>
					</div>
					</div>
					<br />
					<div class="checkbox" style="padding-top: 8px">
						<label style="font-size: 15px"> <input
							name="exam_autostart" type="checkbox"
							<%if (autostart)
				out.print("checked='checked'");%>>自动开始
						</label>
					</div>
					<br />
					<button type="submit" style="margin-top: 8px" class="btn btn-primary">修改</button>
				</form>
			</div>
			
			<div class="col-md-12" style="padding-left: 5px; padding-right: 5px;">
				<div class="alert navbar-inverse "
					style="background-color: #eeeeee;">
					<strong style="margin-left: 20px; font-size: 18px">上传试卷</strong>
					<div>
						<strong class="alert alert-warning" style="line-height: 50px;padding-left: 25px;color: black;margin-top: 8px;font-size: 15px;display: <%if (upload.equals("null"))
				out.print("none");%>">
						已经上传过试卷，再次上传后原试卷将不可访问<a class="btn btn-primary"
						href="../../exam_download" style="margin-left: 10px"><span
						class="glyphicon glyphicon-eye-open"></span>下载查看</a>
					</strong>
					</div>
					
					
					
					<form class="form-inline" role="form" action="../../exam_upload"
						enctype="multipart/form-data" method="post"
						style="margin-left: 20px; margin-top: 8px;">
						<input type="file" id="file" name="file" />
						<button type="submit" onclick="return checkupload()" href="../../exam_upload"
							style="margin-top: 5px" class="btn btn-primary">上传</button>
					</form>
				</div>
			</div>
			<div class="col-md-12" style="padding-left: 5px; padding-right: 5px;">
				<div class="alert navbar-inverse "
					style="background-color: #eeeeee; height: 140px; margin-top: ;">
					<strong style="margin-left: 20px; font-size: 18px">导入学生名单</strong>
					<form class="form-inline" role="form"
						style="margin-left: 20px; margin-top: 12px;">
						<label style="font-size: 12px">目前设定参加此次考试的学生人数：</label> <span><%=count%></span>
						<br /> <a href="../../FenYe?exam=<%=examname %>" class="btn btn-primary">继续导入</a>
					</form>
				</div>
			</div>
			<div class="col-md-12" style="padding-left: 5px; padding-right: 5px;">
				<div class="alert navbar-inverse "
					style="background-color: #eeeeee; height: 140px; margin-top: ;">
					<strong style="margin-left: 20px; font-size: 18px">开启考试</strong>
					<form class="form-inline" role="form" action="../../exam_Start"
						style="margin-left: 20px; margin-top: 12px;">
						<!-- <span style="font-size: 12px; color: #f7AE3F">尚未上传试卷</span> <br /> -->
						<button type="submit" style="margin-top: 12px"
							class="btn btn-warning">
							<span class="glyphicon glyphicon-off"></span>开启
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$('.form_date').datetimepicker({
			format : 'yyyy-mm-dd hh:ii',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0,
			minView : 0,
			minuteStep : 10
		});
	</script>
	
</body>
</html>