package com.shubham.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Services 
{
	public static Connection getConnection()
	{
		String url = "jdbc:mysql://localhost:3306/task";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}
	public static void expireTheSession()
	{
		try
		{
			Connection connection = getConnection();
			Statement st = connection.createStatement();
			int rs = st.executeUpdate("update session set logout=login+interval 5 minute where logout is null");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static  String isUserAlreadyLoggedIn()
	{
		try
		{
			Connection connection = getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select name , minute(TIMEdiff( now() ,login)) from session where logout is  null");
			if(rs.next())
			{
				if(rs.getInt(2) < 5)
				{
					return rs.getString(1);
				}
				else
				{
					expireTheSession();
					return "";
				}
				
			}
			else
			{
				return "";
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "";
	}
	
	public static ArrayList<TimePojo> getAllPreviousLogins(String name)
	{
		ArrayList<TimePojo> al = new ArrayList<>();
		try
		{
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement("select login ,  minute(TIMEdiff( logout ,login)) from session where name=? and logout is not null ");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				TimePojo tp = new TimePojo(rs.getString(1) , rs.getInt(2));
				al.add(tp);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return al;
	}
	
	public static ArrayList<String> getAllPreviousMessages(String name)
	{
		ArrayList<String> al = new ArrayList<>();
		try
		{
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement("select message from messages where name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				al.add(rs.getString(1));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return al;
	}
	
	
	public static ArrayList<String> getAllPreviousMessages()
	{
		ArrayList<String> al = new ArrayList<>();
		try
		{
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement("select message from messages");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				al.add(rs.getString(1));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return al;
	}
	
	
	public static ArrayList<Users> getAllUsers()
	{
		ArrayList<Users> al = new ArrayList<>();
		try
		{
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement("select distinct name , email , mobile from  users");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Users tp = new Users(rs.getString(1) , rs.getString(2) , rs.getString(3));
				al.add(tp);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return al;
	}
}
