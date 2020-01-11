package net.fion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.fion.domain.UserInfoByNickName;
import net.fion.domain.UserMatchRecord;
import net.fion.domain.UserMaxRank;
import net.fion.domain.match.Latest20Match;
import net.fion.domain.match.Match;
import net.fion.util.SetHttpHeaderUtil;

public class UserServiceImpl {
	
	private static RestTemplate restTemplate = new RestTemplate();
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static UserInfoByNickName searchByUserNickName(String nickName) {
		try {
			String nickNameURL = "https://api.nexon.co.kr/fifaonline4/v1.0/users?nickname=";
			
			HttpEntity<UserInfoByNickName> requestEn  = SetHttpHeaderUtil.setAuthorizationHeaders();
			ResponseEntity<UserInfoByNickName> responseEn = restTemplate.exchange(nickNameURL + nickName, HttpMethod.GET, requestEn, UserInfoByNickName.class);
			
			UserInfoByNickName userInfoByNickName = new UserInfoByNickName(
					responseEn.getBody().getAccessId(),
					responseEn.getBody().getNickname(),
					responseEn.getBody().getLevel()
					);
			
			return userInfoByNickName;
			
		} catch (Exception e) {
            e.printStackTrace();
        }
		
		return null;
	}
	
	public static UserMaxRank searchUserMaxRank(String accessId) {
		try {
			String maxRankUrlFront = "https://api.nexon.co.kr/fifaonline4/v1.0/users/";
			String maxRankUrlBack = "/maxdivision";
			
			HttpEntity<UserMaxRank> requestEn  = SetHttpHeaderUtil.setAuthorizationHeaders();
			ResponseEntity<List> responseEn = restTemplate.exchange(maxRankUrlFront + accessId + maxRankUrlBack, HttpMethod.GET, requestEn, List.class);
			
			List<UserMaxRank> listUserMaxRank = mapper.convertValue(responseEn.getBody(), new TypeReference<List<UserMaxRank>>() {});
			
			UserMaxRank userMaxRank = new UserMaxRank(
					listUserMaxRank.get(0).getMatchType(),
					listUserMaxRank.get(0).getDivision(),
					listUserMaxRank.get(0).getAchievementDate()
					);
			
			return userMaxRank;
			
		} catch (Exception e) {
            e.printStackTrace();
        }
		
		return null;
	}
	
	public static UserMatchRecord searchUserMatchRecord(String accessId, Integer matchtype, Integer offset, Integer limit) {
		try {
			String matchRecordUrlFront = "https://api.nexon.co.kr/fifaonline4/v1.0/users/";
			String matchRecordUrlMatches = "/matches?matchtype=";
			String matchRecordOffset = "&offset=";
			String matchRecordLimit = "&limit=";
			
			HttpEntity<String> requestEn  = SetHttpHeaderUtil.setAuthorizationHeaders();
			ResponseEntity<List> responseEn = 
					restTemplate.exchange(matchRecordUrlFront + accessId + matchRecordUrlMatches + 
							matchtype +  matchRecordOffset + offset + matchRecordLimit + limit, HttpMethod.GET, requestEn, List.class);
			
			UserMatchRecord userMatchRecord = new UserMatchRecord(responseEn.getBody());
			
			return userMatchRecord;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Latest20Match MatchDetailRecord(UserMatchRecord userMatchRecord, String nickname) {
		try {
			
			String matchDetailUrl = "https://api.nexon.co.kr/fifaonline4/v1.0/matches/";
			
			HttpEntity<String> requestEn  = SetHttpHeaderUtil.setAuthorizationHeaders();
			
			List<Match> tempMatches = new ArrayList<Match>();
			
			for(int i = 0 ; i < userMatchRecord.getRecords().size() ; i++) {
				String matchid = userMatchRecord.getRecords().get(i);
				
				ResponseEntity<Match> responseEn = 
						restTemplate.exchange(matchDetailUrl + matchid, HttpMethod.GET, requestEn, Match.class);
			
				tempMatches.add(responseEn.getBody());
			}
			
			Latest20Match latest20Match = new Latest20Match(tempMatches);
			
			return latest20Match;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

}

