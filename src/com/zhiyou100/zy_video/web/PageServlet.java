package com.zhiyou100.zy_video.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		response.sendRedirect(request.getContextPath()+"/behind/admin/adminLogin.action");
//		response.sendRedirect(request.getContextPath()+"/behind/admin/index.action");
//		response.sendRedirect(request.getContextPath()+"/behind/course/courseList.action");
		request.getRequestDispatcher("/index.do").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
