package net.fion.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.fion.domain.UserDtoByNickName;
import net.fion.domain.UserInfo;
import net.fion.domain.UserMaxRank;
import net.fion.service.UserServiceImpl;

@Controller
public class SearchController {

	@GetMapping("/user/searchByNickName")
	public String search(@RequestParam("nickname") String nickname, Model model) {
		
		UserDtoByNickName userDtoByNickName = UserServiceImpl.searchByUserNickName(nickname);
		UserMaxRank userMaxRank = UserServiceImpl.searchUserMaxRank(userDtoByNickName.getAccessId());
		UserInfo userInfo = new UserInfo(userDtoByNickName, userMaxRank);
		System.out.println(userMaxRank.getDivision());
		if(!(userDtoByNickName == null)) {
			model.addAttribute("userDtoByNickName", userDtoByNickName);
		}
		if(!(userMaxRank == null)) {
			model.addAttribute("userMaxRank", userMaxRank);
		}
//		model.addAttribute("userDtoByNickName", userDtoByNickName);
		
		
		
		return "/user/search";
	}
}
