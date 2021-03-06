package net.fion.service;


import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.fion.util.SetHttpUtil;

@SpringBootTest(classes= {UserServiceImpl.class})
class UserServiceImplTest {

	private static RestTemplate restTemplate = new RestTemplate();
	
	private static ObjectMapper mapper = new ObjectMapper();
	@Before
	<T> HttpEntity<T> setheaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiOTkwNTE1N"
				+ "jc0IiwiYXV0aF9pZCI6IjIiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4iLCJzZXJ2aWNlX2lkIjoiNDMwMD"
				+ "ExNDgxIiwiWC1BcHAtUmF0ZS1MaW1pdCI6IjIwMDAwOjEwIiwibmJmIjoxNTc3MTkxNDMyLCJleHAiOjE2NDA"
				+ "yNjM0MzIsImlhdCI6MTU3NzE5MTQzMn0.1uCsaHk_C0lxZiSQeQSYqAg4KpEDn8Gq3eEqGpUdQGY"); 
		
		
			return new HttpEntity<T>(headers);
		
		
		
		
	}
	
	@Test
	void 닉네임으로_유저조회() {
//		String searchByUserNickNameURL = "https://api.nexon.co.kr/fifaonline4/v1.0/users?nickname=";
//		String nickName = "S2Jiwon";
//		
//		HttpEntity<UserInfoByNickName> requestEn  = SetHttpUtil.setAuthorizationHeaders();
//		ResponseEntity<UserInfoByNickName> responseEn = restTemplate.exchange(searchByUserNickNameURL + nickName, HttpMethod.GET, requestEn, UserInfoByNickName.class);
//
//		assertEquals(responseEn.getBody().getNickname(), nickName);
	}

	@Test
	void 고유식별자로_역대최고등급조회() {
		
//		String maxRankUrlFront = "https://api.nexon.co.kr/fifaonline4/v1.0/users/";
//		String maxRankUrlBack = "/maxdivision";
//		String accessId = "ede1c50a5a7f087feaefd180";
//		
//		HttpEntity<UserMaxRank> requestEn  = SetHttpUtil.setAuthorizationHeaders();
//		ResponseEntity<List> responseEn = restTemplate.exchange(maxRankUrlFront + accessId + maxRankUrlBack, HttpMethod.GET, requestEn, List.class);
//		
//		List<UserMaxRank> userMaxRank = mapper.convertValue(responseEn.getBody(), new TypeReference<List<UserMaxRank>>() {});
//		
//		assertThat(userMaxRank.get(0).getMatchType(), is(50));
	}
	
	@Test
	void 고유식별자와_매치타입으로_매치기록조회() {
//		String accessId = "755a5b9573403377b23a94f9";
//		Integer matchtype = 50;
//		Integer offset = 0;
//		Integer limit = 20;
//		
//		String matchRecordUrlFront = "https://api.nexon.co.kr/fifaonline4/v1.0/users/";
//		String matchRecordUrlMatches = "/matches?matchtype=";
//		String matchRecordOffset = "&offset=";
//		String matchRecordLimit = "&limit=";
//		
//		HttpEntity<String> requestEn  = SetHttpUtil.setAuthorizationHeaders();
//		ResponseEntity<List> responseEn = 
//				restTemplate.exchange(matchRecordUrlFront + accessId + matchRecordUrlMatches + 
//						matchtype +  matchRecordOffset + offset + matchRecordLimit + limit, HttpMethod.GET, requestEn, List.class);
//		
//		UserMatchRecord userMatchRecord = new UserMatchRecord(responseEn.getBody());
//		
//		assertTrue(userMatchRecord.getRecords().size() <= 20);
	}
	
	@Test
	void 매치_상세기록조회() {
//		List<String> matchids = new ArrayList<String>();
//		matchids.add("5e1607758febac5af540c1ec");
//		matchids.add("5e16034e19bada5036ec993f");
//		matchids.add("5e127d0c5ecda100969d1129");
//		matchids.add("5e12794051e83d0478370e18");
//		matchids.add("5e127276a2a9e05075f27279");
//		
//		List<Match> tempMatches = new ArrayList<Match>();
//       
//		String matchDetailUrl = "https://api.nexon.co.kr/fifaonline4/v1.0/matches/";
//		
//		HttpEntity<String> requestEn  = SetHttpUtil.setAuthorizationHeaders();
//		
//		for(int i = 0 ; i < matchids.size() ; i++) {
//			String matchid = matchids.get(i);
//		 
//			ResponseEntity<Match> responseEn = 
//					restTemplate.exchange(matchDetailUrl + matchid, HttpMethod.GET, requestEn, Match.class);
//			
//			tempMatches.add(responseEn.getBody());
//		}
//		
//		Latest20Match latest20Match = new Latest20Match(tempMatches);
//		
	}
	@Test
	void 매치아이디로_JSON받기() throws ParseException {
		
		HttpEntity requestEn  = setheaders();
		
		StringBuilder searchUrl = 
				new StringBuilder(SetHttpUtil.nexonApiUrl + "matches/" + "5e1c08b5ec5a3c729a68420f");
		
		ResponseEntity<JSONObject> responseEn = 
				SetHttpUtil.restTemplate.exchange(searchUrl.toString(), HttpMethod.GET, requestEn, JSONObject.class);
		
		
		
		System.out.println(responseEn.getBody().toString());
			
		
	}
	
}
