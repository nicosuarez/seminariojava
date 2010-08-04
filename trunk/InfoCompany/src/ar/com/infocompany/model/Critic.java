package ar.com.infocompany.model;

import java.sql.Date;
import java.util.List;

public class Critic {
	
	private User author;
	private Target target;
	private int salary;
	private Comment comment;
	private List<Comment> replies;
	private List<Item> items;
	private Date date;
	
	public float getCompanyRating() {
		// tener en cuenta reputacion usuario
		return 5;
	}
	
	public User getAuthor() {
		return this.author;
	}
	
	public Target getTarget() {
		return this.target;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public Comment getComment() {
		return this.comment;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public List<Item> getItems() {
		return this.items;
	}
	
	public List<Comment> getReplies() {
		return this.replies;
	}
	
	public boolean addReply(Comment reply) {
		return this.replies.add(reply);
	}
	
}
