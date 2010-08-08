/*
 * Company
 * 
 */
package ar.com.infocompany.model;

import java.util.ArrayList;
import java.util.List;

import ar.com.infocompany.infrastructure.BusinessBase;
import ar.com.infocompany.infrastructure.IAggregateRoot;

public class Company extends BusinessBase<Company> implements IAggregateRoot {
	
	private String name;
	private Industry industry;
	private List<Critic> critics;
	
	public Company() {
		 
	}
	
	public Company(String name, Industry industry) {
		this.name = name;
		this.industry = industry;
		this.critics = new ArrayList<Critic>();
	}
	
	public float calculateRating() {
		int rating = 0;
		/*
		for (Critic critic : this.critics) {
			rating += (critic.getCompanyRating() * critic.getAuthor().getReputation());
		}
		rating = (rating / this.critics.size());
		*/
		return rating;
	}
	
	public List<Critic> getBestCritics(int n) {
		return this.getCritics(n, 1);
	}
	
	public List<Critic> getWorstCritics(int n) {
		return this.getCritics(n, 0);
	}
	
	public Critic getLastCritic() {
		Critic critic = null;
		if (this.critics.size() > 0) {
			critic = this.critics.get(this.critics.size() - 1);
		}
		return critic;
	}
		
	public boolean addCritic(Critic critic) {
		return this.critics.add(critic);
	}
	
	public List<Critic> getCritics(int n, int criteria) {
		return null;
	}

	public List<Critic> getCritics() {
		return this.critics;
	}
	
	public List<Job>  getAsociatedJobs() {
		return null;
	}

	public List<Location>  getAsociatedLocations() {
		return null;
	}
	
	public Comment getLastComment() {
		Critic critic = getLastCritic();
		Comment lastComment = null;
		if( critic != null )
		{
			lastComment = critic.getComment();
		}
		return lastComment;
	}
	
	public String getName() {
		return name;
	}
	
	public Industry getIndustry() {
		return this.industry;
	}

	protected void validate() {
		if (this.isVoid(this.name)) {
			this.addBrokenRule("Name", "El nombre de la compania es requerido.");
		}
		
		if(this.industry == null) {
			this.addBrokenRule("Industry", "La industria de la compania es requerida.");
		} else {
			this.addBrokenRule(this.industry.getBrokenRules());
		}
		
		if(this.critics != null) {
			for (Critic critic : this.critics) {
				this.addBrokenRule(critic.getBrokenRules());
			}
		}
	}
	
}

// eof
