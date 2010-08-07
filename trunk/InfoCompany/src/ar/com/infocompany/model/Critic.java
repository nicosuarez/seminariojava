package ar.com.infocompany.model;

import java.util.ArrayList;
import java.util.List;

import ar.com.infocompany.infrastructure.BusinessBase;
import ar.com.infocompany.infrastructure.IAggregateRoot;

public class Critic extends BusinessBase<Critic> implements IAggregateRoot{
	
	private User author;
	private Job job;
	private int salary;
	private Comment comment;
	private List<Comment> replies;
	private List<Item> items;
//	private Date date;
	private int postiveScore;
	private int negativeScore;
	private int id;
	private Company company;
	
	public Critic()
	{
	}
	
	
	public Critic(User author, 
				Company company, 
				String comment,
				Job job,
				int salary) {
		this.author = author;
		this.company = company;
		this.salary = salary;
		this.setJob(job);
		this.comment = new Comment(author, this, comment);
		this.postiveScore = 0;
		this.negativeScore = 0;
		this.items = new ArrayList<Item>();
		this.replies = new ArrayList<Comment>();
	}

	public Critic(User author, 
				Company company, 
				Comment comment, 
				Job job,
				int salary,
				List<Item> items) {
		this.author = author;
		this.company = company;
		this.salary = salary;
		this.replies = new ArrayList<Comment>();
		this.comment = comment;
		this.postiveScore = 0;
		this.negativeScore = 0;
		this.job = job;
		this.items = items;
	}
	
	public void increaseScore() {
		++this.postiveScore;
	}
	
	public void decreaseScore() {
		++this.negativeScore;
	}
	
//	public float getCompanyRating() {
//		// tener en cuenta reputacion usuario
//		return 5;
//	}
//	
	public User getAuthor() {
		return this.author;
	}
	
	public Job getJob() {
		return this.job;
	}
	
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
	
	private void setAuthor(User author) {
		this.author = author;
	}

	private void setReplies(List<Comment> replies) {
		this.replies = replies;
	}

	public int getSalary() {
		return this.salary;
	}
	
	private void setSalary(int salary) {
		this.salary = salary;
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
	
	public boolean addReply(User user, String reply) {
		return this.replies.add(new Comment(user, this, reply));
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
	
	public Company getCompany() {
		return this.company;
	}
	
	private void setCompany(Company company) {
		this.company = company;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public boolean addItem(Item criticItem) {
		return this.items.add(criticItem);
	}


	@Override
	protected void validate() {
		
		if(this.company == null) {
			this.addBrokenRule("Company", "La critica tiene que estar asociada a una compania.");
		}
		
		if(this.job == null) {
			this.addBrokenRule("Job", "El trabajo en requerido.");
		}
		
		if(this.salary > 0) {
			this.addBrokenRule("Salary", "El sueldo tiene que ser mayor que 0.");
		}
		
		if(this.author == null) {
			this.addBrokenRule("Author", "El autor del la critica es requerido.");
		}
		
		if(this.items == null) {
			this.addBrokenRule("Items", "Una critica debe tener al menos un item calificado");
		}
		else if(this.items.size() == 0 ) {
			this.addBrokenRule("Items", "Una critica debe tener al menos un item calificado");
		}
		else {
			for (Item item : this.items) {
				this.addBrokenRule(item.getBrokenRules());
			}
		}
		
	}
		
}
