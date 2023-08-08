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
@WebServlet("/createpwd")
public class WebCreatePassword extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//to refer the file type
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		WebLogic webLogic=new WebLogic();
		HttpSession sessionfor=req.getSession();
		
		String email=(String) sessionfor.getAttribute("email");
		String pwd1=req.getParameter("newpassword");
		String pwd2=req.getParameter("re-newpassword");
		if(pwd1.equals(pwd2))
		{
			if(webLogic.strongPass(pwd2)==true)
			{
				//password to encrypt password
				String password=webLogic.encryption(pwd1);
				boolean checkpwd=insertPassword.insertpwd(email , password);
				if(checkpwd==true)
				{
					sessionfor.getAttribute("email");
					sessionfor.invalidate();
					resp.sendRedirect("login.html");
				}
				else
				{
					req.getRequestDispatcher("newpwd.html").include(req, resp);
					out.print("already exit or ivalid password");
				}
			}
			else
			{
				req.getRequestDispatcher("newpwd.html").include(req, resp);
				out.print("invalid password");
			}
		}
		else
		{
			req.getRequestDispatcher("newpwd.html").include(req, resp);
			out.print("mismatch password");
		}
	}
}
