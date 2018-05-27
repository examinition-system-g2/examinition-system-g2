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
import com.henu.bean.Student;
import com.henu.utils.DaoFactory;
import com.sun.crypto.provider.RSACipher;

/**
 * Servlet implementation class teacher_unlocked
 */
@WebServlet("/teacher_unlocked")
public class teacher_unlocked extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacher_unlocked() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		List<Student> list=DaoFactory.getStudentDaoInstance().search();
		StringBuffer sb=new StringBuffer();
		String stu_id=request.getParameter("id");
		for(Student stu:list)
		{
			if(stu.getStu_id().equals(stu_id))
			{
				sb.append("<tr><td>"+stu.getStu_id()+"</td>");
				sb.append("<td>"+stu.getStu_name()+"</td>");
				sb.append("<td>"+stu.getStu_class()+"</td>");
				
				if(!stu.getStu_ip().equals("null"))
				{
					sb.append("<td>"+stu.getStu_ip()+"</td>");
					sb.append("<td>"+"<a href='../../Teacherunlockip?id="+stu.getStu_id()+"' class='glyphicon glyphicon-edit btn btn-info'>解除绑定</a>"+"</td></tr>");
				}
					
				else
					sb.append("<td>未绑定ip</td><td></td></tr>");
			}
		}
		request.getSession().setAttribute("unlock", sb);
		response.sendRedirect("main_view/teacher/teacher_unlocked.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
