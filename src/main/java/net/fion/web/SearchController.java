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
		UserMatchRecord userMatchRecordType50 = UserMatchRecord.gethUserMatchRecordFromApi(userDtoByNickName.getAccessId(), 50, 0, 15);
		UserMatchRecord userMatchRecordType52 = UserMatchRecord.gethUserMatchRecordFromApi(userDtoByNickName.getAccessId(), 52, 0, 15);
//		UserInfo userInfo = new UserInfo(userDtoByNickName, userMaxRank);
		Latest20Match latest20MatchType50 = Latest20Match.getMatchDetailsFromApi(userMatchRecordType50, nickname);
		Latest20Match latest20MatchType52 = Latest20Match.getMatchDetailsFromApi(userMatchRecordType52, nickname);
		
		if(!(userMaxRankList == null)) {
			model.addAttribute("userMaxRankList", UserMaxRankList.getMaxRanks());
		}
		if(!(latest20MatchType50 == null)){
			model.addAttribute("latest20MatchType50", latest20MatchType50.getLatest20Match());
		}
		if(!(latest20MatchType52 == null)){
			model.addAttribute("latest20MatchType52", latest20MatchType52.getLatest20Match());
		}
		
		return "/user/search";
	}
	
	@GetMapping("/user/showMatchDetail")
	@ResponseBody
	public JSONObject showMatchDetail(@RequestParam("matchId") String matchId) {
			
		return MatchDetail.getMatchDetailFromApi(matchId);
	}
}
