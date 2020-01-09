package net.fion.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.fion.domain.UserDtoByNickName;
import net.fion.domain.UserMaxRank;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {UserServiceImpl.class})
class UserServiceImplTest {

	private static RestTemplate restTemplate = new RestTemplate();
	
	@Test
	void 닉네임으로_유저조회() {
		String searchByUserNickName = "https://api.nexon.co.kr/fifaonline4/v1.0/users?nickname=";
		String nickName = "S2Jiwon";
		
		HttpEntity<UserDtoByNickName> requestEn  = UserServiceImpl.setAuthorizationHeaders();
		ResponseEntity<UserDtoByNickName> responseEn = restTemplate.exchange(searchByUserNickName + nickName, HttpMethod.GET, requestEn, UserDtoByNickName.class);

		System.out.println(responseEn.getBody().getNickname());
		
		assertEquals(responseEn.getBody().getNickname(), nickName);
	}

	@Test
	void 고유식별자로_역대최고등급조회() {
		ObjectMapper mapper = new ObjectMapper();
		
		String maxRankUrlFront = "https://api.nexon.co.kr/fifaonline4/v1.0/users/";
		String maxRankUrlBack = "/maxdivision";
		String accessId = "ede1c50a5a7f087feaefd180";
		
		HttpEntity<UserMaxRank> requestEn  = UserServiceImpl.setAuthorizationHeaders();
		ResponseEntity<List> responseEn = restTemplate.exchange(maxRankUrlFront + accessId + maxRankUrlBack, HttpMethod.GET, requestEn, List.class);
		
		List<UserMaxRank> userMaxRank = mapper.convertValue(responseEn.getBody(), new TypeReference<List<UserMaxRank>>() {});
		
		System.out.println(userMaxRank.get(0).getMatchType());
		
		assertThat(userMaxRank.get(0).getMatchType(), is(50));
	}
	
}
