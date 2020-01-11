package net.fion.domain.match;

import java.util.List;

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
}
