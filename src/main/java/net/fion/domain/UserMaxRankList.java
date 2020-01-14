package net.fion.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.type.TypeReference;

import net.fion.domain.match.Match;
import net.fion.util.SetHttpUtil;

public class UserMaxRankList {
	
	private static List<UserMaxRank> maxRanks;
	
	public UserMaxRankList() {
		this.maxRanks = new ArrayList<UserMaxRank>();
	}

	public static List<UserMaxRank> getMaxRanks() {
		return maxRanks;
	}

	public static UserMaxRankList getUserMaxRankList(String accessId) {
		try {
			StringBuilder searchUrl = new StringBuilder(SetHttpUtil.nexonApiUrl + "users/" + accessId + "/maxdivision");
		
			UserMaxRankList userMaxRankList = new UserMaxRankList(); 
			
			HttpEntity requestEn = SetHttpUtil.setAuthorizationHeaders();
			
			ResponseEntity<List> responseEn = 
					SetHttpUtil.restTemplate.exchange(searchUrl.toString(), HttpMethod.GET, requestEn, List.class);
		
			maxRanks = SetHttpUtil.mapper.convertValue(responseEn.getBody(), new TypeReference<List<UserMaxRank>>() {});
			
			if(maxRanks.size() == 0) {
				return null;
			}
			return userMaxRankList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
}
