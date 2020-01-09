package net.fion.domain;

public class UserInfo {
	
	private UserDtoByNickName userDtoByNickName;
	private UserMaxRank userMaxRank;
	
	public UserInfo() {
	}

	public UserInfo(UserDtoByNickName userDtoByNickName, UserMaxRank userMaxRank) {
		this.userDtoByNickName = userDtoByNickName;
		this.userMaxRank = userMaxRank;
	}	
	
}
