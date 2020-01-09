package net.fion.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.fion.dto.UserDtoByNickName;
import net.fion.service.UserServiceImpl;

@Controller
public class SearchController {

	@GetMapping("/user/searchByNickName")
	public String search(@RequestParam("nickname") String nickname, Model model) {
		
		UserDtoByNickName userDtoByNickName = UserServiceImpl.searchByUserNickName(nickname);
		if(userDtoByNickName == null) {
			return "/index"; // to be updated
		}
		
		model.addAttribute("userDtoByNickName", userDtoByNickName);
		
		
		return "/user/search";
	}
}
