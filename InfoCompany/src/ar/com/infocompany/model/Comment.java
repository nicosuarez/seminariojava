/*
 * Comment
 * 
 */
package ar.com.infocompany.model;

import java.util.Calendar;
import java.util.Date;

import ar.com.infocompany.infraestructure.BusinessBase;

/**
 * Comment
 *
 */
public class Comment extends BusinessBase {

	private User author;
	private String text;
	private int abuseCount;
	private Date date;
	
	public Comment() {
	}

	public Comment(User author, String text) {
		this.author = author;
		this.text = text;
		this.date = Calendar.getInstance().getTime();
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
	
	public Date getDate() {
		return this.date;
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
