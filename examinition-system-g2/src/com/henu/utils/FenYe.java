package com.henu.utils;

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

/**
 * Servlet implementation class FenYe
 */
@WebServlet("/FenYe")
public class FenYe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FenYe() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Exam> list2=DaoFactory.getExamDaoInstance().search();
		String  examname=(String)request.getParameter("exam");
		System.out.println(examname);
		String flag="1";
		session.setAttribute("exam", null);
		if(examname==null)
		{
			flag="2";
			for(Exam exam:list2)
			{
				if(exam.getE_isstart())
					examname=exam.getE_name();
			}
		}
		
		int pages; // 总页数
		int count=0;// 记录总条数
		List<Student> list=DaoFactory.getStudentDaoInstance().search();
		for(Student s:list)
		{
			if(s.getStu_exam().equals(examname))
				count++;
		}
		int pageSize = 5; // 设置每页显示5条记录
		// 计算总页数
		if (count % pageSize == 0) {
			pages = count / pageSize; // 总页数
		} else {
			pages = count / pageSize + 1; // 总页数
		}
		
		int currpage = 1; // 当前页码

		
		String page = request.getParameter("page");
		if (page != null) { // 判断传递的页码是否存在
			int t = Integer.parseInt(page);
			if(t > 0 && t < pages)
				currpage = t; // 将点击的页码号赋给当前页码
			if(t==0)
				currpage = 1;
			if(t==pages)
				currpage = pages;
		}


		StringBuilder sb1 = new StringBuilder(); // 存放本页图书信息
		// 取出本页的数据
		for (int i = (currpage - 1) * pageSize; i < list.size() && i < currpage * pageSize; i++) {
			Student student = list.get(i);
			sb1.append("<tr><td>"+student.getStu_id()+"</td>");
			sb1.append("<td>"+student.getStu_name()+"</td>");
			sb1.append("<td>"+student.getStu_class()+"</td>");
			//在学生信息显示中添加该生属于哪场考试	--@yy
			sb1.append("<td>"+student.getStu_exam()+"</td></tr>");
		}
		
		session.setAttribute("info", sb1);
		
		StringBuilder sb = new StringBuilder(); // 存放页数信息
		
		for (int i = 1; i <= pages; i++) {
			// 构建分页导航条
			if (i == currpage) {
				sb.append("<li class='active page-item'><a  class='page-link' href='#'>" + i + "</a></li>");
			} else {
				if(flag.equals("1"))
					sb.append("<li class='page-item'><a  class='page-link' href='../../FenYe?page=" + i + "&exam="+examname+"'>" + i + "</a></li>");
				else
					sb.append("<li class='page-item'><a  class='page-link' href='../../FenYe?page=" + i +	"'>" + i + "</a></li>");
			}
		}
		if(currpage == 1){
			session.setAttribute("current1", 0);
		}else{
			session.setAttribute("current1", currpage-1);
		}
		
		if(currpage == pages){
			session.setAttribute("current2", pages);
		}else{
			session.setAttribute("current2", currpage+1);
		}

		session.setAttribute("bar", sb.toString());
		// 跳转到显示界面
		session.setAttribute("studentinfo", examname);
		if(flag.equals("1"))
			response.sendRedirect("main_view/teacher/teacher_continueadd.jsp");
		else
		{
			response.sendRedirect("main_view/teacher/teacher_studentinfo.jsp");
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
