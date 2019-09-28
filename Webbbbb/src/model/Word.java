package model;

public class Word {
	int id;
	String wordsKey;
	int count;
	
	public Word(int id, String wordsKey, int count) {
		super();
		this.id = id;
		this.wordsKey = wordsKey;
		this.count = count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWordsKey() {
		return wordsKey;
	}
	public void setWordsKey(String wordsKey) {
		this.wordsKey = wordsKey;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
