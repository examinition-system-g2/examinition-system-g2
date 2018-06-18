package com.henu.teacher;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

import com.henu.bean.Exam;
import com.henu.utils.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.henu.utils.DbUtil;

/**
 * Servlet implementation class teacher_addexam
 */
@WebServlet("/teacher_addexam")
public class teacher_addexam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public teacher_addexam() {
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
		String exam_starttime = request.getParameter("exam_starttime");
		String[] exam_autostart = request.getParameterValues("exam_autostart");
		HttpSession session=request.getSession();
		String teacher=(String)session.getAttribute("teacher");
		boolean autostart = false;
		if (exam_autostart != null) {
			autostart = true;
		}
		/*//判断当前输入的考试名是否已经存在
		Exam exist_examname=DaoFactory.getExamDaoInstance().search(examname);
		if(exist_examname != null) {
			response.sendRedirect("main_view/teacher/teacher_exam_before.jsp");
		}*/
		
		Exam exam=new Exam();
		exam.setE_name(examname);
		exam.setE_starttime(exam_starttime);
		exam.setE_autostart(autostart);
		exam.setE_teacher(teacher);
		
		int result=DaoFactory.getExamDaoInstance().add(exam);
		// 如果执行成功跳转页面
		if (result > 0) {
			response.sendRedirect("main_view/teacher/teacher_exam_before.jsp");
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
