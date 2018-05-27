package com.henu.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.henu.utils.DbUtil;

/**
 * cjy
 * Servlet implementation class ShowInformation
 */
@WebServlet("/ShowInformation")
public class ShowInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String sqlSearch = "select * from information";
		PrintWriter out = response.getWriter();
		ResultSet rs = null;
		rs = DbUtil.executeQuery(sqlSearch);
		StringBuffer sb = new StringBuffer();
		try {
			while (rs.next()) {
				sb.append("<tr><td>"+rs.getString(1) +"</td><td> </td><td>"+ rs.getString(2) + "</td></tr>");
			}
			DbUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(sb.toString());
		out.print(sb.toString());
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
