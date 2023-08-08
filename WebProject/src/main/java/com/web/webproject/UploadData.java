package com.web.webproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//upload the data into the database
public class UploadData 
{
	public static String insert(String uId,String uName,String uPassword,String uEmail)
	{
		String name=uName;
		String user_id=uId;
		WebLogic webLogic=new WebLogic();
		
		//password to encrypt password
		String password=webLogic.encryption(uPassword);
		String email=uEmail;
		
		//insert the signup data into database
		Connection con = null;
		PreparedStatement psmt=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_data?user=root&password=root");
			String query="insert into user_login values(?,?,?,?)";
			psmt=con.prepareStatement(query);
			psmt.setString(1,user_id);
			psmt.setString(2,name);
			psmt.setString(3,password);
			psmt.setString(4,email);
				
			int count=psmt.executeUpdate();
			if(count !=0)
			{
				return "signup successfully";
			}
			else
			{
				return "try again";
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
	return "try again";
	}
	
}
