package com.henu.teacher;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.henu.bean.Exam;
import com.henu.utils.DaoFactory;
import com.henu.utils.DbUtil;

/**
 * Servlet implementation class teacher_clearexam
 */
@WebServlet("/teacher_clearexam")
public class teacher_clearexam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public teacher_clearexam() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String examname = request.getParameter("examname");
		String id = request.getParameter("id");
		Exam exam = DaoFactory.getExamDaoInstance().search(examname);
		exam.setE_clear(true);
		DaoFactory.getExamDaoInstance().update(exam, examname);
		DaoFactory.getExamDaoInstance().delete(examname);
		try {
			String infosql = "delete from information";
			DbUtil.executeUpdate(infosql);
			DbUtil.close();
			String sql = "delete from student where stu_exam='" + examname + "'";
			DbUtil.executeUpdate(sql);
			DbUtil.close();
			String savePath = this.getServletContext().getRealPath("/WEB-INF/upload/" + examname);
			File file = new File(savePath);
			// 判断上传文件的保存目录是否存在
			if (file.exists()) {// 判断文件是否存在
				if (file.isFile()) {// 判断是否是文件
					file.delete();// 删除文件
				} 
				if (file.isDirectory()) {// 否则如果它是一个目录
					File[] files = file.listFiles();// 声明目录下所有的文件 files[];
					for (int i = 0; i < files.length; i++) {// 遍历目录下所有的文件
						boolean b=files[i].delete();// 把每个文件用这个方法进行迭代
						System.out.println(files[i].getName()+":"+b);
					}
					System.out.println(file.getName());
					file.delete();// 删除文件夹
				}
			} else {
				System.out.println("所删除的文件不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			if(id.equals("1"))
				response.sendRedirect("main_view/teacher/teacher_exam_after.jsp");
			else if(id.equals("2"))
				response.sendRedirect("main_view/teacher/teacher_exam_before.jsp");
			else
				response.sendRedirect("main_view/admin/admin_clearexam.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
