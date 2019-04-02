package com.dto;

public class QnaDTO {

	private String email;
	private String name;
	private String content;
	public QnaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QnaDTO(String email, String name, String content) {
		super();
		this.email = email;
		this.name = name;
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "QnaDTO [email=" + email + ", name=" + name + ", content=" + content + "]";
	}
	
	
}
