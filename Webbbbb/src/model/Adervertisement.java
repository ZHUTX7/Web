package model;

public class Adervertisement {
	int ad_id;  //广告id
	int user_id;//用户id
	String img_url;  //广告图片链接
	String ahref_url; //广告图片的超链接
	int clickSum; //点击量
	int ad_price;  //广告位租金
	public Adervertisement(int ad_id, int user_id, String img_url, String ahref_url, int clickSum, int ad_price) {
		super();
		this.ad_id = ad_id;
		this.user_id = user_id;
		this.img_url = img_url;
		this.ahref_url = ahref_url;
		this.clickSum = clickSum;
		this.ad_price = ad_price;
	}
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getAhref_url() {
		return ahref_url;
	}
	public void setAhref_url(String ahref_url) {
		this.ahref_url = ahref_url;
	}
	public int getClickSum() {
		return clickSum;
	}
	public void setClickSum(int clickSum) {
		this.clickSum = clickSum;
	}
	public int getAd_price() {
		return ad_price;
	}
	public void setAd_price(int ad_price) {
		this.ad_price = ad_price;
	}
	
	
}
