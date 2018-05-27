package com.henu.admin;

import java.io.IOException;
import java.sql.*;

import com.henu.bean.DesUtils;
import com.henu.bean.Teacher;
import com.henu.utils.DaoFactory;
import com.henu.utils.DbUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tz
 * Servlet implementation class admin_addTeacher
 */
@WebServlet("/admin_addTeacher")
public class admin_addTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_addTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置请求的字符编码utf-8
		request.setCharacterEncoding("utf-8");
		//将获取的表单数据存入Teacher
		Teacher teacher=new Teacher();
		boolean isManager = false;
		teacher.setT_username(request.getParameter("username"));
		teacher.setT_pwd(request.getParameter("password"));
		teacher.setT_name(request.getParameter("name"));
		String[] manager = request.getParameterValues("manager");
		//判断manager数组是否为空
		if(manager == null){
			isManager = false;
		}else{
			isManager = true;
		}
		teacher.setT_manager(isManager);
		int result=DaoFactory.getTeacherDaoInstance().add(teacher);
		//如果执行成功跳转页面
		if(result > 0){
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
