package com.henu.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.henu.bean.DesUtils;
import com.henu.bean.Teacher;
import com.henu.utils.DaoFactory;

/**
 * Servlet implementation class EditTeacherPwd
 */
@WebServlet("/EditTeacherPwd")
public class EditTeacherPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTeacherPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//将获取的表单数据存入Teacher
		HttpSession session=request.getSession();
		Teacher teacher=new Teacher();
		boolean isManager = false;
		String username=request.getParameter("edit_teacher_username");
		String pwd=request.getParameter("edit_teacher_password");
		try {
			DesUtils des = new DesUtils("leemenz");
			pwd = des.encrypt(pwd);
			System.out.println(pwd);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("失败");
		}
		teacher.setT_pwd(pwd);
		teacher.setT_name(request.getParameter("edit_teacher_name"));
		String[] manager = request.getParameterValues("edit_teacher_manage");
		//判断manager数组是否为空
		if(manager == null){
			isManager = false;
		}else{
			isManager = true;
		}
		teacher.setT_manager(isManager);
		int result=DaoFactory.getTeacherDaoInstance().update(teacher, username);
		
		//如果执行成功跳转页面
		if(result > 0){
			session.setAttribute("pwderror", "<script>alert('密码修改成功');</script>");
			response.sendRedirect("main_view/admin/admin_manageteacher.jsp");
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
