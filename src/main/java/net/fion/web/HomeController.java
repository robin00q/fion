package net.fion.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.fion.dto.UserDtoByNickName;
import net.fion.service.UserServiceImpl;

@Controller
public class HomeController {
	
	@GetMapping("")
	public String home() {
		return "/index";
	}
	
}
