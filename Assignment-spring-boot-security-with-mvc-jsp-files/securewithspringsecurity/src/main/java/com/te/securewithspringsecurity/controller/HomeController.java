package com.te.securewithspringsecurity.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.te.securewithspringsecurity.dto.User;
import com.te.securewithspringsecurity.service.UserServiceImpl;

@Controller
public class HomeController {
	@Autowired
	private UserServiceImpl service;

	
	@GetMapping("/")
	public String home() {
		return "home";
		
	}
	@GetMapping("/user")
	public String user(Principal principal,ModelMap  map) {
		String name = principal.getName();
		User user= service.getByUserName(name);

		if(user.getUserRole().equals("ROLE_ADMIN"))
		map.addAttribute("name", "Admin");
		else map.addAttribute("name", "User");
		return "user";
		
	}

	@GetMapping("/admin")
	public String admin(Principal principal,ModelMap  map) {
		String name = principal.getName();
		User user= service.getByUserName(name);
		if(user.getUserRole().equals("ROLE_ADMIN"))
		map.addAttribute("name", "Admin");
		else map.addAttribute("name", "User");
		return "admin";
		
	}
	@GetMapping("/signup")
	public String signup() {
		return "signup";
		
	}
	@PostMapping("/Home")
	public String loginHome(User user,ModelMap map) {
		service.saveData(user);
		map.addAttribute("msg", "Sign up Success Please Login");
		return "home";
	}
	@PostMapping("/update")
	public String loginHome1(User user,ModelMap map,Principal principal) {
		String userName = principal.getName();
		User user1= service.getByUserName(userName);
		user.setUserId(user1.getUserId());
		user.setUserRole(user1.getUserRole());
		user.setUserPassword(user1.getUserPassword());
		user.setUserName(user1.getUserName());
		
		if(service.saveData1(user)) {
			map.addAttribute("user", user);
			map.addAttribute("msg", "Data Updated Successfully!");
		}else {
			map.addAttribute("user", user);
			map.addAttribute("msg", "Something Went Wrong!");
		}
		
		
		return "update";
	}
	@GetMapping("/logoutHome")
	public String logoutHome(ModelMap map) {
		map.addAttribute("msg", "Logged out Succesfully!");
		return "home";
	}
		
	@GetMapping("/update")
	public String updateUser(Principal principal,ModelMap map) {
		String name = principal.getName();
		User user= service.getByUserName(name);
		map.addAttribute("user", user);
		return "update";
		
		
	}
		
	@GetMapping("/seeAll")
	public String seeAllUserDetails(ModelMap map) {
		List<User> users = service.findAllUserDetails();
		map.addAttribute("users", users);
		return "seeAll";
		
	}
	@GetMapping("/seeu")
	public String seeUserDetails(ModelMap map,Principal principal) {
		String name = principal.getName();
		User user = service.getData(name);
		map.addAttribute("user", user);
		return "getData";
		
	}
	@PostMapping("/delete")
	public String d(int id,ModelMap map) {
		boolean result = service.deleteUser(id);
		if(result) {
			map.addAttribute("msg", "User Deleted Succesfully");
		}
		else map.addAttribute("msg", "User Not Found!");
		return "delete";	
		
	}
	@GetMapping("/delete")
	public String getData() {
		return "delete";
		
		
	}
	
}
