package net.fion.dto;

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
	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	
}
