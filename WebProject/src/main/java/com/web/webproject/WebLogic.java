package com.web.webproject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WebLogic 
{
	//this method for check the password is strong or not
	public boolean strongPass(String uPassword)
	{
		String pwd=uPassword;
		if((pwd.length()>=8) && (pwd.length()<=16))
		{
			return true;
		}
		else
		{
			return false;
		}	
	}
	
	//this method for email validation
	public boolean validEmail(String uEmail) 
	{
		String email=uEmail;
		if(email.contains("@"))
		{
			return true;
		}
		return false;
	}
	//this method for password encryption
	public String encryption(String encryption)
	{
		String pwd=encryption;
		String encrypt = "";
		int p=8;
		for(int i=0;i<pwd.length();i++)
		{
			char pass=pwd.charAt(i);
			pass += p;
			encrypt += pass;
		}	
		return encrypt;
	}
}
