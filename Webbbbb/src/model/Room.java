package model;

public class Room {
	private int room_id;
	private String room_adress; //地址
	private int room_area; //面积
	private int room_floor; //楼层
	private int room_price;//租金
	private int room_type;//房型 ，用于表示卧室数量
	private String room_toward;//朝向
	private String room_decorate;//装修情况
	private int way;//出租方式，way=1单间出租   way=2整套出租
	private String room_note;//备注
	private String room_img;//图片
	
	public Room(int room_id, String room_adress, int room_area, int room_floor, int room_price, int room_type,
			String room_toward, String room_decorate, int way, String room_note, String room_img) {
		super();
		this.room_id = room_id;
		this.room_adress = room_adress;
		this.room_area = room_area;
		this.room_floor = room_floor;
		this.room_price = room_price;
		this.room_type = room_type;
		this.room_toward = room_toward;
		this.room_decorate = room_decorate;
		this.way = way;
		this.room_note = room_note;
		this.room_img = room_img;
	}
	/**
	 * @return the room_id
	 */
	public int getRoom_id() {
		return room_id;
	}
	/**
	 * @param room_id the room_id to set
	 */
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	/**
	 * @return the room_adress
	 */
	public String getRoom_adress() {
		return room_adress;
	}
	/**
	 * @param room_adress the room_adress to set
	 */
	public void setRoom_adress(String room_adress) {
		this.room_adress = room_adress;
	}
	/**
	 * @return the room_area
	 */
	public int getRoom_area() {
		return room_area;
	}
	/**
	 * @param room_area the room_area to set
	 */
	public void setRoom_area(int room_area) {
		this.room_area = room_area;
	}
	/**
	 * @return the room_floor
	 */
	public int getRoom_floor() {
		return room_floor;
	}
	/**
	 * @param room_floor the room_floor to set
	 */
	public void setRoom_floor(int room_floor) {
		this.room_floor = room_floor;
	}
	/**
	 * @return the room_price
	 */
	public int getRoom_price() {
		return room_price;
	}
	/**
	 * @param room_price the room_price to set
	 */
	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}
	/**
	 * @return the room_type
	 */
	public int getRoom_type() {
		return room_type;
	}
	/**
	 * @param room_type the room_type to set
	 */
	public void setRoom_type(int room_type) {
		this.room_type = room_type;
	}
	/**
	 * @return the room_toward
	 */
	public String getRoom_toward() {
		return room_toward;
	}
	/**
	 * @param room_toward the room_toward to set
	 */
	public void setRoom_toward(String room_toward) {
		this.room_toward = room_toward;
	}
	/**
	 * @return the room_decorate
	 */
	public String getRoom_decorate() {
		return room_decorate;
	}
	/**
	 * @param room_decorate the room_decorate to set
	 */
	public void setRoom_decorate(String room_decorate) {
		this.room_decorate = room_decorate;
	}
	/**
	 * @return the way
	 */
	public int getWay() {
		return way;
	}
	/**
	 * @param way the way to set
	 */
	public void setWay(int way) {
		this.way = way;
	}
	/**
	 * @return the room_note
	 */
	public String getRoom_note() {
		return room_note;
	}
	/**
	 * @param room_note the room_note to set
	 */
	public void setRoom_note(String room_note) {
		this.room_note = room_note;
	}
	/**
	 * @return the room_img
	 */
	public String getRoom_img() {
		return room_img;
	}
	/**
	 * @param room_img the room_img to set
	 */
	public void setRoom_img(String room_img) {
		this.room_img = room_img;
	}
}
