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
 * Servlet implementation class ChangeTeacherPwd
 */
@WebServlet("/ChangeTeacherPwd")
public class ChangeTeacherPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public ChangeTeacherPwd() {
        super();
        // TODO Auto-generated constructor stub
    }*/
	public ChangeTeacherPwd() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("teacher");
		System.out.println(session.getAttribute("teacher"));
		String oldPwd = request.getParameter("oldPwd");
		String newPwd1 = request.getParameter("newPwd1");
		String newPwd2 = request.getParameter("newPwd2");
		System.out.println(newPwd1 + newPwd2);
		System.out.println(oldPwd);
		try {
			DesUtils des = new DesUtils("leemenz");
			newPwd1 = des.encrypt(newPwd1);
			System.out.println(newPwd1);
			newPwd2	= des.encrypt(newPwd2);
			System.out.println(newPwd2);
			oldPwd	= des.encrypt(oldPwd);
			System.out.println(oldPwd);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("失败");
		}
		Teacher teacher = DaoFactory.getTeacherDaoInstance().search(id);
		if (teacher.getT_pwd().equals(oldPwd) && newPwd1.equals(newPwd2) && newPwd1 != null) {
			teacher.setT_pwd(newPwd1);
			int result=DaoFactory.getTeacherDaoInstance().update(teacher, id);
			if(result>0)
				session.setAttribute("teacher_error", "<script>alert('密码修改成功');</script>");
				response.sendRedirect("main_view/teacher/teacher_about.jsp");
		} else {
			
			session.setAttribute("teacher_error", "<script>alert('输入原密码错误或修改后两次密码不相同');</script>");
			response.sendRedirect("main_view/teacher/teacher_about.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
