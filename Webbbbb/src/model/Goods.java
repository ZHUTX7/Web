package model;

public class Goods {
	int goods_id;
	String goods_name;
	double goods_price;
	String goods_type;
	String goods_note;
	String goods_img;
	
	public Goods(int goods_id, String goods_name, double goods_price, String goods_type, String goods_note ,
			String goods_img) {
		super();
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.goods_price = goods_price;
		this.goods_type = goods_type;
		this.goods_img = goods_img;
		this.goods_note = goods_note;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
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
	public String getGoods_type() {
		return goods_type;
	}
	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}
	public String getGoods_note() {
		return goods_note;
	}
	public void setGoods_note(String goods_note) {
		this.goods_note = goods_note;
	}
	
}
