package com.henu.admin;

import java.io.IOException;
import java.sql.*;

import com.henu.utils.DaoFactory;
import com.henu.utils.DbUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author tz
 * Servlet implementation class admin_deleteTeacher
 */
@WebServlet("/admin_deleteTeacher")
public class admin_deleteTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_deleteTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//获取输入的表单数据
		String username = request.getParameter("delete_username");
		int result=DaoFactory.getTeacherDaoInstance().delete(username);
		if(result>0)
		{
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
