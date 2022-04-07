package com.friendbook.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.friendbook.dao.UserRepository;
import com.friendbook.entites.User;
import java.util.Random;

@Controller
public class MyController {
   @Autowired
   private UserRepository userRepository;
	  
   
   @GetMapping("/login")
   public String login()
   {
	   return "login";
   }
   @GetMapping("/home")
	public String home(Model m)
	{
		m.addAttribute("user",new User());
		return "home";
		
	}
   
	@GetMapping("/processform")
	public String add(@ModelAttribute("user") User user ,@RequestParam("email") String email,Model m)
	{
		List<User> li=userRepository.findByEmail(email);
		 
		if(li.isEmpty()!=false)
		{ 
			 //username generate start..
			   String s=user.getName();
			   String first=s.substring(0,1).toUpperCase();
				String remanning=s.substring(1);
				Random random = new Random();
				
		        int value = random.nextInt(5 + 1) + 1;
		       int valuee=100+value;

				String userr=first+remanning;
				String username=userr+valuee;
				 //username generate end..
				m.addAttribute("userrandom", username);
		      User u=userRepository.save(user);
	
		return "login";
		}
		else
		{
			m.addAttribute("already","email already exist");
			return "login";
		}
		
	}
	/*
	 * @GetMapping("/logincheck") public String logincheck(@RequestParam("email")
	 * String email,@ModelAttribute User u) {
	 * 
	 * Optional<User> li=userRepository.findById(email);
	 * System.out.println(u.getEmail()+" "+email); System.out.println(li.isEmpty());
	 * return "success";
	 * 
	 * }
	 */
	@GetMapping("/logincheck")
	public String logincheck(@ModelAttribute User user,Model m,@RequestParam("email") String email,@RequestParam("password") String password)
	{
		try {
		User u=userRepository.getUserByEmailandPassword5(email, password);
		System.out.println(u.getEmail()+" "+u.getPassword());
		return "success";
		}
		catch(Exception e)
		{
			
			m.addAttribute("wrong","wrong email or password ");
			System.out.println("error");
			return "login";
		}
	    
	}
	
}
