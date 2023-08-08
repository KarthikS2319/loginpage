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
@WebServlet("/forgot")
public class WebForgotpwd extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//to refer the file type
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();

		String uEmail=req.getParameter("email");
		if(Forgotpwd.checkEmail(uEmail)==true)
		{
			//creating sessionfor to validate email in changing password
			HttpSession sessionfor=req.getSession();
			sessionfor.setAttribute("email", uEmail);
			resp.sendRedirect("newpwd.html");
		}
		else
		{
			req.getRequestDispatcher("login.html").include(req, resp);
			out.print("invalid email");
		}
	}
}
