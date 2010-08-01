package ar.com.infocompany.model;

import java.util.HashSet;
import java.util.Set;

public class Comment {

	private int id;
	private User author;
	private String text;
	private Set<Comment> replies;
	private int rating;
	private int abuseCount;
	
	public Comment(int id, User author, String text) {
		this.id = id;
		this.author = author;
		this.text = text;
		this.replies = new HashSet<Comment>();
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
	
	public Set<Comment> getReplies() {
		return this.replies;
	}
	
	public boolean addReply(Comment reply) {
		return this.replies.add(reply);
	}
	
	public int getRating() {
		return this.rating;
	}
	
	public int incRating() {
		this.author.incReputation();
		return ++this.rating;
	}
	
	public int decRating() {
		this.decRating();
		return --this.rating;
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

