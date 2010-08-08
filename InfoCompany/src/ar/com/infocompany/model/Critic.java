package ar.com.infocompany.model;

import java.util.ArrayList;
import java.util.List;

import ar.com.infocompany.infraestructure.BusinessBase;
import ar.com.infocompany.infraestructure.IAggregateRoot;

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
	
	public Critic() {
		
	}
		
	public Critic(User author, Comment comment, Job job, int salary) {
		this.author = author;
		this.salary = salary;
		this.job = job;
		this.comment = comment;
		this.postiveScore = 0;
		this.negativeScore = 0;
		this.items = new ArrayList<Item>();
		this.replies = new ArrayList<Comment>();
	}

	public Critic(User author, Comment comment,
			Job job, int salary, List<Item> items) {
		this.author = author;
		this.salary = salary;
		this.replies = new ArrayList<Comment>();
		this.comment = comment;
		this.job = job;
		this.items = items;
	}
	
	public void increaseScore() {
		++this.postiveScore;
	}
	
	public void decreaseScore() {
		++this.negativeScore;
	}

	public int getScore() {
		return (this.getPositiveScore() - this.getNegativeScore());
	}

	public int getPositiveScore() {
		return this.postiveScore;
	}
	
	public int getNegativeScore() {
		return this.negativeScore;
	}
	
	public User getAuthor() {
		return this.author;
	}
	
	public Job getJob() {
		return this.job;
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
		
	public boolean addItem(Item criticItem) {
		return this.items.add(criticItem);
	}

	@Override
	protected void validate() {	
		if(this.job == null) {
			this.addBrokenRule("Job", "El trabajo es requerido.");
		}
		
		if (this.salary > 0) {
			this.addBrokenRule("Salary", "El sueldo tiene que ser mayor que 0.");
		}
		
		if (this.author == null) {
			this.addBrokenRule("Author", "El autor del la critica es requerido.");
		}
		
		if (this.items == null) {
			this.addBrokenRule("Items", "Una critica debe tener al menos un item calificado");
		} else if (this.items.size() == 0 ) {
			this.addBrokenRule("Items", "Una critica debe tener al menos un item calificado");
		} else {
			for (Item item : this.items) {
				this.addBrokenRule(item.getBrokenRules());
			}
		}
	}
		
}

// eof
