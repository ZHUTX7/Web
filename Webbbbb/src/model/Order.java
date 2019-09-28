package model;

public class Order {//订单类
	int id;
	int customer_id;  // 顾客id
	int seller_id;   //卖家id
	int year;   //交易年月日
	int month;
	int day;
	String goods_name;   //买家姓名  价格 联系电话 收货地址
	double goods_price;
	String customer_mobile;
	String customer_adress;
	public Order(int id, int customer_id, int seller_id, int year, int month, int day, String goods_name,
			double goods_price, String customer_mobile, String customer_adress) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.seller_id = seller_id;
		this.year = year;
		this.month = month;
		this.day = day;
		this.goods_name = goods_name;
		this.goods_price = goods_price;
		this.customer_mobile = customer_mobile;
		this.customer_adress = customer_adress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	public String getCustomer_mobile() {
		return customer_mobile;
	}
	public void setCustomer_mobile(String customer_mobile) {
		this.customer_mobile = customer_mobile;
	}
	public String getCustomer_adress() {
		return customer_adress;
	}
	public void setCustomer_adress(String customer_adress) {
		this.customer_adress = customer_adress;
	}
	
	
	

}
