package com.henu.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.henu.bean.Exam;
import com.henu.utils.DaoFactory;

/**
 * Servlet implementation class exam_Start
 */
@WebServlet("/exam_Start")
public class exam_Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public exam_Start() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String examname = (String) session.getAttribute("examname");
		List<Exam> list=DaoFactory.getExamDaoInstance().search();
		boolean isstart=true;
		for(Exam exam :list)
		{
			if(exam.getE_isstart())
			{
				isstart=false;
			}
		}
		session.setAttribute("exam_start", isstart+"");
		if(isstart)
		{
			Exam exam=DaoFactory.getExamDaoInstance().search(examname);
			exam.setE_isstart(true);
			int result=DaoFactory.getExamDaoInstance().update(exam, examname);
			if(result>0)
				response.sendRedirect("main_view/teacher/teacher_exam_before.jsp");
		}else
		{
			response.sendRedirect("main_view/teacher/teacher_exam_before.jsp");
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
