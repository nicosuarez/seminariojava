/*
 * User
 * 
 */
package ar.com.infocompany.model;

import java.util.Date;
import java.util.List;

public class User {
	
	private Integer id;
	private String password;
	private String email;
	private Job job;
	private Location location;
	private List<Critic> critics;
	private int reputation;
	
	
	public User(int id, String name, String password, Date creationDate,
			String email, Job job, Location location) {
		this.email = email;
	}
	
	public Critic makeCritic() {
		return null;
	}
	
	public boolean isActive() {
		return true;
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
	
	/*
	public Critic getCompanyLastCritic(Company company) {
		Critic lastCritic = null;
		for (Critic critic: this.critics) {
			if ((critic.getTarget().getCompany().equals(company))
					&& ((lastCritic == null) 
						|| (critic.getDate().before(lastCritic.getDate())))) {
				lastCritic = critic;
			}
		}
		return lastCritic;
	}
	*/
	
	public List<Critic> getCritics()	{
		return this.critics;
	}
		
	public Job getJob() {
		return this.job;
	}
	
	public int getReputation() {
		return this.reputation;
	}
	
	public int increaseReputation() {
		return ++this.reputation;
	}
	
	public int decreaseReputation() {
		return --this.reputation;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
}

// eof
