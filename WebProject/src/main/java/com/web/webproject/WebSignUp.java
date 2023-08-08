package com.web.webproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//it is used to mapping the URL
@WebServlet("/register")
public class WebSignUp extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//to refer the file type 
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		// creating object for WebLogic to get validation process
		WebLogic webLogic=new WebLogic();
		
		String uId=req.getParameter("userId");
		String uName=req.getParameter("name");
		String uPassword=req.getParameter("pwd");
		
		//it check the password is validate or not
		if(webLogic.strongPass(uPassword)==true)
		{
			//it is used to correct the mismatch password
			String uRePassword=req.getParameter("re-pwd");
			if(uRePassword.equals(uPassword))
			{
				String uEmail=req.getParameter("email");	
				boolean em=webLogic.validEmail(uEmail);
				if(em==true)
				{
					//upload the data into database
					String signupVerify=UploadData.insert(uId,uName,uPassword,uEmail);
				
					if(signupVerify=="signup successfully")
					{
						resp.sendRedirect("login.html");
					}
					else 
					{
						req.getRequestDispatcher("signup.html").include(req, resp);
						out.println(" user_ID or email_id already exit ");
					}
				}
				else
				{
					req.getRequestDispatcher("signup.html").include(req, resp);
					out.print("invalid email");
				}	
			}
			else
			{
				req.getRequestDispatcher("signup.html").include(req, resp);
				out.print("Mismatch password");
			}
		}
		else
		{
			req.getRequestDispatcher("signup.html").include(req, resp);
			out.print("too weak password");
		}
	}
}
