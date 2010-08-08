/*
 * Comment
 * 
 */
package ar.com.infocompany.model;

import ar.com.infocompany.infrastructure.BusinessBase;
import ar.com.infocompany.infrastructure.IEntity;

/**
 * Comment
 *
 */
public class Comment extends BusinessBase<Comment> implements IEntity {

	private User author;
	private String text;
	private int abuseCount;
		
	public Comment() {
	}

	public Comment(User author, String text) {
		this.author = author;
		this.text = text;
	}

	public int incAbuseCount() {
		return ++this.abuseCount;
	}
	
	public void resetAbuseCount() {
		this.abuseCount = 0;
	}

	public int getAbuseCount() {
		return this.abuseCount;
	}
	
	public User getAuthor() {
		return author;
	}
	
	public String getText() {
		return this.text; 
	}
	
	protected void validate() {
		if(isVoid(text)) {
			this.addBrokenRule("Text", "El comentario es requerido.");
		}
		
		if(this.abuseCount > BusinessRules.COMMENT_ABUSE_TRESHOLD) {
			this.addBrokenRule("AbuseAcount",
					"El comentario alcanzo el limite de abusos reportados.");
		}	
	}
}

// eof
