package net.fion.domain;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import net.fion.util.SetHttpUtil;

public class UserInfoByNickName {

	private String accessId;
	private String nickname;
	private Integer level;
	
	public UserInfoByNickName() {}

	public UserInfoByNickName(String accessId, String nickname, Integer level) {
		this.accessId = accessId;
		this.nickname = nickname;
		this.level = level;
	}
	
	/* getter */
	public String getAccessId() {
		return accessId;
	}
	public String getNickname() {
		return nickname;
	}
	public Integer getLevel() {
		return level;
	}
	
	public static UserInfoByNickName getUserInfoFromApi(String nickName) {
		try {
			StringBuilder searchUrl = new StringBuilder(SetHttpUtil.nexonApiUrl + "users?nickname=" + nickName);
			
			HttpEntity requestEn  = SetHttpUtil.setAuthorizationHeaders();
			
			ResponseEntity<UserInfoByNickName> responseEn = 
					SetHttpUtil.restTemplate.exchange(searchUrl.toString(), HttpMethod.GET, requestEn, UserInfoByNickName.class);
			
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
	
	
}
