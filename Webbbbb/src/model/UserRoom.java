package model;

public class UserRoom {
	int ur_id;
	int user_id;
	int room_id;
	
	public UserRoom(int ur_id,int user_id, int room_id ) {
		super();
		this.user_id = user_id;
		this.room_id = room_id;
		this.ur_id = ur_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public int getUr_id() {
		return ur_id;
	}
	public void setUr_id(int ur_id) {
		this.ur_id = ur_id;
	}
	
}
