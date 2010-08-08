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
	public List<Critic> getCritics() {
		return this.critics;
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
	
	public boolean addCritic(Critic critic) {
		return this.critics.add(critic);
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
	
	public String getName() {
		return name;
	}
	
	public Industry getIndustry() {
		return this.industry;
	}

	public Critic getLastCritic() {
		Critic critic = null;
		if(this.critics.size() > 0)
		{
			critic = this.critics.get(this.critics.size() - 1);
		}
		return critic;
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

	protected void validate() {
		if(isNullOrEmpty(name)) {
			this.addBrokenRule("Name", "El nombre de la compania es requerido.");
		}
		
		if(this.industry == null) {
			this.addBrokenRule("Industry", "La industria de la compania es requerida.");
		}
		else {
			this.addBrokenRule(industry.getBrokenRules());
		}
		
		if(this.critics != null) {
			for (Critic critic : this.critics) {
				this.addBrokenRule(critic.getBrokenRules());
			}
		}
	}
	
	@SuppressWarnings("unused")
	private void setCritics(List<Critic> critics) {
		this.critics = critics;
	}
	
	@SuppressWarnings("unused")
	private void setIndustry(Industry industry) {
		this.industry = industry;
	}

	@SuppressWarnings("unused")
	private void setName(String name) {
		this.name = name;
	}

}

// eof
