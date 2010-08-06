/*
 * Company
 * 
 */
package ar.com.infocompany.model;

import java.util.ArrayList;
import java.util.List;

import ar.com.infocompany.infrastructure.IAggregateRoot;
import ar.com.infocompany.infrastructure.IEntity;

public class Company implements IEntity, IAggregateRoot {
	
	private int id;
	private String name;
	private Industry industry;
	private List<Critic> critics;
	
	public Company() {
		 
	}
	
//	public Company(String name) {
//		this.name = name;
//	}
	
	public Company(String name, Industry industry) {
		this.name = name;
		this.industry = industry;
		this.critics = new ArrayList<Critic>();
	}
	public List<Critic> getCritics()
	{
		return this.critics;
	}
	
	private void setCritics(List<Critic> critics)
	{
		this.critics = critics;
	}
			
//	public float calculateRating() {
//		int rating = 0;
//		//for (Critic critic : this.critics) {
//			//rating += (critic.getCompanyRating() * critic.getAuthor().getReputation());
//		//}
//		rating = (rating / this.critics.size());
//		return rating;
//	}
	
	public boolean addCritic(Critic critic) {
		return this.critics.add(critic);
	}
	
	private void setIndustry(Industry industry) {
		this.industry = industry;
	}

	private void setName(String name) {
		this.name = name;
	}

	public List<Critic> getBestCritics(int n) {
		return this.getCritics(n, 1);
	}
	
	public List<Critic> getWorstCritics(int n) {
		return this.getCritics(n, 0);
	}
	
	public List<Critic> getCritics(int n, int criteria) {
		return null;
	}

	public List<Job>  getAsociatedJobs() {
		return null;
	}
	
	public List<Location>  getAsociatedLocations() {
		return null;
	}
	
	public int getId() {
		return this.id;
	}
	
	private void setId(int id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	
	public Industry getIndustry() {
		return this.industry;
	}

}

// eof
