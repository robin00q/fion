package net.fion.domain;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import net.fion.util.SetHttpUtil;

public class UserMatchRecord {

	private List<String> records;

	public UserMatchRecord() {}

	public UserMatchRecord(List<String> records) {
		this.records = records;
	}

	/* getter */
	public List<String> getRecords() {
		return records;
	}

	/* toString */
	public String toString() {
		return super.toString();
	}
	
	public static UserMatchRecord gethUserMatchRecordFromApi(String accessId, Integer matchtype, Integer offset, Integer limit) {
		try {
			StringBuilder searchUrl = 
					new StringBuilder(SetHttpUtil.nexonApiUrl + "users/" + accessId + "/matches?matchtype=" + 
								matchtype + "&offset=" + offset + "&limit=" + limit);
			
			HttpEntity requestEn  = SetHttpUtil.setAuthorizationHeaders();
			
			ResponseEntity<List> responseEn = 
					SetHttpUtil.restTemplate.exchange(searchUrl.toString(), HttpMethod.GET, requestEn, List.class);
			
			UserMatchRecord userMatchRecord = new UserMatchRecord(responseEn.getBody());
			
			return userMatchRecord;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
