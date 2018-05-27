package com.henu.student;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import com.henu.bean.Student;
import com.henu.utils.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * @author:yy
 * Servlet implementation class StudentLofin
 */
@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentLogin() {
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
		request.setCharacterEncoding("utf-8");
		// 获取用户名和密码
		String stu_id = request.getParameter("stu_id");
		String stu_name = request.getParameter("stu_username");
		String stu_exam=(String)request.getSession().getAttribute("examname");
		String ip = request.getHeader("x-forwarded-for");
		    if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
		        ip = request.getHeader("Proxy-Client-IP");
		    }
		    if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
		        ip = request.getHeader("WL-Proxy-Client-IP");
		    }
		    if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
		        ip = request.getHeader("X-Real-IP");
		    }
		    if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
		        ip = request.getRemoteAddr();
		    }
		    boolean can=true;
			List<Student> list=DaoFactory.getStudentDaoInstance().search();
		    for(Student stu:list)
		    {
		    	if(stu.getStu_id().equals(stu_id))
		    	{
		    		if(!stu.getStu_ip().equals("null")&&!stu.getStu_ip().equals(ip))
		    			can=false;
		    	}else
		    	{
		    		if(stu.getStu_ip().equals(ip))
		    		can=false;
		    	}
		    }
		System.out.print("学号:" + stu_id + "\n姓名:" + stu_name);
		// 登录确认
		try {
			boolean login = DaoFactory.getStudentDaoInstance().login(stu_id, stu_name);
			if (login&&can) {
				Student student=DaoFactory.getStudentDaoInstance().search(stu_id);
				if(student.getStu_exam().equals(stu_exam))
				{
					student.setStu_ip(ip);
					int result=DaoFactory.getStudentDaoInstance().update(student, stu_id);
					if(result>0)
					{
						HttpSession session = request.getSession();
						session.setAttribute("stu_id", stu_id);
						session.setAttribute("stu_name", stu_name);
						response.sendRedirect("main_view/student/student_about.jsp");
					}
				}
				else
				{
					response.sendRedirect("login/main_login.jsp");
				}
			} else
			{
				response.sendRedirect("login/main_login.jsp");
			}		
		} catch (Exception e) {
			// TODO: handle exception
			response.sendRedirect("login/main_login.jsp");
		}
		
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
