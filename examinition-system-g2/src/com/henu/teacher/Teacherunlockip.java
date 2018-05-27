package com.henu.teacher;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.henu.bean.Student;
import com.henu.utils.DaoFactory;

/**
 * Servlet implementation class Teacherunlockip
 */
@WebServlet("/Teacherunlockip")
public class Teacherunlockip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacherunlockip() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String stu_id=request.getParameter("id");
		List<Student> list=DaoFactory.getStudentDaoInstance().search();
		for(Student stu:list)
		{
			if(stu.getStu_id().equals(stu_id))
			{
				stu.setStu_ip("null");
				int result=DaoFactory.getStudentDaoInstance().update(stu, stu_id);
				if(result>0)
				{
					HttpSession session=request.getSession();
					response.sendRedirect("main_view/teacher/teacher_unlocked.jsp");
				}
			}
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
