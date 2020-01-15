package net.fion.domain.match;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import net.fion.domain.UserMatchRecord;
import net.fion.util.SetHttpUtil;

public class Latest20Match {

	private List<Match> matchList;

	public Latest20Match() {
		this.matchList = new ArrayList<Match>();
	}
	
	public Latest20Match(List<Match> latest20Match) {
		this.matchList = latest20Match;
	}

	/* getter */
	public List<Match> getLatest20Match() {
		return matchList;
	}
	
	private void add(Match match) {
		this.matchList.add(match);
	}
	
	public static Latest20Match getMatchDetailsFromApi(UserMatchRecord userMatchRecord, String nickname) {
		try {			
			HttpEntity<?> requestEn  = SetHttpUtil.setAuthorizationHeaders();
			
			Latest20Match latest20Match = new Latest20Match();
			
			for(int i = 0 ; i < userMatchRecord.getRecords().size() ; i++) {
				StringBuilder searchUrl = 
						new StringBuilder(SetHttpUtil.nexonApiUrl + "matches/" + userMatchRecord.getRecords().get(i));
				
				ResponseEntity<Match> responseEn = 
						SetHttpUtil.restTemplate.exchange(searchUrl.toString(), HttpMethod.GET, requestEn, Match.class);
			
				latest20Match.add(responseEn.getBody());
			}
			return latest20Match;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
