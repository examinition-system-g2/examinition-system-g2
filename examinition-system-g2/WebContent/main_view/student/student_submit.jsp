<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*,java.util.*,com.henu.bean.*,com.henu.utils.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提交试卷</title>
<script type="text/javascript">
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
		String stu_id=(String)session.getAttribute("stu_id");
		String file="";
		//查询此用户名和密码是否存在
		//String sqlSearch = "select * from student where stu_id='"+stu_id+"'";	
		StringBuffer sb=new StringBuffer();
		try{
			List<Student> list =DaoFactory.getStudentDaoInstance().search();
			
			for(Student student : list)
			{
				if(student.getStu_id().equals(stu_id))
				{
					file=student.getStu_submit();
					System.out.print(file);
					do
					{
						String filename=file.substring(file.indexOf("%")+1,file.indexOf("@"));
						file=file.substring(file.indexOf("@")+1);
						String filesize=file.substring(0,file.indexOf("@"))+"bit";
						file=file.substring(file.indexOf("@")+1);
						String filetime="";
						if(file.contains("%"))
						{
							filetime=file.substring(0,file.indexOf("%"));
							file=file.substring(file.indexOf("%"));
						}else{
							filetime=file;
						}
						sb.append("<tr><td>");
						sb.append(filename);
						sb.append("</td><td>");
						sb.append(filesize);
						sb.append("</td><td>");
						sb.append(filetime);
						sb.append("</td><tr>");
					}while(file.contains("%"));
				}
			}	
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	%>
	<jsp:include page="student_head.jsp"></jsp:include>
	<div class="container">
		<h3><strong>已上传文件列表</strong></h3>
			<table class="table table-bordered" style="margin-top: 10px">
				<tr>
					<th class="col-md-4">文件名</th>
					<th class="col-md-4">文件大小</th>
					<th class="col-md-4">上传时间</th>
				</tr>
				<%=sb.toString() %>
			</table>
		<h3>
			<strong>答案上传</strong>
		</h3>
		<form class="form-inline" role="form" name="file"  action="../../student_Upload" enctype="multipart/form-data" method="post"
			style="margin-left: 20px; margin-top: 12px; font-size: 18px">
			<input  class="btn btn-default" type="file" id="file" name="file" value="浏览..." />
			<button type="submit" onclick="return checkupload()" style="margin-top: 10px;" class="btn btn-info">上传</button>
		</form>
	</div>
</body>
</html>