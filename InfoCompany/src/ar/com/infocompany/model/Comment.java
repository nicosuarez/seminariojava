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
	private Critic critic;
	
	public Comment() {
	}

	public Comment(User author, Critic critic, String text) {
		this.critic = critic;
		this.author = author;
		this.text = text;
		this.abuseCount = 0;
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
	
	public Critic getCritic() {
		return critic;
	}
	
	public String getText() {
		return this.text; 
	}
	
	protected void validate() {
		if (this.critic == null) {
			this.addBrokenRule("Critic", "El comentario tiene que estar asociado a una critica.");
		} else {
			this.addBrokenRule(this.critic.getBrokenRules());
		}
		
		if(isNullOrEmpty(text)) {
			this.addBrokenRule("Text", "El comentario es requerido.");
		}
		
		if(this.abuseCount >= 5) {
			this.addBrokenRule("AbuseAcount", "El comentario alcanzo el limite de abusos reportados.");
		}	
	}
}

// eof
