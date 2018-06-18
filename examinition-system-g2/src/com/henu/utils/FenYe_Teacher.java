package com.henu.utils;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.henu.bean.Teacher;

/**
 * Servlet implementation class FenYe_Teacher
 */
@WebServlet("/FenYe_Teacher")
public class FenYe_Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FenYe_Teacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int pages; // 总页数
		int count=0;// 记录总条数
		List<Teacher> list=DaoFactory.getTeacherDaoInstance().search();
		for(Teacher t:list)
		{
			count++;
		}
		
		//查询每页显示记录数
		String sql = "SELECT * FROM systemconf";
		String confPageSize = null;
		System.out.println(sql);
		ResultSet rs;
		try{
			rs = DbUtil.executeQuery(sql);
			while(rs.next()){
				confPageSize = rs.getString("pageSize");
			}
			DbUtil.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		int pageSize = Integer.parseInt(confPageSize); // 设置每页显示5条记录
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


		StringBuilder sb1 = new StringBuilder(); // 存放本页教师信息
		// 取出本页的数据
		for (int i = (currpage - 1) * pageSize; i < list.size() && i < currpage * pageSize; i++) {
			Teacher teacher = list.get(i);
			sb1.append("<tr><td>");
			sb1.append(teacher.getT_username());
			sb1.append("</td><td>");
			sb1.append(teacher.getT_name());
			sb1.append("</td><td>");
			/*if(teacher.getT_manager() == true)
			{
				sb1.append("<td>" + "是" + "</td></tr>");
			}
			else {
				sb1.append("<td>" + "否" + "</td></tr>");
			}*/
			if(teacher.getT_manager()){
				sb1.append("<span class=\"glyphicon glyphicon-ok\"></span>");
			}else{
				sb1.append("");
			}
			//添加对教师的编辑和删除功能  ---@yy
			sb1.append("</td><td>");
			sb1.append("<a href='admin_editTeacher.jsp?edit_username="+teacher.getT_username()+"&edit_name="+teacher.getT_name()+"'><span class='glyphicon glyphicon-edit' title='编辑'></span></a>");
			sb1.append("&nbsp&nbsp&nbsp");
			sb1.append("<a href='../../admin_deleteTeacher?delete_username="+teacher.getT_username()+"'><span class='glyphicon glyphicon-trash' title='删除'></span></a>");
			sb1.append("</td></tr>");
		}
		
		session.setAttribute("info", sb1);
		
		StringBuilder sb = new StringBuilder(); // 存放页数信息
		
		for (int i = 1; i <= pages; i++) {
			// 构建分页导航条
			if (i == currpage) {
				sb.append("<li class='active page-item'><a  class='page-link' href='#'>" + i + "</a></li>");
			} else {
				sb.append("<li class='page-item'><a  class='page-link' href='../../FenYe_Teacher?page=" + i +	"'>" + i + "</a></li>");
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
		response.sendRedirect("main_view/admin/admin_manageteacher.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
