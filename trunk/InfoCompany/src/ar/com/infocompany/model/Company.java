/*
 * Company
 * 
 */
package ar.com.infocompany.model;

import java.util.List;

public class Company {
	
	private int id;
	private String name;
	private Industry industry;
	private List<Critic> critics;
	
	public Company(int id, String name, Industry industry) {
		this.id = id;
		this.name = name;
		this.industry = industry; 
	}
		
	public float calculateRating() {
		int rating = 0;
		//for (Critic critic : this.critics) {
			//rating += (critic.getCompanyRating() * critic.getAuthor().getReputation());
		//}
		rating = (rating / this.critics.size());
		return rating;
	}
	
	public boolean addCritic(Critic critic) {
		return this.addCritic(critic);
	}
	
	public List<Critic> getBestCritics(int n) {
		return this.getCritics(n, 1);
	}
	
	public List<Critic> getWorstCritics(int n) {
		return this.getCritics(n, 0);
	}
	
	private List<Critic> getCritics(int n, int criteria) {
		return null;
	}

	public List<Job>  getAsociatedJobs() {
		return null;
	}
	
	public List<Location>  getAsociatedLocations() {
		return null;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public String getName() {
		return name;
	}
	
	public Industry getIndustry() {
		return this.industry;
	}

}

// eof
