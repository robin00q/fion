package net.fion.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.fion.service.UserServiceImpl;

@Controller
public class HomeController {
	
	@GetMapping("")
	public String home() {
		return "/index";
	}
	
	@GetMapping("/user/search")
	public String search(Model model) {
		
		UserServiceImpl.insert();
		
		return "/user/search";
	}
}
