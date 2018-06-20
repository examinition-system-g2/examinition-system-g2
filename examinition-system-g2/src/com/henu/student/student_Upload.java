package com.henu.student;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.henu.bean.Student;
import com.henu.utils.DaoFactory;
import com.henu.utils.DbUtil;

/**
 * cjy
 * Servlet implementation class student_Upload
 */
@WebServlet("/student_Upload")
public class student_Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student_Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename="",filetime="",filenames="";
		long filesize=0;
		HttpSession session = request.getSession();
		String examname = (String) session.getAttribute("examname");
		//学生学号
		String stuid=(String)session.getAttribute("stu_id");
		//学生信息
		Student student=DaoFactory.getStudentDaoInstance().search(stuid);
		filenames=student.getStu_submit();
		
		// 得到上传文件的保存目录，将上传的文件存放于F目录下，不允许外界直接访问，保证上传文件的安全
		String savePath = this.getServletContext().getRealPath("/WEB-INF/" + examname);
		File file = new File(savePath);
		// 判断上传文件的保存目录是否存在
		if (!file.exists() && !file.isDirectory()) {
			System.out.println(savePath + "目录不存在，需要创建");
			
			// 创建目录
			file.mkdir();
		}
		//删除该学生前面上传的文件
		try{
			Student s =DaoFactory.getStudentDaoInstance().search(stuid);
			String del_file=s.getStu_submit();
			do
			{
				String del_filename=del_file.substring(del_file.indexOf("%")+1,del_file.indexOf("@"));
				del_file=del_file.substring(del_file.indexOf("@")+1);
				del_file=del_file.substring(del_file.indexOf("@")+1);
				if(del_file.contains("%"))
				{
					del_file=del_file.substring(del_file.indexOf("%"));
				}
				String del_path=this.getServletContext().getRealPath("/WEB-INF/upload/" + examname+"/"+del_filename);
				File f = new File(del_path);
				if (f.exists()) {// 判断文件是否存在
					if (f.isFile()) {// 判断是否是文件
						f.delete();// 删除文件
					}
				}
			}while(del_file.contains("%"));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// 消息提示
		String message = "";
		try {
			// 使用Apache文件上传组件处理文件上传步骤：
			// 1、创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 2、创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8");
			// 3、判断提交上来的数据是否是上传表单的数据
			if (!ServletFileUpload.isMultipartContent(request)) {
				// 按照传统方式获取数据
				return;
			}
			// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				// 如果fileitem中封装的是普通输入项的数据

				if (item.isFormField()) {

					String name = item.getFieldName();
					// 解决普通输入项的数据的中文乱码问题
					String value = item.getString("UTF-8");
					// value = new String(value.getBytes("iso8859-1"),"UTF-8");
					System.out.println(name + "=" + value);
				} else {// 如果fileitem中封装的是上传文件
					// 得到上传的文件名称，
					
					filename = item.getName();
					filesize=item.getSize();
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					filetime=df.format(new Date());
					System.out.println(filename);
					if (filename == null || filename.trim().equals("")) {
						continue;
					}
					// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：
					// c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
					// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
					filename = stuid+"_"+filename.substring(filename.lastIndexOf("\\")+1);
					// 获取item中的上传文件的输入流
					InputStream in = item.getInputStream();
					// 创建一个文件输出流
					FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
					// 创建一个缓冲区
					byte buffer[] = new byte[1024];
					// 判断输入流中的数据是否已经读完的标识
					int len = 0;
					// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
					while ((len = in.read(buffer)) > 0) {
						// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\"
						// + filename)当中
						out.write(buffer, 0, len);
					}
					// 关闭输入流
					in.close();
					// 关闭输出流
					out.close();
					// 删除处理文件上传时生成的临时文件
					item.delete();
					message = "文件上传成功";
				}
			}
		} catch (Exception e) {
			message = "文件上传失败";
			e.printStackTrace();
		}
		filenames=filenames+"%"+filename+"@"+filesize+"@"+filetime;
		//更改数据库
		student.setStu_submit(filenames);
		int result=DaoFactory.getStudentDaoInstance().update(student, stuid);
		// 如果执行成功跳转页面
		if (result > 0) {
			response.sendRedirect("main_view/student/student_submit.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
