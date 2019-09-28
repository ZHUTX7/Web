package model;

public class Rent {
	int id;
	int customer_id;
	int seller_id;
	int room_price;
	String room_adress;
	String begin_date;
	String end_date;
	
	public Rent(int id, int customer_id, int seller_id, int room_price, String room_adress, String begin_date,
			String end_date) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.seller_id = seller_id;
		this.room_price = room_price;
		this.room_adress = room_adress;
		this.begin_date = begin_date;
		this.end_date = end_date;
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
	public int getRoom_price() {
		return room_price;
	}
	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}
	public String getRoom_adress() {
		return room_adress;
	}
	public void setRoom_adress(String room_adress) {
		this.room_adress = room_adress;
	}
	public String getBegin_date() {
		return begin_date;
	}
	public void setBegin_date(String begin_date) {
		this.begin_date = begin_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	
	}
