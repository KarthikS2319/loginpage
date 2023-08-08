package com.web.webproject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/welcome_page")
public class Webwelcome extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{	
		resp.setContentType("text/html");
		
		HttpSession session=req.getSession();
		if(session!=null)
		{
			resp.sendRedirect("main.jsp");
		}
		else
		{
			resp.sendRedirect("index.jsp");
		}
		
	}

}
