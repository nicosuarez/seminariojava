package ar.com.infocompany.model;

import java.sql.Date;
import java.util.List;

public class Critic {
	
	private User author;
	private Job job;
	private int salary;
	private Comment comment;
	private List<Comment> replies;
	private List<Item> items;
	private Date date;
	private int postiveScore;
	private int negativeScore;
	
	public void increaseScore() {
		++this.postiveScore;
	}
	
	public void decreaseScore() {
		++this.negativeScore;
	}
	
	public float getCompanyRating() {
		// tener en cuenta reputacion usuario
		return 5;
	}
	
	public User getAuthor() {
		return this.author;
	}
	
	public Job getTargetJob() {
		return this.job;
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
	
	public int getPositiveScore() {
		return this.postiveScore;
	}
	
	public int getNegativeScore() {
		return this.negativeScore;
	}
	
	public int getScore() {
		return (this.getPositiveScore() - this.getNegativeScore());
	}
		
}
