package model;

public class Apply {  //申请成为广告方类
	int user_id;//用户ID
	String company_mobile;//联系电话
	String company_name;//公司名称
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getMobile() {
		return company_mobile;
	}
	public void setMobile(String mobile) {
		this.company_mobile = mobile;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public Apply(int user_id, String mobile, String company_name) {
		super();
		this.user_id = user_id;
		this.company_mobile = mobile;
		this.company_name = company_name;
	}
	

}
