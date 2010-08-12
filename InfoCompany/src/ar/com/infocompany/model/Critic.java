package ar.com.infocompany.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.infocompany.infraestructure.BusinessBase;
import ar.com.infocompany.infraestructure.IAggregateRoot;

public class Critic extends BusinessBase implements IAggregateRoot{
	
	public static final CriticComparator comparator = new CriticComparator();
	
	private User author;
	private int salary;
	private List<Comment> comments;
	private List<CriticItem> criticItems;
	private int postiveCriticScore;
	private int negativeCriticScore;
	private String industryName;
	private String jobName;
	private String country;
	private String state;
	
	@SuppressWarnings("unused")
	private int version; // To concurrency control in Hibernate
	
	public Critic() {
		
	}
		
	@Deprecated
	public Critic(User author, Comment comment, String jobName, String industryName, int salary) {
		this.author = author;
		this.salary = salary;
		this.jobName = jobName;
		this.industryName = industryName;
		this.postiveCriticScore = 0;
		this.negativeCriticScore = 0;
		this.criticItems = new ArrayList<CriticItem>();
		this.comments = new ArrayList<Comment>();
		this.comments.add(comment);
	}
	
	public Critic(User author, Comment comment, Industry industry,
			Job job, int salary, List<CriticItem> items) {
		this(author, comment, job.getName(), industry.getName() , salary, items);
	}

	public Critic(User author, Comment comment, String industryName,
			String jobName, int salary, List<CriticItem> items) {
		this.author = author;
		this.salary = salary;
		this.jobName = jobName;
		this.industryName = industryName;
		this.postiveCriticScore = 0;
		this.negativeCriticScore = 0;
		this.criticItems = items;
		this.comments = new ArrayList<Comment>();
		this.comments.add(comment);
		this.criticItems = items;
	}
	
	public float getScore() {
		float score = 0;
		for (CriticItem item : this.criticItems) {
			score += item.getScore(); 
		}
		score /= this.criticItems.size();
		return score;
	}
	
	public void increaseCriticScore() {
		++this.postiveCriticScore;
	}
	
	public void decreaseCriticScore() {
		++this.negativeCriticScore;
	}

	public int getCriticScore() {
		return (this.getPositiveCriticScore() - this.getNegativeCriticScore());
	}

	public int getPositiveCriticScore() {
		return this.postiveCriticScore;
	}
	
	public int getNegativeCriticScore() {
		return this.negativeCriticScore;
	}
	
	public User getAuthor() {
		return this.author;
	}
	
	public Date getDate() {
		return this.getAuthorComment().getDate();
	}
	
	public Job getJob() {
		return Job.getJob(this.jobName);
	}
	
	public Industry getIndustry() {
		return Industry.getIndustry(this.industryName);
	}
	
	public Comment getAuthorComment() {
		return this.comments.get(0);
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public CriticItem getItem(String tag) {
		CriticItem item = null;
		synchronized(this.criticItems) {
			for (CriticItem i : this.criticItems) {
				if (i.getTag().equals(tag)) {
					item = i;
					break;
				}
			}
		}
		return item;
	}
	
	public List<CriticItem> getItems() {
		return this.criticItems;
	}
	
	public int getRepliesSize() {
		synchronized(this.comments) {
			return this.comments.size() - 1;
		}
	}
	
	public List<Comment> getReplies() {
		List<Comment> replies;
		synchronized(this.comments) {
			replies = this.comments.subList(1, this.comments.size()); 
		}
		return replies;
	}
	
	public boolean addReply(Comment reply) {
		return this.comments.add(reply);
	}
		
	public boolean addItem(CriticItem item) {
		return this.criticItems.add(item);
	}

	protected void validate() {	
		if(this.isVoid(this.industryName) || this.isVoid(this.jobName) ) {
			this.addBrokenRule("Job", "El trabajo es requerido.");
		}
		
		if (this.salary <= BusinessRules.SALARY_MIN) {
			this.addBrokenRule("Salary", "El sueldo minimo es " 
					+ BusinessRules.SALARY_MIN); 
		}
		
		if (this.author == null) {
			this.addBrokenRule("Author", "El autor del la critica es requerido.");
		}
		
		if (this.criticItems == null) {
			this.addBrokenRule("Items", "Una critica debe tener al menos un item calificado");
		} else if (this.criticItems.size() == 0 ) {
			this.addBrokenRule("Items", "Una critica debe tener al menos un item calificado");
		} else {
			for (CriticItem item : this.criticItems) {
				this.addBrokenRule(item.getBrokenRules());
			}
		}
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return this.country;
	}
	
	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return this.state;
	}

}

// eof
