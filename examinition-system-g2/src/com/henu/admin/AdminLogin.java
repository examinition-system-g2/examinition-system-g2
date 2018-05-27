package com.henu.admin;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.henu.bean.DesUtils;
import com.henu.utils.DaoFactory;
import com.henu.utils.DbUtil;

/**
 * 
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获取用户名和密码
		String username = request.getParameter("ad_id");
		String password = request.getParameter("ad_username");
		if(!username.equals("")&&!password.equals(""))
		{
			try {
				DesUtils des = new DesUtils("leemenz");
				password = des.encrypt(password);
				System.out.println("成功");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("失败");
			}
			String login = DaoFactory.getTeacherDaoInstance().login(username, password);
			if (login.equals("admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("main_view/admin/admin_about.jsp");
			} else
				response.sendRedirect("login/main_login.jsp");
		}else
			response.sendRedirect("login/main_login.jsp");
		
	}

}
