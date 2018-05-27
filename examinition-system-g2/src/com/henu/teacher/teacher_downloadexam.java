package com.henu.teacher;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.henu.bean.Exam;
import com.henu.utils.DaoFactory;
import com.henu.utils.ToZip;

/**
 * Servlet implementation class teacher_downloadexam
 */
@WebServlet("/teacher_downloadexam")
public class teacher_downloadexam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacher_downloadexam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String examname = request.getParameter("examname");
		String id = request.getParameter("id");
		Exam exam = DaoFactory.getExamDaoInstance().search(examname);
		exam.setE_file(true);
		String savePath = this.getServletContext().getRealPath("/WEB-INF/upload/" + examname);
		String zipFilePath=this.getServletContext().getRealPath("/WEB-INF/upload");
		boolean flag = ToZip.fileToZip(savePath, zipFilePath, examname);
		if(flag)
			System.out.println("压缩成功");
		else
			System.out.println("压缩失败");
		int result=DaoFactory.getExamDaoInstance().update(exam, examname);
		//下载开始
        //得到要下载的文件名
        String fileName = examname+".zip";
        fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
        //得到要下载的文件
        File file = new File(zipFilePath + "\\" + fileName);
        //设置响应头，控制浏览器下载该文件
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        //读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(zipFilePath + "\\" + fileName);
        //创建输出流
        OutputStream out = response.getOutputStream();
        //创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while((len=in.read(buffer))>0){
            //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        //关闭输出流
        out.close();
		//下载结束
        if(result>0)
		{
			if(id.equals("1"))
				response.sendRedirect("main_view/teacher/teacher_exam_after.jsp");
			else
				response.sendRedirect("main_view/admin/admin_clearexam.jsp");
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
