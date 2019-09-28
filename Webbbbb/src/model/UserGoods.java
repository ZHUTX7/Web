package model;

public class UserGoods {
	int user_id;
	int goods_id;
	int ug_id;
	public UserGoods(int ug_id,int user_id, int goods_id) {
		super();
		this.user_id = user_id;
		this.goods_id = goods_id;
		this.ug_id = ug_id;
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
	public int getUg_id() {
		return ug_id;
	}
	public void setUg_id(int ug_id) {
		this.ug_id = ug_id;
	}
	
}
