package com.shubham.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controllers 
{
	
@GetMapping("/login")	
public String loginPage()
{
	if(!Services.isUserAlreadyLoggedIn().equals(""))
	{
		return "redirect:/home";
	}
	else
	{
		return "login";
	}	
}

@GetMapping("/logout")
public String logout()
{
	String name = Services.isUserAlreadyLoggedIn();
	if(!name.equals(""))
	{
		try
		{
		Connection connection = Services.getConnection();
		PreparedStatement ps = connection.prepareStatement("update session set logout=now() where logout is null");
		int update = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	return "redirect:/login";
}

@GetMapping("/home")	
public String homePage(Model model)
{
	String name = Services.isUserAlreadyLoggedIn();
	if(!name.equals(""))
	{
		model.addAttribute("name" , name);
		model.addAttribute("previousLogins", Services.getAllPreviousLogins(name));
		model.addAttribute("previousMessages" , Services.getAllPreviousMessages(name));
		return "home";
	}
	else
	{
		return "redirect:/login";
	}
	
	
}

@PostMapping("/message")
public String messageController(@RequestParam("message") String message)
{
	String name = Services.isUserAlreadyLoggedIn();
	if(!name.equals(""))
	{
		try
		{
			Connection connection = Services.getConnection();
			PreparedStatement ps = connection.prepareStatement("insert into messages values(?,?)");
			ps.setString(1 , name);
			ps.setString(2, message);
			int inserted = ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "redirect:/home";
	}
	else
	{
		return "redirect:/login";
	}
}






@PostMapping("/home")	
public String redirectToHomePage(@RequestParam("name") String name , @RequestParam("email") String email , @RequestParam("mobile") String mobile , Model model)
{
	if(name.equals("admin") && email.equals("admin@admin.com") && mobile.equals("0000000000"))
	{
		model.addAttribute("name" , name);
		model.addAttribute("users", Services.getAllUsers());
		model.addAttribute("previousMessages" , Services.getAllPreviousMessages());
		return "adminHome";
		
	}
	
	
	try
	{
		Connection connection = Services.getConnection();
		PreparedStatement ps = connection.prepareStatement("insert into users values(?,?,?)");
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3 , mobile);
		int inserted = ps.executeUpdate();
		PreparedStatement ps1 = connection.prepareStatement("insert into session values(?,now(),null)");
		ps1.setString(1 , name);
		int inserted1 = ps1.executeUpdate();
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return "redirect:/home";
}
	
	
}
