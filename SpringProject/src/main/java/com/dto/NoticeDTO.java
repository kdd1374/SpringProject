package com.dto;

public class NoticeDTO {
	
	
	private int notice_num;
	private int notice_seq;
	private String notice_title;
	private String notice_contents;
	private int notice_rdcnt;
	private String reg_datetime;
	private String reg_admin;
	private int opt;
	private String condition;
	
	/*
	 * public NoticeDTO() { super(); // TODO Auto-generated constructor stub }
	 * public NoticeDTO(int notice_num, int notice_seq, String notice_title, String
	 * notice_contents, int notice_rdcnt, String reg_datetime, String reg_admin) {
	 * super(); this.notice_num = notice_num; this.notice_seq = notice_seq;
	 * this.notice_title = notice_title; this.notice_contents = notice_contents;
	 * this.notice_rdcnt = notice_rdcnt; this.reg_datetime = reg_datetime;
	 * this.reg_admin = reg_admin; }
	 */
	public int getNotice_num() {
		return notice_num;
	}
	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}
	public int getNotice_seq() {
		return notice_seq;
	}
	public void setNotice_seq(int notice_seq) {
		this.notice_seq = notice_seq;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_contents() {
		return notice_contents;
	}
	public void setNotice_contents(String notice_contents) {
		this.notice_contents = notice_contents;
	}
	public int getNotice_rdcnt() {
		return notice_rdcnt;
	}
	public void setNotice_rdcnt(int notice_rdcnt) {
		this.notice_rdcnt = notice_rdcnt;
	}
	public String getReg_datetime() {
		return reg_datetime;
	}
	public void setReg_datetime(String reg_datetime) {
		this.reg_datetime = reg_datetime;
	}
	public String getReg_admin() {
		return reg_admin;
	}
	public void setReg_admin(String reg_admin) {
		this.reg_admin = reg_admin;
	}
	
	
	
	public int getOpt() {
		return opt;
	}
	public void setOpt(int opt) {
		this.opt = opt;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	/*
	 * @Override public String toString() { return "NoticeDTO [notice_num=" +
	 * notice_num + ", notice_seq=" + notice_seq + ", notice_title=" + notice_title
	 * + ", notice_contents=" + notice_contents + ", notice_rdcnt=" + notice_rdcnt +
	 * ", reg_datetime=" + reg_datetime + ", reg_admin=" + reg_admin + "]"; }
	 */
	
	
	
}