/*
 * Comment
 * 
 */
package ar.com.infocompany.model;

import ar.com.infocompany.infrastructure.IEntity;

/**
 * Comment
 *
 */
public class Comment implements IEntity {

	private int id;
	//private User author;
	private String text;
	private int abuseCount;
	
//	public Comment(User author, String text) {
//		this.id = id;
//		this.text = text;
//	}
	
	public Comment(){
		
	}
	
	public Comment(String text) {
		this.text = text;
		this.abuseCount = 0;
	}

	public int getId() {
		return this.id;
	}
	
	private void setId(int id)
	{
		this.id = id;
	}
//	public User getAuthor() {
//		return this.author;
//	}

	private void setText(String text) {
		this.text = text; 
	}
	
	public String getText() {
		return this.text; 
	}
	
	private void setAbuseCount(int abuseCount){
		this.abuseCount = abuseCount;
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

