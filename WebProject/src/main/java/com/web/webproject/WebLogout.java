package com.web.webproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//it is used to mapping the URL
@WebServlet("/logout")
public class WebLogout extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//to refer the file type 
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		RequestDispatcher rd=null;
		
		//for closing the session to logout
		HttpSession session=req.getSession();
		if(session!=null)
		{
			session.getAttribute("Email");
			session.invalidate();
			
			rd=req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
			
		}
	}
}
