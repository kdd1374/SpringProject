package com.dto;

public class NaverDTO {

	private String username;
	private String email;
	private int numbers;
	public NaverDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NaverDTO(String username, String email, int numbers) {
		super();
		this.username = username;
		this.email = email;
		this.numbers = numbers;
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
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	@Override
	public String toString() {
		return "NaverDTO [username=" + username + ", email=" + email + ", numbers=" + numbers + "]";
	}
	
	
	
}
