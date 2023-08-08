package com.web.webproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//creating new password
public class insertPassword 
{
	public static boolean insertpwd(String uEmail , String uPassword)
	{
		WebLogic webLogic=new WebLogic();
		String s_password=uPassword;
		String email=uEmail;
		
		Connection con = null;
		PreparedStatement psmt=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_data?user=root&password=root");
			String query="update user_login set password=? where email=?";
			psmt=con.prepareStatement(query);
			psmt.setString(1,s_password);
			psmt.setString(2,email);
				
			int count=psmt.executeUpdate();
			if(count !=0)
			{
				return true;
			}
			else
			{
				return false;
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
