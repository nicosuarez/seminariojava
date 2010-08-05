/*
 * Score
 * 
 */
package ar.com.infocompany.model;

public class Item {
	
	String tag;
	int score;
	
	public Item(String tag, int score) {
		if ((tag == null) || (score < 0) || (score >10)) {
			throw new IllegalArgumentException();
		}
		this.tag = tag;
		this.score = score;
	}
	
	public String getTag() {
		return this.tag;
	}
		
	public int getScore() {
		return this.score;
	}
	
}

// eof
