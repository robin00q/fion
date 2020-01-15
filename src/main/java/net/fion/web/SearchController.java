package net.fion.web;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.fion.domain.UserInfoByNickName;
import net.fion.domain.UserMatchRecord;
import net.fion.domain.UserMaxRankList;
import net.fion.domain.match.Latest20Match;
import net.fion.domain.match.MatchDetail;

@Controller
public class SearchController {

	@GetMapping("/user/searchByNickName")
	public String search(@RequestParam("nickname") String nickname, Model model) {
		
		UserInfoByNickName userDtoByNickName = UserInfoByNickName.getUserInfoFromApi(nickname);
		if(userDtoByNickName == null) {
			String errorMessage = "존재하지 않는 사용자입니다.";
			model.addAttribute("errorMessage", errorMessage);
			return "/user/search";
		}
		model.addAttribute("userDtoByNickName", userDtoByNickName);
		
		UserMaxRankList userMaxRankList = UserMaxRankList.getUserMaxRankList(userDtoByNickName.getAccessId());
		UserMatchRecord userMatchRecord = UserMatchRecord.gethUserMatchRecordFromApi(userDtoByNickName.getAccessId(), UserMaxRankList.getMaxRanks().get(0).getMatchType(), 0, 15);
//		UserInfo userInfo = new UserInfo(userDtoByNickName, userMaxRank);
		Latest20Match latest20Match = Latest20Match.getMatchDetailsFromApi(userMatchRecord, nickname);
		
		if(!(userMaxRankList == null)) {
			model.addAttribute("userMaxRankList", UserMaxRankList.getMaxRanks());
		}
		if(!(userMatchRecord == null)) {
			model.addAttribute("userMatchRecord", userMatchRecord.getRecords());
		}
		if(!(latest20Match == null)){
			model.addAttribute("latest20Match", latest20Match.getLatest20Match());
		}
		String test = "test";
		model.addAttribute("test", test);
		
		return "/user/search";
	}
	
	@GetMapping("/user/showMatchDetail")
	@ResponseBody
	public JSONObject showMatchDetail(@RequestParam("matchId") String matchId) {
			
		return MatchDetail.getMatchDetailFromApi(matchId);
	}
}
