package com.web.webproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//checking the email is correct or not
public class Forgotpwd 
{

	public static boolean checkEmail(String uEmail) 
	{
		String email=uEmail;
		
		Connection con=null;
		PreparedStatement psmt=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_data?user=root&password=root");
			String query="select * from user_login where email =?";
			psmt=con.prepareStatement(query);
			psmt.setString(1 , email);
			ResultSet rs=psmt.executeQuery();
			while(rs.next())
			{
				String em=rs.getString(4);
				if(email.equals(em))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				psmt.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return false;
	}

	
	
}
