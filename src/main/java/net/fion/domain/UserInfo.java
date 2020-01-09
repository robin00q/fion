package net.fion.domain;

public class UserInfo {
	
	private UserInfoByNickName userDtoByNickName;
	private UserMaxRank userMaxRank;
	
	public UserInfo() {
	}

	public UserInfo(UserInfoByNickName userDtoByNickName, UserMaxRank userMaxRank) {
		this.userDtoByNickName = userDtoByNickName;
		this.userMaxRank = userMaxRank;
	}	
	
}
