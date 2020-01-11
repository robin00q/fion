package net.fion.domain;

public class UserMaxRank {

	private Integer matchType;
	private Integer division;
	private String achievementDate;
	
	public UserMaxRank() {}

	public UserMaxRank(Integer matchType, Integer division, String achievementDate) {
		this.matchType = matchType;
		this.division = division;
		this.achievementDate = achievementDate;
	}
	
	/* getter */
	public Integer getMatchType() {
		return matchType;
	}

	public Integer getDivision() {
		return division;
	}

	public String getAchievementDate() {
		return achievementDate;
	}
}
