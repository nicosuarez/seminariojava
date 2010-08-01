package ar.com.infocompany.model;

import java.util.Date;
import java.util.Set;

/*
 * This class represents a user of the InfoCompany system.  This is one of 
 * our applications main domain objects.
 */

public class User {
	
	private Integer id;
	private String name;
	private String password;
	private Date creationDate;
	private String email;
	private Job job;
	private Location location;
	private Set<Critic> critics;
	private int reputation;
	
	/*
	 * Comments associated to the user,
	 * recived or sent.
	 */
	private Set<Comment> comments;
	
	public User(int id, String name, String password, Date creationDate,
			String email, Job job, Location location) {
		this.email = email;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String userName) {
			this.name = userName;
	}
	
	public Date getCreationDate() {
		return this.creationDate;
	}
		
	public Set<Critic> getCritics()	{
		return this.critics;
	}
	
	public boolean addCritic(Critic critic) {
		return this.critics.add(critic);
	}
	
	public Job getJob() {
		return this.job;
	}
	
	public Set<Comment> getComments() {
		return this.comments;
	}
	
	public Set<Comment> getMyComments() {
		return this.comments;
	}
	
	public Set<Comment> getReplies() {
		return this.comments;
	}
	
	public int getReputation() {
		return this.reputation;
	}
	
	public int incReputation() {
		return ++this.reputation;
	}
	
	public int decReputation() {
		return --this.reputation;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
}
