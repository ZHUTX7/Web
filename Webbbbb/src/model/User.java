package model;

public class User {
	private int user_id; //id号
	private String user_password;//登陆密码
	private String user_name;//昵称
	private String user_sex;//性别
	private String user_email;//邮箱
	private String user_mobile; //手机号
	private String user_personalID;//身份证号
	private String user_adress;//所在地
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	public User(int user_id, String user_password, String user_name, String user_sex, String user_email,
			String user_mobile, String user_personalID, String user_adress) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_sex = user_sex;
		this.user_email = user_email;
		this.user_mobile = user_mobile;
		this.user_personalID = user_personalID;
		this.user_adress = user_adress;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the user_password
	 */
	public String getUser_password() {
		return user_password;
	}
	/**
	 * @param user_password the user_password to set
	 */
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}
	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/**
	 * @return the user_sex
	 */
	public String getUser_sex() {
		return user_sex;
	}
	/**
	 * @param user_sex the user_sex to set
	 */
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	/**
	 * @return the user_email
	 */
	public String getUser_email() {
		return user_email;
	}
	/**
	 * @param user_email the user_email to set
	 */
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	/**
	 * @return the user_mobile
	 */
	public String getUser_mobile() {
		return user_mobile;
	}
	/**
	 * @param user_mobile the user_mobile to set
	 */
	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}
	/**
	 * @return the user_personalID
	 */
	public String getUser_personalID() {
		return user_personalID;
	}
	/**
	 * @param user_personalID the user_personalID to set
	 */
	public void setUser_personalID(String user_personalID) {
		this.user_personalID = user_personalID;
	}
	/**
	 * @return the user_adress
	 */
	public String getUser_adress() {
		return user_adress;
	}
	/**
	 * @param user_adress the user_adress to set
	 */
	public void setUser_adress(String user_adress) {
		this.user_adress = user_adress;
	}
	
	
}
