package com.dto;

public class FavorDTO {

	private String gCode;
	private String gCategory;
	private String gName;
	private int gPrice;
	private String gImage;
	private int gAmount;
	private String userid;
	public FavorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "FavorDTO [gCode=" + gCode + ", gCategory=" + gCategory + ", gName=" + gName + ", gPrice=" + gPrice
				+ ", gImage=" + gImage + ", gAmount=" + gAmount + ", userid=" + userid + "]";
	}


	public FavorDTO(String gCode, String gCategory, String gName, int gPrice, String gImage, int gAmount,
			String userid) {
		super();
		this.gCode = gCode;
		this.gCategory = gCategory;
		this.gName = gName;
		this.gPrice = gPrice;
		this.gImage = gImage;
		this.gAmount = gAmount;
		this.userid = userid;
	}


	public String getgCode() {
		return gCode;
	}
	public void setgCode(String gCode) {
		this.gCode = gCode;
	}
	public String getgCategory() {
		return gCategory;
	}
	public void setgCategory(String gCategory) {
		this.gCategory = gCategory;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public int getgPrice() {
		return gPrice;
	}
	public void setgPrice(int gPrice) {
		this.gPrice = gPrice;
	}
	public String getgImage() {
		return gImage;
	}
	public void setgImage(String gImage) {
		this.gImage = gImage;
	}
	public int getgAmount() {
		return gAmount;
	}
	public void setgAmount(int gAmount) {
		this.gAmount = gAmount;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
}
