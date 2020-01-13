package net.fion.domain;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.type.TypeReference;

import net.fion.hashmap.CommonHashMap;
import net.fion.util.SetHttpUtil;

public class UserMaxRank {

	private Integer matchType;
	private Integer division;
	private String achievementDate;
	
	public UserMaxRank() {}

	public UserMaxRank(Integer matchType, Integer division, String achievementDate) {
		this.matchType = matchType;
		this.division = division;
		this.achievementDate = achievementDate;
	}
	
	/* getter */
	public Integer getMatchType() {
		return matchType;
	}

	public Integer getDivision() {
		return division;
	}

	public String getAchievementDate() {
		return achievementDate;
	}
	
	public String getHashMatchType() {
		return CommonHashMap.matchTypeHashMap.get(matchType.toString());
	}
	
	public String getHashDivision() {
		return CommonHashMap.divisionHashMap.get(division.toString());
	}
	
	public static UserMaxRank getMaxRankFromApi(String accessId) {
		try {
			StringBuilder searchUrl = new StringBuilder(SetHttpUtil.nexonApiUrl + "users/" + accessId + "/maxdivision");
			
			HttpEntity requestEn = SetHttpUtil.setAuthorizationHeaders();
			ResponseEntity<List> responseEn = 
					SetHttpUtil.restTemplate.exchange(searchUrl.toString(), HttpMethod.GET, requestEn, List.class);
			
			List<UserMaxRank> listUserMaxRank = 
					SetHttpUtil.mapper.convertValue(responseEn.getBody(), new TypeReference<List<UserMaxRank>>() {});
			
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
}
