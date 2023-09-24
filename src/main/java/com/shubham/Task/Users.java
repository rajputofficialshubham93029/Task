package com.shubham.Task;

public class Users 
{
	public String name;
	public String email;
	public String mobile;
	public Users(String name , String email , String mobile)
	{
		this.name = name;
		this.email =email;
		this.mobile = mobile;
	}
	public String getName()
	{
		return this.name;
	}
	public String getEmail()
	{
		return this.email;
	}
	public String getMobile()
	{
		return this.mobile;
	}

}
