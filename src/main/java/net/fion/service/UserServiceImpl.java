package net.fion.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import net.fion.dto.UserDtoByNickName;

public class UserServiceImpl {
	
	private static RestTemplate restTemplate = new RestTemplate();

	public static <T> HttpEntity<T> setAuthorizationHeaders(){
		HttpHeaders headers = new HttpHeaders();
		
		headers.set("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiOTkwNTE1Njc0IiwiYXV0aF9pZCI6IjIiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4iLCJzZXJ2aWNlX2lkIjoiNDMwMDExNDgxIiwiWC1BcHAtUmF0ZS1MaW1pdCI6IjIwMDAwOjEwIiwibmJmIjoxNTc3MTkxNDMyLCJleHAiOjE2NDAyNjM0MzIsImlhdCI6MTU3NzE5MTQzMn0.1uCsaHk_C0lxZiSQeQSYqAg4KpEDn8Gq3eEqGpUdQGY");
		
		return new HttpEntity<T>(headers);
	}
	
	public static UserDtoByNickName searchByUserNickName(String nickName) {
		try {
			String nickNameURL = "https://api.nexon.co.kr/fifaonline4/v1.0/users?nickname=";
			
			HttpEntity<UserDtoByNickName> requestEn  = setAuthorizationHeaders();
			ResponseEntity<UserDtoByNickName> responseEn = restTemplate.exchange(nickNameURL + nickName, HttpMethod.GET, requestEn, UserDtoByNickName.class);
			
			UserDtoByNickName userDtoByNickName = new UserDtoByNickName(
					responseEn.getBody().getAccessId(),
					responseEn.getBody().getNickname(),
					responseEn.getBody().getLevel()
					);
			
			return userDtoByNickName;
			
		} catch (Exception e) {
            e.printStackTrace();
        }
		
		return null;
	}
}
