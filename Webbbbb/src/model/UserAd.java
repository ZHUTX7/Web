package model;

public class UserAd {
	int userAd_id;
	int user_id;
	int ad_id;
	public UserAd(int userAd_id, int user_id, int ad_id) {
		super();
		this.userAd_id = userAd_id;
		this.user_id = user_id;
		this.ad_id = ad_id;
	}
	public int getUserAd_id() {
		return userAd_id;
	}
	public void setUserAd_id(int userAd_id) {
		this.userAd_id = userAd_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	
}
