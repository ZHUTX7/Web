package model;

public class Wish {
	int id;
	int user_id;
	int goods_id;
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
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public Wish(int id, int user_id, int goods_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.goods_id = goods_id;
	}
	
}
