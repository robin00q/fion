package net.fion.domain.match;

public class MatchDetail {
	private Integer seasonId;
	private String matchResult;
	private Integer matchEndType;
	private Integer systemPause;
	private Integer foul;
	private Integer injury;
	private Integer redCards;
	private Integer yellowCards;
	private Integer dribble;
	private Integer cornerKick;
	private Integer possession;
	
	public MatchDetail() {

	}
	public Integer getSeasonId() {
		return seasonId;
	}
	public String getMatchResult() {
		return matchResult;
	}
	public Integer getMatchEndType() {
		return matchEndType;
	}
	public Integer getSystemPause() {
		return systemPause;
	}
	public Integer getFoul() {
		return foul;
	}
	public Integer getInjury() {
		return injury;
	}
	public Integer getRedCards() {
		return redCards;
	}
	public Integer getYellowCards() {
		return yellowCards;
	}
	public Integer getDribble() {
		return dribble;
	}
	public Integer getCornerKick() {
		return cornerKick;
	}
	public Integer getPossession() {
		return possession;
	}
	
	
}
