package com.dto;

public class NaverDTO {

	private String username;
	private String email;
	public NaverDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NaverDTO(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "NaverDTO [username=" + username + ", email=" + email + "]";
	}
	
	
	
}
