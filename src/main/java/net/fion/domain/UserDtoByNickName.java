package net.fion.domain;

public class UserDtoByNickName {

	private String accessId;
	private String nickname;
	private Integer level;
	
	public UserDtoByNickName() {
	}

	public UserDtoByNickName(String accessId, String nickname, Integer level) {
		this.accessId = accessId;
		this.nickname = nickname;
		this.level = level;
	}
	
	public String getAccessId() {
		return accessId;
	}
	public String getNickname() {
		return nickname;
	}
	public Integer getLevel() {
		return level;
	}
	
	
}
