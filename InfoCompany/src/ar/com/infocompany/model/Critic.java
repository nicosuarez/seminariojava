package ar.com.infocompany.model;

import java.sql.Date;
import java.util.Set;

public class Critic {
	
	private User author;
	private Company company;
	private Job job;
	private int salary;
	private Comment comment;
	private Set<Item> items;
	private Date date;
	
	public User getAuthor() {
		return this.author;
	}
	
	public float getCompanyRating() {
		// tener en cuenta reputacion usuario
		return 5;
	}
	
	public Comment getComment() {
		return this.comment;
	}
	
	public Company getCompany() {
		return this.company;
	}
	
	public Job getJob() {
		return this.job;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public Set<Item> getItems() {
		return this.items;
	}
	
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
}
