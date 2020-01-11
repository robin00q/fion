package net.fion.domain;

public class UserInfoByNickName {

	private String accessId;
	private String nickname;
	private Integer level;
	
	public UserInfoByNickName() {}

	public UserInfoByNickName(String accessId, String nickname, Integer level) {
		this.accessId = accessId;
		this.nickname = nickname;
		this.level = level;
	}
	
	/* getter */
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
