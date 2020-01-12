package net.fion.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SetHttpUtil {
	
	public static RestTemplate restTemplate = new RestTemplate();
	
	public static ObjectMapper mapper = new ObjectMapper();
	
	public static String nexonApiUrl = "https://api.nexon.co.kr/fifaonline4/v1.0/";

	public static <T> HttpEntity<T> setAuthorizationHeaders(){
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiOTkwNTE1N"
				+ "jc0IiwiYXV0aF9pZCI6IjIiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4iLCJzZXJ2aWNlX2lkIjoiNDMwMD"
				+ "ExNDgxIiwiWC1BcHAtUmF0ZS1MaW1pdCI6IjIwMDAwOjEwIiwibmJmIjoxNTc3MTkxNDMyLCJleHAiOjE2NDA"
				+ "yNjM0MzIsImlhdCI6MTU3NzE5MTQzMn0.1uCsaHk_C0lxZiSQeQSYqAg4KpEDn8Gq3eEqGpUdQGY");
		return new HttpEntity<T>(headers);
	}
	
	
}
