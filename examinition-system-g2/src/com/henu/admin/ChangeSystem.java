package com.henu.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.henu.bean.Conf;

/**
 * Servlet implementation class ChangeSystem
 */
@WebServlet("/ChangeSystem")
public class ChangeSystem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeSystem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		
		Conf conf = new Conf();
		conf.setTime(request.getParameter("time").toString());
		System.out.println(request.getParameter("time").toString());
		conf.setPageSize(request.getParameter("pageSize").toString());
		System.out.println(request.getParameter("pageSize").toString());
		conf.setManualTime(request.getParameter("manualTime").toString());
		System.out.println(request.getParameter("manualTime").toString());
		conf.setMinSize(request.getParameter("minSize").toString());
		System.out.println(request.getParameter("minSize").toString());
		conf.setMaxSize(request.getParameter("maxSize").toString());
		System.out.println(request.getParameter("maxSize").toString());
		conf.save();
		System.out.println("save");
		
		response.sendRedirect("main_view/admin/admin_system.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
