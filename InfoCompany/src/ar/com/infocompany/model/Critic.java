package ar.com.infocompany.model;

import ar.com.infocompany.infrastructure.IAggregateRoot;
import ar.com.infocompany.infrastructure.IEntity;

public class Critic implements IEntity, IAggregateRoot{
	
//	private User author;
//	private Job job;
	private int salary;
	private Comment comment;
//	private List<Comment> replies;
//	private List<Item> items;
//	private Date date;
//	private int postiveScore;
//	private int negativeScore;
	private int id;
	private Company company;
	
	public Critic()
	{
	}
	
	public Critic(int salary, Company company, Comment comment)
	{
		this.salary = salary;
		this.company = company;
		this.comment = comment;
	}
//	public void increaseScore() {
//		++this.postiveScore;
//	}
//	
//	public void decreaseScore() {
//		++this.negativeScore;
//	}
//	
//	public float getCompanyRating() {
//		// tener en cuenta reputacion usuario
//		return 5;
//	}
//	
//	public User getAuthor() {
//		return this.author;
//	}
//	
//	public Job getTargetJob() {
//		return this.job;
//	}
//	
//	public Date getDate() {
//		return this.date;
//	}
	
	private void setComment(Comment comment)
	{
		this.comment = comment;
	}
	
	public Comment getComment() {
		return this.comment;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	private void setSalary(int salary) {
		this.salary = salary;
	}
	
//	public List<Item> getItems() {
//		return this.items;
//	}
//	
//	public List<Comment> getReplies() {
//		return this.replies;
//	}
//	
//	public boolean addReply(Comment reply) {
//		return this.replies.add(reply);
//	}
//	
//	public int getPositiveScore() {
//		return this.postiveScore;
//	}
//	
//	public int getNegativeScore() {
//		return this.negativeScore;
//	}
//	
//	public int getScore() {
//		return (this.getPositiveScore() - this.getNegativeScore());
//	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id=id;
	}
	
	public Company getCompany() {
		return this.company;
	}
	
	private void setCompany(Company company) {
		this.company = company;
	}
		
}
