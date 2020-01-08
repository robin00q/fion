package net.fion.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import net.fion.dto.UserDTO;

public class UserServiceImpl {
	
	private static RestTemplate restTemplate = new RestTemplate();

	public static <T> HttpEntity<T> setHeaders(){
		HttpHeaders headers = new HttpHeaders();
		
		headers.set("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiOTkwNTE1Njc0IiwiYXV0aF9pZCI6IjIiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4iLCJzZXJ2aWNlX2lkIjoiNDMwMDExNDgxIiwiWC1BcHAtUmF0ZS1MaW1pdCI6IjIwMDAwOjEwIiwibmJmIjoxNTc3MTkxNDMyLCJleHAiOjE2NDAyNjM0MzIsImlhdCI6MTU3NzE5MTQzMn0.1uCsaHk_C0lxZiSQeQSYqAg4KpEDn8Gq3eEqGpUdQGY");
		
		return new HttpEntity<T>(headers);
	}
	
	public static void insert() {
		try {
			String searchByUserNickName = "https://api.nexon.co.kr/fifaonline4/v1.0/users?nickname=";
			
			HttpEntity<UserDTO> requestEn  = setHeaders();
			ResponseEntity<UserDTO> responseEn = restTemplate.exchange("https://api.nexon.co.kr/fifaonline4/v1.0/users?nickname=S2Jiwon", HttpMethod.GET, requestEn, UserDTO.class);
			
			System.out.println(responseEn.getBody().getAccessId());
			System.out.println(responseEn.getBody().getNickname());
			System.out.println(responseEn.getBody().getLevel());
			
		} catch (Exception e) {
            e.printStackTrace();
        }
	}
}
