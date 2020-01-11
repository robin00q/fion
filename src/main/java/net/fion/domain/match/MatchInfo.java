package net.fion.domain.match;

public class MatchInfo {

	private String accessId;
	private String nickname;
	private MatchDetail matchDetail;
	private Shoot shoot;
	
	/* getter */
	public String getAccessId() {
		return accessId;
	}

	public String getNickname() {
		return nickname;
	}

	public MatchDetail getMatchDetail() {
		return matchDetail;
	}

	public Shoot getShoot() {
		return shoot;
	}

	/* toString */
	public String toString() {
		return "MatchInfo [accessId=" + accessId + ", nickname=" + nickname + ", matchDetail=" + matchDetail + "]";
	}

	
}
