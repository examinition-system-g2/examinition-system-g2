package com.henu.teacher;

import java.io.IOException;

import com.henu.bean.DesUtils;
import com.henu.utils.DaoFactory;
import com.henu.utils.DbUtil;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TeacherLogin
 */
@WebServlet("/TeacherLogin")
public class TeacherLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("t_id");  //获得教师的ID
		String pwd = request.getParameter("t_username");  //获得教师的口令
		if(!id.equals("")&&!pwd.equals(""))
		{
			try {
				DesUtils des = new DesUtils("leemenz");
				pwd=des.encrypt(pwd);
				System.out.println("成功");
				System.out.println(pwd);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("失败");
			}
			String login=DaoFactory.getTeacherDaoInstance().login(id, pwd);
			if(login.equals("teacher")||login.equals("admin"))
			{
				HttpSession session=request.getSession();
				session.setAttribute("teacher", id);
				response.sendRedirect("main_view/teacher/teacher_about.jsp");
			}else{
				System.out.println("Here!");
				response.sendRedirect("login/main_login.jsp");
			}
		}else
		{
			response.sendRedirect("login/main_login.jsp");
		}
		
	}

}
