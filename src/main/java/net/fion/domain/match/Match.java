package net.fion.domain.match;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Match {
	private String matchId;
	private String matchDate;
	private Integer matchType;
	private List<MatchInfo> matchInfo;
	
	public String getMatchId() {
		return matchId;
	}
	public String getMatchDate() {
		return matchDate;
	}
	public Integer getMatchType() {
		return matchType;
	}
	public List<MatchInfo> getMatchInfo() {
		return matchInfo;
	}
	public void setMatchInfo(List<MatchInfo> matchInfo) {
		this.matchInfo = matchInfo;
	}

	public String getTimeDiff() throws ParseException {
		SimpleDateFormat stringToDate = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss", Locale.KOREA);
		
		Date playDate = stringToDate.parse(matchDate.substring(0, 10) + matchDate.substring(11, 19));
		Date nowDate = new Date();
		
		long diff = nowDate.getTime() - playDate.getTime();
		
		long diffDays = diff / (24 * 60 * 60 * 1000);
		if(diffDays > 0) { return Long.toString(diffDays) + "일전"; }
		
		long diffHours = diff / (60 * 60 * 1000) % 24;
		if(diffHours > 0) { return Long.toString(diffHours) + "시간전"; }
		
		return Long.toString(diff / (60 * 1000) % 60) + "분전";

	}			
}
