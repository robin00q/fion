package net.fion.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.fion.domain.UserInfoByNickName;
import net.fion.domain.UserMatchRecord;
import net.fion.domain.UserMaxRank;
import net.fion.domain.match.Latest20Match;
import net.fion.service.UserServiceImpl;

@Controller
public class SearchController {

	@GetMapping("/user/searchByNickName")
	public String search(@RequestParam("nickname") String nickname, Model model) {
		
		UserInfoByNickName userDtoByNickName = UserServiceImpl.searchByUserNickName(nickname);
		UserMaxRank userMaxRank = UserServiceImpl.searchUserMaxRank(userDtoByNickName.getAccessId());
		UserMatchRecord userMatchRecord = UserServiceImpl.searchUserMatchRecord(userDtoByNickName.getAccessId(), userMaxRank.getMatchType(), 0, 10);
//		UserInfo userInfo = new UserInfo(userDtoByNickName, userMaxRank);
		Latest20Match latest20Match = UserServiceImpl.MatchDetailRecord(userMatchRecord, nickname);
		System.out.println(userMaxRank.getDivision());
		if(!(userDtoByNickName == null)) {
			model.addAttribute("userDtoByNickName", userDtoByNickName);
		}
		if(!(userMaxRank == null)) {
			model.addAttribute("userMaxRank", userMaxRank);
		}
		if(!(userMatchRecord == null)) {
			model.addAttribute("userMatchRecord", userMatchRecord.getRecords());
		}
		if(!(latest20Match == null)){
			model.addAttribute("latest20Match", latest20Match.getLatest20Match());
//			System.out.println(latest20Match.getLatest20Match().get(0).getMatchInfo().get(0).getMatchDetail().getMatchResult());
		}
//		model.addAttribute("userDtoByNickName", userDtoByNickName);
		
		
		
		return "/user/search";
	}
}
