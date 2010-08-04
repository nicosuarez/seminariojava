/*
 * Comment
 * 
 */
package ar.com.infocompany.model;

/**
 * Comment
 *
 */
public class Comment {

	private int id;
	private User author;
	private String text;
	private int abuseCount;
	
	public Comment(int id, User author, String text) {
		this.id = id;
		this.text = text;
	}
	
	public int getId() {
		return this.id;
	}
	
	public User getAuthor() {
		return this.author;
	}
	
	public String getText() {
		return this.text; 
	}
		
	public int getAbuseCount() {
		return this.abuseCount;
	}
	
	public int incAbuseCount() {
		return ++this.abuseCount;
	}
	
	public void resetAbuseCount() {
		this.abuseCount = 0;
	}
	
}

// eof

