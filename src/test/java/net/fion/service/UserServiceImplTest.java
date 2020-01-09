package net.fion.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import net.fion.dto.UserDtoByNickName;

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

		System.out.println(responseEn.getBody().getAccessId());
		
		assertEquals(responseEn.getBody().getNickname(), nickName);
	}

}
