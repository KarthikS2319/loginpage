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
@WebServlet("/login")
public class WebLogin extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//to refer the file type 
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		//get user email and password from HTML page
		String uEmail=req.getParameter("email");
		String uPassword=req.getParameter("pwd");
		
		//it check the database whether the email and password correct or not
		if(FetchData.getData(uEmail,uPassword)==true)
		{
			//creating session for login to stay 
			HttpSession session=req.getSession();
			session.setAttribute("Email", uEmail);
			resp.sendRedirect("index.jsp");
		}
		else
		{
			req.getRequestDispatcher("login.html").include(req, resp);
			out.print("email or password is wrong");
		}
	}
}
