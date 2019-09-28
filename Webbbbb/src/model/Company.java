package model;

public class Company {
	int id;
	int user_id;
	String company_mobile;
	String company_name;
	public Company(int id, int user_id, String mobile, String company_name) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.company_mobile = mobile;
		this.company_name = company_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCompany_mobile() {
		return company_mobile;
	}
	public void setCompany_mobile(String company_mobile) {
		this.company_mobile = company_mobile;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	
}
