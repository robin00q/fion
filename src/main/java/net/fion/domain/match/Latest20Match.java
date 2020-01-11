package net.fion.domain.match;

import java.util.List;

public class Latest20Match {

	private List<Match> latest20Match;

	public Latest20Match() {
	}
	
	public Latest20Match(List<Match> latest20Match) {
		this.latest20Match = latest20Match;
	}

	public List<Match> getLatest20Match() {
		return latest20Match;
	}
}
